package com.gm.infobus.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.gm.infobus.constant.StageConstant;


public abstract class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected ServletContext servletContext;

	@Autowired
	protected HttpSession session;

	@Autowired
	protected HttpServletRequest request;
	
	/**
	 * 转JSON格式.
	 * 
	 * @param resultData
	 *            the result data
	 * @return the string
	 */
	protected String toJSON(Object resultData) {
		return toJSON(resultData, null);
	}

	/**
	 * 转JSON格式带参数.
	 * 
	 * @param resultData
	 *            the result data
	 * @param config
	 *            the config
	 * @return the string
	 */
	protected String toJSON(Object resultData, JsonConfig config) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(StageConstant.JSON.KEY_RESULT,
				StageConstant.JSON.RESULT_OK);
		jsonObj.put(StageConstant.JSON.KEY_DATA, resultData);
		String resData = null;
		if (config != null) {
			resData = JSONObject.fromObject(jsonObj, config).toString();
		} else {
			resData = JSONObject.fromObject(jsonObj).toString();
		}
		logger.debug(resData);
		return resData;
	}

	/**
	 * 转JSON格式（返回错误）.
	 * 
	 * @param errorMessage
	 *            the error message
	 * @return the string
	 */
	protected String toJSONError(String errorMessage) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(StageConstant.JSON.KEY_RESULT,
				StageConstant.JSON.RESULT_FAILED);
		jsonObj.put(StageConstant.JSON.KEY_MESSAGE, errorMessage);
		String resData = JSONObject.fromObject(jsonObj).toString();
		logger.debug(resData);
		return resData;
	}

}
