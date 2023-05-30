package com.green.boardver3;

import com.green.boardver3.model.UserDto;
import com.green.boardver3.model.UserInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insBoard(UserInsDto dto);
}
