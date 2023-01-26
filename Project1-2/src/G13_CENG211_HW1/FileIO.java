package G13_CENG211_HW1;

import java.io.*;

/** Class for file input to the program*/
public class FileIO {
	// Instance Variables
	private BufferedReader bufferedReader;
	private FileReader fileReader;
	private File file;
	private boolean initialized = false;
	private String[][] resultOfReading;
	
	// Constructor
	public FileIO(String fileName) {
		file = new File(fileName);
		readFile();
		initialized = true;
	}
	
	/*
	 Final and private method who called by constructor: 
	 Reading the file and save it in two-dimensional array format
	*/
	private final void readFile() {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			String fullString = "";
			boolean flag = true;
			int numberOfColumns = 0;
			int numberOfRows = 0;
			
			while((line = bufferedReader.readLine()) != null) {
				if(flag) {
					numberOfColumns = getNumberOf(line, ",");
					fullString += line;
					flag = false;
				} else {
					fullString += ";" + line;
				}
			}
			numberOfRows = getNumberOf(fullString, ";");
			
			resultOfReading = getResult(fullString, numberOfRows, numberOfColumns);
			bufferedReader.close();
			
		} catch(FileNotFoundException exception) {
			exception.printStackTrace();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 Accessor that gives the information two-dimensional array deep copy.
	 @return Two-dimensional array which includes the information readed from the file.
	 @throws SecurityException if the object is not initialized.
	 */
	public String[][] getResultArray() {
		if(initialized) {
			int rows = resultOfReading.length;
			int cols = resultOfReading[0].length;
			String[][] temp = new String[rows][cols];
			for(int row = 0; row < rows; row++) {
				for(int col = 0; col < cols; col++) {
					temp[row][col] = resultOfReading[row][col];
				}
			}
			return temp;
		} else {
			throw new SecurityException();
		}
	}
	
	/**
	 Accessor that gives the file name if needed.
	 @return The name of the file.
	 @throws SecurityException if the object is not initialized.*/
	public String getFileName() {
		if(initialized) {
			return file.getName();
		} else {
			throw new SecurityException();
		}
	}
	
	/*Implementation details*/
	
	private int getNumberOf(String line, String delimiter) {
		return line.split(delimiter).length;
	}
	
	private String[][] getResult(String fullLines, int rows, int cols) {
		String[][] result = new String[rows][cols];
		String[] temp = fullLines.split(";");
		for(int index = 0; index < temp.length; index++) {
			result[index] = temp[index].split(",");
		}
		return result;
	}
}
