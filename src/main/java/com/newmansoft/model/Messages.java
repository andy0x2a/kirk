package com.newmansoft.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by user on 8/28/2016.
 */

public class Messages {

    private List<Message> message;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
