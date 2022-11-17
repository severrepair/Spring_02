package com.bitc.board2.controller;

import com.bitc.board2.dto.BoardDto;
import com.bitc.board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Rest 란?
//  Representational State Transfer 의 약자
//  기존 웹은 웹의 프로토콜인 HTTP의 모든 기능을 다 활용하지 못하고 있어 그것을 해결하기 위한 방법으로 제시된 방식
//  자원을 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든 것
//  HTTP 프로토콜을 그대로 활용(GET, POST, UPDATE, DELETE)하여 해당 자원의 CRUD 명령을 적용하는 것을 의미함
//  웹의 모든 자원에 고유한 ID인 HTTP URI를 부여함

//  자원 (Resource) URL
//  모든 자원에 고유한 ID가 존재하고, 이 자원은 서버에 존재
//  자원을 구분하는 ID는 /order/order_id/1 형태 같은 HTTP URI 임

//  행위 (Verb) HTTP Method
//  Http 프로토콜의 Method 임
//  Http 프로토콜은 GET, POST, PUT, DELETE와 같은 메서드를 제공

//  표현 (Repersentation of Resource)
//  Client 가 자원의 상태에 대한 조작을 요청 시 서버는 이에 적절한 응답을 보냄
//  REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 나타낼 수 있음
//  현재는 JSON으로 주고 받는 것이 대부분임

//  GET : 해당 URI의 리소스를 조회
//  POST : 리소스를 생성
//  PUT : 해당 URI의 리소스를 수정
//  DELETE : 해당 URI의 리소스를 삭제

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/restBoardList");

        List<BoardDto> boardList = boardService.selectBoardList();
        mv.addObject("boardList", boardList);

        return mv;
    }

//    아래의 writeBoard()와 insertBoard() 메서드는 서로 매칭된 주소가 동일하지만 method의 타입이 다르기 때문에 다르게 동작됨
//    get을 사용한 writeBoard() 메서드는 view를 표현하고, post를 사용한 insertBoard() 메서드는 데이터를 추가함
    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String writeBoard() throws Exception {
        return "board/restWriteBoard";
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);

        return "redirect:/board";
    }

//    @PathVariable : URI의 리소스가 메서드의 파라미터로 사용하는 어노테이션
    @RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("board/restBoardDetail");

        BoardDto board = boardService.selectBoardDetail(idx);
        mv.addObject("board", board);

        return mv;
    }

    @RequestMapping(value = "/board/update/{idx}", method = RequestMethod.PUT)
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/delete/{idx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
        boardService.deleteBoard(idx);
        return "redirect:/board";
    }

}







