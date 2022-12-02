package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            int points = 0;
            System.out.println(loadData(points));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int loadData(int points) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("CheatSheet.txt");
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            char[] results = new char[3];
            String line = scan.nextLine();
            for (int i = 0; i < 3; i++) {
                results[i] = line.charAt(i);
            }
            int opponentPoints = 0;
            int myPoints = 0;
            if (results[0] == 'A') {
                opponentPoints += 1;
            } else if (results[0] == 'B') {
                opponentPoints += 2;
            } else if (results[0] == 'C') {
                opponentPoints += 3;
            }
            if (results[2] == 'X') {
                myPoints += 1;
            } else if (results[2] == 'Y') {
                myPoints += 2;
            } else if (results[2] == 'Z'){
                myPoints += 3;
            }

            if (myPoints > opponentPoints) {
                myPoints += 6;
            } else if (myPoints == opponentPoints) {
                myPoints += 3;
            }
            points += myPoints;
        }
        return points;

    }
}
