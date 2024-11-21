package service.config;

import static org.junit.Assert.*;

import model.config.Config;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ConfigServiceTest {

    private ConfigService configService;

    @Before
    public void setUp() {
        configService = new ConfigService();
    }

    @Test
    public void testPopulateConfig_ValidFile() throws IOException {
        String path = "src/test/resources/config.json";

        Config config = configService.populateConfig(path);

        assertNotNull(config);
        assertEquals(4, config.getRows().intValue());
        assertEquals(4, config.getColumns().intValue());
    }

    @Test(expected = IOException.class)
    public void testPopulateConfig_FileNotFound() throws IOException {
        String path = "src/test/resources/nonExistentConfig.json";

        configService.populateConfig(path);
    }

}
