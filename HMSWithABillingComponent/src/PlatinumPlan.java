public class PlatinumPlan extends HealthInsurancePlan{
   public PlatinumPlan() {
setCoverage(getCoverage() + (0.9));
       setDiscount(getDiscount() + 50);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return (salary*0.08);
    }
}
