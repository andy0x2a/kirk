package com.newmansoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 8/28/2016.
 */

@Entity
@Table(name = "message")
@JsonRootName(value = "message")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Message {


    @JsonProperty("@clientUnixTime")
    private String clientUnixTime;


    @Id
    private Long id;

    @Column()
    private String messengerId;

    @Column()
    private String messengerName;
    @Column()
    private  long unixTime;
    @Column()
    private String messageType;
    @Column()
    private double latitude;
    @Column()
    private double longitude;
    @Column()
    private String modelId;
    @Column()
    private String showCustomMsg;
    @Column()
    private String dateTime;
    @Column()
    private String messageDetail;

    @Column()
    private String batteryState;
    @Column()
    private int hidden;
    @Column()
    private String messageContent;



    public String getMessengerId() {
        return messengerId;
    }

    public void setMessengerId(String messengerId) {
        this.messengerId = messengerId;
    }

    public String getClientUnixTime() {
        return clientUnixTime;
    }

    public void setClientUnixTime(String clientUnixTime) {
        this.clientUnixTime = clientUnixTime;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getShowCustomMsg() {
        return showCustomMsg;
    }

    public void setShowCustomMsg(String showCustomMsg) {
        this.showCustomMsg = showCustomMsg;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getBatteryState() {
        return batteryState;
    }

    public void setBatteryState(String batteryState) {
        this.batteryState = batteryState;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
