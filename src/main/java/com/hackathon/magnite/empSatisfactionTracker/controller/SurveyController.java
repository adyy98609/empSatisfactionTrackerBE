package com.hackathon.magnite.empSatisfactionTracker.controller;

import com.hackathon.magnite.empSatisfactionTracker.model.SurveyModel;
import com.hackathon.magnite.empSatisfactionTracker.model.SurveyResponse;
import com.hackathon.magnite.empSatisfactionTracker.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping(value = "/v1/responses")
    public Map<String,Object> getResponses(@RequestParam(required = true) String surveyId){
        Map map = new HashMap();
        if (StringUtils.hasLength(surveyId)) {
            map.put("data", surveyService.getResponses(surveyId));
        } else {
            map.put("data", "[{\n" +
                    "  \"satisfaction-score\": 5,\n" +
                    "  \"nps-score\": 10\n" +
                    "}, {\n" +
                    "  \"satisfaction-score\": 5,\n" +
                    "  \"nps-score\": 9\n" +
                    "}, {\n" +
                    "  \"satisfaction-score\": 3,\n" +
                    "  \"nps-score\": 6\n" +
                    "}, {\n" +
                    "  \"satisfaction-score\": 3,\n" +
                    "  \"nps-score\": 6\n" +
                    "}, {\n" +
                    "  \"satisfaction-score\": 2,\n" +
                    "  \"nps-score\": 3\n" +
                    "}]");
        }
        return map;
    }

}