package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardDetail {

    private int iboard;
    private String title;
    private String ctnt;
    private String iuser;
    private String createdAt;
    private String updatedAt;
}
