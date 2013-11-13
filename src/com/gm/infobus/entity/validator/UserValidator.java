package com.gm.infobus.entity.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.gm.infobus.entity.User;

/**
 * @Description:
 * @author liuwei
 * @date 2013年11月13日 下午1:16:04
 * 
 */
public class UserValidator extends BaseValidator {

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	/*
	 * (非 Javadoc) <p>Title: validate</p> <p>Description: </p>
	 * 
	 * @param obj
	 * 
	 * @param errors
	 * 
	 * @see
	 * com.gm.infobus.entity.validator.BaseValidator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "accountName", "用户名不能为空.");
		User user = (User) obj;
		if (user.getPassword() == null || user.getPassword().length() < 6
				|| user.getPassword().length() > 128) {
			errors.rejectValue("password", "密码长度不能小于3位并且不能大于128位.");
		}
		if (!user.getPassword().equals(user.getrPassword())) {
			errors.rejectValue("rPassword", "两次填写密码不一致.");
		}
		if (!this.isValidEmail(user.getEmail())) {
			errors.rejectValue("email", "不是有效的email.");
		}
		if (!this.isValidMobileNumber(user.getMobile())) {
			errors.rejectValue("mobile", "不是一个正确的手机号码.");
		}
	}

}
