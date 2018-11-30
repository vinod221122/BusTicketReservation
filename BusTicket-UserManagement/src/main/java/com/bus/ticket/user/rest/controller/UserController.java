/**
 * 
 */
package com.bus.ticket.user.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bus.ticket.user.bean.LoginDetailsBean;
import com.bus.ticket.user.bean.UpdatePasswordBean;
import com.bus.ticket.user.bean.UserDetailsBean;
import com.bus.ticket.user.service.UserService;

/**
 * @author VinodHoney Kusuma
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDetailsBean> persistUser(@RequestBody UserDetailsBean userDetailsBean) {

		UserDetailsBean response = userService.persistUser(userDetailsBean);

		return new ResponseEntity<UserDetailsBean>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDetailsBean> loginUser(@RequestBody LoginDetailsBean loginDetailsBean) {

		UserDetailsBean response = userService.loginUser(loginDetailsBean);

		return new ResponseEntity<UserDetailsBean>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDetailsBean> updatePassword(@RequestBody UpdatePasswordBean updatePasswordBean) {

		UserDetailsBean response = userService.updatePassword(updatePasswordBean);

		return new ResponseEntity<UserDetailsBean>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UserDetailsBean> forgetPassword(@RequestBody UpdatePasswordBean updatePasswordBean) {

		UserDetailsBean response = userService.forgetPassword(updatePasswordBean);

		return new ResponseEntity<UserDetailsBean>(response, HttpStatus.OK);

	}
}
