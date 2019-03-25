import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static String csvRegx = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";

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




    public static Matcher[] parseCSV(String csv_data, int firstLine) {
        String[] lines = csv_data.split(("\n"));
        Matcher[] out = new Matcher[lines.length - firstLine]; //may be off by one
        Pattern csv = Pattern.compile(csvRegx);
        for (int i = firstLine; i < lines.length ; i++) {
            Matcher m = csv.matcher(lines[i]);
            out[i - firstLine] = m;
        }
        return out;
    }

    public static String[][] getData(Matcher[] m,  int lineNum, int index){
        
    }



    /*
    public static ArrayList<State> initializeStates(String csv_data) {
        String[] lines = csv_data.split(("\n"));
        ArrayList<State> out = new ArrayList<>();

        for (int i =1 ; i < lines.length ; i++) {
            String current = lines[i];
            State state = new State(stateName(current));

            ArrayList<County> counties = initializeCounties("data/2016_Presidential_Results.csv");
            for (County county : counties ) {
                if (county.getState = state.getName()) state.addCounty(county);
            }
            out.add(current);
        }
        return out;
    }

    public static ArrayList<County> initializeCounties(String csv_data) {
        String[] lines = csv_data.split(("\n"));
        ArrayList<County> out = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String current = lines[i];
            County temp = new County();

            String[] commaBreaks = current.split(",");
            temp.setName(getName(commaBreaks));
            temp.setFips(getFips(commaBreaks));
            temp.setState(getState(commaBreaks));

            ArrayList<Election2016> electionData = parseElection2016("data/2016_Presidential_Results.csv");
            for (Election2016 data : electionData) {
                if (data.getFips() == temp.getFips()) temp.setVote2016(data);
            }
            ArrayList<Education2016> educationData = parseEducation2016("data/Education.csv");
            for (Education2016 data : educationData) {
                if (data.getFips() == temp.getFips()) temp.setEducation2016(data);
            }
            ArrayList<Employment2016> employment2016 = parseEmployment2016("data/Employment.csv");
            for (Employment2016 data : employment2016) {
                if (data.getFips() == temp.getFips()) temp.setEmployment2016(data);
            }

            out.add(temp);
        }
        return out;
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
            temp.setFips(getCombinedFips(commaBreaks));

            out.add(temp);
        }
        return out;
    }

    public static ArrayList<Education2016> parseEducation2016(String csv_data)  {
        String[] lines = csv_data.split(("\n"));
        ArrayList<Education2016> out = new ArrayList<>();

        for (int i = 5; i < lines.length; i++) {
            String current = lines[i];
            Education2016 temp = new Education2016();

            String[] commaBreaks = current.split(",");
            temp.setFips(getEducationFips(commaBreaks));
            temp.setNoHighSchool(getNoHighSchool(commaBreaks));
            temp.setOnlyHighSchool(getOnlyHighSchool(commaBreaks));
            temp.setSomeCollege(getSomeCollege(commaBreaks));
            temp.setBachelorsOrMore(getBachs(commaBreaks));

            out.add(temp);
        }
        return out;
    }


    public static ArrayList<Employment2016> parseEmployment2016(String csv_data) {
        String[] lines = csv_data.split("\n");
        ArrayList<Employment2016> out = new ArrayList<>();

        for (int i = 9; i < lines.length; i++) {
            String current = lines[i];
            Employment2016 temp = new Employment2016();

            String[] commaBreaks = current.split(",");
            temp.setFips();
            temp.setUnemployedPercent();
            temp.setUnemployedLaborForce();
            temp.setEmployedLaborForce();
            temp.setTotalLaborForce();

            out.add(temp);
        }
        return out;
    }



    private static int getEducationFips(String[] commaBreaks) { return Integer.parseInt(commaBreaks[0]); }

    private static double getBachs(String[] commaBreaks) { return Integer.parseInt( commaBreaks[commaBreaks.length -1]); }

    private static double getSomeCollege(String[] commaBreaks) { return Integer.parseInt( commaBreaks[commaBreaks.length - 2]); }

    private static double getOnlyHighSchool(String[] commaBreaks) { return Integer.parseInt( commaBreaks[commaBreaks.length - 3]); }

    private static double getNoHighSchool(String[] commaBreaks) { return Integer.parseInt( commaBreaks[commaBreaks.length -4]); }


    private static int getCombinedFips(String[] commaBreaks) {
        String temp = commaBreaks[commaBreaks.length - 1];
        if (temp.length() == 4 ) return Integer.parseInt("0" + temp);
        return Integer.parseInt(temp);
    }


    private static double getTotalVotes(String[] commaBreaks) { return Double.parseDouble(commaBreaks[3]); }

    private static double getVotesGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[2]); }

    private static double getVotesDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[1]); }

    */

//    private static int getDiff(String current) {
//        String[] temp = current.split("\"");
//        String diff = temp[1];
//        if (diff.contains(",")) {
//            return Integer.parseInt(diff.replace(",", ""));
//        } else return Integer.parseInt(diff);
//    }

//        public static ArrayList<ElectionResult> parse2016PresidentialResults(String csv_data) {
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


//
//    private static String getCountyName(String[] commaBreaks) { return commaBreaks[commaBreaks.length - 2]; }
//
//    private static String getStateAbbr(String[] commaBreaks) { return commaBreaks[commaBreaks.length -3];}
//
//    private static double getPerPointDiff(String[] commaBreaks) {
//        String temp = commaBreaks[commaBreaks.length - 4];
//        temp = temp.substring(0,temp.length() - 1);
//        return Double.parseDouble(temp);
//    }
//
//    private static double getPerGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[5]); }
//
//    private static double getPerDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[4]); }
}
