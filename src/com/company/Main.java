package com.company;
import java.io.*;

/*

Runbeck Interview Coding Excercise
By: Dave Rhea
Date: 1/15/2020
This application is intended to prompt a user (in the console) for the following info:
1. the URL to a file
2. determine if values are comma or tab seperated
3. the number or columns to validate for each row.

Upon the above user input, the application will:
1. parse the CSV/TSV file
2. remove the header row
3. validate the rows have appropriate number of fields
4. create two files:
    good.txt - rows that pass validation should be added.
    bad.txt - rows that failed validation

    //TODO: Break down into cleaner classes.

*/

public class Main{

        //Static vars
        public static String delimiter;
        public static String fileName;
        public static int fieldCount;
        public static String line;


        public static void main(String args[]) throws IOException {

            //Create BufferedReader to read user console inputs
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //Prompt User for filePath
            System.out.print("Enter your filepath: ");
            fileName = br.readLine();
            ///TODO: Test url:  /Users/david/Desktop/Runbeck/testData.txt


            //Ask user if file is comma or tabbed
            System.out.print("\nFile Format: [C]SV or [T]SV (tab-separated values)?:");

            if(br.readLine().equalsIgnoreCase("C")){
                delimiter = ",";
            } else{
                delimiter = "\\\\s+";
                //TODO: Capture user input more gracefully and reprompt if invalid input is entered.
                //TODO: Currently, this sets any input other that 'C' to TSV mode.

            }


            //Ask User How many fields
            System.out.print("\nHow many fields should each record contain?:");
            fieldCount = Integer.parseInt(br.readLine());
            //TODO: Capture invalid inputs gracefully.

            //Setup Reader and Writers
            //Read the file at the user-defined URL
            br = new BufferedReader(new FileReader(fileName));

            //Setup file writers
            FileWriter badWriter = new FileWriter("bad.txt");
            FileWriter goodWriter = new FileWriter("good.txt");
            //TODO: output files to a nicer location...?

            //Read Header Line in order to omit it from exported files
            String headerLine = br.readLine();


            //Validate lines for user-inputted fieldCount
            while ((line = br.readLine()) != null){
                //Split fields by user-defined delimiter
                String fields[] = line.split(delimiter);

                if (fields.length != fieldCount){
                    //Lines that fail validation are written to the BAD file
                    badWriter.append(line + "\n");
                } else {
                    //Lines that pass validation go to the GOOD file
                    goodWriter.append(line + "\n");

                }
            }
            System.out.print("\nProgram completed. Files created in app root.");
            goodWriter.close();
            badWriter.close();




            }

            }









