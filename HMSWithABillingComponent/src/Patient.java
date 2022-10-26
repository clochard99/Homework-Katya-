public class Patient extends User {
   private HealthInsurancePlan insurancePlan;
    private long patientId;
        private boolean insured;

        public long getPatientId() {
            return patientId;
        }

        public void setPatientId(long patientId) {
            this.patientId = patientId;
        }

        public boolean isInsured() {
            return insured;
        }

        public void setInsured(boolean insured) {
            this.insured = insured;
        }

    public void setInsurancePlan(HealthInsurancePlan insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public HealthInsurancePlan getInsurancePlan() {
            return insurancePlan;
    }

}

