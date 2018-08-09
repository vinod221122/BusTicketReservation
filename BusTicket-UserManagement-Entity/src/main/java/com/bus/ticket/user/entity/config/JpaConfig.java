/**
 * 
 */
package com.bus.ticket.user.entity.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author VinodHoney Kusuma
 *
 */
@Configuration
@EnableJpaRepositories("com.bus.ticket.user")
@EntityScan("com.bus.ticket.user")
public class JpaConfig {

	/*@Bean
	@ConfigurationProperties("spring.datasource")
	public ComboPooledDataSource dataSource(){
		return new ComboPooledDataSource();
	}*/
}
