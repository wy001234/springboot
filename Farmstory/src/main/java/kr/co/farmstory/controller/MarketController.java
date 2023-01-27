package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketController {


    @GetMapping("market/market")
    public String market(){
        return "market/market";
    }

}
