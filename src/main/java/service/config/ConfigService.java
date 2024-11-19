package service.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import model.config.Config;

import java.io.File;
import java.io.IOException;

public class ConfigService {

    public void populateConfig(Config config, String path) throws IOException {
        ObjectMapper objectMapper = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .build();
        config = objectMapper.readValue(new File(path), Config.class);
    }
}
