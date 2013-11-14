package com.gm.infobus.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gm.infobus.json.JsonResponse;
import com.gm.infobus.service.UserService;
import com.gm.infobus.util.ConstantUtils;
import com.gm.infobus.util.MD5;

/**
* @Description: check the token from client. If the token value doesn't equals to the value of server side, 
* it tells user that his/her request is not valid.
* @author liuwei
* @date 2013年11月14日 上午9:27:03
*
*/
@Component
public class UserTokenFilter implements Filter {
	public static final String EXCLUDED_URLS = "excludedUrls";
	public static final String INCLUDED_URLS = "includedUrls";
	private List<String> includedUrlList = new ArrayList<String>();
	private List<String> excludedUrlList = new ArrayList<String>();
	private FilterConfig filterConfig = null;
	private final Logger logger = Logger.getLogger(this.getClass());
	private boolean initialized = false;
	@Autowired
	private UserService userService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		if (!(req instanceof HttpServletRequest) || !(res instanceof HttpServletResponse)) {
			throw new ServletException("It just supports HTTP requests");
		}
		HttpServletRequest request = (HttpServletRequest) req;
		if (this.isApplicable(request)) {
			String token = request.getParameter("token");
			String accountName = request.getParameter("accountName");
			boolean isAccountNameExisted = userService.isAccountNameExisted(accountName);
			String serverToken = "";
			if (isAccountNameExisted) {
				serverToken = MD5.encode(ConstantUtils.TOKEN_KEY + accountName);
				this.logger.debug("sever token is : "+ serverToken);
			}
			if (!serverToken.equals(token)) {
				JsonResponse jsonRes = new JsonResponse();
				jsonRes.setResult(ConstantUtils.JSON.RESULT_FAILED);
				jsonRes.setMsg("无效请求.");
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				pw.println(JSONObject.fromObject(jsonRes).toString());
				pw.flush();
				return;
			}
		}
		chain.doFilter(req, res);

	}

	/**
	 * Indicates whether current url is going to the logic of the filter
	 * @param request
	 * @return
	 */
	protected boolean isApplicable(final HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		if (this.isInExcludedUrlList(currentUrl)) {
			return false;
		}
		return true;
	}

	private boolean isInExcludedUrlList(String currentUrl) {
		for (String url : this.excludedUrlList) {
			if (currentUrl.indexOf(url) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		this.processConfig();
	}

	/**
	* @Title: processConfig
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @return:void
	* @author: liuwei
	* @date: 2013年11月14日
	* Modification History:
	* Date  Author  Version  Description
	* ---------------------------------------------------------*
	* 2013年11月14日  liuwei v1.0.0   修改原因
	*/
	protected void processConfig() {
		if (this.filterConfig == null) {
			this.initialized = false;
			return;
		}

		// now gather list of applicable(included) urls
		this.includedUrlList = this.initListParams(UserTokenFilter.INCLUDED_URLS);
		// now gather list of excluded urls
		this.excludedUrlList = this.initListParams(UserTokenFilter.EXCLUDED_URLS);

		this.logger.debug("initialized");
		this.initialized = true;
	}

	/**
	 * read params from web.xml
	 * 
	 * @param parameterName
	 * 
	 */
	private List<String> initListParams(final String parameterName) {
		final List<String> paramValueList = new ArrayList<String>();
		final String parameterValue = this.filterConfig.getInitParameter(parameterName);
		if (parameterValue == null) {
			this.initialized = false;
			return paramValueList;
		}
		final String[] parameterValueArray = parameterValue.split(";");
		for (int i = 0; i < parameterValueArray.length; i++) {
			paramValueList.add(StringUtils.trim(parameterValueArray[i]));
		}
		return paramValueList;
	}
}
