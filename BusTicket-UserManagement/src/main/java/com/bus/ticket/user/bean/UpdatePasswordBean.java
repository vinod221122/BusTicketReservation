/**
 * 
 */
package com.bus.ticket.user.bean;

/**
 * @author VinodHoney Kusuma
 *
 */
public class UpdatePasswordBean {
	
	private String userName;
	private String oldPassword;
	private String password;
	private String confPassword;
	
	/**
	 * @return the oldPassword
	 */
	public String getoldPassword() {
		return oldPassword;
	}
	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setoldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * @return the confPassword
	 */
	public String getConfPassword() {
		return confPassword;
	}
	/**
	 * @param confPassword the confPassword to set
	 */
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	
	
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdatePasswordBean [userName=" + userName + ", oldPassword=" + oldPassword + ", password=" + password
				+ ", confPassword=" + confPassword + "]";
	}
	
	
}
