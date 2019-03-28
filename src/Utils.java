import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static String csvRegx =  ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

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



    public static HashMap<String, String> parseCSV(String csv_data, int firstLine, int firstIndex, int index, int size) {
        String[] lines = csv_data.split(("\n"));

        HashMap<String, String> out = new HashMap<>();

        Pattern csv = Pattern.compile(csvRegx);
        for (int i = firstLine; i < lines.length ; i++) {
            String[] temp = lines[i].split(csvRegx);
            if (temp.length < size)
                out.put("NULL", "NULL");
            else{
                out.put(temp[firstIndex], temp[index]);
            }

        }
        return out;
    }

}
