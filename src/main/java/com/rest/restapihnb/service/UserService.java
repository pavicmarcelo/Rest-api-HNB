package com.rest.restapihnb.service;

import com.rest.restapihnb.dto.UserProductDTO;
import com.rest.restapihnb.model.Product;
import com.rest.restapihnb.model.User;
import com.rest.restapihnb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private UserRepo userRepo;


    public List<UserProductDTO> getAllUsersProducts() {

        return userRepo.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }


    private UserProductDTO convertEntityToDTO(User user) {

        UserProductDTO userProductDTO = new UserProductDTO();

        userProductDTO.setUserId(user.getId());
        userProductDTO.setEmail(user.getEmail());
        userProductDTO.setCode(user.getProduct().getCode());
        userProductDTO.setName(user.getProduct().getName());
        userProductDTO.setPrice(user.getProduct().getPrice_eur());

        return userProductDTO;
    }



}
