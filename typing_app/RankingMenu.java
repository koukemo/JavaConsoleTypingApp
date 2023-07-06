package typing_app;

import typing_app.utility.*;
import java.util.List;

public class RankingMenu {
    public RankingList rankingList = new RankingList();

    /**
     * Get ranking index
     * @param ranking Ranking information
     * @return Ranking index
     */
    public int getRankingIndex(Ranking ranking) {
        return this.rankingList.getNewRankingIndex(ranking);
    }

    /**
     * Register for ranking
     * @param ranking Ranking information to be registered
     */
    public void registerRanking(Ranking ranking) {
        this.rankingList.updateRankingList(ranking);
    }

    /**
     * Display ranking list
     */
    public void displayRankingList() {
        this.rankingList.printRankingList();
    }

    /**
     * Creating a ranking list from a CSV file
     * @return Ranking list
     */
    public RankingList createRankingMenu() {
        final String fileName = "ranking";
        this.rankingList.createRankingList(fileName);

        return this.rankingList;
    }

    /**
     * Create ranking CSV file
     * @return true : When CSV succeeds, false : When CSV fails
     */
    public boolean createRankingCsv() {
        final String fileName = "ranking";

        List<String[]> rankingStringArrayList = this.rankingList.convertStringArrayList();

        boolean isCreated = StandardCsvOperator.convertRankingListToCsv(
            rankingStringArrayList, 
            fileName
        );
        
        return isCreated;
    }
}
