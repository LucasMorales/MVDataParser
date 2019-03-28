/***
 * Main class for data parsers
 * @author: Varun Srivastava
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

            String eduData = Utils.readFileAsString("data/Education.csv");
            String trumpData = Utils.readFileAsString("data/2016_Presidential_Results.csv");
            String fundingData = Utils.readFileAsString("stateFundingByPupil.csv");

            HashMap<String, Double> stateEducation = Utils.parseCSV(eduData, 6, 1, 43);
            HashMap<String, Double> stateTrump = Utils.parseCSV(trumpData,1,8,2);
            HashMap<String, Double> stateFunding = Utils.parseCSV(fundingData, 0, 0,1);


    }

}
