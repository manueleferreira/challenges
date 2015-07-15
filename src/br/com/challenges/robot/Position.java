package br.com.challenges.robot;

public class Position 
{
	int x;
	int y;
	String direction;
	
	public Position(int x, int y, String direction) 
	{
		setX(x);
		setY(y);
		setDirection(direction);
	}
	
	public Position(String x, String y, String direction) 
	{
		Integer intX = Integer.valueOf( x );
		Integer intY = Integer.valueOf( y );
		
		setX(intX);
		setY(intY);
		setDirection(direction);
	}
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public String getDirection() 
	{
		return direction;
	}
	
	public void setDirection(String direction) 
	{
		this.direction = direction;
	}
	
}
