/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

/**
 *
 * @author karim
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class Score {
    
    
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author omar azab
 */
    private int sum = 0;
    public int scoresum()
    {
        sum = sum + 2;
        return sum;
    }
    public void write(int sum){
    try
    {
    File file =  new File("score.txt");
    PrintWriter pr = new PrintWriter(file);
    Scanner scanner =  new Scanner(file);
    while(!scanner.hasNext())
    {
        pr.println(sum);
        pr.close();
    }
    }
    catch(Exception ex)
    {
        System.out.println(ex.getMessage());
    }
    }
}

    

