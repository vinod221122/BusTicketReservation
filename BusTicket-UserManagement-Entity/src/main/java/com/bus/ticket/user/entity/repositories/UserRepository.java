/**
 * 
 */
package com.bus.ticket.user.entity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.ticket.user.entity.entities.User;

/**
 * @author VinodHoney Kusuma
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String userId);
	public User findByUsernameAndPassword(String userId,String password);
}
