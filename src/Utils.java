import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
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

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> electionResults = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int startIndex = line.indexOf(",") + 1;

            line = line.substring(startIndex);

            int indexOfFirstQuotation = line.indexOf("\"");
            int indexOfLastQuotation = line.lastIndexOf("\"");
            String[] info = null;

            for (int j = 0; j < line.length(); j++) {
                line = removeCharacter(line, "%");
                line = removeCharacter(line, "," , indexOfFirstQuotation,indexOfLastQuotation);
                line = removeCharacter(line, "\"");
                info = line.split(",");

            }

            double  votes_dem = Double.parseDouble(info[0]);
            double votes_gop = Double.parseDouble(info[1]);
            double total_votes = Double.parseDouble(info[2]);
            double per_dem = Double.parseDouble(info[3]);
            double per_gop = Double.parseDouble(info[4]);
            int diff = Integer.parseInt(info[5]);
            double per_point_diff = Double.parseDouble(info[6]);
            String state_abbr = info[7];
            String county_name = info[8];
            int combined_fips = Integer.parseInt(info[9]);

            ElectionResult e = new ElectionResult(votes_dem,votes_gop,total_votes,per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips);
            electionResults.add(e);


        }

        return electionResults;

    }


    private static String removeCharacter(String line, String s){
        String newString = "";
        for (int i = 0; i < line.length(); i++) {
            if (! line.substring(i, i+1).equals(s)){
                newString += line.substring(i, i+1);
            }
        }
        return newString;

    }


    private static String removeCharacter(String line, String s, int startIndex, int endIndex) {
        String newString = "";

        if(line.contains(s)) {
            String val = line.substring(startIndex, endIndex+1);

            for (int i = 0; i < val.length(); i++) {
                if (! val.substring(i, i+1).equals(s)){
                    newString += val.substring(i, i+1);
                }
            }

        }
        return newString;
    }
}
