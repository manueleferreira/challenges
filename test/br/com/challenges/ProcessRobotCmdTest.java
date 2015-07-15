package br.com.challenges;

import org.junit.Assert;
import org.junit.Test;

import br.com.challenges.robot.Position;
import br.com.challenges.robot.ProcessRobotCmd;

public class ProcessRobotCmdTest 
{
	
	@Test
	public void executeCorrectCmdSequence()
	{
		Position position = new Position(0, 0, "N");
		position = ProcessRobotCmd.executeCmdSequence("L", new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "W", position.getDirection() );
	}

	@Test
	public void executeValidTransCmdSequence()
	{
		Position position = new Position(0, 0, "N");
		position = ProcessRobotCmd.executeCmdSequence("T 1 3", new String[]{"10", "10"}, position);
		Assert.assertEquals( 1, position.getX() );
		Assert.assertEquals( 3, position.getY() );
		Assert.assertEquals( "N", position.getDirection() );
	}
	
	@Test
	public void executeInvalidTransCmdSequence()
	{
		Position position = new Position(0, 0, "N");
		position = ProcessRobotCmd.executeCmdSequence("T 10 11", new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "N", position.getDirection() );
	}
	
	@Test
	public void generateValidLeftNewDirection()
	{
		Assert.assertEquals( "W", ProcessRobotCmd.getNewDirection('L', "N") );
		Assert.assertEquals( "N", ProcessRobotCmd.getNewDirection('L', "E") );
	}
	
	@Test
	public void generateValidRightNewDirection()
	{
		Assert.assertEquals( "N", ProcessRobotCmd.getNewDirection('R', "W") );
		Assert.assertEquals( "S", ProcessRobotCmd.getNewDirection('R', "E") );
	}
	
	@Test
	public void executeSimpleLeftCmdSequence()
	{
		Position position = new Position(0, 0, "N");
		position = ProcessRobotCmd.executeSimpleCmd('L', new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "W", position.getDirection() );
	}
	
	@Test
	public void executeSimpleRightCmdSequence()
	{
		Position position = new Position(0, 0, "W");
		position = ProcessRobotCmd.executeSimpleCmd('R', new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "N", position.getDirection() );
	}
	
	@Test
	public void executeSimpleMoveNorthCmdSequence()
	{
		Position position = new Position(0, 0, "N");
		position = ProcessRobotCmd.executeSimpleCmd('M', new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 1, position.getY() );
		Assert.assertEquals( "N", position.getDirection() );
	}
	
	@Test
	public void executeSimpleMoveEastCmdSequence()
	{
		Position position = new Position(0, 0, "E");
		position = ProcessRobotCmd.executeSimpleCmd('M', new String[]{"10", "10"}, position);
		Assert.assertEquals( 1, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "E", position.getDirection() );
	}
	
	@Test
	public void executeSimpleMoveWestCmdSequence()
	{
		Position position = new Position(1, 0, "W");
		position = ProcessRobotCmd.executeSimpleCmd('M', new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "W", position.getDirection() );
	}
	

	@Test
	public void executeSimpleMoveSouthCmdSequence()
	{
		Position position = new Position(0, 1, "S");
		position = ProcessRobotCmd.executeSimpleCmd('M', new String[]{"10", "10"}, position);
		Assert.assertEquals( 0, position.getX() );
		Assert.assertEquals( 0, position.getY() );
		Assert.assertEquals( "S", position.getDirection() );
	}
}
