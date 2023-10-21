import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AutoParkButtonPane extends Pane{
    private Button addButton;
    private Button removeButton;
    private Button sellButton;
    private Button resetButton;

    public AutoParkButtonPane(){
        Pane innerPane = new Pane();

        addButton = new Button("Add to Cart");
        addButton.relocate(0, 0);
        addButton.setPrefSize(120, 30);

        removeButton = new Button("Remove item");
        removeButton.relocate(230, 0);
        removeButton.setPrefSize(120, 30);

        sellButton = new Button("Complete Sale");
        sellButton.relocate(355, 0);
        sellButton.setPrefSize(120, 30);

        resetButton = new Button("Reset");
        resetButton.relocate(535, 0);
        resetButton.setPrefSize(120, 30);

        innerPane.getChildren().addAll(addButton, removeButton, sellButton, resetButton);
        getChildren().addAll(innerPane);
    }

    public Button getAddButton() { return addButton; }
    public Button getRemoveButton() { return removeButton; }
    public Button getSellButton() { return sellButton; }
    public Button getResetButton() { return resetButton; }
}
