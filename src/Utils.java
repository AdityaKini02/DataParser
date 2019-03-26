import javax.xml.crypto.Data;
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

    private static String normalizeLineBreaks(String s) {
        s= s.replace('\u00A0',' '); // remove non-breaking whitespace characters
        s= s.replace('\u2007',' ');
        s= s.replace('\u202F',' ');
        s= s.replace('\uFEFF',' ');

        return s.replace("\r\n", "\n").replace('\r', '\n');
    }

    public static void  parse2016ElectionResults(String data) {

        //ArrayList<ElectionResult>

        ArrayList<ElectionResult> electionResults = new ArrayList<>();
        String d = (readFileAsString(data));
        String[] lines = d.split("\n");

//        for (int i = 0; i < lines.length; i++) {
//            String line = lines[i];
//            int startIndex = line.indexOf(",") + 1;
//
//            line = line.substring(startIndex);
//
//            int indexOfFirstQuotation = line.indexOf("\"");
//            int indexOfLastQuotation = line.lastIndexOf("\"");
//            String[] info = null;
//
//            for (int j = 0; j < line.length(); j++) {
//                line = removeCharacter(line, "%");
//                line = removeCharacter(line, "," , indexOfFirstQuotation,indexOfLastQuotation);
//                line = removeCharacter(line, "\"");
//                info = line.split(",");
//
//            }
//
//            double  votes_dem = Double.parseDouble(info[0]);
//            double votes_gop = Double.parseDouble(info[1]);
//            double total_votes = Double.parseDouble(info[2]);
//            double per_dem = Double.parseDouble(info[3]);
//            double per_gop = Double.parseDouble(info[4]);
//            int diff = Integer.parseInt(info[5]);
//            double per_point_diff = Double.parseDouble(info[6]);
//            String state_abbr = info[7];
//            String county_name = info[8];
//            int combined_fips = Integer.parseInt(info[9]);
//
//            ElectionResult e = new ElectionResult(votes_dem,votes_gop,total_votes,per_dem,per_gop,diff,per_point_diff,state_abbr,county_name,combined_fips);
//            electionResults.add(e);
//
//
//        }
//
//        return electionResults;

    }



    public static ArrayList<Employment2016> parse2016EmploymentResults(String data){
        ArrayList<Employment2016> employment2016 = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        for (int i = 0; i < lines.length; i++) {
            String current = lines[i];
            current = removeQuotations(current);
            String[] arr = current.split(",");

            String name = arr[2];
            String countyName = arr[3];
            int unemployedPopulation = Integer.parseInt(arr[45]);

        }
        return employment2016;
    }

    public static ArrayList<Education2016> parse2016Education(String data){
        ArrayList<Education2016> education2016 = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        for (int i = 0; i < lines.length; i++) {
            String current = lines[i];
            current = removeQuotations(current);
            String[] arr = current.split(",");

            String name = arr[2];
            String countyName = arr[3];
            int onlyHighSchool = Integer.parseInt(arr[49]);



        }

        return education2016;
    }

    public static ArrayList<County> parseCountyData(String data){
        ArrayList<County> county = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        return county;
    }

    public static ArrayList<DataManager> parseDataManager(String data){
        ArrayList<DataManager> dataManager = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        return dataManager;
    }

    public static ArrayList<Election2016> parse2016Election(String data){
        ArrayList<Election2016> election2016 = new ArrayList<>();
        String[] lines = readFileAsString(data).split("\n");

        return election2016;
    }


    // HELPER METHODS

    public static String removeCharacter(String line, String s){
        String newString = "";

        for (int i = 0; i < line.length(); i++) {
            if (! (line.substring(i, i + 1).equals(s)) ){
                newString += line.substring(i, i + 1);
            }
        }

        return newString;
    }

    public static String removeQuotations(String line){
        int indexOfFirstQuotation = line.indexOf("\"");

        while(indexOfFirstQuotation != line.lastIndexOf("\"") && indexOfFirstQuotation >= 0) {
            int indexOfNextQuotation = line.indexOf("\"", indexOfFirstQuotation + 1);
            String s = line.substring(indexOfFirstQuotation + 1, indexOfNextQuotation);
            String target = s;
            s = removeCharacter(s, ",");
            line = line.replace(target, s);

            indexOfFirstQuotation = line.indexOf("\"", indexOfNextQuotation + 1);
        }

        line = removeCharacter(line, "\"");
        return line;
    }

}
