package com.green.boardver3.board;


import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private  BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper){
        this.mapper=mapper;
    }

    public int insBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }

    public List<BoardDto> selBoard(BoardDto dto){
    int stardIdx=(dto.getPage()-1)*dto.getLowRen();
    dto.setStardIdx(stardIdx);
        return mapper.selBoard(dto);
    }
}
