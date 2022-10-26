public class PlatinumPlan extends HealthInsurancePlan{
   public PlatinumPlan() {
setCoverage(getCoverage() + (1000*0.9));
       setDiscount(getDiscount() + 50);
    }

}
