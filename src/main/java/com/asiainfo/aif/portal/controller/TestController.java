package com.asiainfo.aif.portal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/act")
@RestController
@Slf4j
public class TestController {

    @Autowired
    private ActivitiAPI activitiAPI;

    public TestController() {
        System.out.println("activitiAPI========>"+activitiAPI);
    }

    @RequestMapping("/createByApi")
    public String create(String processName){
        String newModelId = "";
        try {
            newModelId = activitiAPI.newModel(processName);
        } catch (Exception e) {
            log.error("创建模型失败",e);
        }
        return newModelId;
    }
}
