package com.max.lowercaser;


public class Main {
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		fileManager.toLowerFile(args[0]);
	}

}
