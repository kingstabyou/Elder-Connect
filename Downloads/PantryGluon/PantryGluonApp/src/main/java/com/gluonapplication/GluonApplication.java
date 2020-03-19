package com.gluonapplication;

import com.gluonapplication.lists.Density;
import com.gluonapplication.lists.Ingredients;
import com.gluonapplication.properties.Ingredient;
import com.gluonapplication.views.PrimaryView;
import com.gluonapplication.views.SecondaryView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GluonApplication extends MobileApplication {
    //charmListView.setHeadersFunction(String::length);


    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";
    
    @Override
    public void init() {
        addViewFactory(PRIMARY_VIEW, () -> new PrimaryView().getView());


        addViewFactory(SECONDARY_VIEW, () -> new SecondaryView().getView());

        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon.png")));
    }
}
