package com.Cucumber_BDD_Hybrid.testCases;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.Cucumber_BDD_Hybrid.testCases.BaseClass;
import static com.Cucumber_BDD_Hybrid.testCases.BaseClass.readConfig;



public class ObjectFileReader  {
	 
	static String tier;
	static String filepath = System.getProperty("user.dir")+"/src/main/resources/"; 
	
	public static String[] getELementFromFile(String pageName, String elementName) { 
		setTier(); 
		try { 
			FileReader specFile = new FileReader(filepath + tier + "/PageObjectRepository/" + pageName + ".txt");
			return getElement(specFile, elementName);
			} catch (Exception e) { 
				e.printStackTrace(); 
		}
	 return null; 
	} 

	public static String getPageTitleFromFile(String pageName) { 
	setTier(); 
	BufferedReader br = null; 
	String returnElement = ""; 
	try { 
		 br = new BufferedReader(new FileReader(filepath + tier + "/PageObjectRepository/" + pageName + ".txt")); 
		 String line = br.readLine(); 
		while (line != null && !line.startsWith("========")) {
			String titleId = line.split(":", 3)[0];
			if (titleId.equalsIgnoreCase("pagetitle")
					|| titleId.equalsIgnoreCase("title")
					|| titleId.equalsIgnoreCase("page title")) {
				returnElement = line;
			break; 
		}
		 line = br.readLine();
		 } 
		} catch (IOException ioe) {
			ioe.printStackTrace();
			} finally {
				if (br != null) { 
					try { 
						br.close();
						} catch (IOException e) { 
							e.printStackTrace(); } 
		}
	  }
	
	System.out.println(returnElement); 
	return returnElement.split(":",2)[1].trim(); 
}

	private static String[] getElement(FileReader specFile, String elementName) throws Exception { 
		String[] elementLineSplit;
		ArrayList<String> elementLines = getSpecSection(specFile); 
		
		for (String elementLine : elementLines) {
			elementLineSplit = elementLine.split(" "); 
		
		if (elementLineSplit[0].trim().equalsIgnoreCase(elementName)) {
			return elementLine.split(" ", 3);
			} else { 
				continue; 
				}
		}
		throw new Exception(); 
		} 

		private static ArrayList<String> getSpecSection(FileReader specfile) {
			String readBuff = null; 
			ArrayList<String> elementLines = new ArrayList<String>(); 
		
		try { 
		BufferedReader buff = new BufferedReader(specfile);
		try {
			boolean flag = false;
			readBuff = buff.readLine(); 
			 while ((readBuff = buff.readLine()) != null) {
				 if (readBuff.startsWith("========")) {
					 flag = !flag; 
			}
			if (flag) {
				elementLines.add(readBuff.trim().replaceAll("[ \t]+"," ")); 
			}
				if (!elementLines.isEmpty() && !flag) { 
					break; 
				}
			} 
			} finally {
				buff.close(); 
				if (elementLines.get(0).startsWith("========"))
					elementLines.remove(0); 
			} 
			}
		catch (FileNotFoundException e1) { 
			System.out.println("Spec File not found at location :- " + filepath);
			} catch (IOException e) { 
				System.out.println("exceptional case");
				} 
		return elementLines;  
		}
		
		private static void setTier() { 
			switch (Tiers.valueOf(readConfig.getTire())){
			case production: 
			case PROD:
			case PRODUCTION:
			case Production: 
			case prod: 
				tier = "PROD/";
			    break;
			case stag:
			case staging:
			case Staging: 
			case STAGING: 
				tier = "STAGING/"; 
				break; 
			case pristine: 
			case PR:
			case PRISTINE: 
			case Pristine: 
			case pr: 
				tier = "PR/";
				break; 
			case ga: 
			case QA: 
			case Qa: 
				tier = "QA/";
				break;
				case Dev: 
				case DEV: 
				case dev: 
					tier = "DEV/";
					break;
			}
		}

	


}
