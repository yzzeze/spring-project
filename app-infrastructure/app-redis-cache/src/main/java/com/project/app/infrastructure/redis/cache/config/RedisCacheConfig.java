package com.project.app.infrastructure.redis.cache.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCacheConfig {

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private Integer redisPort;


    /**
     * Java의 Redis Client 라이브러리
     */
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }

    /**
     * ObjectMapper 확장 <br>
     * Spring 에서는 기본적으로 jackson 모듈의 ObjectMapper 클래스가 Java 객체와 JSON 사이의 직렬화를 처리
     * Spring HTTP 메시지 컨버터 구성 참고
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }


    /**
     * RedisTemplate
     * <br><br>
     * - JdkSerializationRedisSerializer : Spring Data Redis 기본 직렬화 구현체 <br>
     * - StringRedisSerializer : String 값을 그대로 저장
     * - GenericJackson2JsonRedisSerializer : objectMapper 을 사용하여 클래스(타입) 정보 없이 저장 / 역직렬화시 데이터 타입 판별 어려움, 타입 명시적 지정 필요 <br>
     * - Jackson2JsonRedisSerializer : objectMapper 을 사용하여 클래스(타입) 정보 함께 저장 / 해당 클래스 정보를 기반으로 역직렬화 , 역직렬화시 데이터 타입 자동으로 판별 <br>
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(ObjectMapper objectMapper) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper);
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // Redis에 저장될 값의 직렬화 설정
        // string
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);

        // hash
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(serializer);

        return redisTemplate;
    }

}