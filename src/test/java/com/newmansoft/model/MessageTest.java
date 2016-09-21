package com.newmansoft.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.newmansoft.model.GPX.AList;
import com.newmansoft.model.GPX.GRoot;
import com.newmansoft.model.GPX.Trk;
import com.newmansoft.service.SpotMessageClient;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class MessageTest {

    @Test()
    public void testDeserialization() {

        try {

            String path = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\1.gpx";
//                        String path = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\testTrk.xml";

//            ObjectMapper mapper = new ObjectMapper();
//         Root root = mapper.readValue(new URL(path), Root.class);
//            assertNotNull(root);

            XmlMapper mapper = new XmlMapper();


            List<Trk> gpx = mapper.readValue(new URL(path),AList.class);
            assertNotNull(gpx);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void testGetPaged() {
		SpotMessageClient client = new SpotMessageClient();
	Response response = 	client.RetrieveSpotData();
		assertNotNull(response);
		assertEquals(response.getFeedMessageResponse().getMessages().getMessage().size(), response.getFeedMessageResponse().getTotalCount());
	}

}