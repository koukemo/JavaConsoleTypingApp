package typing_app;

import typing_app.utility.*;
import java.util.*;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        RankingMenu rankingMenu = new RankingMenu();

        rankingMenu.createRankingMenu();
        
        while (true) {
            mainMenu.displayMode();
            GameMode selectMode = mainMenu.selectGameMode();
            mainMenu.startCountDown(5);

            long startGame = mainMenu.startGame(selectMode);
            
            Ranking ranking = new Ranking(startGame, selectMode);

            int newRankingIndex = rankingMenu.getRankingIndex(ranking);
            ranking.setIndex(newRankingIndex);

            rankingMenu.registerRanking(ranking);

            rankingMenu.displayRankingList();
            rankingMenu.createRankingCsv();
            mainMenu.isContiueGame();
        }
    }

    /**
     * Display the mode selection menu
     */
    public void displayMode() {
        System.out.println("難易度を選択してください(1-3)");
        System.out.println("1: Easy");
        System.out.println("2: Normal");
        System.out.println("3: Hard");
    }

    /**
     * Select GameMode
     * @return Selected gameMode
     */
    public GameMode selectGameMode() {
        int inputNum = StandardInputReader.inputInt("> ");

        switch (inputNum) {
            case 1:
                return GameMode.EASY;
            case 2:
                return GameMode.NORMAL;
            case 3:
                return GameMode.HARD;
            default:
                System.out.println("Normalで開始します");
                return GameMode.NORMAL;
        }
    }

    /**
     * Do a countdown 
     * @param countTime Time of countdown
     */
    public void startCountDown(int countTime) {
        for (int i = 0; i < countTime; i++) {
            System.out.println(String.format("%d..........", 5 - i));
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

    /**
     * Start game
     * @param gameMode Selected GameMode
     * @return Elapsed time at the end of game
     */
    public long startGame(GameMode gameMode) {
        int questionCount = 0;
        List<String> questionList = new ArrayList<String>();

        var easyList = StandardCsvOperator.convertQuestionCsvToList("easy");
        var normalList = StandardCsvOperator.convertQuestionCsvToList("normal");
        var hardList = StandardCsvOperator.convertQuestionCsvToList("hard");

        StopWatch.start();
        System.out.println("Start!");

        switch (gameMode) {
            case EASY:
                questionCount = 5;
                questionList.addAll(easyList);
                break;
            case NORMAL:
                questionCount = 10;
                questionList.addAll(easyList);
                questionList.addAll(normalList);
                break;
            case HARD:
                questionCount = 20;
                questionList.addAll(easyList);
                questionList.addAll(normalList);
                questionList.addAll(hardList);
                break;
            default:
                break;
        }

        for (int i = 0; i < questionCount; i++) {
            int randomIndex = new Random().nextInt(questionList.size());
            String question = questionList.get(randomIndex);

            while (true) {
                String answer = StandardInputReader.inputString(String.format("%s: ", question));

                if (question.equals(answer)) {
                    System.out.println("OK!");
                    break;
                } else {
                    System.out.println("MISS...");
                }
            }
        }

        long endTime = StopWatch.milliTime();
        System.out.println(String.format("Finished. time = %d[ms]", endTime));

        return endTime;
    }

    /**
     * Choose to continue the game
     */
    public void isContiueGame() {
        System.out.println("リトライしますか? (1: する / 2: しない)");
        
        int selectNumber = 0;

        while (true) {
            try {
                selectNumber = StandardInputReader.inputInt("> ");

                switch (selectNumber) {
                    case 1:
                        return;
                    case 2:
                        System.out.println("タイピングアプリを終了します");
                        System.exit(0);
                    default:
                        System.out.println("正しい数値を入力してください");
                        break;
                }
            } catch (Exception e) {
                System.out.println("数値が入力されませんでした");
                System.out.println("再度入力を行ってください");
            }
        }
    }
}
