package validation.params;

import java.io.File;

public class RunParamsValidator {

    public boolean validatePath(String configPath) {
        if (configPath==null) {
            System.err.println("Invalid config path");
            return false;
        }
        else if(!new File(configPath).exists()) {
            System.err.printf("Config file does not exist %s%n", configPath);
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateBettingAmount(String amount) {
        try {
            int bettingAmount = Integer.parseInt(amount);
            if(bettingAmount<=0) {
                System.err.printf("Invalid betting amount %d - Betting amount should be more than 0%n", bettingAmount);
                return false;
            }
        }
        catch(NumberFormatException e) {
            System.err.printf("Invalid betting amount %s%n", amount);
            return false;
        }
        return true;
    }
}
