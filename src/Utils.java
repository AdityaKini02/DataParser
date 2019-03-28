import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {


    //Parse Employment Data
    public static ArrayList<Employment2016> parse2016EmploymentResults(String filepath){
        ArrayList<Employment2016> employment2016 = new ArrayList<>();

        String[] lines = readFileAsString(filepath).split("\n");
        ArrayList<String[]> parsedLines = parseLinesIntoArrays(lines, 9);

        // populate employment2016
        for (int i = 0; i < parsedLines.size(); i++) {
            String[] arr = parsedLines.get(i);
            if(arr.length >= 44){
                String state = arr[1].trim();
                String county = arr[2];
                county = fixCountyName(county);
                int unemployedPopulation = Integer.parseInt(arr[44].trim());
                employment2016.add(new Employment2016(state, county, unemployedPopulation));
            }
        }

        return employment2016;
    }


    //Parse Education Data
    public static ArrayList<Education2016> parse2016Education(String filepath){
        ArrayList<Education2016> education2016 = new ArrayList<>();


        String[] lines = readFileAsString(filepath).split("\n");
        ArrayList<String[]> parsedLines = parseLinesIntoArrays(lines, 6);

        //populate education2016
        for (int i = 0; i < parsedLines.size(); i++) {
            String[] arr = parsedLines.get(i);
            if(arr.length >= 40){
                String state = arr[1].trim();
                String county = arr[2];
                county = fixCountyName(county);
                int onlyHighschool = (int)Double.parseDouble(arr[40].trim());
                education2016.add(new Education2016(state, county, onlyHighschool));
            }

        }

        return education2016;
    }


    //Parse CommunityCenterData
    public static ArrayList<CommunityCenter> parseCommunityCenterData(String filepath){
        ArrayList<CommunityCenter> CommunityCenterData = new ArrayList<>();

        String[] lines = readFileAsString(filepath).split("\n");
        ArrayList<String[]> parsedLines = parseLinesIntoArrays(lines, 2);

        //populate CommunityCenterData
        for (int i = 0; i < parsedLines.size(); i++) {
            String[] arr = parsedLines.get(i);
            if(arr.length >= 13){
                String state = arr[8].trim();
                String county = arr[10];
                county = fixCommunityCareName(county);
                String status = arr[13];
                if (status.equals("LICENSED")) {
                    CommunityCenterData.add(new CommunityCenter(state, county));
                }
            }

        }

        return CommunityCenterData;
    }

    public static void createCSV(String filename, DataManager dataManager){

        try {
            FileWriter writer = new FileWriter(filename);
            //Write header
            writer.append("State");
            writer.append(",County");
            writer.append(",People who graduated High School");
            writer.append(",Unemployed Labor Force");
            writer.append(",Number of Community Care Centers");
            writer.append("\n");

            //Write data
            ArrayList<County> stateData = dataManager.getStateData();
            for (int i = 0; i < stateData.size(); i++) {
                County c = stateData.get(i);

                writer.append(dataManager.getState());
                writer.append("," + c.getName());
                writer.append("," + c.getOnlyHighSchool());
                writer.append("," + c.getUnemployed());
                writer.append("," + c.getCommunityCenters());
                writer.append("\n");

            }

            writer.flush();
            writer.close();

        }
        catch(IOException e) {
            System.out.println("Exception while creating file");
        }


    }



    // HELPER METHODS FOR PARSING AND RE-FORMATTING

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

    public static ArrayList<String[]> parseLinesIntoArrays(String[] lines, int startIndex){
        ArrayList<String[]> parsedLines = new ArrayList<>();

        for (int i = startIndex; i < lines.length; i++) {
            String current = lines[i];
            current = removeQuotations(current);
            String[] arr = current.split(",");
            if (arr.length > 0) {
                parsedLines.add(arr);
            }
        }

        return parsedLines;
    }


    public static String fixCountyName(String s){
        if (s.contains("County")) {
            s = removePhrase(s, "County");
        } else if(s.contains("Muncipio")){
            s = removePhrase(s, "Municipio");
        }
        return s;
    }

    public static String fixCommunityCareName(String s){
        return s.toLowerCase();
    }

    public static String removePhrase(String s, String phrase){
        int index = s.indexOf(phrase);
        String substring = s.substring(index);
        s = s.replace(substring, "");
        s = s.trim();
        s = s.toLowerCase();
        return s;
    }

}
