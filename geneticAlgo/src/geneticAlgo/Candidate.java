package geneticAlgo;

import java.util.Random;



 
public class Candidate implements Comparable<Candidate> {
    public static final int npNbr = 12;
    public boolean[][] genotype;
    final Random rand = new Random();
 
    public Candidate() {
    	Random randomNbr = new Random();
    	int wavNbr;
        wavNbr = 1 +randomNbr.nextInt(20); 
    	   
        genotype = new boolean[npNbr][wavNbr];
    }
    
    public Candidate(int size) {
   	   
       genotype = new boolean[npNbr][size];
   }
 
    void random() {
        for (int i = 0; i < npNbr; i++) {
        	for (int j = 0; j < genotype[i].length; j++) {
                
        	genotype[i][j] = 0.5 > rand.nextFloat();
        	}
        }
    }
 
    private String gene() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
    	sb.append("Wavelength Numbers=====>");
    	
        for (int i = 0; i < npNbr; i++) {
        	sb.append("\n");
        	sb.append("m"+(i+1));
        	sb.append(" ");
        	
        	for (int j = 0; j < genotype[i].length; j++) {
           sb.append(genotype[i][j] == true ? 1 : 0);
        	sb.append(" ");
        	}
        }
        return sb.toString();
    }
 
    int fitness() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < genotype[i].length; j++) {   
        		if (genotype[i][j])
                sum++;
        }}
        return sum;
    }
 
    public int compareTo(Candidate o) {
        int f1 = this.fitness();
        int f2 = o.fitness();
 
        if (f1 < f2)
            return 1;
        else if (f1 > f2)
            return -1;
        else
            return 0;
    }
 
    @Override
    public String toString() {
        return  gene() + " min_req_wav=" + this.genotype[0].length;
    }
}