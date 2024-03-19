package com.saveli.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class CreateLogs {
    private LocalDateTime now = LocalDateTime.now();
    private String currentNameFile;
    private String absolutePath;
    private String nearesTime;

    public CreateLogs(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/application.properties"));
            this.absolutePath = properties.getProperty("absolute.path.logger");
        } catch (IOException  e) {
            e.printStackTrace();
        }
        String fileName = GenerateNameFile();
        if(isFileCreated(fileName, absolutePath) == false){
            GenerateLogsFile(fileName, absolutePath);
        }
    }

    /* Return: Имя файла, без Path. */
    private String GenerateNameFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalTime localTime = LocalTime.now();
        String localTimeString = getNearestDecimalTime(localTime).toString().replace(":", "-");
        String nameFile = now.format(formatter) + "-" + localTimeString + ".txt";
        this.currentNameFile = nameFile;
        return nameFile;
    }

    /* Создание файла с логами */
    private File GenerateLogsFile(String nameFile, String absolutePath) {
        if (CheckCorrect(nameFile, absolutePath) == true) {
            File file = new File(absolutePath + nameFile);
            System.out.println(file.getAbsolutePath().toString());
            if(file.isFile() == true){
                if(file.canWrite() == true){
                    return file;
                }
            }
            if(file.isFile() == false){
                try {
                    if(file.createNewFile() == true){
                        System.out.println("File created.");
                        return file;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new File("null");
        // Файл всегда создается, надо проверять есть ли файл в логах.
    }

    public boolean CreateLog(String message){
        File logsFile;
        if((currentNameFile == null || currentNameFile == "") && (absolutePath == null || absolutePath == "")){
            return false;
        }
        if(isFileCreated(currentNameFile, absolutePath) == true){
            logsFile = searchFile(currentNameFile, absolutePath);
        }
        else{
            logsFile = GenerateLogsFile(currentNameFile, absolutePath);
        }
        if(logsFile.isFile() == true){
            LocalTime lTime = LocalTime.now();
            try {
                FileWriter fWriter = new FileWriter(logsFile, true);
                fWriter.append(lTime.toString() +":"+ message + "\n");
                fWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean CheckCorrect(String nameFile, String absolutePath) {
        boolean correctNameFile = false;
        boolean correctAbsolutePath = false;
        if (nameFile != null && nameFile != "") {
            correctNameFile = true;
        }
        File correctPath = new File(absolutePath);
        if (correctPath.isDirectory() == true) {
            correctAbsolutePath = true;
        }
        return (correctAbsolutePath && correctNameFile);
    }

    private File searchFile(String nameFile,String absolutePath){
        File logsFile = new File(absolutePath + nameFile);
        if(logsFile.isFile() == true){
            return logsFile;
        }
        return new File("");
    }

    private boolean isFileCreated(String nameFile, String absolutePath){
        File fileDirectory = new File(absolutePath);
        if(fileDirectory.isDirectory() == true){
            for(File file: fileDirectory.listFiles()){
                if(file.isDirectory()){
                    // Вложенная папка в логах, можно изменить на вызов метода, чтобы проверять и внутри.
                    return false;
                }
                if(file.getName().equals(nameFile)){
                    return true;
                }
            }
        }
        return false; 
    }

    private LocalTime getNearestDecimalTime(LocalTime localTime){
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        int nearestHour = hour;
        int nearestMinute = (int) (Math.round(minute / 10.0) * 10) % 60;
        /*
         * Делим на 10.0 и получаем 58 = 5.8
         * Округляем 5.8 = 6
         * Умножаем на 10, чтобы получить двоичное число. 6 = 60
         * Остаток от деления, 60 = 0
         */

        //Может быть 0?
        if(nearestMinute == 60){
            nearestHour = nearestHour + 1;
            nearestMinute = 0;
        }

        LocalTime nearestDecimalTime = LocalTime.of(nearestHour, nearestMinute);
        this.nearesTime = nearestDecimalTime.toString();
        return nearestDecimalTime;
    }
}
