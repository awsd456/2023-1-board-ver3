package com.green.boardver3.board;


import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="게시판")
@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService service;

    @Autowired
    public BoardController(BoardService service){
        this.service=service;
    }

    @PostMapping
    @Operation(summary = "글쓰기",description = ""+
    "title:[50]제목<br>"+
    "ctnt:[text]내용<br>"+
    "iuser:[20]회원번호<br>")
    public int postBoard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);
    }

    @GetMapping
    List<BoardDto> getBoard(@RequestParam int page,@RequestParam int row){
        BoardDto dto=new BoardDto();
        dto.setPage(page);
        dto.setLowRen(row);
        return service.selBoard(dto);
    }

}
