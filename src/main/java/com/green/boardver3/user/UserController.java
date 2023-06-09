package com.green.boardver3.user;

import com.green.boardver3.user.model.UserInsDto;
import com.green.boardver3.user.model.UserLoginDto;
import com.green.boardver3.user.model.UserPatchPicDto;
import com.green.boardver3.user.model.UserPatchPwDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/login")
    @Operation(summary = "로그인",description = ""+
    "리턴값:"+
    "(1)로그인 성공"+
    "(2)아이디없음"+
    "(3)비밀번호 다름")
    public int postLoginUser(@RequestBody UserLoginDto dto){
        return service.login(dto);
    }


    @PatchMapping("/pw")
    @Operation(summary = "비밀번호 변경",description = ""+
    "iuser:[20]유저 번호<br>"+
    "upw:[100]유저 비밀번호<br>")
    public int patchUser(@RequestBody UserPatchPwDto dto){
        return service.updUserPw(dto);
    }

    @PatchMapping(name="/pic",consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser){
        UserPatchPicDto dto=new UserPatchPicDto();
        dto.setIuser(iuser);
        return service.updUserPic(pic,dto);
    }



}
