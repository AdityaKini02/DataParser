public class County {
    private String name;
    private int fips;
    private Election2016 vote2016;
    private Education2016 educ2016;
    private Employment2016 employ2016;
    private int CommunityCenters;


//    County defined by the number of people who:
//    - Only graduated High School
//    - Unemployed
//    - Number of community centers


    public County(String name, int fips, Education2016 educ2016, Employment2016 employ2016, int CommunityCenters) {
        this.name = name;
        this.fips = fips;
        this.educ2016 = educ2016;
        this.employ2016 = employ2016;
        this.CommunityCenters = CommunityCenters;

        this.vote2016 = vote2016;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }


    public Education2016 getEduc2016() {
        return educ2016;
    }

    public void setEduc2016(Education2016 educ2016) {
        this.educ2016 = educ2016;
    }

    //EXTRAS
    public Election2016 getVote2016() {
        return vote2016;
    }

    public void setVote2016(Election2016 vote2016) {
        this.vote2016 = vote2016;
    }
}
