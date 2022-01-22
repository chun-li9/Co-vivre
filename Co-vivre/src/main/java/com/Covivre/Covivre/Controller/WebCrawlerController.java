package com.Covivre.Covivre.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/data")
public class WebCrawlerController {

    @GetMapping("greeting")
    public String getGreeting(){
        return("welcome to covivre!~");
    }

}
