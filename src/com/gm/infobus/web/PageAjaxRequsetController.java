package com.gm.infobus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.infobus.entity.User;
import com.gm.infobus.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class PageAjaxRequsetController extends BaseController {
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "more")
	@ResponseBody
	public Object showAllUsers(@RequestBody User user) {
		if (user == null) {
			return toJSONError("参数有误");
		}
		System.out.println(user.getName());
		List<User> users = userService.findAllUsers();
		System.out.println(toJSON(users));
		return toJSON(users);
	}
}
