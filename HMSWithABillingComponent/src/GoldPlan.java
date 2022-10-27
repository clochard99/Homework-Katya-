public class GoldPlan extends HealthInsurancePlan{
    public GoldPlan() {
        setCoverage(getCoverage() + (0.8));
        setDiscount(getDiscount() + 40);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return (salary*0.07);
    }
}
