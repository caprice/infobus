
package com.gm.infobus.entity;

import java.io.Serializable;


/**
* @Description: A new class
* @author liuwei
* @date 2013年11月12日 下午3:01:26
*/
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id; //自增id
	private String accountName;//用户名
	private String password;//密码
	private String rPassword;//确认密码
	private String birth;//出生年月日
	private String email;//email
	private String idCard;
	private String location;//地点
	private String mobile;//手机号码
	private String nickName;//昵称
	private String photo;//用户照片
	private String plate;//车牌号
	private String profession;//职业
	private String sex;//性别：0-男 1-女
	private String signature;
	private String userLog;
	private int status;

	
	public User() {
		super();
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}
	public final String getAccountName() {
		return accountName;
	}

	public final void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getBirth() {
		return birth;
	}

	public final void setBirth(String birth) {
		this.birth = birth;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getIdCard() {
		return idCard;
	}

	public final void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public final String getLocation() {
		return location;
	}

	public final void setLocation(String location) {
		this.location = location;
	}

	public final String getMobile() {
		return mobile;
	}

	public final void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public final String getNickName() {
		return nickName;
	}

	public final void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public final String getPhoto() {
		return photo;
	}

	public final void setPhoto(String photo) {
		this.photo = photo;
	}
	public final String getPlate() {
		return plate;
	}

	public final void setPlate(String plate) {
		this.plate = plate;
	}

	public final String getProfession() {
		return profession;
	}

	public final void setProfession(String profession) {
		this.profession = profession;
	}

	public final String getSex() {
		return sex;
	}

	public final void setSex(String sex) {
		this.sex = sex;
	}

	public final String getUserLog() {
		return userLog;
	}

	public final void setUserLog(String userLog) {
		this.userLog = userLog;
	}

	public final int getStatus() {
		return status;
	}

	public final void setStatus(int status) {
		this.status = status;
	}

	public final String getrPassword() {
		return rPassword;
	}

	public final void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}

	public final String getSignature() {
		return signature;
	}

	public final void setSignature(String signature) {
		this.signature = signature;
	}

}
