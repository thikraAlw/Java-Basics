package day3;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class FileRW {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter File Name: ");
        String fileName = s.nextLine();

//        C:\\Users\\dev\\Desktop\\Myfile.txt

        var f1 = new File(fileName);

//        System.out.println(f1.length());
//        System.out.println(f1.exists());
//        System.out.println(f1.isDirectory());
//        System.out.println("---------------------");

        HashMap<Integer, String> MyWord = new HashMap<Integer, String>();

        String chars = "";

        try {
            var fsc = new Scanner(f1);
            while (fsc.hasNext()) {
                chars += fsc.nextLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        for (int i = 0; i < chars.length(); i++) {
            var myC = chars.charAt(i);
            MyWord.put(i, String.valueOf(myC));
        }




        System.out.println(chars);


//        try {
//            var fileName = "src/main/java/day3/sorted_words.txt";
//            var pr = new FileWriter(fileName);
//            pr.write("om");
//
//            pr.close();
//
//        }
//        catch (Exception e) {
//            System.out.println("File Not Found");
//        }


//        FileReader fr = new FileReader();

    }
}
