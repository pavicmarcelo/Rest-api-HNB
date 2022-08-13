package com.rest.restapihnb.repository;

import com.rest.restapihnb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u set u.password = :password WHERE u.id = :id")
    int updateUserPassword(@Param("password") String password, @Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u set u.email = :email WHERE u.id = :id")
    void updateUserEmail(@Param("id") Integer userId, @Param("email") String email);

}
