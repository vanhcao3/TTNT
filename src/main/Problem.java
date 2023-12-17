package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem{
    public static int[][] distance;
    public static int  N;
    public static void load_input_data(String filepath) throws FileNotFoundException{
        Scanner sc=new Scanner(new File(filepath));
        int N1=sc.nextInt();
        N=N1;
        distance=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                distance[i][j]=sc.nextInt();
            }
        }
        sc.close();
    }
}
