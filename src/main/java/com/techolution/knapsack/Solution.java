package com.techolution.knapsack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author saikiran
 *
 */

/**
 * This class reads content from data.txt file from resource location.
 * It returns maximum satisfaction using knapsack algorithm.
 *
 */
@Component
class Solution {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Solution.class);
	
	// reading data file name from application.properties
    private static String fileName;
    
 	@Autowired
    public void MyBean(@Value("${input.filename}") String fileName) {
        this.fileName = fileName;
     }
	
	static int[] val = new int[100];
	static int[] wt = new int[100];
	static int W = 0;
	static int N = 0;// Get the total number of items. Could be wt.length or
					 // val.length. Doesn't matter

	public static int knapsack() throws IOException {
		
		// read content from data.txt file
		readContentFromFile();
		
		LOGGER.info("Applying knapsnack on data...");
 		int[][] V = new int[N + 1][W + 1]; // Create a matrix. Items are in rows
											// and weight at in columns +1 on
											// each side
		// What if the knapsack's capacity is 0 - Set all columns at row 0 to be
		// 0
		for (int col = 0; col <= W; col++) {
			V[0][col] = 0;
		}
		// What if there are no items at home. Fill the first row with 0
		for (int row = 0; row <= N; row++) {
			V[row][0] = 0;
		}
		for (int item = 1; item <= N; item++) {
			// Let's fill the values row by row
			for (int weight = 1; weight <= W; weight++) {
				// Is the current items weight less than or equal to running
				// weight
				if (wt[item - 1] <= weight) {
					// Given a weight, check if the value of the current item +
					// value of the item that we could afford with the remaining
					// weight
					// is greater than the value without the current item itself
					V[item][weight] = Math.max(val[item - 1]
							+ V[item - 1][weight - wt[item - 1]],
							V[item - 1][weight]);
				} else {
					// If the current item's weight is more than the running
					// weight, just carry forward the value without the current
					// item
					V[item][weight] = V[item - 1][weight];
				}
			}
		}
		// Printing the matrix
		/*for (int[] rows : V) {
			for (int col : rows) {
				 System.out.format("%5d", col);
			}
		}*/
 		return V[N][W];
	}

	/**
	 * This method reads data from file and parses it.
	 * @return 
	 * 
	 */
	public static String readContentFromFile() throws NumberFormatException
			 {
		LOGGER.info("Reading content from file...");
		int counter = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		String line;
		 
		// logic to read content from file
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			LOGGER.error("File not found, please check file is located in resources folder...");
			e.printStackTrace();
		}
		try {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ", 2);
				if (parts.length >= 2) {
					// get maximum time and number of items
					if (parts[0].equals("10000") & parts[1].equals("100")) {
						W = (int) Integer.parseInt(parts[0]);
						N = (int) Integer.parseInt(parts[1]);
					} // get satisfaction, time and add to map
					else {
						map.put((int) Integer.parseInt(parts[0]),
								(int) Integer.parseInt(parts[1]));
					}
				} else {
					LOGGER.warn("ignoring line: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// loop map elements and add to int array.
		for (int key : map.keySet()) {
			val[counter] = key;
			wt[counter] = map.get(key);
			counter++;
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("File read successfully...");
		return "success";
	}
}