package com.gm.infobus.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gm.infobus.json.JsonResponse;
import com.gm.infobus.service.UserService;
import com.gm.infobus.util.ConstantUtils;
import com.gm.infobus.util.MD5;

public class UserTokenInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
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
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			PrintWriter pw = response.getWriter();
			pw.println(JSONObject.fromObject(jsonRes).toString());
			pw.flush();
			return false;
		}
		return true;
	}
}
