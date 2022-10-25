public class BronzePlan extends HealthInsurancePlan{
    public BronzePlan() {
        setCoverage(getCoverage() + (1000*0.6));
    }
}
