/**
 * 
 */
package com.bus.ticket.user.service;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ticket.common.request.validate.RequestValidator;
import com.bus.ticket.user.bean.LoginDetailsBean;
import com.bus.ticket.user.bean.UpdatePasswordBean;
import com.bus.ticket.user.bean.UserDetailsBean;
import com.bus.ticket.user.entity.entities.Role;
import com.bus.ticket.user.entity.entities.User;
import com.bus.ticket.user.entity.repositories.UserRepository;
import com.exception.BadRequestException;
import com.exception.CommonException;
import com.exception.UserExistException;

/**
 * @author VinodHoney Kusuma
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDetailsBean persistUser(UserDetailsBean userDetailsBean) {
		Role role = new Role();
		RequestValidator.validateRequest(userDetailsBean);
		
		//user = userRepository.findByUsername(userDetailsBean.getUserId());
		User user=getUserByUserName(userDetailsBean);
		if (Objects.nonNull(user) && user.getUsername().equals(userDetailsBean.getUserId()))
			throw new UserExistException();
		user=new User();
		user.setFirstName(userDetailsBean.getFirstName());
		user.setMiddleName(userDetailsBean.getMiddleName());
		user.setLastName(userDetailsBean.getLastName());
		user.setUsername(userDetailsBean.getUserId());
		user.setPassword(userDetailsBean.getPassword());
		user.setMobile(userDetailsBean.getMobile());
		user.setCPassword(userDetailsBean.getConfPassword());
		user.setEmail(userDetailsBean.getEmail());
		if (userDetailsBean.isAgent()) {
			user.setBTravels("Y");
			role.setId(3);
			user.setRole(role);
		} else {
			role.setId(2);
			user.setRole(role);
		}

		user = userRepository.save(user);
		return userDetailsBean;
	}

	public UserDetailsBean loginUser(LoginDetailsBean loginDetailsBean) {
		RequestValidator.validateRequest(loginDetailsBean);
		User user = userRepository.findByUsernameAndPassword(loginDetailsBean.getUserName(),
				loginDetailsBean.getPassword());
		return setUserToUserDatailsBean(user);
	}

	private UserDetailsBean setUserToUserDatailsBean(User user) {
		RequestValidator.validateRequest(user);
		UserDetailsBean userDetailsBean = new UserDetailsBean();
		userDetailsBean.setUserId(user.getUsername());
		userDetailsBean.setPassword(user.getPassword());
		userDetailsBean.setMobile(user.getMobile());
		userDetailsBean.setFirstName(user.getFirstName());
		userDetailsBean.setMiddleName(user.getMiddleName());
		userDetailsBean.setLastName(user.getLastName());
		userDetailsBean.setEmail(user.getEmail());
		userDetailsBean.setConfPassword(user.getCPassword());
		if (user.getBTravels().equals("Y"))
			userDetailsBean.setAgent(true);
		return userDetailsBean;

	}

	public UserDetailsBean updatePassword(UpdatePasswordBean updatePasswordBean) {
		RequestValidator.validateRequest(updatePasswordBean);
		//User user = userRepository.findByUsername(updatePasswordBean.getUserName());
		User user=getUserByUserName(updatePasswordBean);
		RequestValidator.validateObject(user);
		return validateAndUpdatePassword(updatePasswordBean, user);
	}

	private UserDetailsBean validateAndUpdatePassword(UpdatePasswordBean updatePasswordBean, User user) {
		if (!user.getPassword().equals(updatePasswordBean.getoldPassword()))
			throw new BadRequestException();
		if(!updatePasswordBean.getPassword().equals(updatePasswordBean.getConfPassword())){
			throw new BadRequestException();
		}
		user.setPassword(updatePasswordBean.getPassword());
		user.setCPassword(updatePasswordBean.getConfPassword());
		user = userRepository.save(user);
		RequestValidator.validateObject(user);
		return setUserToUserDatailsBean(user);
	}

	public UserDetailsBean forgetPassword(UpdatePasswordBean updatePasswordBean) {
		RequestValidator.validateObject(updatePasswordBean);
		User user = getUserByUserName(updatePasswordBean);
		RequestValidator.validateObject(user);
		user=userRepository.save(user);
		return setUserToUserDatailsBean(user);
	}
	
	private User getUserByUserName(Object object){
		RequestValidator.validateObject(object);
		User user=null;
		try {
			PropertyDescriptor[] propertyDescriptors=Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
			for(PropertyDescriptor propertyDescriptor:propertyDescriptors){
				//System.out.println(propertyDescriptor.getReadMethod().getName());
				if(propertyDescriptor.getReadMethod().getName().contains("UserName") ||propertyDescriptor.getReadMethod().getName().contains("UserId") ){
					String value=(String) propertyDescriptor.getReadMethod().invoke(object);
					//System.out.println(value);
					user=userRepository.findByUsername(value);
					break;
				}
			}
		} catch (IntrospectionException e) {
			throw new CommonException();
		} catch (IllegalAccessException e) {
			throw new CommonException();
		} catch (IllegalArgumentException e) {
			throw new CommonException();
		} catch (InvocationTargetException e) {
			throw new CommonException();
		}
		
		return user;
	}

}
