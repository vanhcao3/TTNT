package main;

import main.ga.GA;
import main.ga.Individual;
import main.ga.SubChromosome;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static main.Configs.MAX_VEHICLE;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.nanoTime();
        Problem.load_input_data("D:\\java-workplace\\TNTT\\src\\main\\data\\dantzig_699.txt");
        GA solver=new GA();
        Individual best=solver.run();
        System.out.println(best.fitness);
        for(int id: best.chromosome){
            System.out.print(id+" ");

        }
        int current = 1;
        while (current < MAX_VEHICLE+1) {
            ArrayList<Integer> destilist = new ArrayList<>();
            int size = best.chromosome.size();
            for (int i = 0; i < size; i++) {
                if (best.chromosome.get(i) == current)
                    destilist.add(i);
            }
            for(int id: destilist){
                System.out.print((id+1)+" ");

            }
            System.out.println();

            current++;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration/1000000);







    }
}
