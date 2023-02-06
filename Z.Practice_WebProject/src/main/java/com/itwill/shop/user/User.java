package com.itwill.shop.user;

/*
이름            널?       유형            
------------- -------- ------------- 
USER_ID       NOT NULL VARCHAR2(100) 
USER_PASSWORD          VARCHAR2(100)  
USER_NAME              VARCHAR2(100) 
USER_EMAIL             VARCHAR2(100) 
USER_PHONE             VARCHAR2(50)  
USER_ADDRESS           VARCHAR2(100)    
*/	

public class User {
	
	private String userid;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userid, String password, String name, String email, String phone, String address) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	/*
	 * 패쓰워드 일치여부 검사
	 */
	public boolean isMathPassword(String password) {
		boolean isMatch = false;
		if(this.password.equals(password)) {
			isMatch = true;
		}
		return isMatch;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", address=" + address + "]";
	}
		
}