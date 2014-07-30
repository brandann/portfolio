/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brandan
 */
public class Driver {
    
    public Driver(){
        
    }
    
    public Program[] getData(){
        Program[] Programs = null;
        ArrayList<Program> prorgamList = new ArrayList<>();
        Scanner fileInputScanner;
        int count = 0;
        try{
            fileInputScanner = new Scanner(new File("data.txt"));
            while(fileInputScanner.hasNextLine()){
                String in = fileInputScanner.nextLine();
                if(count > 1){
                    prorgamList.add(new Program(in));
                }
                count++;
            }
            Programs = new Program[prorgamList.size()];
            Programs = prorgamList.toArray(Programs);
            prorgamList = null;
        }
        catch(IOException e){
            System.out.println("Error");
        }
        return Programs;
    }
    
    public boolean launchProgram(Program p){
        try{
            //Executes a file
            Desktop d = Desktop.getDesktop();
            d.open(new File(p.programName));
            return true;
        }
        catch(Exception e){
            System.out.println("Error: StarInYourOwnBook.FileExecutionMethod");
        }
        return false;
    }
    
    public String[] getProgramStrings(Program[] p){
        String[] s = new String[p.length];
        int i = 0;
        for(Program pro : p){
            s[i] = pro.toString();
            i++;
        }
        return s;
    }
    
    private final String PREFIX = "";
}
