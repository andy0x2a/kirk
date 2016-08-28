package com.newmansoft.repository;

import com.newmansoft.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 8/28/2016.
 */



@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
}

