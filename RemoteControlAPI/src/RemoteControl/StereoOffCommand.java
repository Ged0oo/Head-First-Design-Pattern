package RemoteControl;

public class StereoOffCommand implements Command{
    Stereo stereo;
    public StereoOffCommand(Stereo stereo) { this.stereo = stereo; }
    
    @Override
    public void execute() { stereo.off(); }
	
    @Override
	public void undo() {
		// TODO Auto-generated method stub
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
	}
}