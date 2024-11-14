package com.zefair.launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LauncherUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Minecraft Launcher");

        Button launchButton = new Button("Запустить Minecraft");
        launchButton.setOnAction(event -> {
            MinecraftLauncher minecraftLauncher = new MinecraftLauncher();

            // Передаем параметры для метода launchMinecraft
            String username = "Ndr_Zet"; // Замените на нужное имя пользователя
            String version = "1.19.2"; // Укажите нужную версию Minecraft
            String gameDir = "C:\\Users\\karin\\AppData\\Roaming\\.minecraft"; // Каталог с игрой
            String assetsDir = "C:\\Users\\karin\\AppData\\Roaming\\.minecraft\\assets"; // Каталог с ресурсами

            minecraftLauncher.launchMinecraft(username, version, gameDir, assetsDir);
        });

        StackPane root = new StackPane();
        root.getChildren().add(launchButton);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
