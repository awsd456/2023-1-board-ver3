package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardEntity extends BoardInsDto{

    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
    private String created_at;
    private String updated_at;


}
