package main;

import main.ga.GA;
import main.ga.Individual;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        try{
            Problem.load_input_data("D:\\java-workplace\\TNTT\\src\\main\\data\\dantzig_699.txt");
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

//        GA solver=new GA();
//        Individual best=solver.run();
//        System.out.println(best.fitness);

        Individual th=new Individual();
        for(int i=1;i<=40;i++){
            th.chromosome.add(10);
        }
        th.chromosome.add(3);
        th.calculateFitness();
        System.out.println(1/ th.fitness);





    }
}
