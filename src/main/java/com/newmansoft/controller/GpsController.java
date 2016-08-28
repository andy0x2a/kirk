package com.newmansoft.controller;


import com.newmansoft.model.FeedMessageResponse;
import com.newmansoft.model.Message;
import com.newmansoft.model.Messages;
import com.newmansoft.model.Response;
import com.newmansoft.repository.MessageRepository;
import com.newmansoft.service.SpotMessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gps")
@CrossOrigin()
public class GpsController {

@Autowired
private MessageRepository messageRepository;


    private SpotMessageClient spotMessageClient = new SpotMessageClient();

    public GpsController() {

    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Message> get() {
        Iterable<Message> messages = messageRepository.findAll();
        return  messages;
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void tempPost() {
        Response response = spotMessageClient.RetrieveSpotData();
        if (response != null) {
            FeedMessageResponse feedMessageResponse= response.getFeedMessageResponse();

            if (feedMessageResponse != null) {
                Messages messagesContainer = feedMessageResponse.getMessages();
                if (messagesContainer != null) {
                    List<Message> messages = messagesContainer.getMessage();
                    for (Message message : messages) {
                    Message existing =     messageRepository.findOne((message.getId()));
                        if (existing == null) {
                            messageRepository.save(message);

                        }
                    }
                }
            }
        }
    }



}
