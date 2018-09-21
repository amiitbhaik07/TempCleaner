package test;

import java.util.Timer;

public class RunScheduler
{
	public static void main(String[] args) throws Exception
	{
		Timer time = new Timer();
		Scheduler st = new Scheduler();
		time.schedule(st, 0, 8*3600*1000);
	}
}
