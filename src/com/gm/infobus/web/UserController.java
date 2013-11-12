package com.gm.infobus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.infobus.entity.User;
import com.gm.infobus.service.UserService;


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

	
	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "register", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String addNewUser(@RequestBody User user) {
		if (user == null) {
			return toJSONError("参数有误");
		}
		int userId = userService.addUser(user);
		if(userId > 0){
			return this.toJSON(user);
		}else{
			return this.toJSONError("注册用户失败，请检查你的网络是否连接!");
		}
	}
	
	
	/**
	 * 
	 * @param condition
	 *            the condition
	 * @return the object
	 */
	@RequestMapping(value = "login")
	@ResponseBody
	public String login(@RequestBody User user) {
		if (user == null) {
			return toJSONError("参数有误");
		}
		int userId = userService.addUser(user);
		if(userId > 0){
			return this.toJSON(user);
		}else{
			return this.toJSONError("注册用户失败，请检查你的网络是否连接!");
		}
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
	
	public static void main(String[] args) {
		UserController c = new UserController();
		User user = new User();
		String userStr = c.toJSON(user);
		System.out.println(userStr);
	}
}
