package br.com.challenges;

public class MaxSum 
{

	public static void main(String[] args) 
	{
		final int[] sequence = {2, -4, 6, 8, -10, 100, -6, 5};
		final int[] positions = identifyPositionsMaxSum(sequence);
		for (int i : positions) {
			System.out.print(i+" ");
		}
	}

	public static int[] identifyPositionsMaxSum(int[] sequence) 
	{
		int actual = 0;
		int max = 0;
		int first = 0;
		int newFirst = 0;
		int second = 0;
		
		for (int j = 0; j < sequence.length; j++) 
		{
			actual += sequence[j];
			if( max < actual )
			{
				first = newFirst;
				second = j;
				max = actual;
			}
			else if( actual < 0 )
			{
				actual = 0;
				newFirst = j+1;
			}
		}
		
		final int[] result = new int[]{first, second};
		return result;
	}
	
}
