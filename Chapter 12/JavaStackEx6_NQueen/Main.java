package client;

import res.*;

public class Main {

    public static void main(String[] args) {
        NQueenSolver solver = new NQueenSolver(4);
        System.out.println(solver.solve());
        
        solver = new NQueenSolver(8);
        System.out.println(solver.solve());
    }
}