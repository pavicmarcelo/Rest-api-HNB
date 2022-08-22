package com.rest.restapihnb.controller;

import com.rest.restapihnb.dto.UserProductDTO;
import com.rest.restapihnb.model.User;
import com.rest.restapihnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
/*
    @GetMapping("/getAllUserProductDTO")
    public List<UserProductDTO> getAllUserProductDTO() {

        return userService.getAllUsersProducts();
    }
*/

    @RequestMapping (value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public User creatingUser(@RequestBody User product) {
        return userService.saveUser(product);
    }


    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    User getUserById(@PathVariable(value = "id") final Long id) {
        return userService.getUserById(id);
    }


    @RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public String deleteUserById (@PathVariable(value = "id") final Long id) {
        userService.deleteUserById(id);
        return "User with id: " + id + " is deleted!";
    }



    @RequestMapping(value = "/user/{id}/emailUpdate", method = RequestMethod.PUT, consumes = "application/json;")
    public String updateUserEmail (@PathVariable Long id, @RequestBody User user) {

        userService.updateUserEmail(id, user.getEmail());
        return "Updated...";
    }


}
