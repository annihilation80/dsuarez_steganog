package dsuarez_Steganog;

import java.util.ArrayList;
import java.util.List;

public class PrimeIterator {
	
	List<Integer> primeList = new ArrayList<Integer>();
	int it = -1;
	
	public PrimeIterator(int max){
		
		boolean[] primeCandidates = new boolean[max]; 
		
		for (int i = 2; i < max; i++) {
			primeCandidates[i] = true;
		}

		for (int i = 2; i < Math.sqrt(max); i++) {
			if (primeCandidates[i]) {
				
				for (int j = i + i; j < max; j = j + i) {
					primeCandidates[j] = false;
				}
			}

		}

		for (int i = 0; i < primeCandidates.length; i++) {
			if (primeCandidates[i]) {
				primeList.add(i);
			}
		}
	}
	
	public boolean hasNext(){
		return (primeList.size() > it+1);
	}
	
	public int next(){
		return primeList.get(++it);
		
	}
	
	
}
