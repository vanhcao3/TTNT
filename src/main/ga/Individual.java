package main.ga;
import java.util.ArrayList;
import java.util.Random;
import static main.Configs.MAX_VEHICLE;
import static main.Problem.N;

public class Individual{
    public ArrayList<Integer> chromosome; 
    public double fitness;

    public Individual(){
        this.chromosome = new ArrayList<>();
        this.fitness = -1;

    }

    public Individual(ArrayList<Integer> chromosome){
        this.chromosome = new ArrayList<>(chromosome);
        this.fitness = -1;

    }

    public void random_init(){
        ArrayList<Integer> randomChromosome = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < N-1; i++) {
            randomChromosome.add(rand.nextInt(MAX_VEHICLE)+1); 
        }
        this.chromosome = randomChromosome; 
    }

    double getFitness(){
        return -this.fitness;
    }

    public void calculateFitness(){
        int max = 0;
        int current = 1;

        while (current < MAX_VEHICLE+1) {
            ArrayList<Integer> destilist = new ArrayList<>();
            int size = chromosome.size();
            for (int i = 0; i < size; i++) {
                if (chromosome.get(i) == current)
                    destilist.add(i);
            }

            SubChromosome desti = new SubChromosome(destilist);
            int temp=desti.calculate_fitness();

            if (max< temp){
                max = temp;
            }
            current++;
        }
        this.fitness = (double)1.0/max;
    }

    public void swapMutate(){
        Random rand = new Random();
        int index1 = rand.nextInt(N-1);
        int index2 = rand.nextInt(N-1);
        int tmp = chromosome.get(index1);
        chromosome.set(index1, chromosome.get(index2));
        chromosome.set(index2, tmp);

    }
}
