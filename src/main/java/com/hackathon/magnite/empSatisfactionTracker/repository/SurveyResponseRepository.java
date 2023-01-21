package com.hackathon.magnite.empSatisfactionTracker.repository;

import com.hackathon.magnite.empSatisfactionTracker.model.SurveyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyResponseRepository extends MongoRepository<SurveyResponse, String> {
}
