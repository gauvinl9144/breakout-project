/**
 * 
 */
package application;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import javafx.animation.Timeline;


/**
 * @author RaffelNicholas
 *
 */
public class SoundCreator {

	protected File blockBreakSound;
	protected File ballBounceSound;
	protected File gamePlaySound;
	protected AudioInputStream audioInStream;
	protected AudioFormat audioForm;
	protected Clip clip;
	protected DataLine.Info DataLineInfo;
	
	SoundCreator()
	{
		
		this.blockBreakSound = new File("pop.wav");
		this.ballBounceSound = new File("ballbounce.wav");
		this.gamePlaySound = new File("gamebackground.wav");
	}
	
	public void playBlockBreakSound()
	{
		System.out.println("pop");
		try
		{
			this.blockBreakSound = new File("pop.wav");
			audioInStream = AudioSystem.getAudioInputStream(blockBreakSound);
			audioForm = audioInStream.getFormat();
			DataLineInfo = new DataLine.Info(Clip.class, audioForm);
			clip = (Clip) AudioSystem.getLine(DataLineInfo);
			clip.open(audioInStream);
			clip.start();
			System.out.println("pop");
		}
		catch(Exception e)
		{
			System.out.println("Couldn't play pop.wav");
		}
		
	}
	
	public void playBallBounceSound()
	{
		try
		{
			audioInStream = AudioSystem.getAudioInputStream(ballBounceSound);
			audioForm = audioInStream.getFormat();
			DataLineInfo = new DataLine.Info(Clip.class, audioForm);
			clip = (Clip) AudioSystem.getLine(DataLineInfo);
			clip.open(audioInStream);
			clip.start();
		}
		catch(Exception e)
		{
			System.out.println("Couldn't play pop.wav");
		}
	}
	
	public void playGamePlaySound()
	{
		try
		{
			audioInStream = AudioSystem.getAudioInputStream(gamePlaySound);
			audioForm = audioInStream.getFormat();
			DataLineInfo = new DataLine.Info(Clip.class, audioForm);
			clip = (Clip) AudioSystem.getLine(DataLineInfo);
			clip.open(audioInStream);
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f);
			
			clip.start();
			clip.loop(Timeline.INDEFINITE);
		}
		catch(Exception e)
		{
			System.out.println("Couldn't play pop.wav");
		}
	}
	
}
