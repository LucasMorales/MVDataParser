/***
 * Main class for data parsers
 * @author: Varun Srivastava
 */
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

            // test data reading
            String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
            ArrayList<ElectionResult> results = Utils.parse2016PresidentialResults(data);
            for (ElectionResult result : results) {
                System.out.println(result + "\n");
            }

    }

}
