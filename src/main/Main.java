package main;
import main.ga.GA;
import main.ga.Individual;
import main.ga.SubChromosome;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static main.Configs.MAX_VEHICLE;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.nanoTime();
        try (Scanner sc = new Scanner(System.in)) {
            String filename = sc.nextLine();
            Problem.load_input_data("..\\TTNT\\src\\main\\data\\"+filename+".txt");
        }
        
        GA solver=new GA();
        Individual best=solver.run();        

        System.out.print("\nOutput: ");
        for(int id: best.chromosome){
            System.out.print(id+" ");

        }
        int current = 1, max = 0;
        while (current < MAX_VEHICLE+1) {
            ArrayList<Integer> destilist = new ArrayList<>();
            int size = best.chromosome.size();
            for (int i = 0; i < size; i++) {
                if (best.chromosome.get(i) == current)
                    destilist.add(i);
            }
            
            SubChromosome cal = new SubChromosome(destilist);
            cal.calculate_fitness();
            if(cal.fitness > max)
                max = cal.fitness;

            System.out.println();
            System.out.print("Route for person " + current + ": ");

            for(int id: cal.route){
                System.out.print((id+1)+"->");
            }

            System.out.print("1" + " Distance travelled: " + cal.fitness);
            System.out.println();

            current++;
        }
        
        System.out.println("\nResult: " + max);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration/1000000 + "ms");
    }
}
