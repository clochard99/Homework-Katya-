package HMS;
public class BlueCrossBlueShield  implements InsuranceBrand {

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        return checkSmoking(insurancePlan, smoking) + checkAge(insurancePlan,age);
    }

    private double checkAge(HealthInsurancePlan insurancePlan, int age) {
        double premiumAge = 0;
        if (age > 55) {
            if (insurancePlan instanceof PlatinumPlan) {
                premiumAge = 200;
            }
            if (insurancePlan instanceof GoldPlan) {
                premiumAge = 150;
            }
            if (insurancePlan instanceof SilverPlan) {
                premiumAge = 100;
            }
            if (insurancePlan instanceof BronzePlan) {
                premiumAge = 50;
            }
        }
        return premiumAge;
    }

    private double checkSmoking(HealthInsurancePlan insurancePlan, boolean smoking) {
        double premiumSmoking = 0;
        if (smoking) {
            if (insurancePlan instanceof PlatinumPlan) {
                premiumSmoking = 100;
            }
            if (insurancePlan instanceof GoldPlan) {
                premiumSmoking = 90;
            }
            if (insurancePlan instanceof SilverPlan) {
                premiumSmoking = 80;
            }
            if (insurancePlan instanceof BronzePlan) {
                premiumSmoking = 70;
            }
        }
        return premiumSmoking;
    }
}

