package br.com.challenges;

public class CollatzConjecture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberToEvaluate = 1000000;
		 
		int number = identifyNumberWithLargestSequence( numberToEvaluate );
		
		System.out.println( number );
	}

	/**
	 * metodo identifica numero com a maior sequencia
	 * 
	 * @param numberToEvaluate
	 * @return
	 */
	public static int identifyNumberWithLargestSequence(int numberToEvaluate) {
		int maxSequenceLength = 0;
		int startingNumber = 1;
		int MAX_VALUE = numberToEvaluate + 1;
		int[] numberSequenceArray = new int[MAX_VALUE];
		numberSequenceArray[1] = 1;
		 
		long sequence;
		for (int i = 2; i <= numberToEvaluate; i++) {
		    sequence = i;
		    int increaseSequence = 0;
		    while ( ( sequence >= 1 ) && ( sequence >= i) ) {
		        increaseSequence++;
		        sequence = calculateNextSequenceNumber(sequence);
		    }
		    
	    	int lastValue = numberSequenceArray[(int)sequence];
			numberSequenceArray[i] = increaseSequence + lastValue;
		 
		    if (numberSequenceArray[i] > maxSequenceLength) {
		        maxSequenceLength = numberSequenceArray[i];
		        startingNumber = i;
		    }
		}
		return startingNumber;
	}

	/**
	 * metodo que calcula o proximo numero na sequencia
	 * 
	 * @param sequence
	 * @return
	 */
	public static long calculateNextSequenceNumber(long sequence) {
		if ( isEven(sequence) ) {
		    sequence = sequence / 2;
		} else {
		    sequence = sequence * 3 + 1;
		}
		return sequence;
	}
	
	/**
	 * metodo que verifica se o numero e par ou impar
	 * 
	 * @param sequence
	 * @return
	 */
	public static boolean isEven(long sequence) {
		boolean isEven = (sequence % 2) == 0;
		return isEven;
	}

}
