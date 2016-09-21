package com.newmansoft.controller;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.newmansoft.model.*;
import com.newmansoft.model.GPX.AList;
import com.newmansoft.model.GPX.Trk;
import com.newmansoft.model.GPX.Trkpt;
import com.newmansoft.repository.MessageRepository;
import com.newmansoft.service.SpotMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/gps")
@CrossOrigin()
public class GpsController {

@Autowired
private MessageRepository messageRepository;


    private SpotMessageClient spotMessageClient = new SpotMessageClient();
    private static long SECONDS = 60;
    private static long MINUTES = 60;
    private static long HOURS = 24;
    private static long DAYS = 2;

    private static long OFFSET = SECONDS*MINUTES*HOURS*DAYS;

    public GpsController() {

    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
  //  @CrossOrigin(origins = "*")
    public List<MapPoint> get() {
        long unixTime =  (new Date().getTime()/1000)-(OFFSET);

        List<MapPoint> response = new ArrayList<MapPoint>();
        Iterable<Message> messages = messageRepository.findAll();

        if (messages != null) {
            for (Message message : messages) {
                if (message.getUnixTime() < unixTime) {
                    response.add(new MapPoint(message.getLatitude(),
                            message.getLongitude(), message.getUnixTime()));
                }
            }
        }

        Collections.sort(response, (m1,m2) -> Long.compare(m1.getTimestamp(), m2.getTimestamp()));
        return  response;
    }

//    @RequestMapping(value = "/trk", method = RequestMethod.POST)
    public void tempTrk() {
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

            for (Trk allTrack : allTracks) {
                for (Trkpt trkpt : allTrack.getTrkSeg()) {
                    if (startDate.compareTo(trkpt.getTime()) <0 && endDate.compareTo(trkpt.getTime())>0) {
                        pts.add(trkpt);
                    }
                }
            }
            Collections.sort(pts,( Trkpt m1, Trkpt m2) -> m1.getTime().compareTo(m2.getTime()));

            List<Message> useablePts = new ArrayList<Message>();
            for(int i=0; i<pts.size(); i++) {
                if (i%50==0) {

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
            Collections.sort(useablePts,( m1, m2) -> Long.compare(m1.getUnixTime(),m2.getUnixTime()));
//            for (Message useablePt : useablePts) {
//                Message alreadyExists = messageRepository.findOne(useablePt.getId());
//
//                if (alreadyExists == null) {
//                    messageRepository.save(useablePt);
//                    System.out.println("Adding entry " + useablePts.indexOf(useablePt) + " / " + useablePts.size());
//                } else {
//                    System.out.println("Entry already exists");
//                }
//
//            }
            System.out.println("About to save");
            messageRepository.save(useablePts);
            System.out.println("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void tempPost() {
        System.out.println("Updating");

        SpotMessageClient client = new SpotMessageClient();
        client.RetrieveSpotData();
        Response response = client.RetrieveSpotData();
        if (response != null) {
            FeedMessageResponse feedMessageResponse = response.getFeedMessageResponse();

            if (feedMessageResponse != null) {
                Messages messagesContainer = feedMessageResponse.getMessages();
                if (messagesContainer != null) {
                    List<Message> messages = messagesContainer.getMessage();
                    for (Message message : messages) {
                        Message existing = messageRepository.findOne((message.getId()));
                        if (existing == null) {
                            messageRepository.save(message);

                        }
                    }
                }
            }
        }
    }

    }
