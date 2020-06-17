package pojo;

public class User {

	private long id;
	private String userName;
	private int roleId;
	private String mobile;
	private String password;
	
	public static final String ID = "id";
	public static final String USERNAME = "user_name";
	public static final String ROLE_ID = "role_id";
	public static final String MOBILE = "phone_number";
	public static final String PASSWORD = "key";
	
	public User(Builder builder) {
		this.id = builder.id;
		this.userName = builder.userName;
		this.roleId = builder.roleId;
		this.mobile = builder.mobile;
		this.password = builder.password;
	}
	
	public static class Builder{
		
		private long id;
		private String userName;
		private int roleId;
		private String mobile;
		private String password;
		
		public Builder id(long id) {
			 this.id = id;
			 return this;
		}

		public Builder userName(String userName) {
			 this.userName = userName;
			 return this;
		}
		
		public Builder roleId(int roleId) {
			 this.roleId = roleId;
			 return this;
		}
		
		public Builder mobile(String mobile) {
			 this.mobile = mobile;
			 return this;
		}
		
		public Builder password(String password) {
			 this.password = password;
			 return this;
		}
		
		public User build() {
		     return new User(this);
		 }
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
