public class County {
    private String state;
    private String name;
    private int onlyHighSchool;
    private int unemployed;
    private int communityCenters;


//    County defined by the number of people who:
//    - Only graduated High School
//    - Unemployed
//    - Number of community centers


    public County(String state, String name) {
        this.state = state;
        this.name = name;

        onlyHighSchool = 0;
        unemployed = 0;
        communityCenters = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public void setOnlyHighSchool(int onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
    }

    public int getUnemployed() {
        return unemployed;
    }

    public void setUnemployed(int unemployed) {
        this.unemployed = unemployed;
    }

    public int getCommunityCenters() {
        return communityCenters;
    }

    public void incrementCommunityCenter() {
        this.communityCenters++;
    }
}
