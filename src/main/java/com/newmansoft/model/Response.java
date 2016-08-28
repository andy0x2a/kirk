package com.newmansoft.model;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by user on 8/28/2016.
 */


@JsonRootName(value = "response")
public class Response {
    private FeedMessageResponse feedMessageResponse;

    public FeedMessageResponse getFeedMessageResponse() {
        return feedMessageResponse;
    }

    public void setFeedMessageResponse(FeedMessageResponse feedMessageResponse) {
        this.feedMessageResponse = feedMessageResponse;
    }
}
