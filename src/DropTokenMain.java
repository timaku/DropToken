/*
Copyright 2018. Written by Timothy Nguyen
 */

import java.util.Scanner;
/*
This program is the starts a session of DropToken from the command-line.
 */
public class DropTokenMain {
    public static void main(String[] args) {
        DropTokenModel model = new DropTokenModel();
        DropTokenView view = new DropTokenView();
        DropTokenController controller = new DropTokenController(model, view);

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while (!line.equals("EXIT")) {
            controller.inputCommand(line);
            line = scan.nextLine();
        }
    }
}
