package com.green.boardver3.board;


import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardEntity;
import com.green.boardver3.board.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int insBoard(BoardInsDto dto);
    List<BoardDto> selBoard(BoardDto dto);
}
