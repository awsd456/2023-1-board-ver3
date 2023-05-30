package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public int postUser(@RequestBody UserInsDto dto){
        return service.insBoard(dto);
    }

}
