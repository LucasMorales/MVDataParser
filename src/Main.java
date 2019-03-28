/***
 * Main class for data parsers
 * @author: Varun Srivastava
 */
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
            compliledData[counter][1] = stateEducation.get(name);
            compliledData[counter][2] = stateTrump.get(name);
            String funding = stateFunding.get(name);
            String fundingName = cleanUp(funding);
            compliledData[counter][3] = fundingName;
            counter++;
        }


//        for (int i = 0; i < compliledData.length; i++) {
//            for (int j = 0; j < compliledData[0].length; j++) {
//                System.out.print(compliledData[i][j]);
//                System.out.print(", ");
//            }
//            System.out.println();
//        }
    }

    private static String cleanUp(String str) {
        str = str.replaceAll(" ","");
        str  = str.replaceAll("\\$","");
        str = str.replaceAll("\"","");
        return str;
    }

}
