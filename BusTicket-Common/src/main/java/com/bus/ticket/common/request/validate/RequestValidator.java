/**
 * 
 */
package com.bus.ticket.common.request.validate;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.springframework.util.StringUtils;

import com.exception.BadRequestException;

/**
 * @author VinodHoney Kusuma
 *
 */
public class RequestValidator {
	
	public static void validateObject(Object object){
		if(Objects.isNull(object)||StringUtils.isEmpty(object))
			throw new BadRequestException();
	}

	public static boolean validateRequest(Object object){
		
		validateObject(object);
		try {
			PropertyDescriptor[] discripterArray=Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
			for(PropertyDescriptor discripter:discripterArray){
				if((Objects.isNull(discripter.getReadMethod().invoke(object)) || StringUtils.isEmpty(discripter.getReadMethod().invoke(object))))
					throw new BadRequestException();
			}
		} catch (IntrospectionException | BadRequestException e ) {
			throw new BadRequestException();
		} catch (IllegalAccessException e) {
			throw new BadRequestException();
		} catch (IllegalArgumentException e) {
			throw new BadRequestException();
		} catch (InvocationTargetException e) {
			throw new BadRequestException();
		}
		return true;
	}
	
	
}
