package com.rest.restapihnb.repository;

import com.rest.restapihnb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.transaction.Transactional;


public interface UserRepo extends JpaRepository<User, Long> {


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u set u.email = :email WHERE u.id = :id")
    void updateUserEmail(@Param("id") Long userId, @Param("email") String email);

}
