public class SilverPlan extends HealthInsurancePlan{
    public SilverPlan() {
        setCoverage(getCoverage() + (1000*0.7));
        setDiscount(getDiscount() + 30);
    }
}
