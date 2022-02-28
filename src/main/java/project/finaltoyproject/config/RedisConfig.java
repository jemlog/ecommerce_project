package project.finaltoyproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    public String host;

    @Value("${spring.redis.port}")
    public int port;


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>(); // String의 key, Object형의 value
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key는 stringRedisSerializer로 직렬화
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value는 jackson2 -> object이기때문
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host); // application.yml에 설정한 host정보
        configuration.setPort(port); // application.yml에 설정한 port 정보
        return new LettuceConnectionFactory(configuration); // redis는 Lettuce를 사용한다. connectionFactory 생성을 위해
                                                            // configuration 정보 추가 Lettuce는 redis 클라이언트 jedis보다 훨씬 좋다.
    }
}