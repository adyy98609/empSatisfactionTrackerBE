package com.hackathon.magnite.empSatisfactionTracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class SurveyModel {

        private String surveyId;
        private String logo;
        private String logoWidth;
        private String logoHeight;
        private String logoFit;
        private String logoPosition;
        private List<CompletedHtmlOnCondition> completedHtmlOnCondition;
        private List<Element> elements;
        private boolean showPrevButton;
        private String questionsOnPageMode;
        private boolean showQuestionNumbers;
        private String widthMode;
        private String width;

}
