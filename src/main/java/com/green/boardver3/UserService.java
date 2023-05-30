package com.green.boardver3;

import com.green.boardver3.model.UserDto;
import com.green.boardver3.model.UserInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper){
        this.mapper=mapper;
    }

    public int insBoard(UserInsDto dto){
        return mapper.insBoard(dto);
    }
}
