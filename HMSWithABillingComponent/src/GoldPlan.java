public class GoldPlan extends HealthInsurancePlan{
    public GoldPlan() {
        setCoverage(getCoverage() + (1000*0.8));
    }
}
