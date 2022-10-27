import java.util.Arrays;

public class Billing  extends HealthInsurancePlan {
    static final int DEFAULT_DISCOUNT = 20;

    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new BronzePlan();
        User user = new User();
        double[] payments1 = Billing.computeMonthPremium (user, 3000.0);
        System.out.println(Arrays.toString(payments1));
    }

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

    public static double[] computeMonthPremium(User user, double salary) {
        double[] payments1 = new double[1];
        HealthInsurancePlan userInsurancePlan = user.getInsurancePlan();
        if (userInsurancePlan instanceof BronzePlan) {
            payments1[0] = userInsurancePlan.computeMonthlyPremium(salary);
        }
        ;
        return payments1;
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary;
    }
}


