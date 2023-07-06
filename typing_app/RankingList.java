package typing_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import typing_app.utility.ConvertListType;
import typing_app.utility.StandardCsvOperator;

public class RankingList {
    private List<Ranking> rankingList;

    /**
     * constructor
     */
    public RankingList() {
        rankingList = new ArrayList<Ranking>();
     }

    /**
     * rankingList setter
     * @param rankingList list of ranking
     */
    public void setRankingList(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    /**
     * rankingList getter
     * @return ranking list
     */
    public List<Ranking> getRankingList() {
        return this.rankingList;
    }

    /**
     * Create ranking list
     */
    public void createRankingList(String fileName) {
        var readingRankingListStr = StandardCsvOperator.convertRankingCsvToList(fileName);
        var rankingListCount = readingRankingListStr.size();
        final int MAX_RANKING_LIST_COUNT = 10;

        if (rankingListCount == MAX_RANKING_LIST_COUNT) {
            var rankingIndexListStr = new ArrayList<String>();
            var rankingScoreListStr = new ArrayList<String>();
            var rankingGameModeListStr = new ArrayList<String>();

            for (var readingRankingStr : readingRankingListStr) {
                rankingIndexListStr.add(readingRankingStr[0]);
                rankingScoreListStr.add(readingRankingStr[1]);
                rankingGameModeListStr.add(readingRankingStr[2]);
            }

            List<Integer> rankingIndexList = ConvertListType.convertStringListToIntegerList(rankingIndexListStr);
            List<Long> rankingScoreList = ConvertListType.convertStringListToLongList(rankingScoreListStr);
            List<GameMode> rankingGameModeList = ConvertListType.convertStringListToGameModeList(rankingGameModeListStr);
            
            for (int i = 0; i < MAX_RANKING_LIST_COUNT; i++) {
                var ranking = new Ranking(rankingScoreList.get(i), rankingGameModeList.get(i));
                ranking.setIndex(rankingIndexList.get(i));
                this.rankingList.add(ranking);
            }
        } else {
            var defaultRankingIndexList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
            var defaultRankingScoreList = new ArrayList<Long>(Collections.nCopies(10, 999_999_999_999_999L));
            var defaultRankingGameModeList = new ArrayList<GameMode>(Collections.nCopies(10, GameMode.NORMAL));

            for (int i = 0; i < MAX_RANKING_LIST_COUNT; i++) {
                var ranking = new Ranking(defaultRankingScoreList.get(i), defaultRankingGameModeList.get(i));
                ranking.setIndex(defaultRankingIndexList.get(i));

                this.rankingList.add(ranking);
            }
        }
    }

    /**
     * Get ranking index after ranking update
     * @param ranking Newer ranking information
     * @return New ranking index
     */
    public int getNewRankingIndex(Ranking ranking) {
        int fluctuatingIndex = -1;
        for (var oldRanking : rankingList) {
            if (ranking.getScore() < oldRanking.getScore()) {
                fluctuatingIndex = oldRanking.getIndex() - 1;
            }
        }

        return fluctuatingIndex;
    }
    
    /**
     * update ranking list
     * @param ranking ranking information for comparison
     */
    public void updateRankingList(Ranking ranking) {
        int fluctuatingIndex = -1;
        for (var oldRanking : rankingList) {
            if (ranking.getScore() < oldRanking.getScore()) {
                fluctuatingIndex = oldRanking.getIndex() - 1;
                break;
            }
        }

        if (fluctuatingIndex != -1) {
            this.rankingList.add(fluctuatingIndex, ranking);
            this.rankingList.remove(rankingList.size() - 1);
        }

        for (int i = 0; i < rankingList.size(); i++) {
            rankingList.get(i).setIndex(i + 1);
        }
    }

    /**
     * print ranking list
     */
    public void printRankingList() {
        System.out.println(String.format("%4s  %15s %8s", "Rank", "Score", "GameMode"));
        System.out.println("------------------------------");
        for (var ranking : this.rankingList) {
            System.out.println(String.format("%4d: %15d %8s", ranking.getIndex(), ranking.getScore(), "[" + ranking.getGameMode().name() + "]"));
        }
    }

    /**
     * Convert RankingList to String array(index, score, GameMode) list
     * @return List<String[]>
     */
    public List<String[]> convertStringArrayList() {
        List<String[]> stringArrayList = new ArrayList<String[]>();

        for (var ranking : this.rankingList) {
            String[] stringArray = {Integer.toString(ranking.getIndex()), Long.toString(ranking.getScore()), ranking.getGameMode().name()};

            stringArrayList.add(stringArray);
        }

        return stringArrayList;
    }
}
