public class Education2016 {

    private String state;
    private String county;
    private int onlyHighSchool;

    public Education2016(String state, String county, int onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
        this.state = state;
        this.county = county;

    }

    public int getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public void setOnlyHighSchool(int onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

}
