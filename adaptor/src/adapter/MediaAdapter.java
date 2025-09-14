package adapter;

public class MediaAdapter implements MediaPlayer {
	private AdvancedMediaPlayer adv;

	public MediaAdapter(String audioType) {
		if(audioType.equalsIgnoreCase("vlc")) {
			adv = new VLCPlayer();
		} else if(audioType.equalsIgnoreCase("mp4")) {
			adv = new MP4Player();
		}
	}
	
	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("vlc")) {
			adv.playVLC(fileName);
		} else if(audioType.equalsIgnoreCase("mp4")) {
			adv.playMP4(fileName);
		}
	}
}
