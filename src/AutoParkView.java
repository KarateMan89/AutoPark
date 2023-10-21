import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class AutoParkView extends Pane{
    private AutoParkButtonPane buttonPane;
    private ListView<Item> inventoryList, popularList;
    private ListView<String> cartList;
    private TextField salesField, revenueField, avgSaleField;
    private Label label2;

    public AutoParkView(){
        
        //Create labels
        Label label1 = new Label("Park inventory:");
        label1.relocate(15, 10);
        label2 = new Label("Current cart ($0.00):");
        label2.relocate(300, 10);
        Label label3 = new Label("Park Summary:");
        label3.relocate(580, 10);
        Label label4 = new Label("# Sales:");
        label4.relocate(590, 40);
        Label label5 = new Label("Revenue:");
        label5.relocate(590, 70);
        Label label6 = new Label("$ / Sale:");
        label6.relocate(590, 100);
        Label label7 = new Label("Most Popular Items:");
        label7.relocate(580, 130);

        //create ListViews
        inventoryList = new ListView<>();
        inventoryList.relocate(15, 40);
        inventoryList.setPrefSize(275, 300);

        cartList = new ListView<>();
        cartList.relocate(300, 40);
        cartList.setPrefSize(275, 300);

        popularList = new ListView<>();
        popularList.relocate(580, 160);
        popularList.setPrefSize(200, 180);
        
        //text fields
        salesField = new TextField("0");
        salesField.relocate(650, 40);
        revenueField = new TextField("$0.00");
        revenueField.relocate(650, 70);
        avgSaleField = new TextField("N/A");
        avgSaleField.relocate(650, 100);

        //add button pane
        buttonPane = new AutoParkButtonPane();
        buttonPane.relocate(85, 350);

        getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, inventoryList, cartList, popularList, salesField, revenueField, avgSaleField, buttonPane);

        setPrefSize(800, 400);

    }

    public ListView<Item> getInventoryList() { return inventoryList; }
    public ListView<String> getCartList() { return cartList; }
    public ListView<Item> getPopularList() { return popularList; }
    public AutoParkButtonPane getButtonPane() { return buttonPane; }
    public TextField getSalesField() { return salesField; }
    public TextField getRevenueField() { return revenueField; }
    public TextField getAvgSaleField() { return avgSaleField; }

    public void update(AutoPark model){
        inventoryList.setItems(FXCollections.observableArrayList(model.getAvailableItems()));
        cartList.setItems(FXCollections.observableArrayList(model.getCartItems()));
        popularList.setItems(FXCollections.observableArrayList(model.getXPopularItems(3)));
        salesField.setText(Integer.toString(model.getNumSales()));
        revenueField.setText(String.format("$%.2f", model.getRevenue()));
        avgSaleField.setText(model.getAvgSaleString());
        label2.setText("Current cart ($" + String.format("%.2f", model.getCartTotal()) + "):");

        //disable buttons if cart is empty
        if(model.getCartItems().isEmpty()){
            buttonPane.getSellButton().setDisable(true);
        } else {
            buttonPane.getSellButton().setDisable(false);
        }

        //disable add button if nothing from inventory is selected
        if(inventoryList.getSelectionModel().getSelectedItem() == null){
            buttonPane.getAddButton().setDisable(true);
        } else {
            buttonPane.getAddButton().setDisable(false);
        }

        //disable remove button if nothing from cart is selected or if cart is empty
        if(cartList.getSelectionModel().getSelectedItem() == null || model.getCartItems().isEmpty()){
            buttonPane.getRemoveButton().setDisable(true);
        } else {
            buttonPane.getRemoveButton().setDisable(false);
        }

    }
}