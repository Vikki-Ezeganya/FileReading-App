package org.vikki;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileReader fileReader = new FileReader(new HashMap());
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(fileReader, scanner);
        ui.start();
        System.out.println("You ended the application. Goodbye!");
    }
}
