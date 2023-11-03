package main.ga;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Individual implements Comparable<Individual> {

    public ArrayList<Integer> chromosome;

    public double fitness;

    public Individual(){

    }

    public Individual(ArrayList<Integer> chromosome){

    }

    public Individual random_init(){
        //create chromosome
        return null;
    }

    public double calculateFitness(){
        //
        return -1;
    }

    public void swapMutate(){

    }


    @Override
    public int compareTo(Individual o) {
        return -Double.valueOf(this.fitness).compareTo(o.fitness);
    }
}
