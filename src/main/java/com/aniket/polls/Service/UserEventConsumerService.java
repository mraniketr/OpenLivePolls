package com.aniket.polls.Service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class UserEventConsumerService {

    private final StringRedisTemplate redisTemplate;

    public UserEventConsumerService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = "user_events_topic", groupId = "user-events-group")
    public void consumeUserEvent(String event) {
        System.out.println("Consumed user event from Kafka: " + event);
        // Push event to Redis with a unique key
        redisTemplate.opsForValue().set("user_event_" + System.currentTimeMillis(), event);
        System.out.println("User event pushed to Redis: " + event);
    }
}


