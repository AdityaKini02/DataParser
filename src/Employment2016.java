public class Employment2016 {
    private int totalLaborForce;
    private int employedLaborForce;
    private int unemployedLaborForce;
    private double unemploymentPercent;

    // Only need: Unemployed population

    public Employment2016(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;

        this.totalLaborForce = totalLaborForce;
        this.employedLaborForce = employedLaborForce;
        this.unemploymentPercent = unemploymentPercent;
    }

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

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public double getUnemploymentPercent() {
        return unemploymentPercent;
    }

    public void setUnemploymentPercent(double unemploymentPercent) {
        this.unemploymentPercent = unemploymentPercent;
    }
}
