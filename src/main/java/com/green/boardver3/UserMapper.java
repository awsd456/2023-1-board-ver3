package com.green.boardver3;

import com.green.boardver3.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insBoard(UserDto dto);
}
