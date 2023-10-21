import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class AutoParkApp extends Application {
    private AutoPark model;

    public AutoParkApp(){ model = AutoPark.createPark(); }

    @Override
    public void start(Stage primaryStage){
        Pane aPane = new Pane();

        //create view
        AutoParkView view = new AutoParkView();

        //handle add button
        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleAddButton(view);
                view.update(model);
            }
        });

        //handle remove button
        view.getButtonPane().getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleRemoveButton(view);
                view.update(model);
            }
        });

        //handleSaleButton
        view.getButtonPane().getSellButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSellButton();
                view.update(model);
            }
        });

        //handle reset button
        view.getButtonPane().getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resetModel();
                view.getInventoryList().getSelectionModel().clearSelection();
                view.update(model);
            }
        });

        //when inventory is clicked update view
        view.getInventoryList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                view.update(model);
            }
        });

        //when cart is clicked update view
        view.getCartList().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                view.update(model);
            }
        });

        //add view to pane
        aPane.getChildren().add(view);

        //update view
        view.update(model);

        //set stage
        primaryStage.setTitle(model.getName() + " - Sales and Inventory");
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    public void handleAddButton(AutoParkView view){
        Item item = view.getInventoryList().getSelectionModel().getSelectedItem();
        if(item != null)
            model.addToCart(item);
    }

    public void handleRemoveButton(AutoParkView view){
        String item = view.getCartList().getSelectionModel().getSelectedItem();
        if(item != null)
            model.removeFromCart(item);
    }

    public void handleSellButton(){
        model.completeSale();
    }

    public void resetModel(){ model = AutoPark.createPark(); }

    public static void main(String[] args) { launch(args); }
}