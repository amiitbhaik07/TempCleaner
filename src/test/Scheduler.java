package test;

import java.util.Date;
import java.util.TimerTask;

public class Scheduler extends TimerTask
{
	Date now;
	public void run() 
	{
		now = new Date();
		try
		{
			Temp.CleanTempFiles();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
