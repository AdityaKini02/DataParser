import java.util.ArrayList;
import java.util.Arrays;

/***
 * Main class for data parsers
 * @author Aditya Kini
 */

public class Main {

    public static void main(String[] args) {
        String presidentialResults2016 = "data/2016_Presidential_Results.csv";
        String education = "data/Education.csv";
        String unemployment = "data/Unemployment.csv";
        String communityCareCenters = "data/community-care-licensing-adult-residential-facility-locations.csv";

        ArrayList<Education2016> educationData = Utils.parse2016Education(education);
        ArrayList<Employment2016> employmentData = Utils.parse2016EmploymentResults(unemployment);
        ArrayList<CommunityCenter> communityCenterData = Utils.parseCommunityCenterData(communityCareCenters);


        ArrayList<County> counties = new ArrayList<>();




    }
}
