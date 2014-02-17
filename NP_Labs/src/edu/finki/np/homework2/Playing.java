package edu.finki.np.homework2;

public class Playing implements State {

	private MP3Player mp3Player;
	
	public Playing(MP3Player mp3){
		mp3Player = mp3;
	}
	
	@Override
	public void pressPlay() {
		if(mp3Player.getIsPaused().get(mp3Player.getSongs().get(mp3Player.getCurrentSong())))
			System.out.println("Song " + mp3Player.getCurrentSong() + " is playing");
		else
			System.out.println("Song is already playing");
	}

	@Override
	public void pressStop() {
		mp3Player.getIsPaused().put(mp3Player.getSongs().get(mp3Player.getCurrentSong()), true);
		System.out.println("Song " + mp3Player.getCurrentSong() + " is paused");
		//System.out.println(mp3Player.getSongs().get(mp3Player.getCurrentSong()).toString());
		mp3Player.setState(mp3Player.getStoppedState());
	}

	@Override
	public void pressFWD() {
		System.out.println("Forward...");
		mp3Player.getIsPaused().put(mp3Player.getSongs().get(mp3Player.getCurrentSong()), true);
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
		mp3Player.getIsPaused().put(mp3Player.getSongs().get(mp3Player.getCurrentSong()), true);
		int nextSong = mp3Player.getCurrentSong() - 1;
		if(nextSong == -1)
			nextSong = mp3Player.getSongs().size()-1;
		//int nextSong = mp3Player.getCurrentSong() == (mp3Player.getSongs().size() - 1) ? 0 : mp3Player.getCurrentSong() + 1;
		mp3Player.setCurrentSong(nextSong);
		//mp3Player.setState(mp3Player.getPlayingState());
	}

}
