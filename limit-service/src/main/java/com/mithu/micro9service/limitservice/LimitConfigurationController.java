package com.mithu.micro9service.limitservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
public class LimitConfigurationController {

    @Autowired
    private  Configuration configuration;
    @RequestMapping("/limits")
    public LimitConfiguration retrieveLimitConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
