package com.augustowskipiotr;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String keyWord = "LOGIC";
        String inputFilePath = "src/resources/input.txt";
        String outputFilePath = "src/resources/output.txt";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter keyWord [default: " + keyWord + "]");
        String userKeyWord = scanner.nextLine();

        System.out.println("Enter input file path [default: " + inputFilePath + "]");
        String userInputPath = scanner.nextLine();

        System.out.println("Enter output file path [default: " + outputFilePath + "]");
        String userOutputPath = scanner.nextLine();

        if(!userKeyWord.equals("")) {
            keyWord = userKeyWord;
        }
        if(!userInputPath.equals("")) {
            inputFilePath = userInputPath;
        }
        if(!userOutputPath.equals("")) {
            outputFilePath = userOutputPath;
        }

        try{
            Problem problem = new Problem(keyWord);

            String data = FileManager.read(inputFilePath);
            Map<CharsWordLengthEntry, Integer> solution = problem.solve(data);
            String stringedSolution = problem.solutionToString(solution);

            FileManager.write(outputFilePath, stringedSolution);
            System.out.println("Everything worked fine!");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please check if provided paths were correct");
        }
    }
}
