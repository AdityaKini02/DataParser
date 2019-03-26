public class Employment2016 {
    private String State;
    private String County;
    private int totalLaborForce;
    private int employedLaborForce;
    private int unemployedLaborForce;
    private double unemploymentPercent;


    // Only need: Unemployed population

    public Employment2016(String State, String County, int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
        this.State = State;
        this.County = County;

        this.totalLaborForce = totalLaborForce;
        this.employedLaborForce = employedLaborForce;
        this.unemploymentPercent = unemploymentPercent;
    }



    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }




    //EXTRAS

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmployedLaborForce() {
        return employedLaborForce;
    }

    public void setEmployedLaborForce(int employedLaborForce) {
        this.employedLaborForce = employedLaborForce;
    }

    public double getUnemploymentPercent() {
        return unemploymentPercent;
    }

    public void setUnemploymentPercent(double unemploymentPercent) {
        this.unemploymentPercent = unemploymentPercent;
    }
}
