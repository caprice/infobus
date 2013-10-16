package com.gm.infobus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gm.infobus.entity.Coordinate;
import com.gm.infobus.entity.Equipment;
import com.gm.infobus.entity.ZoneArea;
import com.gm.infobus.service.LoginService;
import com.gm.infobus.service.MainSearchService;

/**
 * @author lw 登录页面
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private MainSearchService mainService;

	/**
	 * 登录验证，登录成功取得机器坐标
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "index")
	public String index(ModelMap modelMap) {
		List<Equipment> list = loginService.getAllEquipmentNames();
		if (list == null || list.isEmpty()) {
			modelMap.addAttribute("msg", "没有机器!");
			return "redirect:index";
		} else {
			modelMap.addAttribute("msg", "登录成功");
			modelMap.addAttribute("equipNames", list);
			return "addUser";
		}
	}

	/**
	 * 登录验证，登录成功取得机器坐标
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "validate")
	public ModelAndView login(Equipment equipment) {
		ModelAndView mv = new ModelAndView();
		List<Equipment> list = loginService.getEquipmentByLoginInfo(equipment);
		if (list == null || list.isEmpty()) {
			mv.addObject("msg", "密码错误");
			mv.setViewName("redirect:index");
		} else {
			mv.addObject("msg", "登录成功");
			Equipment equip = list.get(0);
			Coordinate coordinate = this.loginService
					.getLoginEquipmentCoordinate(equip.getCoordinate());
			mv.addObject("coordinate", coordinate);
			// 进入main页面
			mv.setViewName("main");
		}
		return mv;
	}
}
