package com.gm.infobus.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @Description: A new class
 * @author liuwei
 * @date 2013年11月12日 下午3:01:26
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;// 用户名
	private String createDate;
	private String email;// email
	private String name;
	private String password;// 密码
	private String rPassword;// 确认密码
	private int status;
	private String updateDate;
	private UserDetail userDetail;

	public User() {
		super();
	}

	public final String getCreateDate() {
		return createDate;
	}

	public final String getEmail() {
		return email;
	}

	public final String getName() {
		return name;
	}

	@JsonProperty
	public final String getPassword() {
		return password;
	}

	@JsonProperty
	public final String getrPassword() {
		return rPassword;
	}

	public final int getStatus() {
		return status;
	}

	public final String getUpdateDate() {
		return updateDate;
	}

	public final UserDetail getUserDetail() {
		return userDetail;
	}

	public final void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public final void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public final void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}

	public final void setStatus(int status) {
		this.status = status;
	}

	public final void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public final void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

}
