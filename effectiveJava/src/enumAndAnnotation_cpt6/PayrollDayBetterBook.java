package enumAndAnnotation_cpt6;

/**
 * the strategy enum pattern
 */
public enum PayrollDayBetterBook {
    MONDAY(PayType.WEEKDAY),

    TUESDAY(PayType.WEEKDAY),

    WEDNESDAY(PayType.WEEKDAY),

    THURSDAY(PayType.WEEKDAY),

    FRIDAY(PayType.WEEKDAY),

    SATURDAY(PayType.WEEKEND),

    SUNDAY(PayType.WEEKEND);


    private final PayType payType;

    PayrollDayBetterBook(PayType payType) {
        this.payType = payType;
    }

    private enum PayType {
        WEEKDAY{
            @Override
            double overtimePay(double hoursWorked, double payRate) {
                return  hoursWorked <= HOURS_PER_SHIFT ?
                        0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2; }
        },

        WEEKEND{
            @Override
            double overtimePay(double hoursWorked, double payRate) {
                return hoursWorked * payRate / 2; }
        };

        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hoursWorked, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}


