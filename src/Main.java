import java.util.ArrayList;

/***
 * Main class for data parsers
 * @author Aditya Kini
 */

public class Main {

    public static void main(String[] args) {
        String presidentialResults2016 = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String education = Utils.readFileAsString("data/Education.csv");
        String unemployment = Utils.readFileAsString("data/Unemployment.csv");

        //System.out.println(data);
        Utils.parse2016EmploymentResults(unemployment);

        //DataManager datamanager = new DataManager(Utils.parseStateData(presidentialResults2016));



    }
}
