package me.nsarvar.controller;

import me.nsarvar.UserAssembler;
import me.nsarvar.exception.ResourceNotFoundException;
import me.nsarvar.model.User;
import me.nsarvar.service.UserService;
import me.nsarvar.vo.CreateUserVO;
import me.nsarvar.vo.UpdateUserVO;
import me.nsarvar.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by nsarvar on 12/27/17.
 *
 * ResponseEntity is meant to represent the entire HTTP response. You can control anything that goes into it:
 * status code, headers, and body.
 * @RequestBody maps HttpRequest body to a transfer or domain object, enabling automatic deserialization of the
 * inbound HttpRequest body onto a Java object
 * @ResponseBody tells a controller that the object returned is automatically serialized into JSON and
 * passed back into the HttpResponse object
 * @ResponseStatus declares the status code of the HTTP response.
 * @RestController - annotation that adds the @Controller and @ResponseBody annotations itself
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVO getUser(@PathVariable("id") long id){
        User user = userService.getUserById(id);

        if(user == null)
            throw new ResourceNotFoundException(id, "User not found");

        return userAssembler.toUserVO(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

@RequestMapping(method = RequestMethod.POST)
public UserVO createUser(@Valid @RequestBody CreateUserVO userVO) {
    //convert to User
    User user = userAssembler.toUser(userVO);
    //save User
    User savedUser = userService.createUser(user);
    //convert to UserVO
    return userAssembler.toUserVO(savedUser);
}

    @RequestMapping(method = RequestMethod.PUT)
    public UserVO updateUser(@Valid @RequestBody UpdateUserVO updateUserVO) {
        //convert to User
        User user = userAssembler.toUser(updateUserVO);
        //update User
        User updatedUser = userService.updateUser(user);
        //convert to UserVO
        return userAssembler.toUserVO(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
