import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<Election2016> parseElection2016(String csv_data) {
        String[] lines = csv_data.split(("\n"));
        ArrayList<Election2016> out = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String current = lines[i];
            Election2016 temp = new Election2016();

            String[] commaBreaks = current.split(",");
            temp.setDemVotes(getVotesDem(commaBreaks));
            temp.setGopVotes(getVotesGop(commaBreaks));
            temp.setTotalVotes(getTotalVotes(commaBreaks));

            out.add(temp);
        }
        return out;
    }

    public static ArrayList<Education2016> parseEducation2016(String csv_data)  {

    }

    public static ArrayList<Employment2016> parseEmployment2016(String csv_data) {

    }

//    public static ArrayList<ElectionResult> parse2016PresidentialResults(String csv_data) {
//        String[] lines = csv_data.split("\n");
//        ArrayList<ElectionResult> out = new ArrayList<>();
//
//        for (int i = 1; i < lines.length; i++) {
//            String current = lines[i];
//            ElectionResult temp = new ElectionResult();
//            temp.setDiff(getDiff(current));
//
//            String[] commaBreaks = current.split(",");
//            temp.setVotesDem(getVotesDem(commaBreaks));
//            temp.setVotesGOP(getVotesGop(commaBreaks));
//            temp.setTotalVotes(getTotalVotes(commaBreaks));
//            temp.setPerDem((getPerDem(commaBreaks)));
//            temp.setPerGOP((getPerGop(commaBreaks)));
//            temp.setPerPointDiff((getPerPointDiff(commaBreaks)));
//            temp.setStateAbbr((getStateAbbr(commaBreaks)));
//            temp.setCountyName((getCountyName(commaBreaks)));
//            temp.setCombinedFips((getCombinedFips(commaBreaks)));
//
//            out.add(temp);
//        }
//
//        return out;
//    }

    private static int getCombinedFips(String[] commaBreaks) {
        return Integer.parseInt(commaBreaks[commaBreaks.length - 1]);
    }

    private static String getCountyName(String[] commaBreaks) { return commaBreaks[commaBreaks.length - 2]; }

    private static String getStateAbbr(String[] commaBreaks) { return commaBreaks[commaBreaks.length -3];}

    private static double getPerPointDiff(String[] commaBreaks) {
        String temp = commaBreaks[commaBreaks.length - 4];
        temp = temp.substring(0,temp.length() - 1);
        return Double.parseDouble(temp);
    }

    private static double getPerGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[5]); }

    private static double getPerDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[4]); }

    private static double getTotalVotes(String[] commaBreaks) { return Double.parseDouble(commaBreaks[3]); }

    private static double getVotesGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[2]); }

    private static double getVotesDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[1]); }

    private static int getDiff(String current) {
        String[] temp = current.split("\"");
        String diff = temp[1];
        if (diff.contains(",")) {
            return Integer.parseInt(diff.replace(",", ""));
        } else return Integer.parseInt(diff);
    }
}
