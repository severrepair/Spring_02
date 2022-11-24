package com.bitc.board2.controller;

import com.bitc.board2.dto.AreaDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax/nonAjaxCalView", method = RequestMethod.GET)
    public String nonAjaxCalculatorView() throws Exception {
        return "ajax/nonAjaxCalView";
    }

    @RequestMapping(value = "/ajax/nonAjaxCalResult", method = RequestMethod.GET)
    public ModelAndView nonAjaxCalViewResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
        ModelAndView mv = new ModelAndView("ajax/nonAjaxCalResult");

        int result = num1 + num2;
        mv.addObject("result", result);

        return mv;
    }

    @RequestMapping(value = "/ajax/ajaxCalView", method = RequestMethod.GET)
    public String ajaxCalView() throws Exception {
        return "ajax/ajaxCalView";
    }

    @ResponseBody
    @RequestMapping(value = "/ajax/ajaxCalResult", method = RequestMethod.POST)
    public Object ajaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2")int num2) throws Exception {
        int result = num1 + num2;

//        Map<String, String> result = new HashMap<>();
//        result.put("result", "success");
//        result.put("value", String.valueOf(num1 + num2));

        return result;
    }

    @RequestMapping(value = "/ajax/selectbox", method = RequestMethod.GET)
    public String selectBox() throws Exception {
        return "ajax/selectbox";
    }

    @ResponseBody
    @RequestMapping(value = "/ajax/selectbox1", method = RequestMethod.POST)
    public Object box1Selected(AreaDto area) throws Exception {
        List<AreaDto> areaList = new ArrayList<>();

        if (area.getAreaName().equals("서울")) {
            AreaDto se1 = new AreaDto();
            AreaDto se2 = new AreaDto();
            AreaDto se3 = new AreaDto();
            AreaDto se4 = new AreaDto();
            
            se1.setAreaName("강북구");
            se2.setAreaName("강남구");
            se3.setAreaName("강서구");
            se4.setAreaName("강동구");

            areaList.add(se1);
            areaList.add(se2);
            areaList.add(se3);
            areaList.add(se4);

        }
        else if (area.getAreaName().equals("대전")) {
            AreaDto dj1 = new AreaDto();
            AreaDto dj2 = new AreaDto();
            AreaDto dj3 = new AreaDto();
            AreaDto dj4 = new AreaDto();

            dj1.setAreaName("동구");
            dj2.setAreaName("중구");
            dj3.setAreaName("서구");
            dj4.setAreaName("유성구");

            areaList.add(dj1);
            areaList.add(dj2);
            areaList.add(dj3);
            areaList.add(dj4);
        }
        else if (area.getAreaName().equals("대구")) {
            AreaDto dg1 = new AreaDto();
            AreaDto dg2 = new AreaDto();
            AreaDto dg3 = new AreaDto();
            AreaDto dg4 = new AreaDto();

            dg1.setAreaName("달서구");
            dg2.setAreaName("달성군");
            dg3.setAreaName("수성구");
            dg4.setAreaName("중구");

            areaList.add(dg1);
            areaList.add(dg2);
            areaList.add(dg3);
            areaList.add(dg4);
        }
        else if (area.getAreaName().equals("부산")) {
            AreaDto ps1 = new AreaDto();
            AreaDto ps2 = new AreaDto();
            AreaDto ps3 = new AreaDto();
            AreaDto ps4 = new AreaDto();
            
            ps1.setAreaName("부산진구");
            ps2.setAreaName("해운대구");
            ps3.setAreaName("동래구");
            ps4.setAreaName("영도구");

            areaList.add(ps1);
            areaList.add(ps2);
            areaList.add(ps3);
            areaList.add(ps4);
        }
        return areaList;
    }

    @ResponseBody
    @RequestMapping(value = "/ajax/selectbox2", method = RequestMethod.POST)
    public Object selectBox2(@RequestParam("area") String area) {
        List<AreaDto> areaList = new ArrayList<>();

        AreaDto ad1 = new AreaDto();
        AreaDto ad2 = new AreaDto();

        switch (area) {
            case "강서구":
                ad1.setAreaName("강서1동");
                ad2.setAreaName("강서2동");
                break;
            case "강북구":
                ad1.setAreaName("강북1동");
                ad2.setAreaName("강북2동");
                break;
            case "강동구":
                ad1.setAreaName("강동1동");
                ad2.setAreaName("강동2동");
                break;
            case "강남구":
                ad1.setAreaName("강남1동");
                ad2.setAreaName("강남2동");
                break;

            case "동구":
                ad1.setAreaName("동1동");
                ad2.setAreaName("동2동");
                break;
            case "중구":
                ad1.setAreaName("중1동");
                ad2.setAreaName("중2동");
                break;
            case "서구":
                ad1.setAreaName("서1동");
                ad2.setAreaName("서2동");
                break;
            case "유성구":
                ad1.setAreaName("유성1동");
                ad2.setAreaName("유성2동");
                break;

            case "달서구":
                ad1.setAreaName("달서1동");
                ad2.setAreaName("달서2동");
                break;
            case "달서군":
                ad1.setAreaName("달서1읍");
                ad2.setAreaName("달서2읍");
                break;
            case "수성구":
                ad1.setAreaName("수성1동");
                ad2.setAreaName("수성2동");
                break;
            case "대덕구":
                ad1.setAreaName("대덕1동");
                ad2.setAreaName("대덕2동");
                break;

            case "해운대구":
                ad1.setAreaName("우동1동");
                ad2.setAreaName("우동2동");
                break;
            case "부산진구":
                ad1.setAreaName("전포1동");
                ad2.setAreaName("전포2동");
                break;
            case "동래구":
                ad1.setAreaName("온천1동");
                ad2.setAreaName("온천2동");
                break;
            case "영도구":
                ad1.setAreaName("청학1동");
                ad2.setAreaName("청학2동");
                break;
        }

        areaList.add(ad1);
        areaList.add(ad2);

        return areaList;
    }
}
