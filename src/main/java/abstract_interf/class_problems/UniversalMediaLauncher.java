package main.java.abstract_interf.class_problems;
interface Playable 
{
    void play();
    void play(int seconds);
}
abstract class MediaItem 
{
    protected String title;
    public MediaItem(String title) 
    {
        this.title = title;
    }
    public final String getTitle() 
    {
        return title;
    }
    public abstract void display();
}
class MusicTrack extends MediaItem implements Playable 
{
    public MusicTrack(String title) 
    {
        super(title);
    }
    @Override
    public void display() 
    {
        System.out.println("Music: " + title);
    }
    @Override
    public void play() 
    {
        System.out.println("Playing music: " + title);
    }
    @Override
    public void play(int seconds) 
    {
        System.out.println("Playing music for " + seconds + " seconds: " + title);
    }
}
class VideoClip extends MediaItem implements Playable 
{
    public VideoClip(String title) 
    {
        super(title);
    }
    @Override
    public void display() 
    {
        System.out.println("Video: " + title);
    }
    @Override
    public void play() 
    {
        System.out.println("Playing video: " + title);
    }
    @Override
    public void play(int seconds) 
    {
        System.out.println("Playing video for "+ seconds + " seconds: " + title);
    }
}
public class UniversalMediaLauncher 
{
    public static void main(String[] args) 
    {
        MediaItem music = new MusicTrack("My Song");
        MediaItem video = new VideoClip("My Video");
        music.display();
        video.display();
        Playable musicPlayer = (Playable) music;
        Playable videoPlayer = (Playable) video;
        musicPlayer.play();
        musicPlayer.play(30);
        videoPlayer.play();
        videoPlayer.play(60);
        MediaItem[] items = {music, video};
        for (MediaItem item : items) 
        {
            item.display();
        }
    }
}