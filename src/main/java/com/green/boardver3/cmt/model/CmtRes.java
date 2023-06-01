package com.green.boardver3.cmt.model;


import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CmtRes {

    private int maxPage;
    private int isMore; //0댓글 더없음 1댓글더있음
    private List<CmtVo> list;

}
