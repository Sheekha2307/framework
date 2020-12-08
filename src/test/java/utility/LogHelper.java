package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogHelper {

 public enum LogStatus{Info, Error};
 
 public static void logger(String FileName, String LogDetails) throws IOException
 {
	 File file = new File(FileName+".txt");
	 FileWriter fr = new FileWriter(file, true);
	 fr.append(LogDetails);
	 fr.append("\n");
	 fr.close();	 
 }

}
