package com.oliver.guava.dao;

import java.io.Serializable;
import java.util.Date;

public class TemplatePo implements Serializable {
    private Integer id;

    private String brand;

    private String emailType;

    private Byte templateType;

    private String placeHolders;

    private String emailDescription;

    private String triggerRuleDescription;

    private String state;

    private String createdBy;

    private Date createdTime;

    private String lastmodifiedBy;

    private Date lastTime;

    private String emailTemplateList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType == null ? null : emailType.trim();
    }

    public Byte getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Byte templateType) {
        this.templateType = templateType;
    }

    public String getPlaceHolders() {
        return placeHolders;
    }

    public void setPlaceHolders(String placeHolders) {
        this.placeHolders = placeHolders == null ? null : placeHolders.trim();
    }

    public String getEmailDescription() {
        return emailDescription;
    }

    public void setEmailDescription(String emailDescription) {
        this.emailDescription = emailDescription == null ? null : emailDescription.trim();
    }

    public String getTriggerRuleDescription() {
        return triggerRuleDescription;
    }

    public void setTriggerRuleDescription(String triggerRuleDescription) {
        this.triggerRuleDescription = triggerRuleDescription == null ? null : triggerRuleDescription.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastmodifiedBy() {
        return lastmodifiedBy;
    }

    public void setLastmodifiedBy(String lastmodifiedBy) {
        this.lastmodifiedBy = lastmodifiedBy == null ? null : lastmodifiedBy.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getEmailTemplateList() {
        return emailTemplateList;
    }

    public void setEmailTemplateList(String emailTemplateList) {
        this.emailTemplateList = emailTemplateList == null ? null : emailTemplateList.trim();
    }
}