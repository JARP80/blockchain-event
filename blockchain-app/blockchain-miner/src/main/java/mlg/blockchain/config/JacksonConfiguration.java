package mlg.blockchain.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.function.Function;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.core.JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN;
import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Slf4j
@Configuration
public class JacksonConfiguration {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    @Primary
    private static ObjectMapper objectMapper() {

        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setSerializationInclusion(NON_EMPTY);
        objectMapper.enable(ALLOW_NUMERIC_LEADING_ZEROS);
        objectMapper.enable(WRITE_BIGDECIMAL_AS_PLAIN);
        return objectMapper;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

   
    public static String toJson(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        }  catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
