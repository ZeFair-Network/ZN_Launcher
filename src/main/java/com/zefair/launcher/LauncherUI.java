package com.zefair.launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LauncherUI extends Application {
    @Override
    public void start(Stage stage) {
        // Создаём элементы интерфейса
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        // Логика для кнопки
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // Вызов метода для авторизации
            System.out.println("Username: " + username + ", Password: " + password);
        });

        // Расположение элементов
        VBox vbox = new VBox(10, usernameField, passwordField, loginButton);
        Scene scene = new Scene(vbox, 300, 200);

        // Настройки окна
        stage.setTitle("Minecraft Launcher");
        stage.setScene(scene);
        stage.show();
    }

public class LauncherUI {
}
