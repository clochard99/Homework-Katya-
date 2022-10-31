package HMS;
import java.util.Arrays;

public class Billing  extends HealthInsurancePlan {
    static final int DEFAULT_DISCOUNT = 20;
    public static void main(String[] args) {


        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan = new BronzePlan();
        insurancePlan.setOfferedBy(insuranceBrand);

        User staff = new User();
        staff.setInsurancePlan(insurancePlan);
        System.out.println(insurancePlan.computeMonthlyPremium(5000, 56, false));

        Patient patient = new Patient();
        double [] payments = Billing.computePaymentAmount(patient, 1230);
        System.out.println(Arrays.toString(payments));

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
        if (patientInsurancePlan != null ) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount()) - ((amount * patientInsurancePlan.getCoverage())));
            return payments;
        }
        return payments;
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean smoking) {
        return salary;
    }
}


