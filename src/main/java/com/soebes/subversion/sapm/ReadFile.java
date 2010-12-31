package com.soebes.subversion.sapm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	public static ArrayList<IContent> readFile (String fileName) {
		Parser p = new Parser ();
		try {
	        BufferedReader in = new BufferedReader(new FileReader(fileName));
	        String str;
	        while ((str = in.readLine()) != null) {
	        	p.parse(str);
	        }
	        in.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return p.getRules();
	}

}
