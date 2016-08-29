package com.newmansoft.service;

import com.newmansoft.model.FeedMessageResponse;
import com.newmansoft.model.Message;
import com.newmansoft.model.Messages;
import com.newmansoft.model.Response;
import com.newmansoft.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by v-annew on 29-Aug-16.
 */
@Component
public class ScheduledTask {


    @Autowired
    private MessageRepository messageRepository;


    //


    //@Scheduled(cron="0 * * *  * * ")
    @Scheduled(cron="${sched}")
    public void updateData() {

        System.out.println("Updating");

//        SpotMessageClient client = new SpotMessageClient();
//        client.RetrieveSpotData();   Response response = client.RetrieveSpotData();
//        if (response != null) {
//            FeedMessageResponse feedMessageResponse= response.getFeedMessageResponse();
//
//            if (feedMessageResponse != null) {
//                Messages messagesContainer = feedMessageResponse.getMessages();
//                if (messagesContainer != null) {
//                    List<Message> messages = messagesContainer.getMessage();
//                    for (Message message : messages) {
//                        Message existing =     messageRepository.findOne((message.getId()));
//                        if (existing == null) {
//                            messageRepository.save(message);
//
//                        }
//                    }
//                }
//            }
//        }
    }
}
