package adapter;

public class MP4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playMP4(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Playing mp4 file. Name: " + fileName);
	}

}
