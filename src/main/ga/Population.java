package main.ga;
import java.util.ArrayList;
import java.util.Comparator;

import main.Configs;

public class Population{
    public ArrayList<Individual> individuals;
    public Individual best;

    public Population(){
        individuals = new ArrayList<Individual>();
        best = null;
    }

    public void randomInit(){
        for(int i = 0; i < Configs.POPULATION_SIZE; i++){
            Individual individual = new Individual();
            individual.random_init();
            individual.calculateFitness();
            individuals.add(individual);       
        }
    }
    
    public ArrayList<Individual> crossover(Individual p1,Individual p2){
        ArrayList<Individual> offsprings = new ArrayList<Individual>();

        for(int i = 0; i < 2; i++){
            Individual offspring = new Individual();
            ArrayList<Integer> chromosome = new ArrayList<Integer>();

            for(int j = 0; j < p1.chromosome.size(); j++){
                if(Math.random() < 0.5){
                    chromosome.add(p1.chromosome.get(j));
                }
                else{
                    chromosome.add(p2.chromosome.get(j));
                }
            }
            offspring.chromosome = chromosome;
            offsprings.add(offspring);
        }
        return offsprings;
    }

    public void executeSelection(){
        this.individuals.sort(Comparator.comparingDouble(Individual::getFitness));
        int len=individuals.size();
        while(individuals.size()>Configs.POPULATION_SIZE){
             individuals.remove(len-1);
             len--;

        }
        best=individuals.get(0);
    }
}
