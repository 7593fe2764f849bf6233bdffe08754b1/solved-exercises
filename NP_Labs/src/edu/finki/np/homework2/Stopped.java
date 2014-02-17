package edu.finki.np.homework2;

import java.util.Set;

public class Stopped implements State {

	private MP3Player mp3Player;
	
	public Stopped(MP3Player mp3){
		mp3Player = mp3;
	}
	
	@Override
	public void pressPlay() {
		System.out.println("Song " + mp3Player.getCurrentSong() + " is playing");
		//System.out.println(mp3Player.getSongs().get(mp3Player.getCurrentSong()).toString());
		mp3Player.getIsPaused().put(mp3Player.getSongs().get(mp3Player.getCurrentSong()), false);
		mp3Player.setState(mp3Player.getPlayingState());
	}

	@Override
	public void pressStop() {
		System.out.println("Songs are stopped");
		mp3Player.setCurrentSong(0);
		Set<Song> it = mp3Player.getIsPaused().keySet();
		for(Song song: it){
			mp3Player.getIsPaused().put(song, false);
		}
	}

	@Override
	public void pressFWD() {
		System.out.println("Forward...");
		int nextSong = mp3Player.getCurrentSong() + 1;
		if(nextSong == mp3Player.getSongs().size()-1)
			nextSong = 0;
		//int nextSong = mp3Player.getCurrentSong() == (mp3Player.getSongs().size() - 1) ? 0 : mp3Player.getCurrentSong() + 1;
		mp3Player.setCurrentSong(nextSong);
		//mp3Player.setState(mp3Player.getPlayingState());
	}

	@Override
	public void pressREW() {
        System.out.println("Reward...");
		int nextSong = mp3Player.getCurrentSong() - 1;
		if(nextSong == -1)
			nextSong = mp3Player.getSongs().size()-1;
		//int nextSong = mp3Player.getCurrentSong() == (mp3Player.getSongs().size() - 1) ? 0 : mp3Player.getCurrentSong() + 1;
		mp3Player.setCurrentSong(nextSong);
		//mp3Player.setState(mp3Player.getPlayingState());
	}

}
