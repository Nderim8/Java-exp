/*package Audio;

import javax.sound.sampled.*;

public class AudioPlayer 
{
	public static Clip clip;
	
   public static final int LOOP_CONTINUOUSLY = -1;
	
	// constructer
	public AudioPlayer(String s) // string s is the path to the audio
	{                            // file the we want to load up.
		
		// to read in the file need to use try-catch
		try
		{
			// te read audio
			AudioInputStream ais = AudioSystem.getAudioInputStream(
					getClass().getResourceAsStream(s));
			
			// find the compressed format that we are reading in
			AudioFormat baseFormat = ais.getFormat();
			// second format
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(), false);
			// now we need to actually convert it 
			// so we need another input stream to stream it into decoding format
			AudioInputStream dais =        // dais -> decoded audio input stream
			AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip(); //clip is the data structure that holds
			clip.open(dais);              //the audio.
			
		}
		catch(Exception e)
		{ 
			e.printStackTrace(); 
		}
		
	}
	public static void playbg()
	{
		if(clip == null) return;        
		stop();    // stop it if it is playing
        
		clip.setFramePosition(0);    //  frame where clips starts  70000
		
		// System.out.println(clip.getFrameLength());
		
		// start playing
		clip.loop(LOOP_CONTINUOUSLY);
		clip.setLoopPoints(0, clip.getFrameLength() - 250000);   //  frames where clips start playing and when stops
		
	}
	
	
	public static void play()
	{
		if(clip == null) return;        
		stop();    // stop it if it is playing
        
		// and then set the clip to the start position
		clip.setFramePosition(0);
		// start playing
		clip.start();
		
	}
	
	public static void stop()
	{
		if(clip.isRunning())  clip.stop();
	}
    // close the clip
	public void close()
	{
		stop();
		clip.close();
	}
	
	
}




*/