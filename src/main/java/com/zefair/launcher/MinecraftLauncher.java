package com.zefair.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinecraftLauncher {

    public void launchMinecraft(String username, String version, String gameDir, String assetsDir) {
        List<String> command = new ArrayList<>();

        // Путь к Java
        command.add("C:\\Users\\karin\\AppData\\Local\\Packages\\Microsoft.4297127D64EC6_8wekyb3d8bbwe\\LocalCache\\Local\\runtime\\java-runtime-gamma\\windows-x64\\java-runtime-gamma\\bin\\javaw.exe");

// Устанавливаем параметры JVM
        command.add("-Xms512M"); // Начальный размер памяти
        command.add("-Xmx14G");  // Максимальный размер памяти
        command.add("-XX:+UnlockExperimentalVMOptions");
        command.add("-XX:+UseG1GC");
        command.add("-XX:G1NewSizePercent=20");
        command.add("-XX:G1ReservePercent=20");
        command.add("-XX:MaxGCPauseMillis=50");
        command.add("-XX:G1HeapRegionSize=32M");

        String fabricJarPath = gameDir + "/versions/" + version + "/fabric-loader-0.15.11-1.19.2/fabric-loader-0.15.11-1.19.2.jar";
        command.add("-cp");
        command.add(fabricJarPath); // Указываем путь к Fabric .jar
        command.add("net.fabricmc.loader.impl.launch.knot.KnotClient"); // Класс запуска для Fabric

        // Аргументы для запуска Minecraft с Fabric
        command.add("--username");
        command.add(username);
        command.add("--version");
        command.add(version);
        command.add("--gameDir");
        command.add(gameDir);
        command.add("--assetsDir");
        command.add(assetsDir);

        // Создаем процесс для запуска Minecraft
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(gameDir)); // Устанавливаем рабочую директорию

        try {
            Process process = processBuilder.start(); // Запускаем процесс
            System.out.println("Minecraft Fabric запущен!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при запуске Minecraft Fabric!");
        }
    }
}