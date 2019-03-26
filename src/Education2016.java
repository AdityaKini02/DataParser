public class Education2016 {
    private double noHighSchool;
    private double onlyHighSchool;
    private double noCollege;
    private double bachelorsOrMore;

    //Only need: onlyHighSchool

    public Education2016(double onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;

        this.noHighSchool = noHighSchool;
        this.noCollege = noCollege;
        this.bachelorsOrMore = bachelorsOrMore;
    }

    public double getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public void setOnlyHighSchool(double onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
    }


    //EXTRAS

    public double getNoHighSchool() {
        return noHighSchool;
    }

    public void setNoHighSchool(double noHighSchool) {
        this.noHighSchool = noHighSchool;
    }

    public double getNoCollege() {
        return noCollege;
    }

    public void setNoCollege(double noCollege) {
        this.noCollege = noCollege;
    }

    public double getBachelorsOrMore() {
        return bachelorsOrMore;
    }

    public void setBachelorsOrMore(double bachelorsOrMore) {
        this.bachelorsOrMore = bachelorsOrMore;
    }
}
