package com.green.boardver3;

import com.green.boardver3.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService serivce){
        this.service = service;
    }

    @PostMapping
    public int insBoard(UserDto dto){
        return service.insBoard(dto);
    }

}
