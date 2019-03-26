package com.stock.analysis;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.List;

public class Table {


    public List<TableColumn> getTableColumns(){

        //Name column
        TableColumn<Security, String> nameColumn = new TableColumn<>("Компания");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Security, Double> priceColumn = new TableColumn<>("Текущая ценя");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Security, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        return Arrays.asList(nameColumn, priceColumn, quantityColumn);
    }
}
