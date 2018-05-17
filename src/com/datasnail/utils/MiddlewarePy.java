package com.datasnail.utils;

import java.io.IOException;

import org.python.util.PythonInterpreter;

public class MiddlewarePy {
	public static void main(String[] args) {

        PythonInterpreter interpreter = new PythonInterpreter(); 
        Process proc = null;
        try {
			proc = Runtime.getRuntime().exec("python " + "H:\\myeclipse\\SocialNetwork\\src\\python\\communityDetection1.py");
			proc.waitFor();
			System.out.println("33");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
