package typing_app;

import java.util.List;

public class Question {
    private GameMode gameMode;
    private int limit;
    private int questionCount;
    private List<String> questionList;

    /**
     * Constructer
     * @param gameMode game difficulity
     * @param limit limit time
     * @param questionCount number of questions
     * @param questionList list of questions
     */
    public Question(GameMode gameMode, int limit, int questionCount, List<String> questionList) {
        this.gameMode = gameMode;
        this.limit = limit;
        this.questionCount = questionCount;
        this.questionList = questionList;
    }

    /**
     * GameMode setter
     * @param gameMode game mode to set
     */
    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * limit setter
     * @param limit limit time to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * questionCount setter
     * @param questionCount number of questions
     */
    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    /**
     * questionList setter
     * @param questionList list of questions
     */
    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    /**
     * GameMode getter
     * @return game difficulity
     */
    public GameMode getGameMode() {
        return this.gameMode;
    }

    /**
     * limit getter
     * @return limit time
     */
    public int getLimit() {
        return this.limit;
    }

    /**
     * questionCount getter
     * @return number of questions
     */
    public int getQuestionCount() {
        return this.questionCount;
    }

    /**
     * questionList getter
     * @return list of questions
     */
    public List<String> getQuestionList() {
        return this.questionList;
    }
}
