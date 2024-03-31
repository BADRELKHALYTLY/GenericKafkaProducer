package com.generic.kafka.GenericProducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.generic.kafka.GenericProducer.model.Notification;
import com.generic.kafka.GenericProducer.publisher.KafkaMessagePublisher;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;


    @PostMapping("/publishNotification/{objectType}")
    public <T> void sendEventNotification(
            @RequestBody T object,@PathVariable(value = "objectType") String objectType) throws JsonProcessingException {


        Notification<T> objectNotification = new Notification<T>();
        objectNotification.setItem(object);
        objectNotification.setClassName(objectType);

        publisher.sendNotificationsToTopic(objectNotification);
    }


}
