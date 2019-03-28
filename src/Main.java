/***
 * Main class for data parsers
 * @author: Varun Srivastava
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class Main {

    private static String[][] compliledData = new String[51][4];
    private static int counter = 0;

    public static void main(String[] args) {

            String eduData = Utils.readFileAsString("data/Education.csv");
            String trumpData = Utils.readFileAsString("data/2016voterdata.csv");
            String fundingData = Utils.readFileAsString("data/stateFundingByPupil.csv");
            String abrvData = Utils.readFileAsString("data/stateAbrvs.csv");

            HashMap<String, String> stateEducation = Utils.parseCSV(eduData, 4, 2, 44,47);
            HashMap<String, String> stateTrump = Utils.parseCSV(trumpData,0,0,6,25);
            HashMap<String, String> stateFunding = Utils.parseCSV(fundingData, 0, 0,1,1);
            HashMap<String, String> stateAbrv = Utils.parseCSV(abrvData,0,0,1,1);

        for (String name : stateAbrv.keySet()) {
            String abrv = stateAbrv.get(name);
            compliledData[counter][0] = name;

            String edu = stateEducation.get(name);
            String eduPercent = clean(edu);
            compliledData[counter][1] = eduPercent;

            compliledData[counter][2] = stateTrump.get(name);

            String funding = stateFunding.get(name);
            String fundingName = cleanUp(funding);
            compliledData[counter][3] = fundingName;
            counter++;
        }

        Arrays.sort(compliledData, Comparator.comparingDouble(a-> Double.parseDouble(cleanUp(a[3],3))));

        for (int i = 0; i < compliledData.length; i++) {
            for (int j = 0; j < compliledData[0].length; j++) {
                System.out.print(compliledData[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    private static void sort(String[][] arr) {
        double prevVal = 0;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i][2];
            str = cleanUp(str,2);
            double val = Double.parseDouble(str);


        }

    }

    private static String clean(String edu) {
        String out = String.valueOf(100 - Double.parseDouble(edu));
        return out + "%";
    }


    private static String cleanUp(String str) {
        str = str.replaceAll(" ","");
        return str;
    }

    private static String cleanUp(String str, int a) {
        str = str.replaceAll(" ","");
        str  = str.replaceAll("\\$","");
        str = str.replaceAll("\"","");
        str = str.replaceAll(",","");
        return str;
    }

}
