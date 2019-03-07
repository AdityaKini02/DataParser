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

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> electionResults = new ArrayList<>();

        //loop over data, make each row into it's own index in an arrayList
        //take out each row seperatly
        //remove the commas, and create a new Election Result object
        //store it into electionResults

        //String d = normalizeLineBreaks(readFileAsString(data));

        String[] lines = readFileAsString(data).split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].substring(2);

            int startIndex = line.indexOf("\"");
            int endIndex = line.indexOf("\"", startIndex  + 1);

            removeCharacter(line, "," , startIndex, endIndex);




            String[] info = line.split(",");
            double  votes_dem = Double.parseDouble(info[0]);
            double votes_gop = Double.parseDouble(info[1]);
            double total_votes = Double.parseDouble(info[2]);
            double per_dem = Double.parseDouble(info[3]);
            double per_gop = Double.parseDouble(info[4]);
            int diff = Integer.parseInt(info[5]);
            double per_point_diff = Double.parseDouble(info[6]);
            String state_abbr = info[7];
            String county_name = info[8];
            int combined_fips = Integer.parseInt(info[10]);

            ElectionResult e = new ElectionResult(votes_dem,votes_gop,total_votes,per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips);
            electionResults.add(e);

        }
        return electionResults;
    }



    private static String removeCharacter(String line, String s, int startIndex, int endIndex) {
        String newString = "";
        if(line.contains(s)) {
            String val = line.substring(startIndex + 1, endIndex);

            for (int i = 0; i < val.length() - 1; i++) {
                if (! val.substring(i, i+1).equals(s)){
                    newString += val.substring(i, i+1);
                }
            }

        }
        return newString;
    }


}
