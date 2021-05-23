package com.augustowskipiotr;

public class Main {

    public static void main(String[] args) {
        String text = "I love to work in global logic";

        Problem problem = new Problem("Logic");

        var a = problem.solve(text);
        problem.printSolution(a);
    }
}
