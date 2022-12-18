package com.javahouse.effective.create;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        try {
            rf.read("/a.txt");
        } catch (IOException e) {
            Throwable[] throwables = e.getSuppressed();
            for (Throwable throwable : throwables) {
                System.out.println(throwable.getMessage());
            }
        }
    }
    public void read(String filename) throws IOException {
        FileInputStream input = null;
        IOException readException = null;
        try {
            input = new FileInputStream(filename);
        } catch (IOException ex) {
            readException = ex;
        } finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException ex2) {
                    if(readException != null){
                        readException.addSuppressed(ex2);    //注意这里
                    }else{
                        readException = ex2;
                    }
                }
            }
            if(readException != null){
                readException.addSuppressed(new Exception("test exception"));
                throw readException;
            }
        }
    }
}