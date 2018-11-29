public class DropTokenController {

    private DropTokenModel model;
    private DropTokenView view;

    public DropTokenController(DropTokenModel model, DropTokenView view) {
        this.model = model;
        this.view = view;
    }

    public void inputCommand(String line) {
        if (line.startsWith("PUT")) {
            if (model.isGameOver()) {
                System.out.println("Cannot PUT because game has ended");
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
}
