package HMS;
public class GoldPlan extends HealthInsurancePlan{
    public GoldPlan() {
        setCoverage(getCoverage() + (0.8));
        setDiscount(getDiscount() + 40);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return (salary*0.07) +getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
}
