package FileProcessing;

public class EncryptionDecorator extends DataSourceDecorator {

	public EncryptionDecorator(DataSource source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String readData() {
		// TODO Auto-generated method stub
		String data = super.readData();
		return new StringBuilder(data).reverse().toString();
	}

	@Override
	public void writeData(String data) {
		// TODO Auto-generated method stub
		String encrypted = new StringBuilder(data).reverse().toString();
		super.writeData(encrypted);
	}

}
