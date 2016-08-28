package com.newmansoft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newmansoft.model.Response;
import com.newmansoft.model.Root;

import java.net.URL;

/**
 * Created by user on 8/28/2016.
 */
public class SpotMessageClient {

    public Response RetrieveSpotData() {
        String url = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/0b00GO5eoVWQlMuaefir1Ze2ALDXlQMcd/message.json";

        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = mapper.readValue(new URL(url), Root.class);

            return root.getResponse();
        } catch (Exception e) {
            return  null;
        }

    }
}
