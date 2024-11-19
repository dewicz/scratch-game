import model.config.Config;
import model.params.RunParams;
import service.config.ConfigService;

import java.io.IOException;

public class ScratchGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Scratch Game");
        RunParams runParams = new RunParams(args);
        System.out.printf("Betting amount %d%n", runParams.getBettingAmount());
        System.out.printf("Config path %s%n", runParams.getConfigPath());
        ConfigService configService = new ConfigService();
        Config config = new Config();
        try {
            configService.populateConfig(config, runParams.getConfigPath());
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(config);
    }
}
