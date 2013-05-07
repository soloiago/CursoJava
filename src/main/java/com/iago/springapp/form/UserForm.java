package com.iago.springapp.form;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.iago.springapp.service.LoginService;


public class UserForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname;
	private String password;
	
	//Profile
	private String name;
	private String surname;
	private String email;
	private CommonsMultipartFile avatar;

	@Autowired
	private LoginService loginService;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CommonsMultipartFile getFileData()
	{
		return avatar;
	}

	public void setFileData(CommonsMultipartFile fileData)
	{
		this.avatar = fileData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void validateSignup(ValidationContext context) {
        MessageContext messages = context.getMessageContext();
        if (nickname.equals("")) {
            messages.addMessage(new MessageBuilder().error().source("nickname").
                defaultText("Tienes que escribir algo").build());
        } else if (isUser(nickname)) {
        	messages.addMessage(new MessageBuilder().error().source("nickname").
                    defaultText("El usuario ya existe").build());
        }
    }
	
	private boolean isUser(String nickname)  {
		boolean result = false;
		
		try {
			boolean isUser = getLoginService().isUser(nickname);
			if(isUser) {
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public String insertUser() {
		String result = "success";
		
		try {
			if(!getLoginService().insertUser(this)) {
				result = "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
