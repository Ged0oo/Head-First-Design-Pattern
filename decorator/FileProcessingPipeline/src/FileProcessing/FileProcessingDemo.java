package FileProcessing;

public class FileProcessingDemo {

	public static void main(String[] args) {
		String fileName = "test.txt";
		String rawData = "Hello world Decorator Pattern";
		
		DataSource file = new FileDataSource(fileName);
		DataSource pipeline = new EncryptionDecorator(new CompressionDecorator(file));
		pipeline.writeData(rawData);
		
        System.out.println("Raw data: " + rawData);
        System.out.println("From file (decoded): " + pipeline.readData());
	}
}
