import java.util.Scanner;

public class DropTokenMain {
    /*
    todo list: comment everything, explain the program? , load to github, test on CLI, test all winning poss
    ibilities

    should i make put return game over when game already ended? i think so, deny the put!
     */
    public static void main(String[] args) {
        DropTokenModel model = new DropTokenModel();
        DropTokenView view = new DropTokenView();
        DropTokenController controller = new DropTokenController(model, view);

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while (!line.equals("EXIT")) {
            if (validCommand(line)) {
                controller.inputCommand(line);
            }
            line = scan.nextLine();
        }
    }

    /**
     *
     * @param line
     * @return
     */
    public static boolean validCommand(String line) {
        if (line.equals("GET") || line.equals("BOARD")) {
            return true;
        } else if (line.matches("PUT .*")) {
            if (line.matches("PUT [1234]")) {
                return true;
            } else {
                System.out.println("Invalid column number for PUT, please choose number between 1 and 4 inclusive");
                return false;
            }
        } else {
            System.out.println("Command not recognized, please use PUT <column>, GET, BOARD, or EXIT");
            return false;
        }
    }



}
