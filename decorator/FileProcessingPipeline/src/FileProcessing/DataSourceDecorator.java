package FileProcessing;

public abstract class DataSourceDecorator implements DataSource {
	protected DataSource wrappee;
	
	public DataSourceDecorator(DataSource source) {
		// TODO Auto-generated constructor stub
		this.wrappee = source;
	}

	@Override
	public String readData() {
		// TODO Auto-generated method stub
		return wrappee.readData();
	}

	@Override
	public void writeData(String data) {
		// TODO Auto-generated method stub
		wrappee.writeData(data);
	}

}
