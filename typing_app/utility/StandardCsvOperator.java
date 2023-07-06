package typing_app.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StandardCsvOperator {
    /**
     * Convert CSV data to String list
     * @param csvFileName CSV file name
     * @return String type list
     */
    public static List<String> convertQuestionCsvToList(String csvFileName) {
        var currentDir = Paths.get("").toAbsolutePath();
        var resourcesDir = Paths.get("typing_app/resources");
        var targetFileDir = currentDir.resolve(resourcesDir);
        Path targetFilePath = targetFileDir.resolve(Paths.get(csvFileName + ".csv"));

        List<String> results = new ArrayList<String>();

        try {
            results = Files.readAllLines(targetFilePath, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * Convert ranking CSV data to String[] list
     * @param csvFileName CSV file name
     * @return String[] type list
     */
    public static List<String[]> convertRankingCsvToList(String csvFileName) {
        var currentDir = Paths.get("").toAbsolutePath();
        var resourcesDir = Paths.get("typing_app/resources");
        var targetFileDir = currentDir.resolve(resourcesDir);
        Path targetFilePath = targetFileDir.resolve(Paths.get(csvFileName + ".csv"));

        List<String[]> results = new ArrayList<String[]>();
        List<String> csvLists = new ArrayList<String>();

        try {
            csvLists = Files.readAllLines(targetFilePath, Charset.forName("UTF-8"));
            
            for (var rows : csvLists) {
                results.add(rows.split(","));
            }
        } catch(IOException e) {
            e.getStackTrace();
        }

        return results;
    }

    /**
     * Convert String[] list to CSV
     * @param list Base String[] list
     * @param csvFileName Creating CSV name (ex. test.csv -> test)
     * @return true : When CSV succeeds, false : When CSV fails
     */
    public static boolean convertRankingListToCsv(List<String[]> list, String csvFileName) {
        var currentDir = Paths.get("").toAbsolutePath();
        var resourcesDir = Paths.get("typing_app/resources");
        var targetFileDir = currentDir.resolve(resourcesDir);
        Path targetFilePath = targetFileDir.resolve(Paths.get(csvFileName + ".csv"));
        
        try {
            FileWriter csvWriter = new FileWriter(targetFilePath.toString());

            for (int i = 0; i < list.size(); i++) {
                var lineList = Arrays.asList(list.get(i)[0], list.get(i)[1], list.get(i)[2]);
                csvWriter.append(String.join(",", lineList));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            
            return false;
        }
    }
}
