package com.trungthuc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class SqlExecFileRepository {

    @Autowired
     EntityManager entityManager;


    public void ping(){
        String command = "ping www.codejava.net";

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String  execCmdOS(String filePath){
        String response =null;
        StringBuilder builder = new StringBuilder();
        builder.append(" LOAD DATA LOCAL INFILE ")
                .append(" \'").append(filePath).append("\'")
                .append(" INTO TABLE csvdata FIELDS TERMINATED BY \',\'")
                .append(" LINES TERMINATED BY '\\n' ")
                .append(" IGNORE 1 ROWS (name, des) ");
        try {

//            ProcessBuilder builderCmd = new ProcessBuilder(
//                    "cmd.exe", "/c", builder.toString());
//            builderCmd.directory(new File("C:/"));
//            builderCmd.redirectErrorStream(true);
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c ", " mysql -u root -p password && " +builder);
            // run command line at: C:\\ (nó tương ứng với lệnh cd C:/
            processBuilder.directory(new File("C:\\\\"));
            Process p = processBuilder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                response = line;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

  public   void execFileCSV(String filePath){

      StringBuilder builder = new StringBuilder();
      builder.append(" LOAD DATA LOCAL INFILE ")
              .append(" \'").append(filePath).append("\'")
              .append(" INTO TABLE csvdata FIELDS TERMINATED BY \',\'")
              .append(" LINES TERMINATED BY '\\n' ")
              .append(" IGNORE 1 ROWS (name, des) ");

//        String queryStr = " \n LOAD DATA LOCAL INFILE " + "\'"+ filePath +"\'  \n "+
//                     "   INTO TABLE csvdata FIELDS TERMINATED BY ','  \n " +
//                     "   LINES TERMINATED BY '\\n'  \n " +
//                    "   IGNORE 1 ROWS (name, des) " ;
        Query query = entityManager.createQuery(builder.toString());
        query.executeUpdate();

    }
}
