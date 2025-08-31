package FileProcessing;

public class CompressionDecorator extends DataSourceDecorator {

	public CompressionDecorator(DataSource source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readData() {
		// TODO Auto-generated method stub
		return super.readData();
	}

	@Override
	public void writeData(String data) {
		// TODO Auto-generated method stub
		String compressed = data.replaceAll(" ", "");
		super.writeData(compressed);
	}
}
