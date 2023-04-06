package com.example.softwaresecproj;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

public class AboutView extends GridPane {

    public AboutView(){
        setup();
    }
    private void setup(){
        File file = new File("myLogo.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        imageView.setFitHeight(100);
        imageView.setFitWidth(300);
        imageView.setImage(image);
        Label aboutText = new Label("Version: 1.0\n" +
                "\nThis app was built using the latest technology \n" +
                "to ensure a seamless user experience.\n" +
                "You can add, edit and delete records.\n" +
                "\nThis app was created by Sarthak Sharma\n" );
        aboutText.setWrapText(true);
        aboutText.setStyle("-fx-font-size: 15px;-fx-text-fill: #ADEAEA");
        this.add(imageView, 0, 0);
        this.add(aboutText, 0, 1);

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
    }
}
