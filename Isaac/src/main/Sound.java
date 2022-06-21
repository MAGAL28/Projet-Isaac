package main;
//#9
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];

	public Sound() {
		soundURL[0] = getClass().getResource("/sound/the_kraken.wav");
		soundURL[1] = getClass().getResource("/sound/mine_sound.wav");
		soundURL[2] = getClass().getResource("/sound/pick_mine_sound.wav");
		soundURL[3] = getClass().getResource("/sound/shell_to_tank_sound.wav");
		soundURL[4] = getClass().getResource("/sound/tank_shoot_sound.wav");
		soundURL[5] = getClass().getResource("/sound/health_sound.wav");
		soundURL[6] = getClass().getResource("/sound/coin.wav");
		soundURL[7] = getClass().getResource("/sound/fanfare.wav");
		soundURL[8] = getClass().getResource("/sound/unlock.wav");
		soundURL[9] = getClass().getResource("/sound/powerup.wav");
		soundURL[10] = getClass().getResource("/sound/hitmonster.wav");
		soundURL[11] = getClass().getResource("/sound/receivedamage.wav");
		
		
		
	}

	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {

		}
	}

	public void play() {
		clip.start();

	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public void stop() {
		//clip.stop();

	}
}
