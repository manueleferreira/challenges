package br.com.challenges.robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Robot 
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Por favor, informe o caminho do arquivo de leitura:");
		BufferedReader fileReader = new BufferedReader( new InputStreamReader( System.in ) );
		File file = new File(fileReader.readLine());
		if(file.exists())
		{
			InputStream is = new FileInputStream(file);
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			final String space = br.readLine();
			final String[] lengthSpace = space.split(" ");
			
			final String initialLocalization = br.readLine();
			final String[] initialLocalizationRobot = initialLocalization.split(" ");
			String x = initialLocalizationRobot[0];
			String y = initialLocalizationRobot[1];
			String direction = initialLocalizationRobot[2];
			
			Position position = new Position(x, y, direction);
			
			String cmdSequence;
			while((cmdSequence = br.readLine()) != null)
			{
				position = ProcessRobotCmd.executeCmdSequence(cmdSequence, lengthSpace, position);
			}
			
			br.close();
			
			if(position != null)
			{
				System.out.println(String.format( "%s %s %s", position.getX(), position.getY(), position.getDirection()));
			}
		}
		else
		{
			System.err.println("Caminho inválido");
		}
	}



}
