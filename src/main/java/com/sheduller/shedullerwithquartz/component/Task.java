package com.sheduller.shedullerwithquartz.component;

import com.sheduller.shedullerwithquartz.config.DatabaseConnectionsUtils;
import com.sheduller.shedullerwithquartz.config.Jobs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
@Data
@AllArgsConstructor
public class Task implements Runnable{
    private Jobs.Job job;
    @SneakyThrows
    @Override
    public void run() {
        Connection connection = DatabaseConnectionsUtils.getConnection(job.getConnection());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(job.getQuery());
        File file = new File("C:\\Users\\ab448\\IdeaProjects\\" +job.getFileName()+".txt") ;
        if(!file.exists()) file.createNewFile();
        FileWriter fw = new FileWriter(file) ;
        while (resultSet.next()){
            fw.write(resultSet.getObject(1).toString());
            fw.write("                                   ");
            fw.write(resultSet.getObject(2).toString());
            fw.write("                                   ");
            fw.write(String.valueOf(System.currentTimeMillis()/1000));
            fw.write("\n");
        }
        fw.close();
        System.out.println("success !");
        connection.close();
    }
}
