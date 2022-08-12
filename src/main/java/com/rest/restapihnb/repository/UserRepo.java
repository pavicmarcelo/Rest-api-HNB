package com.rest.restapihnb.repository;

import com.rest.restapihnb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


}
