package com.bitc.board2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OutsideController {

    @RequestMapping(value = "/outside/imgLoad", method = RequestMethod.GET)
    public String imgLoad() throws Exception {
        return "outside/imgLoad";
    }
}
