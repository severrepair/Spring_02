package com.bitc.board2.service;

import com.bitc.board2.dto.BoardDto;

import java.util.List;

public interface BoardService {
    public List<BoardDto> selectBoardList() throws Exception;

    public void insertBoard(BoardDto board) throws Exception;

    public BoardDto selectBoardDetail(int idx) throws Exception;

    public void updateBoard(BoardDto board) throws Exception;

    public void deleteBoard(int idx) throws Exception;
}
