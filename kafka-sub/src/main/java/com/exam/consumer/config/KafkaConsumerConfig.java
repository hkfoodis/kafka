package com.exam.consumer.config;

//import com.example.common.UserDTO;
import com.exam.consumer.domain.UserSub;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public ConsumerFactory<String, UserSub> userConsumerFactory() {

        JsonDeserializer<UserSub> deserializer = new JsonDeserializer<>(UserSub.class);             // Producer에서 보낸 Topic의 객체를 받을 객체를 지정
        // Producer에서 지정한 클래스와 동일하지 않더라도 객체를 구성가능하게 하는 설정
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);  // Consumer가 객체를 받을 때 Producer에서 보낸 객체의 키 값을 기준으로 받음

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "user");                                          // Consumer가 속한 Consumer 그룹의 ID 지정
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserSub> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserSub> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(userConsumerFactory());
        // 필터 사용 시
        // factory.setRecordFilterStrategy(record -> record.value().contains("World"));
        return factory;
    }

}