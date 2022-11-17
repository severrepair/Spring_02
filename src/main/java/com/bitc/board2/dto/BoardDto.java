package com.bitc.board2.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int idx;
    private String title;
    private String contents;
    private String userId;
    private String pwd;
    private String createDt;
    private String updateDt;
    private int hitCnt;
}
