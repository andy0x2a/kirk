package com.newmansoft.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.newmansoft.model.GPX.AList;
import com.newmansoft.model.GPX.GRoot;
import com.newmansoft.model.GPX.Trk;
import com.newmansoft.model.GPX.Trkpt;
import com.newmansoft.service.SpotMessageClient;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class MessageTest {

    @Test()
    public void testDeserialization() {

        try {

            String path1 = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\1.gpx";
			String path2 = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\2.gpx";
			String path3 = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\3.gpx";
			String path4 = "file:\\C:\\Users\\anewman\\Downloads\\GPX\\4.gpx";


            XmlMapper mapper = new XmlMapper();


            AList allTracks = new AList();

			System.out.println(allTracks.size());
			allTracks.addAll(mapper.readValue(new URL(path1),AList.class));
			System.out.println(allTracks.size());
			allTracks.addAll(mapper.readValue(new URL(path2),AList.class));
			System.out.println(allTracks.size());
			allTracks.addAll(mapper.readValue(new URL(path3),AList.class));
			System.out.println(allTracks.size());
			allTracks.addAll(mapper.readValue(new URL(path4),AList.class));
			System.out.println(allTracks.size());

			String endString = "14-09-2016";
			String startString = "30-08-2016";
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date endDate = dateFormat.parse(endString);
			Date startDate = dateFormat.parse(startString);


			List<Trkpt> pts = new ArrayList<Trkpt>();
			List<Trkpt> allP = new ArrayList<Trkpt>();
			for (Trk allTrack : allTracks) {
				for (Trkpt trkpt : allTrack.getTrkSeg()) {
					if (startDate.compareTo(trkpt.getTime()) <0 && endDate.compareTo(trkpt.getTime())>0) {
						pts.add(trkpt);
					}
					allP.add(trkpt);
				}
			}


			List<Message> useablePts = new ArrayList<Message>();
			for(int i=0; i<pts.size(); i++) {
				if (i%25==0) {

					Trkpt pt = pts.get(i);
					Message message = new Message();
					message.setId((long) (10000+i));
					message.setBatteryState("GOOD");
					message.setClientUnixTime(String.valueOf(pt.getTime().getTime()/1000));
					message.setDateTime(pt.getTime().toString());
					message.setHidden(0);
					message.setLatitude(Double.parseDouble(pt.getLat()));
					message.setLongitude(Double.parseDouble(pt.getLon()));
					message.setMessageContent(null);
					message.setMessageDetail("");
					message.setMessageType("GPX_MANUAL%25");
					message.setMessengerId("ANDY_MANUAL");
					message.setMessengerName("MANUAL");
					message.setModelId("MANUAL");
					message.setShowCustomMsg("N");
					message.setUnixTime(pt.getTime().getTime()/1000);
					useablePts.add(message);
				}
			}



            assertNotNull(useablePts);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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