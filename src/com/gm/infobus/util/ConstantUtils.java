package com.gm.infobus.util;

public interface ConstantUtils {
	public interface Request {
		String KEY_ARTICLES = "articles";
		String KEY_CATEGORY = "category";
		String KEY_ONE_ARTICLE = "article";
	}

	public interface JSON {
		String KEY_RESULT = "result";
		String KEY_MESSAGE = "message";
		String KEY_DATA = "data";

		String RESULT_OK = "ok";
		String RESULT_FAILED = "failed";
	}
	
	public interface JSP {
		String PAGE_ERROR = "error";
		String PAGE_NOT_FOUND = "404";
	}
}
