package com.exam.producer.publisher;

import com.exam.producer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class UserPublisher {
    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    @Value(value = "${user.topic.name}")
    private String userTopicName;

    public void publish(User user) {
        ListenableFuture<SendResult<String, User>> future = userKafkaTemplate.send(userTopicName, user);

        // 아래의 콜백은 옵션 사항
        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            @Override
            public void onSuccess(SendResult<String, User> result) {
                User user = result.getProducerRecord().value();
                System.out.println("Sent message=[" + user.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println( "Unable to send message=[" + user.toString() + "] due to : " + ex.getMessage());
            }
        });


    }
}
