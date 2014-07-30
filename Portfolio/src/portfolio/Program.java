/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

/**
 *
 * @author brandan
 */
public class Program {
    protected String programName;
    protected String programTitle;
    protected String programDescription;

    
    public Program(String in){
        String[] temp = in.split(",");
        programName = temp[0].trim();
        programTitle = temp[1].trim();
        programDescription =  temp[2].trim();
    }
    
    @Override
    public String toString(){
        String s = "";
        s = programTitle + "   -   " + programDescription;
        System.out.println(s);
        return s;
    }
}
