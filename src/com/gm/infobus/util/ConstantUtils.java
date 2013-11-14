package com.gm.infobus.util;

public interface ConstantUtils {
	public final static String SALT_KEY = "GM";
	public static final String TOKEN_KEY = "DiDi7538";
	public interface Request {
		String KEY_ARTICLES = "articles";
		String KEY_CATEGORY = "category";
		String KEY_ONE_ARTICLE = "article";
	}

	public interface JSON {
		String KEY_RESULT = "result";
		String KEY_MESSAGE = "message";
		String KEY_DATA = "data";

		String RESULT_OK = "0";
		String RESULT_FAILED = "-1";
	}
	
	public interface JSP {
		String PAGE_ERROR = "error";
		String PAGE_NOT_FOUND = "404";
	}
}
