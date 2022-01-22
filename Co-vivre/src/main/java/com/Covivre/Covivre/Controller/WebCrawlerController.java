package com.Covivre.Covivre.Controller;

import com.Covivre.Covivre.Service.WebCrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

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

    @CrossOrigin(origins = "http://localhost:1234")
    @GetMapping("basicData")
    public ArrayList<String> getBasicData() throws IOException {
        return webCrawService.getCases();
    }

}
