/*
Copyright 2018. Written by Timothy Nguyen
*/
/**
 * DropTokenController manages the interactions between the players, the model, and the view.
 * This controller receives valid commands via Strings and updates the given model and view appropriately.
 */
public class DropTokenController {
    private static String INVALID_PUT_COLUMN_ERROR_MESSAGE = "Invalid column number for PUT, please choose number " +
            "between 1 and 4 inclusive";
    private static String INVALID_COMMAND_ERROR_MESSAGE = "Command not recognized, please use PUT <column>, GET, " +
            "BOARD, or EXIT";
    private static String GAME_OVER_NO_PUTS_ERROR_MESSAGE = "Cannot PUT because game has ended";

    private DropTokenModel model;
    private DropTokenView view;

    /**
     * Constructs a new DropTokenController with the given model and view
     * @param model An instance of a model of DropToken
     * @param view An instance of a view for displaying DropToken to the user
     */
    public DropTokenController(DropTokenModel model, DropTokenView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Translate a command line action from the players into appropriate method calls to
     * the model and view. If action is not valid, model and view are not updated.
     * @param line The action the player requested. Must be a valid action.
     *             Valid actions include PUT <column number>, BOARD, GET, and EXIT.
     */
    public void inputCommand(String line) {
        if (!validCommand(line)) {
            return;
        } else if (line.startsWith("PUT")) {
            if (model.isGameOver()) {
                System.out.println(GAME_OVER_NO_PUTS_ERROR_MESSAGE);
                return;
            }
            String[] tokens = line.split(" ");
            int column = Integer.parseInt(tokens[1]);
            System.out.println(model.putToken(column));
        } else if (line.equals("GET")) {
            view.printMoves(model.getMoves());
        } else if (line.equals("BOARD")) {
            view.printBoard(model.getBoard());
        }
    }

    /*
     *  Returns true if the user typed in a valid action for the DropToken game
     * otherwise returns false. It also prints helpful messages when the command is not valid
     */
    private static boolean validCommand(String line) {
        if (line.equals("GET") || line.equals("BOARD")) {
            return true;
        } else if (line.matches("PUT .*")) {
            if (line.matches("PUT [1234]")) {
                return true;
            } else {
                System.out.println(INVALID_PUT_COLUMN_ERROR_MESSAGE);
                return false;
            }
        } else {
            System.out.println(INVALID_COMMAND_ERROR_MESSAGE);
            return false;
        }
    }

}
