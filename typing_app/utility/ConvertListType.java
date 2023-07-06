package typing_app.utility;

import typing_app.GameMode;
import java.util.List;
import java.util.ArrayList;

public class ConvertListType {
    /**
     * Convert Integer list to String list 
     * @param integerList Base Long list
     * @return String list
     */
     public static List<String> convertIntegerListToStringList(List<Integer> integerList) {
        List<String> stringList = new ArrayList<String>();

        for (Integer integerNum : integerList) {
            stringList.add(integerNum.toString());
        }

        return stringList;
    }

    /**
     * Convert String list to Integer list
     * @param stringList Base String list
     * @return Integer list
     */
    public static List<Integer> convertStringListToIntegerList(List<String> stringList) {
        List<Integer> integerList = new ArrayList<Integer>();

        for (String str : stringList) {
            integerList.add(Integer.parseInt(str));
        }

        return integerList;
    }

    /**
     * Convert Long list to String list 
     * @param longList Base Long list
     * @return String list
     */
     public static List<String> convertLongListToStringList(List<Long> longList) {
        List<String> stringList = new ArrayList<String>();

        for (Long longNum : longList) {
            stringList.add(longNum.toString());
        }

        return stringList;
    }

    /**
     * Convert String list to Long list
     * @param stringList Base String list
     * @return Long list
     */
    public static List<Long> convertStringListToLongList(List<String> stringList) {
        List<Long> longList = new ArrayList<Long>();

        for (String str : stringList) {
            longList.add(Long.parseLong(str));
        }

        return longList;
    }

    /**
     * Convert GameMode list to String list
     * @param gameModeList Base GameMode list
     * @return String list
     */
    public static List<String> convertGameModeListToStringList(List<GameMode> gameModeList) {
        List<String> stringList = new ArrayList<String>();

        for (GameMode gameMode : gameModeList) {
            switch (gameMode) {
                case EASY:
                    stringList.add("EASY");
                    break;
                case NORMAL:
                    stringList.add("NORMAL");
                    break;
                case HARD:
                    stringList.add("HARD");
                    break;
                default:
                    break;
            }
        }

        return stringList;
    }

    /**
     * Convert String list to GameMode list
     * @param stringList Base String list
     * @return GameMode list
     */
    public static List<GameMode> convertStringListToGameModeList(List<String> stringList) {
        List<GameMode> gameModeList = new ArrayList<GameMode>();

        for (String str : stringList) {
            switch (str) {
                case "EASY":
                    gameModeList.add(GameMode.EASY);
                    break;
                case "NORMAL":
                    gameModeList.add(GameMode.NORMAL);
                    break;
                case "HARD":
                    gameModeList.add(GameMode.HARD);
                    break;
                default:
                    break;
            }
        }

        return gameModeList;
    }
}
