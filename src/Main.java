import javax.swing.*;
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


        //Parse CSV File Data
        ArrayList<Education2016> educationData = Utils.parse2016Education(education);
        ArrayList<Employment2016> employmentData = Utils.parse2016EmploymentResults(unemployment);
        ArrayList<CommunityCenter> communityCenterData = Utils.parseCommunityCenterData(communityCareCenters);


        //Prompt User
        String state = JOptionPane.showInputDialog("Input State Abbreviation");
        DataManager dataManager = new DataManager(state);
        

        //Set educationData
        for (int i = 0; i < educationData.size(); i++) {
            Education2016 countyEducation = educationData.get(i);
            if (countyEducation.getState().equals(state)) {
                String countyName = countyEducation.getCounty();

                dataManager.createCounty(countyName);
                dataManager.setOnlyHighSchool(countyName, countyEducation.getOnlyHighSchool());


            }

        }


        //Set employment Data
        for (int i = 0; i < employmentData.size(); i++) {
            Employment2016 countyEmployment = employmentData.get(i);
            if(countyEmployment.getState().equals(state)){
                String countyName = countyEmployment.getCounty();

                dataManager.createCounty(countyName);
                dataManager.setUnemployed(countyName, countyEmployment.getUnemployedLaborForce());
            }
        }


        //
        for (int i = 0; i < communityCenterData.size(); i++) {
            CommunityCenter countyCommunityCenter = communityCenterData.get(i);
            if(countyCommunityCenter.getState().equals(state)){
                String countyName = countyCommunityCenter.getCounty();

                dataManager.createCounty(countyName);
                dataManager.incrementCommunityCenter(countyName);
            }

        }

        //Write Data to File
        Utils.createCSV("/Users/adityakini/IdeaProjects/DataParser/data/output", dataManager);




    }
}
