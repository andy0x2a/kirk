package com.newmansoft.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class MessageTest {

    @Test()
    public void testDeserialization() {

        try {

            String path = "C:\\Users\\user\\code\\git\\KirkApi\\src\\test\\resources\\sampleModel.json";
           String url = "https://api.findmespot.com/spot-main-web/consumer/rest-api/2.0/public/feed/0b00GO5eoVWQlMuaefir1Ze2ALDXlQMcd/message.json";

            ObjectMapper mapper = new ObjectMapper();
         Root root = mapper.readValue(new URL(url), Root.class);
            assertNotNull(root);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}