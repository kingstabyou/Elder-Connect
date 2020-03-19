package com.gluonapplication.views;

import com.gluonapplication.lists.Ingredients;
import com.gluonapplication.properties.Ingredient;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CharmListCell;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.control.ListTile;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PrimaryPresenter {

    @FXML
    private View primary;

    //@FXML
    //private Label label;

    private VBox vbox;

    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().getDrawer().open()));
                appBar.setTitleText("Your ingredients");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));

                CharmListView<Ingredient, Integer> charmListView = new CharmListView<>(Ingredients.ingredientsList);
                vbox = (VBox)primary.getChildren().get(0);
                vbox.getChildren().addAll(charmListView);

                charmListView.setCellFactory(p -> new CharmListCell<Ingredient>() {
                    @Override
                    public void updateItem(Ingredient item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            VBox buttons = new VBox(MaterialDesignIcon.STAR_BORDER.graphic());
                            buttons.setMaxHeight(Double.MAX_VALUE);
                            buttons.setAlignment(Pos.TOP_RIGHT);

                            Label amountLabel = new Label(item.getAmount().toString());
                            amountLabel.setPrefWidth(40);
                            amountLabel.setTextAlignment(TextAlignment.RIGHT);
                            HBox hbox1 = new HBox(amountLabel);
                            hbox1.setAlignment(Pos.CENTER);
                            hbox1.setPrefSize(40,40);

                            ListTile tile = new ListTile();
                            tile.textProperty().addAll(item.getName()
                            , "Cost: $" + item.getCost()+ " | " + "Calories: " + item.getCalories());

                            tile.setSecondaryGraphic(buttons);
                            tile.setPrimaryGraphic(hbox1);
                            tile.setPrefHeight(40);
                            tile.setOnMouseClicked(e -> buttons.getChildren().setAll(MaterialDesignIcon.STAR.graphic()));
                            /*ListTile tile2 = new ListTile();
                            tile2.textProperty().setAll(item.getAmount().toString());
                            tile2.setSecondaryGraphic(buttons);
                            tile2.setPrefHeight(40);*/

                            setText(null);
                            setGraphic(tile);
                        } else {
                            setText(null);
                            setGraphic(null);
                        }
                    }

                });

                /*charmListView.setCellFactory(p -> new CharmListCell(){
                    public void updateItem(Ingredient item, boolean empty) {
                        super.updateItem(item, empty);

                        if(item != null && !empty){
                            ListTile tile = new ListTile();
                            tile.textProperty().setAll(item.getName());//.addAll(item.getName());
                            tile.setPrefHeight(40);
                            setText(null);
                            setGraphic(tile);
                        } else {
                            setText(null);
                            setGraphic(null);
                        }
                    }
                });*/
            }
        });
    }
    
    /*@FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }*/
    
}
