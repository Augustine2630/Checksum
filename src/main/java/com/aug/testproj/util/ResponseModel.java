package com.aug.testproj.util;

public class ResponseModel {

    private String preparedChecksum;

    private String calculatedChecksum;

    private Boolean condition;

    public ResponseModel(String preparedChecksum, String calculatedChecksum, Boolean condition) {
        this.preparedChecksum = preparedChecksum;
        this.calculatedChecksum = calculatedChecksum;
        this.condition = condition;
    }

    public String getPreparedChecksum() {
        return preparedChecksum;
    }

    public void setPreparedChecksum(String preparedChecksum) {
        this.preparedChecksum = preparedChecksum;
    }

    public String getCalculatedChecksum() {
        return calculatedChecksum;
    }

    public void setCalculatedChecksum(String calculatedChecksum) {
        this.calculatedChecksum = calculatedChecksum;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }
}
