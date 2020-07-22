package com.company.infrastructure.logger;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTestLogger implements TestLogger {
    private int step = 1;

    @Override
    public void log(String msg) {
        msg = step + ") " + currentTimeStamp() + " [" + currentMethod() + "]: " + msg;
        step++;

        try {
            FileWriter f = new FileWriter("log.txt", true);
            f.write(msg + '\n');
            f.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private String currentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    private String currentMethod() {
        return Thread.currentThread().getName();
    }
}
