package HMS;

public class PlatinumPlan extends HealthInsurancePlan {
    public PlatinumPlan() {
        setCoverage(getCoverage() + (0.9));
        setDiscount(getDiscount() + 50);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return (salary * 0.08) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
