package com.newmansoft.model;

/**
 * Created by user on 8/28/2016.
 */
public class Feed {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(int daysRange) {
        this.daysRange = daysRange;
    }

    public boolean isDetailedMessageShown() {
        return detailedMessageShown;
    }

    public void setDetailedMessageShown(boolean detailedMessageShown) {
        this.detailedMessageShown = detailedMessageShown;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String id; //GUID
    private String name;
    private String description;
    private String status;
    private int usage;
    private int daysRange;
    private boolean detailedMessageShown;
    private String type;


}
