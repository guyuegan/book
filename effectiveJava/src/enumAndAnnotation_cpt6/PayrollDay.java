package enumAndAnnotation_cpt6;

/**
 * enum that switches on its value to share code - questionable
 * 假设将一个元素添加到该枚举，或许是一个表示假期天数的特殊值，
 * 但是忘记给switch语句添加相应的case，程序依然可以编译，
 * 但pay方法会悄悄地将假期的工资计算成与正常工作日的相同
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursWorked, double payRate) {
        double basePay = hoursWorked * payRate;

        double overtimePay;
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overtimePay = hoursWorked * payRate / 2;
            default: //Weekdays
                overtimePay = hoursWorked <= HOURS_PER_SHIFT ?
                        0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
                break;
        }

        return basePay + overtimePay;
    }
}
