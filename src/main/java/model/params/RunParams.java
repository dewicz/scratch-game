package model.params;

import util.Constants;
import validation.params.RunParamsValidator;

public class RunParams {
    private String configPath;
    private int bettingAmount;

    public String getConfigPath() {
        return configPath;
    }

    public int getBettingAmount() {
        return bettingAmount;
    }

    public RunParams(String[] args) {
        RunParamsValidator validator = new RunParamsValidator();
        populateParams(args, validator);
    }

    private void populateParams(String[] args, RunParamsValidator validator) {
        if(args.length != Constants.NUMBER_OF_PARAMS) { // expecting 4 args --config config.json --betting-amount 100
            printInstructions();
        }
        for(int i=0; i<args.length; i++) {
            String arg = args[i];
            switch(arg) {
                case Constants.CONFIG_ARG:
                    i++;
                    if(validator.validatePath(args[i]))
                        configPath = args[i];
                    break;
                case Constants.BETTING_AMOUNT_ARG:
                    i++;
                    if(validator.validateBettingAmount(args[i]))
                        bettingAmount = Integer.parseInt(args[i]);
                    break;
                default:
                    printInstructions();
                    break;
            }
        }
    }

    private void printInstructions() {
        System.out.println("Invalid arguments");
        System.out.println("Make sure to include following options:");
        System.out.printf(" %s <path>%n", Constants.CONFIG_ARG);
        System.out.printf(" %s <amount>%n", Constants.BETTING_AMOUNT_ARG);
    }
}
