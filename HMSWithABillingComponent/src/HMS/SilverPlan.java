package HMS;
public class SilverPlan extends HealthInsurancePlan{
    public SilverPlan() {
        setCoverage(getCoverage() + (0.7));
        setDiscount(getDiscount() + 30);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return (salary*0.06) + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
