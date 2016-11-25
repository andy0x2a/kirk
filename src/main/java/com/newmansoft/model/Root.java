package com.newmansoft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by user on 8/28/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
