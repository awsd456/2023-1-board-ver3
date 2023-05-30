package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "회원가입",description = ""+
    "uid:[20] 회원 아이디,<br>" +
    "upw:[100] 회원 비밀번호,<br>" +
    "nm:[30] 회원명,<br>" +
    "gender:[20] 회원 성별(M:남성,F:여성),<br>" +
    "addr:[100] 회원 주소")
    public int postUser(@RequestBody UserInsDto dto){
        return service.insBoard(dto);
    }

}
