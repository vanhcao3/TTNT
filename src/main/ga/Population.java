package main.ga;

import java.util.ArrayList;
import java.util.Comparator;
import main.Configs;

public class Population {

    public ArrayList<Individual> individuals;

    public Individual best;

    public Population(){
        individuals = new ArrayList<Individual>();
        best = null;
    }

    public void random_init(){
        for(int i = 0; i < Configs.POPULATION_SIZE; i++){
            Individual individual = new Individual();
            individual.random_init();
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

    public void execute_selection(){
        ArrayList<Individual> selectedParents = new ArrayList<>();

        int tournamentSize = 10; //Thay doi dc

        for (int i = 0; i < Configs.POPULATION_SIZE; i++) {
            ArrayList<Individual> tournament = new ArrayList<>();
        
                for (int j = 0; j < tournamentSize; j++) {
                    tournament.add(individuals.get((int) (Math.random() * individuals.size())));
                }

        tournament.sort(Comparator.comparingDouble(individual -> individual.fitness));
        selectedParents.add(tournament.get(0));
    }

    individuals = selectedParents;
    }
}
