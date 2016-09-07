package com.newmansoft.controller;


import com.newmansoft.model.*;
import com.newmansoft.repository.MessageRepository;
import com.newmansoft.service.SpotMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                            message.getLongitude()));
                }
            }
        }
        return  response;
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
