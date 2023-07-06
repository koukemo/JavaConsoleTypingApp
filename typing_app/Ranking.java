package typing_app;

public class Ranking {
    private int index;
    private long score;
    private GameMode gameMode;

    /**
     * constructor
     * @param score game score
     * @param gameMode game difficulity
     */
    public Ranking(long score, GameMode gameMode) {
        this.index = -1;
        this.score = score;
        this.gameMode = gameMode;
    }

    /**
     * index setter
     * @param index ranking index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * score setter
     * @param score game score
     */
    public void setScore(long score) {
        this.score = score;
    }

    /**
     * GameMode setter
     * @param gameMode game difficulity
     */
    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * index getter
     * @return ranking index
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * score getter
     * @return score
     */
    public long getScore() {
        return this.score;
    }

    /**
     * GameMode getter
     * @return game difficulity
     */
    public GameMode getGameMode() {
        return this.gameMode;
    }
}
