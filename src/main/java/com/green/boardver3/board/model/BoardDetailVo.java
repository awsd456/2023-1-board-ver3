package com.green.boardver3.board.model;

import com.green.boardver3.cmt.model.CmtVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardDetailVo {

    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String mainPic;
    private String createdAt;
}
