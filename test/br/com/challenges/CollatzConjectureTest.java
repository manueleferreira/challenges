package br.com.challenges;

import org.junit.Assert;
import org.junit.Test;

public class CollatzConjectureTest {

	@Test
	public void calculateNextValidSequenceNumberTest()
	{
		final long even = CollatzConjecture.calculateNextSequenceNumber( 4 );
		Assert.assertEquals( 2, even );
		final long odd = CollatzConjecture.calculateNextSequenceNumber( 3 );
		Assert.assertEquals( 10, odd );
	}
	
	@Test
	public void calculateNextInvalidSequenceNumberTest()
	{
		final long even = CollatzConjecture.calculateNextSequenceNumber( 4 );
		Assert.assertNotEquals( 13, even );
		final long odd = CollatzConjecture.calculateNextSequenceNumber( 3 );
		Assert.assertNotEquals( 2, odd );
	}
	
	@Test
	public void isEvenInvalidTest()
	{
		final boolean isEven = CollatzConjecture.isEven( 3 );
		Assert.assertFalse( isEven );
	}
	
	@Test
	public void isEvenValidTest()
	{
		final boolean isEven = CollatzConjecture.isEven( 4 );
		Assert.assertTrue( isEven );
	}
	
	@Test( timeout = 5000 )
	public void identifyNumberWithLargestSequenceWithLongValueTest(){
		final int longNumber = 1000000;
		final int number = CollatzConjecture.identifyNumberWithLargestSequence( longNumber );
		Assert.assertEquals( 837799, number );
	}
	
	@Test( timeout = 5000 )
	public void identifyNumberWithLargestSequenceWithShortValueTest(){
		final int longNumber = 4;
		final int number = CollatzConjecture.identifyNumberWithLargestSequence( longNumber );
		Assert.assertEquals( 3, number );
	}
	
	@Test( timeout = 5000 )
	public void identifyNumberWithLargestSequenceWithBaseValueTest(){
		final int longNumber = 1;
		final int number = CollatzConjecture.identifyNumberWithLargestSequence( longNumber );
		Assert.assertEquals( 1, number );
	}
}
