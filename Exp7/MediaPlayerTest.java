package Exp7;
import java.util.Scanner;
class MediaPlayer {
    public void play() {
        System.out.println("Playing media");
    }
}
class AudioPlayer extends MediaPlayer {
    public void play() {
        System.out.println("Playing audio");
    }
}
class VideoPlayer extends MediaPlayer {
    public void play() {
        System.out.println("Playing video");
    }
}
public class MediaPlayerTest {
    public static void main(String[] args) {
        MediaPlayer[] arr = new MediaPlayer[2];
        arr[0] = new AudioPlayer();
        arr[1] = new VideoPlayer();
        for (int i = 0; i < arr.length; i++) {
            arr[i].play();   // dynamic binding
        }
    }
}