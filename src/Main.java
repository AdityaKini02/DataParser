import java.util.ArrayList;
import java.util.Arrays;

/***
 * Main class for data parsers
 * @author Aditya Kini
 */

public class Main {

    public static void main(String[] args) {
        String presidentialResults2016 = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String education = Utils.readFileAsString("data/Education.csv");
        String unemployment = Utils.readFileAsString("data/Unemployment.csv");

        ArrayList<Education2016> educationData = Utils.parse2016Education("data/Education.csv");
        ArrayList<Employment2016> employmentData = Utils.parse2016EmploymentResults("data/Unemployment.csv");



    }
}
