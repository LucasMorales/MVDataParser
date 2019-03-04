import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {



    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }


    /***
     *   private double votesDem, votesGOP, totalVotes, perDem, perGOP;
     *     private int !diff;
     *     private double perPointDiff;
     *     private String stateAbbr, countyName;
     *     private int combinedFips;
     */


    public static ArrayList<ElectionResult> parse2016PresidentialResults(String csv_data) {
        String[] lines = csv_data.split("\n");
        ArrayList<ElectionResult> out = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String current = lines[i];
            ElectionResult temp = new ElectionResult();


        }

        return out;
    }

    private static int getDiff(String current) {
        String[] temp = current.split("\"");
        String diff = temp[1];
        if ( diff.indexOf(",") != -1 ) {
            int out = Integer.parseInt(diff.replace(",", ""));
            return out;
        } else return Integer.parseInt(diff);
    }
}
