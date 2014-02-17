package edu.finki.np.homework2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MP3Player implements State {

	private Playing playingState;
	private Stopped stoppedState;
	private State currentState;
	
	private List<Song> songs;
	private int currentSong;
	private Map<Song, Boolean> isPaused;
	
	private MP3Player(List<Song> s){
		songs = s;
		currentSong = 0;
		playingState = new Playing(this);
		stoppedState = new Stopped(this);
		currentState = stoppedState;
		isPaused = new HashMap<>();
		for(Song song: songs){
			isPaused.put(song, false);
		}
	}
	
	public void printCurrentSong(){
		System.out.println(songs.get(currentSong).toString());
	}
	
	@Override
	public void pressPlay() {
		currentState.pressPlay();
	}

	@Override
	public void pressStop() {
		currentState.pressStop();
	}

	@Override
	public void pressFWD() {
		currentState.pressFWD();
	}

	@Override
	public void pressREW() {
		currentState.pressREW();
	}
	
	public List<Song> getSongs(){
		return songs;
	}
	
	public void setCurrentSong(int num){
		currentSong = num;
	}
	public int getCurrentSong(){
		return currentSong;
	}
	
	public void setState(State s){
		currentState = s;
	}
	
	public State getState(){
		return currentState;
	}

	public Map<Song, Boolean> getIsPaused() {
		return isPaused;
	}

	public void setIsPaused(Map<Song, Boolean> isPaused) {
		this.isPaused = isPaused;
	}

	public Playing getPlayingState() {
		return playingState;
	}

	public Stopped getStoppedState() {
		return stoppedState;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append("{currentSong = "+currentSong);
		sb.append(", songList = " + songs.toString());
		sb.append("}");
		return sb.toString();
	}
	
}
