import java.util.Arrays;

public class Billing  extends HealthInsurancePlan {
    final static int DEFAULT_DISCOUNT = 20;

    public static void main(String[] args) {

        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        HealthInsurancePlan insurancePlan2 = new BronzePlan();

        Patient patient = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();

        patient.setInsurancePlan(insurancePlan);
        patient2.setInsurancePlan(insurancePlan2);

        double[] payments = Billing.computePaymentAmount(patient, 3000.0);
        double[] payments2 = Billing.computePaymentAmount(patient2, 1000.0);
        double[] payments3 = Billing.computePaymentAmount(patient3, 3500.0);
        System.out.println(Arrays.toString(payments));
        System.out.println(Arrays.toString(payments2));
        System.out.println(Arrays.toString(payments3));
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
            payments[1] = ((amount - patientInsurancePlan.getDiscount())- ((amount * patientInsurancePlan.getCoverage()) ));
            return payments;
        }
        if (patientInsurancePlan instanceof GoldPlan) {
            payments[1] =((amount - patientInsurancePlan.getDiscount())- ((amount * patientInsurancePlan.getCoverage()) ));
            return payments;
        }
        if (patientInsurancePlan instanceof SilverPlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount())- ((amount * patientInsurancePlan.getCoverage()) ));
            return payments;
        }
        if (patientInsurancePlan instanceof BronzePlan) {
            payments[1] = ((amount - patientInsurancePlan.getDiscount())- ((amount * patientInsurancePlan.getCoverage()) ));
            return payments;
        }

        return payments;
    }


}
