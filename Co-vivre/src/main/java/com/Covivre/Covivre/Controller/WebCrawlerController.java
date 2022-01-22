package com.Covivre.Covivre.Controller;

import com.Covivre.Covivre.Service.WebCrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/data")
public class WebCrawlerController {

    private final WebCrawService webCrawService;

    @Autowired
    public WebCrawlerController(WebCrawService webCrawService){
        this.webCrawService = webCrawService;
    }

    @GetMapping("greeting")
    public String getGreeting(){
        return("welcome to covivre!~");
    }

}
