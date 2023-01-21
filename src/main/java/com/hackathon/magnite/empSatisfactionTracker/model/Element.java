package com.hackathon.magnite.empSatisfactionTracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Element {

    private String type;
    private String name;
    private List<Element> elements;
    private Title title;
    private int rateMax;
    private MaxRateDescription maxRateDescription;
    private MinRateDescription minRateDescription;
    private String visibleIf;
    private Description description;
    private List<Validator> validators;
    private boolean isRequired;
    private boolean showOtherItem;
    private List<Choice> choices;
    private OtherText otherText;
    private OtherPlaceholder otherPlaceholder;
    private int colCount;
    private Placeholder placeholder;
}
