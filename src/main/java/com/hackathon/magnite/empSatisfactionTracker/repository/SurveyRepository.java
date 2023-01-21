package com.hackathon.magnite.empSatisfactionTracker.repository;

import com.hackathon.magnite.empSatisfactionTracker.model.SurveyModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyModel, String> {


}
