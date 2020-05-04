import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger; 

public class CurlExecution {
	
	public void curlexecutor(String wf_id,Logger oLogger,String config_prop){
			
		Properties prop = new Properties();
		String OOZIE_HOST = "";
		try {
			
			prop.load(new FileInputStream(config_prop));
			OOZIE_HOST = prop.getProperty("OOZIE_HOST").replaceAll("\"", "");
			
			oLogger.info("Oozie_Host : " + OOZIE_HOST);
		} 
		catch (IOException ce) {
			oLogger.error("Exception in building Java config.properties !!",ce);
			System.exit(1);
		}
		
 		String username = "test"; 
 		String password = "test"; 
 		 		
 		String url = ""+OOZIE_HOST+"/v1/job/"+wf_id+"?action=kill";	
 		
 		oLogger.info(" Oozie Host Url with oozie host as parameter:" +  url);
 		
 		//String url = ""+oozie_host+"/v1/job/"+wf_id+"?action=kill";
 		
 		String[] command = { "curl" , "-i", "--negotiate", "-u" , username + ":" + password, "-X" , "PUT" , url };
 		
 		oLogger.info("Starting the Process Builder for oozie workflow curl command");	
 		
 		ProcessBuilder process = new ProcessBuilder(command); 
 		
 		//oLogger.info("oozie curl command : " + command);
 		Process p; 
 		
 		try { 
 			p = process.start(); 
 			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 			
 			String line = null;	
 			while ((line = reader.readLine()) != null) { 		
 				if (line.contains("OK"))
 				{
 		        oLogger.info("The Oozie workflow " +wf_id+ " has been killed properly");
 		        }				
 			} 				
 			
 		} 
 		catch (IOException e) { 
 			oLogger.error("Error in curl command",e);
 		} 
 	} 
 	

}
