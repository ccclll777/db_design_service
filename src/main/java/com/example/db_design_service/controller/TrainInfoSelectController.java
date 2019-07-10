package com.example.db_design_service.controller;


import com.example.db_design_service.bean.Data;
import com.example.db_design_service.bean.TrainInfo;
import com.example.db_design_service.bean.UserInfo;
import com.example.db_design_service.service.TrainInfoService;
import com.example.db_design_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainInfoSelectController {
    private static final Logger logger = LoggerFactory.getLogger(TrainInfoSelectController.class);
    @Resource
    private TrainInfoService  trainInfoService;

    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public void UserInfo() {
        logger.info("/train/info");
    }
}
