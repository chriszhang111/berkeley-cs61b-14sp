/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class whose main method reads a string from the keyboard and prints the same string, 
	* with its second character removed.
 */

class Nuke2 {
	  /** Your program must read just one string, then print the same string 
	  	*with the second character omitted, then exit.
	   */
	
	
	public static void main(String[] arg) throws Exception {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = keyboard.readLine();

	    if(inputLine.length() >=2 ){
	    	String output = inputLine.charAt(0) + inputLine.substring(2,inputLine.length());
	    	System.out.println(output);
	    }
	    
	} 

	
}