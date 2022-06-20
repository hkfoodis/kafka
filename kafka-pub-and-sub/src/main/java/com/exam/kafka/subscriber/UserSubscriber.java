package com.exam.kafka.subscriber;

import com.exam.kafka.domain.User;
import com.exam.kafka.service.ApiService;
import com.exam.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserSubscriber {
    @Autowired
    UserService userService;

    @Autowired
    ApiService apiService;

    @KafkaListener(topics = "${user.topic.name}", containerFactory = "userKafkaListenerContainerFactory")
    public void userListener(User user) {
        try {
            System.out.println("▶▶▶▶▶▶▶▶ RECEIVED DATA FROM KAFKA: " + user.toString());
            User result = apiService.calAvg(user);

            if (result != null) {
                userService.updateScore(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
