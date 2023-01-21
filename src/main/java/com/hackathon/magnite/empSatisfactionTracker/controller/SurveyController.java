package com.hackathon.magnite.empSatisfactionTracker.controller;

import com.hackathon.magnite.empSatisfactionTracker.model.SurveyModel;
import com.hackathon.magnite.empSatisfactionTracker.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;


    @GetMapping(value="/v1/survey")
    public Map<String,Object> getSurvey(@RequestParam(required = false) String id) {
        Map map = new HashMap();
        if (StringUtils.hasLength(id)) {
            map.put("data", surveyService.getSurveyById(id).get());
        } else {
            map.put("data", surveyService.getSurvey());
        }
        return map;
    }

    @PostMapping(value = "/v1/survey")
    public SurveyModel saveSurvey(@RequestBody SurveyModel surveyModel) {
        surveyService.saveSurvey(surveyModel);
        return  surveyModel;
    }
    
}
