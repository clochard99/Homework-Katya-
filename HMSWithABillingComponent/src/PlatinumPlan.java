public class PlatinumPlan extends HealthInsurancePlan{
   public PlatinumPlan() {
setCoverage(getCoverage() + (0.9));
       setDiscount(getDiscount() + 50);
    }

}
