package FileProcessing;

import java.io.*;

public class FileDataSource implements DataSource {
	private String fileName;
	
	public FileDataSource(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
	}

	@Override
	public String readData() {
		// TODO Auto-generated method stub
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			return reader.readLine();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public void writeData(String data) {
		// TODO Auto-generated method stub
		try(FileWriter writer = new FileWriter(fileName)){
			writer.write(data);
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
