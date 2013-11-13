package com.gm.infobus.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.infobus.entity.User;
import com.gm.infobus.entity.validator.UserValidator;
import com.gm.infobus.json.JsonResponse;
import com.gm.infobus.service.UserService;
import com.gm.infobus.util.ConstantUtils;
import com.gm.infobus.util.MD5;

/**
 * @Description:
 * @author liuwei
 * @date 2013年11月12日 下午3:28:39
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;

	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(userValidator);
	}

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "register")
	@ResponseBody
	public JsonResponse addNewUser(@Valid User user, BindingResult result) {
		JsonResponse response = new JsonResponse();
		if (!result.hasErrors()) {
			user.setPassword(MD5.encode(user.getPassword(),
					ConstantUtils.SALT_KEY));
			int userId = userService.addUser(user);
			if (userId > 0) {
				response.setResult(true);
				response.setData(user);
			} else {
				response.setResult(false);
				response.setMsg("注册用户失败，请检查你的网络是否连接!");
			}
		} else {
			response.setResult(false);
			response.setData(result.getAllErrors());
		}

		return response;
	}

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "verifyAccount")
	@ResponseBody
	public JsonResponse verifyUser(String accountName) {
		JsonResponse response = new JsonResponse();
		boolean isAccountNameExisted = userService
				.isAccountNameExisted(accountName);
		if (!isAccountNameExisted) {
			response.setResult(true);
		} else {
			response.setResult(false);
			response.setMsg("用户名已经存在!");
		}

		return response;
	}

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "verifyPlate")
	@ResponseBody
	public JsonResponse verifyPlate(String plate) {
		JsonResponse response = new JsonResponse();
		boolean isPlateExisted = userService.isPlateExisted(plate);
		if (!isPlateExisted) {
			response.setResult(true);
		} else {
			response.setResult(false);
			response.setMsg("车牌号已经存在!");
		}

		return response;
	}

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "login")
	@ResponseBody
	public JsonResponse login(User userParam) {
		JsonResponse response = new JsonResponse();
		userParam.setPassword(MD5.encode(userParam.getPassword(),
				ConstantUtils.SALT_KEY));
		User user = userService.getLoginUser(userParam);
		if (user != null) {
			response.setResult(true);
			response.setData(user);
			response.setMsg("登录成功.");
		} else {
			response.setResult(false);
			response.setMsg("用户名或者密码错误.");
		}

		return response;
	}

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "showAllUsers")
	@ResponseBody
	public String showAllUsers(@RequestBody User user) {
		if (user == null) {
			return toJSONError("参数有误");
		}
		List<User> users = userService.findAllUsers();
		System.out.println(toJSON(users));
		return toJSON(users);
	}
}
