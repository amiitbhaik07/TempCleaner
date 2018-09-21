package test;

import java.io.File;
import java.util.Scanner;

public class Temp 
{
	static int fileCounter=0, folderCounter=0;
	public static void CleanTempFiles() throws Exception 
	{
		String tempFilePath = System.getProperty("java.io.tmpdir");
		System.out.println("Your TEMP directory : " + tempFilePath);
		deleteAllFilesFromDirectory(tempFilePath);
		deleteEmptyDirectories(tempFilePath);
		System.out.println();
		System.out.println();
		if(fileCounter==0 && folderCounter==0)
			System.out.println("Your TEMP folder is clean! Enjoy!");
		else
			System.out.println("Hoila! \nDeleted '"+fileCounter+"' files and '"+folderCounter+"' folders");
		Scanner sc = new Scanner(System.in);
		sc.next();
	}
	
	public static void deleteAllFilesFromDirectory(String directoryPath)
	{
		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile()) 
			{
				try
				{					
					listOfFiles[i].delete();
					try
					{
						if(!listOfFiles[i].exists())
						{
							System.out.println("Deleted File   : " + listOfFiles[i].getAbsolutePath());
							fileCounter++;
						}
					}
					catch(Exception e) {}
				}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			} 
			else if (listOfFiles[i].isDirectory()) 
			{
				deleteAllFilesFromDirectory(listOfFiles[i].getAbsolutePath());
			}
		}
	}
	
	public static void deleteEmptyDirectories(String directoryPath)
	{
		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isDirectory()) 
			{
				File[] listOfInnerFiles = listOfFiles[i].listFiles();
				for(int j=0; j<listOfInnerFiles.length; j++)
				{
					if(listOfInnerFiles[j].isDirectory())
						deleteEmptyDirectories(listOfFiles[i].getAbsolutePath());
				}
				listOfFiles[i].delete();	
				try
				{
					if(!listOfFiles[i].exists())
					{
						System.out.println("Deleted Folder : " + listOfFiles[i].getAbsolutePath());
						folderCounter++;
					}
				}
				catch(Exception e) {}
			}
		}
	}
}
