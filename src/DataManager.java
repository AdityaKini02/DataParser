import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private String state;
    private ArrayList<County> stateData;

    public DataManager(String state){
        this.state = state;
        stateData = new ArrayList<>();
    }

    public ArrayList<County> getStateData(){
        return stateData;
    }

    public String getState(){
        return state;
    }



    public void setUnemployed(String countyname, int unemployed) {
        if(exists(countyname)){
           int index = findIndexOfCounty(countyname);
           stateData.get(index).setUnemployed(unemployed);
        }
    }



    public void setOnlyHighSchool(String countyName, int onlyHighSchool) {
        if(exists(countyName)){
            int index = findIndexOfCounty(countyName);
            stateData.get(index).setOnlyHighSchool(onlyHighSchool);
        }
    }

    public void incrementCommunityCenter(String countyName){
        if(exists(countyName)){
            int index = findIndexOfCounty(countyName);
            stateData.get(index).incrementCommunityCenter();
        }

    }

    public boolean exists(String county) {
        boolean exists = false;
        for (int i = 0; i < stateData.size(); i++) {
            County c = stateData.get(i);
            if(county.equals(c.getName())){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public void createCounty(String county) {
        if(! exists(county)) {
            County c = new County(state, county);
            stateData.add(c);
        }
    }

    private int findIndexOfCounty(String countyName) {
        for (int i = 0; i < stateData.size(); i++) {
            if (stateData.get(i).getName().equals(countyName)){
                return i;
            }
        }
        return -1;
    }
}
