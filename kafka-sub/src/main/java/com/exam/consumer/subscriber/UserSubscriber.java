package com.exam.consumer.subscriber;

//
import com.exam.consumer.domain.UserSub;
import com.exam.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserSubscriber {
    @Autowired
    UserService userService;

    @KafkaListener(topics = "${user.topic.name}", containerFactory = "userKafkaListenerContainerFactory")
    public void userListener(UserSub userSub) {
        try {
            System.out.println("▶▶▶▶▶▶▶▶ RECEIVED DATA FROM KAFKA: " + userSub.toString());
            userService.insertUser(userSub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
