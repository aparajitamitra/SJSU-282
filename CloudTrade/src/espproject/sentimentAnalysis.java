package espproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.servlet.ServletContext;

public class sentimentAnalysis {

	
	public static double calSentimentScore(String sentimentText, int retweetPar, int favoritePar,  ServletContext context)
	{
		double sentimentScore=0;
		int sP=0,sN=0;
		try{
			Scanner scaninput=new Scanner(sentimentText);
		    String inputSentence = scaninput.nextLine();
		    String[] result=inputSentence.split(" ");
		   for (int j=0;j<result.length;j++) {
		        if(result[j].startsWith("#", 0))
		        {
		        	result[j].replace("#", "");
		        }
		     }
				sP=countPositiveWords(result, context);
				sN=countNegativeWords(result, context);
				if(sP==0 && sN==0)
				{
					sentimentScore=0;
				}
				else
				{
				  sentimentScore=(float)(sP-sN)/(sP+sN);
				  if((retweetPar >0 && retweetPar <=30)||(favoritePar >0 && favoritePar <=30))
				  {
					  sentimentScore=sentimentScore*1.3;
				  }else if((retweetPar>30 &&  retweetPar<=100)||(favoritePar>30 &&  favoritePar<=100))
				  {
					  sentimentScore=sentimentScore*1.5;
				  }
				  else if((retweetPar>100)||(favoritePar>100))
				  {
					  sentimentScore=sentimentScore*1.8;
				  }
				}
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		return sentimentScore;
		
	}
	public static int countPositiveWords(String[] wordArr,ServletContext context)
	{
		int posCount=0;
       
		File f=new File(context.getRealPath("positive-words.txt"));
		
			Scanner txtscan;
			try {
				txtscan = new Scanner(f);
			
				while(txtscan.hasNextLine())
				{
				    String str = txtscan.nextLine();
				    for(int i=0;i<wordArr.length;i++)
				    {
				    	 if(str.equals(wordArr[i])!=false)
						    {
						       // System.out.println("EXISTS");
				    		 if(wordArr[i-1].toLowerCase().equals("very"))
				    		 {
				    			 posCount++;
				    		 }else if(wordArr[i-1].toLowerCase().equals("extremely"))
				    		 {
				    			 posCount++;
				    		 }else if((wordArr[i-1].toLowerCase().equals("so")))
				    		 {
				    			 posCount++;
				    			 
				    		 }
				    		 
				    		   posCount++;
						    }
				    	
				    }
				   
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return posCount;
	}
	
	public static int countNegativeWords(String[] wordArr,ServletContext context)
	{
		int negCount=0;
	       
		File f=new File(context.getRealPath("negative-words.txt"));
		
			Scanner txtscan;
			try {
				txtscan = new Scanner(f);
			
				while(txtscan.hasNextLine())
				{
				    String str = txtscan.nextLine();
				    for(int i=0;i<wordArr.length;i++)
				    {
				    	 if(str.equals(wordArr[i])!=false)
						    {
				    		 
							       // System.out.println("EXISTS");
					    		 if(wordArr[i-1].toLowerCase().equals("very"))
					    		 {
					    			 negCount++;
					    		 }else if(wordArr[i-1].toLowerCase().equals("extremely"))
					    		 {
					    			 negCount++;
					    		 }else if((wordArr[i-1].toLowerCase().equals("so")))
					    		 {
					    			 negCount++;
					    			 
					    		 }
				    		   negCount++;
						    }
				    	
				    }
				   
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return negCount;
	}
}
