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
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        MediaPlayer[] arr = new MediaPlayer[n];

        for(int i=0;i<n;i++) {
            System.out.print("Type (1-Audio 2-Video): ");
            int t = sc.nextInt();

            if(t==1) arr[i] = new AudioPlayer();
            else arr[i] = new VideoPlayer();
        }

        for(int i=0;i<n;i++)
            arr[i].play();   // dynamic binding
    }
}