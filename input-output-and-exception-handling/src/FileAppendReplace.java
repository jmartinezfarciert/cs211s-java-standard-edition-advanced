import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileAppendReplace {

	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the file name with the data");
		String userFile = scan.nextLine();
		
		Path userInputPath = Paths.get(userFile);
		
		if(Files.exists(userInputPath))
		{
			Scanner fileScan = new Scanner(userInputPath); // can create a scanner from a path object
			
			while (fileScan.hasNextLine())
			{
				String line = fileScan.nextLine();
				Scanner parseScan = new Scanner(line);
				parseScan.useDelimiter(",");
				
				String fileName = parseScan.next();
				boolean append = Boolean.parseBoolean(parseScan.next());
				List<String> newTextList = new ArrayList<String>();
				while(parseScan.hasNext())
				{
					newTextList.add(parseScan.next());
				}
				/*Option 1 for writing */
//				PrintWriter out = new PrintWriter(new FileOutputStream(fileName, append));
//				
//				for (String text : newTextList)
//				{
//					out.println(text);
//				}
//				out.close();
				
				/* option 2 for writing */
				// Using static Files method
				Path fileToModify = Paths.get(fileName);
				StandardOpenOption howToWrite = append ? StandardOpenOption.APPEND: StandardOpenOption.TRUNCATE_EXISTING;
				Files.write(fileToModify, newTextList, howToWrite);
				
			}// end while 
				
			fileScan.close();
			System.out.println("Done");
		} else {
			System.out.println("Invalid file");
		}
				
	}
}
