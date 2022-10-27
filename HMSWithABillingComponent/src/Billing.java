import java.util.Arrays;

public class Billing  extends HealthInsurancePlan {
    static final int DEFAULT_DISCOUNT = 20;

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        if (patientInsurancePlan == null) {
            payments[0] = DEFAULT_DISCOUNT;
            payments[1] = (amount - DEFAULT_DISCOUNT);
            return payments;
        } else {
            payments[0] = (amount * patientInsurancePlan.getCoverage()) + patientInsurancePlan.getDiscount();
        }
        if (patientInsurancePlan instanceof PlatinumPlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount()) - ((amount * patientInsurancePlan.getCoverage())));
            return payments;
        } else if (patientInsurancePlan instanceof GoldPlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount()) - ((amount * patientInsurancePlan.getCoverage())));
            return payments;
        } else if (patientInsurancePlan instanceof SilverPlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount()) - ((amount * patientInsurancePlan.getCoverage())));
            return payments;
        } else if (patientInsurancePlan instanceof BronzePlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount()) - ((amount * patientInsurancePlan.getCoverage())));
            return payments;
        }

        return payments;
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary;
    }
}


