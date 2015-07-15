package br.com.challenges.robot;

public class ProcessRobotCmd {

	static String directions = "NESW";

	/**
	 * executa uma sequência de comandos
	 * 
	 * @param cmdSequence
	 * @param spaceLim
	 * @param position
	 * @return
	 */
	public static Position executeCmdSequence(String cmdSequence, String[] spaceLim,
			Position position) 
	{
		final char firstChar = cmdSequence.charAt(0);
		if(firstChar != 'T')
		{
			for (char cmd : cmdSequence.toCharArray()) 
			{
				position = executeSimpleCmd(cmd, spaceLim, position);
			}
		}
		else
		{
			position = executeTransCmd(cmdSequence, spaceLim, position);
		}
		return position;
	}

	/**
	 * executa o comando transporte
	 * 
	 * @param cmdSequence
	 * @param spaceLim
	 * @param position
	 * @return
	 */
	private static Position executeTransCmd(String cmdSequence,
			String[] spaceLim, Position position) 
	{
		final String[] trans = cmdSequence.split(" ");
		final int newX = Integer.valueOf(trans[1]);
		final int newY = Integer.valueOf(trans[2]);

		if( validValue(newX, spaceLim[0]) && validValue(newY, spaceLim[1]) )
		{
			Integer newXConvert = Integer.valueOf( newX );
			Integer newYConvert = Integer.valueOf( newY );
			
			position.setX(newXConvert);
			position.setY(newYConvert);
		}
		else
		{
			System.err.println(String.format( "Movimento inválido: %s", cmdSequence));
		}
		
		return position;
	}

	/**
	 * verifica se a nova posição é válida em relação ao limite do plano
	 * 
	 * @param value
	 * @param limit
	 * @return
	 */
	private static boolean validValue(int value, String limit) 
	{
		int intLimit = Integer.valueOf(limit);
		if( ( value >= 0 ) && ( value < intLimit ) )
		{
			return true;
		}
		return false;
	}

	/**
	 * executa comandos simples de uma sequência
	 * 
	 * @param cmd
	 * @param spaceLim
	 * @param position
	 * @return
	 */
	public static Position executeSimpleCmd(char cmd, String[] spaceLim,
			Position position) 
	{
		if(cmd != 'M')
		{
			String direction = getNewDirection(cmd, position.getDirection());
			position.setDirection(direction);
		}
		else
		{
			final String direction = position.getDirection();
			int x = position.getX();
			int y = position.getY();
			if( "N".equals(direction) )
			{
				y++;
			}
			else if( "S".equals(direction) )
			{
				y--;
			}
			else if( "E".equals(direction) )
			{
				x++;
			}
			else 
			{
				x--;
			}
			
			if( validValue(y, spaceLim[0]) && validValue(x, spaceLim[1]) )
			{
				position.setX(x);
				position.setY(y);
			}
			else
			{
				System.err.println(String.format( "Movimento inválido: %s", cmd));
			}
		}
		
		return position;
	}

	/**
	 * indica a nova direção baseado em uma rotação
	 * 
	 * @param cmd
	 * @param actualDirection
	 * @return
	 */
	public static String getNewDirection(char cmd, String actualDirection) {
		int pos = directions.indexOf(actualDirection);
		if( cmd == 'L' )
		{
			pos--;
			if( pos < 0)
				pos = directions.length()-1;
		}
		else
		{
			pos++;
			if( pos == directions.length() )
				pos = 0;
		}
		
		String direction = Character.toString( directions.charAt(pos) );
		return direction;
	}	

}
