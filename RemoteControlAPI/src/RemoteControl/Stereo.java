package RemoteControl;

public class Stereo {
    public void on() { System.out.println("Stereo is On"); }
    public void off() { System.out.println("Stereo is Off"); }
    public void setCD() { System.out.println("Stereo is set for CD input"); }
    public void setVolume(int level) { System.out.println("Stereo volume set to " + level); }
}