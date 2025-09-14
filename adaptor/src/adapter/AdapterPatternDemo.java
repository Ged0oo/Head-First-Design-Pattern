package adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "beyond_the_horizon.mp3");
        player.play("mp4", "alone.mp4");
        player.play("vlc", "far_far_away.vlc");
        player.play("avi", "mind_me.avi");
    }
}
