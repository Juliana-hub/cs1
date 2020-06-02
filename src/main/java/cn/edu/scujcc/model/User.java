package cn.edu.scujcc.model;

import org.springframework.data.annotation.Id;

public class User {
	public static String CACHE_NAME="users";
	@Id
	private String id;
	private String username;
	private String password;
	private String phone;
	private String gender;
	private String birthday;
	private String last_login;
	private String last_ip;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsename() {
		return username;
	}
	public void setUsename(String usename) {
		this.username = usename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		//result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((last_ip == null) ? 0 : last_ip.hashCode());
		result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		//if (id == null) {
			//if (other.id != null)
				//return false;
		//} else if (!id.equals(other.id))
			//return false;
		if (last_ip == null) {
			if (other.last_ip != null)
				return false;
		} else if (!last_ip.equals(other.last_ip))
			return false;
		if (last_login == null) {
			if (other.last_login != null)
				return false;
		} else if (!last_login.equals(other.last_login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usename=" + username + ", password=" + password + ", phone=" + phone + ", gender="
				+ gender + ", birthday=" + birthday + ", last_login=" + last_login + ", last_ip=" + last_ip + "]";
	}
	
 
}
