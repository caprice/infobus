package com.gm.infobus.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.infobus.constant.StageConstant.JSON;
import com.gm.infobus.entity.ZoneArea;
import com.gm.infobus.entity.ZoneJsonEntity;
import com.gm.infobus.service.MainSearchService;

/**
 * 菜单跳转界面，点击相应链接或按钮进入对应功能页面
 * 
 * @author lw
 */
@Controller
@RequestMapping(value = "/main")
public class MainPageController extends BaseController {
	@Autowired
	private MainSearchService mainService;

	/**
	 * 菜单页面，点击相应链接或按钮进入对应功能页面
	 * 
	 * @return the string
	 */

	/**
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "searchPage")
	public String goToSearchPage(ModelMap modelMap) {
		List<ZoneArea> zoneAreaList = mainService.getAllZoneAreas();
		modelMap.addAttribute("zoneAreaList", zoneAreaList);
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		modelMap.addAttribute("x", x);
		modelMap.addAttribute("y", y);
		return "searchInfo";
	}
	
	@RequestMapping(value = "showCemeteryZones")
	@ResponseBody
	public String showCemeteryZoneList() {
		String requestId = request.getParameter("areaId");
		if(requestId == null){
			this.toJSONError("failure");
		}
		int areaId = Integer.parseInt(requestId);
		List<ZoneJsonEntity> cemeteryZoneList = mainService.getAllCemeteryZoneByZoneId(areaId);
//		map.put(JSON.KEY_RESULT, JSON.RESULT_OK);
//		map.put(JSON.KEY_DATA, cemeteryZoneList);
		System.out.println(this.toJSON(cemeteryZoneList));
		return this.toJSON(cemeteryZoneList);
	}

}
