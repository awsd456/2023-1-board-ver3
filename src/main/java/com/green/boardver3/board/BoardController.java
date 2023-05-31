package com.green.boardver3.board;


import com.green.boardver3.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="게시판")
@RestController
@Validated
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
    @Operation(summary = "게시판",description = ""+
    "iboard:[20]게시판 번호<br>"+
    "title:[50]제목<br>"+
    "ctnt:[text]내용<br>"+
    "iuser:[20]회원번호<br>"+
    "createdAt:게시판 생성일자<br>")
    List<BoardVo> getBoard(@RequestParam @Min(value=1, message="page값은 1이상이어야 합니다")  int page, @RequestParam(defaultValue = "30") int row){
        BoardSelDto dto= new BoardSelDto();
       dto.setPage(page);
       dto.setRow(row);

        return service.selBoard(dto);
    }
    @GetMapping("/maxpage")
    public int getBoardMaxPage(@RequestParam int row){
        return service.selBoardRowCountMaxPage(row);
    }


    @GetMapping("/{iboard}")
    public BoardDetailVo getBoardDetail(@PathVariable int iboard) {
        BoardSelDto dto= new BoardSelDto();
        dto.setIboard(iboard);
        return service.selBoardDetail(dto);
    }

    @DeleteMapping
    public int delBoard(@RequestParam int iboard,@RequestParam int iuser){
        BoardDelDto dto=new BoardDelDto();
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.delBoard(dto);
    }


}
