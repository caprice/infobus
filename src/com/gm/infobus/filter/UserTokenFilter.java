package com.gm.infobus.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;

import com.gm.infobus.json.JsonResponse;
import com.gm.infobus.service.UserService;
import com.gm.infobus.util.ConstantUtils;
import com.gm.infobus.util.MD5;

public class UserTokenFilter implements Filter {

	@Autowired
	private UserService userService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		if (!(req instanceof HttpServletRequest)
				|| !(res instanceof HttpServletResponse)) {
			throw new ServletException("It just supports HTTP requests");
		}
		HttpServletRequest request = (HttpServletRequest) req;
		String token = request.getParameter("token");
		String accountName = request.getParameter("accountName");
		boolean isAccountNameExisted = userService
				.isAccountNameExisted(accountName);
		String serverToken = "";
		if (isAccountNameExisted) {
			serverToken = MD5.encode(ConstantUtils.TOKEN_KEY + accountName);
		}
		if (!serverToken.equals(token)) {
			JsonResponse jsonRes = new JsonResponse();
			jsonRes.setResult(false);
			jsonRes.setMsg("无效用户");
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/json");
			PrintWriter pw = res.getWriter();
			pw.println(JSONObject.fromObject(jsonRes).toString());
			pw.flush();
			return;
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
