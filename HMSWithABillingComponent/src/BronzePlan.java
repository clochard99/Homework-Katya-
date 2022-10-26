public class BronzePlan extends HealthInsurancePlan{

    public BronzePlan() {
        setCoverage(getCoverage() + (0.6));
        setDiscount(getDiscount() + 25);
    }

}
