package ro.salajan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String findAllRooms() {
        return "main";
    }
}
