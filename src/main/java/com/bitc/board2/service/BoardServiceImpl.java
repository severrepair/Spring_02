package com.bitc.board2.service;

import com.bitc.board2.dto.BoardDto;
import com.bitc.board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto selectBoardDetail(int idx) throws Exception {
        BoardDto board = boardMapper.selectBoardDetail(idx);
        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int idx) throws Exception {
        boardMapper.deleteBoard(idx);
    }
}







