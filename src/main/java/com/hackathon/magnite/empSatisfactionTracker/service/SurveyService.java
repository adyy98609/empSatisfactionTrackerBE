package com.hackathon.magnite.empSatisfactionTracker.service;

import com.hackathon.magnite.empSatisfactionTracker.model.SurveyModel;
import com.hackathon.magnite.empSatisfactionTracker.model.SurveyResponse;
import com.hackathon.magnite.empSatisfactionTracker.repository.SurveyRepository;
import com.hackathon.magnite.empSatisfactionTracker.repository.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private SurveyResponseRepository surveyResponseRepository;

    public Optional<SurveyModel> getSurveyById(String id) {
        return surveyRepository.findById(id);
    }

    public List<SurveyModel> getSurvey() {
        return surveyRepository.findAll();
    }

    public void saveSurvey(SurveyModel surveyModel) {
        surveyModel.setSurveyId(UUID.randomUUID().toString());
        if(Objects.nonNull(surveyModel))
        surveyRepository.save(surveyModel);
        else throw new RuntimeException("Error while saving the survey.");
    }

    public Optional<SurveyResponse> getResponses(String surveyId) {
        return surveyResponseRepository.findById(surveyId);
    }
}
