import model.params.RunParams;

public class ScratchGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Scratch Game");
        RunParams runParams = new RunParams(args);
        System.out.println(runParams.getBettingAmount());
        System.out.println(runParams.getConfigPath());
    }
}
