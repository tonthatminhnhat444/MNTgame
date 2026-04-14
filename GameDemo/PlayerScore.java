package GameDemo;

public class PlayerScore {
    private String name;
    private int score;
    private int time_played;     
   

    public PlayerScore(String name, int score, int time_played) {
        this.name = name;
        this.score = score;
        this.time_played = time_played;
        
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public int getTimePlayed() {
    	return time_played; }

    
}
