package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String uid;
    private String nm;
    private String mainPic;
    private String createdAt;
    private String updatedAt;
}
