package com.bitc.board2.mapper;

import com.bitc.board2.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardDto> selectBoardList() throws Exception;

    public void insertBoard(BoardDto boardDto) throws Exception;

    public BoardDto selectBoardDetail(int idx) throws Exception;

    public void updateBoard(BoardDto board) throws Exception;

    public void deleteBoard(int idx) throws Exception;
}
