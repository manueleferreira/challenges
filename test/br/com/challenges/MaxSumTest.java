package br.com.challenges;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumTest 
{

	@Test
	public void identifyPositionsMaxSumTest()
	{
		final int[] sequence = {2, -4, 6, 8, -10, 100, -6, 5};
		final int[] positions = MaxSum.identifyPositionsMaxSum(sequence);
		Assert.assertEquals( 2, positions[0] );
		Assert.assertEquals( 5, positions[1] );
	}
	
	@Test
	public void identifyPositiveArrayPositionsMaxSumTest()
	{
		final int[] sequence = {1, 2, 3, 4, 5, 6, 7, 8};
		final int[] positions = MaxSum.identifyPositionsMaxSum(sequence);
		Assert.assertEquals( 0, positions[0] );
		Assert.assertEquals( 7, positions[1] );
	}

	@Test
	public void identifyOnlyOnePositiveNumberPositionsMaxSumTest()
	{
		final int[] sequence = {0, 0, 0, 1};
		final int[] positions = MaxSum.identifyPositionsMaxSum(sequence);
		Assert.assertEquals( 0, positions[0] );
		Assert.assertEquals( 3, positions[1] );
	}

	@Test
	public void identifyZeroArrayPositionsMaxSumTest()
	{
		final int[] sequence = {0, 0, 0, 0};
		final int[] positions = MaxSum.identifyPositionsMaxSum(sequence);
		Assert.assertEquals( 0, positions[0] );
		Assert.assertEquals( 0, positions[1] );
	}
	
	@Test
	public void identifyPositionsMaxWrongSumTest()
	{
		final int[] sequence = {2, -4, 6, 8, -10, 100, -6, 5};
		final int[] positions = MaxSum.identifyPositionsMaxSum(sequence);
		Assert.assertNotEquals( 5, positions[0] );
		Assert.assertNotEquals( 2, positions[1] );
	}
	
}	
