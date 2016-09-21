package com.newmansoft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newmansoft.model.Message;
import com.newmansoft.model.Messages;
import com.newmansoft.model.Response;
import com.newmansoft.model.Root;

import java.net.URL;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/28/2016.
 */
public class SpotMessageClient {

    public Response RetrieveSpotData() {
        int runningCount = 0;
        String baseurl = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/0b00GO5eoVWQlMuaefir1Ze2ALDXlQMcd/message.json";
        Response response = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = mapper.readValue(new URL(baseurl), Root.class);

            runningCount+=root.getResponse().getFeedMessageResponse().getCount();
            int totalCount = root.getResponse().getFeedMessageResponse().getTotalCount();

            response = root.getResponse();
            if (runningCount < totalCount) {
                List<Message> pagedList = getPagedResponses(baseurl,runningCount,totalCount );
                response.getFeedMessageResponse().getMessages().getMessage().addAll(pagedList);

            }


            return response;
        } catch (Exception e) {
            return  null;
        }

    }

    private List<Message> getPagedResponses(final String baseurl, final int baseCount, int totalCount) {
        int runningCount = baseCount;
        List<Message> responses = new ArrayList<Message>();
        while(runningCount < totalCount) {
            String url = baseurl + "?start=" + runningCount;
            ObjectMapper mapper = new ObjectMapper();
            try {
                Root root = mapper.readValue(new URL(url), Root.class);
                runningCount += root.getResponse().getFeedMessageResponse().getCount();
                Messages messages = root.getResponse().getFeedMessageResponse().getMessages();
                responses.addAll(messages.getMessage());
            } catch(Exception e) {

            }

        }
    return responses;
    }
}
