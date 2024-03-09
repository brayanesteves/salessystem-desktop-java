package com.halconbit.salessystem.desktop.maven.javav17.access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 * @author Brayan Esteves [brayan.esteves93@gmail.com]
 */
public class Access {
    public static List<String> loadFile(String root) {
        List<String> list = null;
        // Create file .txt.
        FileReader fileReader;
        // Read file .txt.
        BufferedReader bufferedReader;
        // Save line in 'bufferedReader'.
        String line;
        File folder = new File("Documents/Files/Texts");
        File file = new File("Documents/Files/Texts/" + root);
        try {
            if(!folder.exists()) {
                FileUtils.forceMkdir(folder);
            }
            if(!file.exists()) {
                file.createNewFile();
            }
            list = new ArrayList<>();
            fileReader = new FileReader("Documents/Files/Texts/" + root);
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch(IOException iOException) {
            JOptionPane.showMessageDialog(null, "Error load file " + file.getName() + ". -> " + iOException.getMessage());
        }
        return list;
    }
}
