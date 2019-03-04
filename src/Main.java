import java.util.ArrayList;

/***
 * Main class for data parsers
 * @author Aditya Kini
 */

public class Main {

    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);

        ArrayList<ElectionResult> results = Utils.parse2016ElectionResults(data);


    }
}
