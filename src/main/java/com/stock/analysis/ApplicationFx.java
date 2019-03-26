package com.stock.analysis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@SpringBootApplication
public class ApplicationFx extends javafx.application.Application {


    private ConfigurableApplicationContext springContext;
    Stage window;
    TableView<Security> table;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(ApplicationFx.class);
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //Name column
        TableColumn<Security, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Security, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Security, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getStock());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

        try {
            Stock googl = YahooFinance.get("RASP.ME");

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Get all of the Stocks
    public ObservableList<Security> getStock() {
        ObservableList<Security> Stocks = FXCollections.observableArrayList();
        Stocks.add(new Security("Laptop", 859.00, 20));
        Stocks.add(new Security("Bouncy Ball", 2.49, 198));
        Stocks.add(new Security("Toilet", 99.00, 74));
        Stocks.add(new Security("The Notebook DVD", 19.99, 12));
        Stocks.add(new Security("Corn", 1.49, 856));
        return Stocks;
    }

    @Override
    public void stop() {
        springContext.stop();
    }


}
