package com.saveli.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateLogs {
    private LocalDateTime now = LocalDateTime.now();

    /* Return: Имя файла, без Path. */
    public String GenerateNameFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalTime localTime = LocalTime.now();
        String localTimeString = getNearestDecimalTime(localTime).toString().replace(":", "-");
        String nameFile = now.format(formatter) + "-" + localTimeString + ".txt";
        return nameFile;
    }

    /* Создание файла с логами */
    public File GenerateLogsFile(String nameFile, String absolutePath) {
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
    }

    public boolean CreateLog(String message, File logsFile){
        if(logsFile.isFile() == true){
            LocalTime lTime = LocalTime.now();
            try {
                FileWriter fWriter = new FileWriter(logsFile);
                fWriter.append(lTime.toString() + message);
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

    private boolean searchFile(){
        
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

        return nearestDecimalTime;
    }
}
