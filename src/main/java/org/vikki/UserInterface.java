package org.vikki;

import java.util.Scanner;

public class UserInterface {
    private FileReader fileReader;
    private Scanner scanner;
    private  String input;

    public UserInterface(FileReader fileReader, Scanner scanner) {
        this.fileReader = fileReader;
        this.scanner = scanner;
    }

// Starts the app and display welcome message
    public void start() {
        boolean runStatus = true;
        System.out.println("***** Hi! Welcome to The FileReading Application. ****" + "\n");
        System.out.println("You can only read from the following files:");
        System.out.println("1. config.text.dev" + " \n" + "2. config.txt" + "\n" + "3. config.txt.staging");
        System.out.println("4. quit");
        System.out.println();
        processCommands();

    }

//    Processes the commands entered by the user
    private void processCommands() {

       boolean runningStatus = true;

        while (runningStatus) {

            System.out.println("Enter a number from 1-3 to read from a file or 4 to quit");
            input = scanner.nextLine();
            if (input.equals("1")) {
                readFromChosenFile("config.text.dev");
                if(!runAgain()){
                    runningStatus = false;
                }
            } else if (input.equals("2")) {
                readFromChosenFile("config.txt");
                if(!runAgain()){
                    runningStatus = false;
                }
            } else if (input.equals("3")) {
                readFromChosenFile("config.txt.staging");
                if(!runAgain()){
                    runningStatus = false;
                }
            }
            else if (input.equals("4")) {
              System.exit(0);
            }
            else  {
                try {
                    throw new WrongInputException("Invalid command number entered.Please Enter a valid number");
                } catch (WrongInputException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println();
                    System.out.println();
                }

            }

        }
    }

//    Reads the file supplied
    public void readFromChosenFile(String fileName) {
        this.fileReader.readFromFile(fileName);

    }


//    Checks if the user wants to continue issuing commands
    private  boolean runAgain(){
        boolean answer = false;
        boolean repeat = false;
        System.out.println();
        System.out.println("Do you wish to continue? [y/n]");


        do{
            System.out.println();
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("y")){
                answer = true;
                repeat = false;
            } else if(input.equalsIgnoreCase("n")){
                answer = false;
                repeat = false;
            }

            else{
                try {
                    throw new WrongInputException("Invalid command number. Input a valid command character");
                } catch (WrongInputException ex) {
                    System.out.println(ex.getMessage());
                    repeat = true;
                }
            }
        }
        while(repeat);

        return  answer;
    }
}


