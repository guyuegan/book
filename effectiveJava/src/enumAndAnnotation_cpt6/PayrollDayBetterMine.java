package enumAndAnnotation_cpt6;

/**
 * the strategy FunctionalInterface pattern
 */
public enum PayrollDayBetterMine {
    MONDAY(PayrollDayBetterMine.overtimePay4Weekday()),

    TUESDAY(overtimePay4Weekday()),

    WEDNESDAY(overtimePay4Weekday()),

    THURSDAY(overtimePay4Weekday()),

    FRIDAY(overtimePay4Weekday()),

    SATURDAY(overtimePay4Weekend()),

    SUNDAY(overtimePay4Weekend());

    /**
     * 两种方法确保新增的常量都有自己的加班支付策略：
     * 1.定义一个成员变量(当然要构造器)，用来存储“策略”对象（FunctionalInterface）
     * 2.定义一个抽象方法，强制每个枚举实例都实现“策略”
     */
    private final OvertimePayFunction overtimePayStrategy;

    PayrollDayBetterMine(OvertimePayFunction overtimePayStrategy) {
        this.overtimePayStrategy = overtimePayStrategy;
    }

    double pay(double hoursWorked, double payRate) {
        double basePay = hoursWorked * payRate;
        double overtimePay = this.overtimePayStrategy.apply(hoursWorked, payRate);
        return basePay + overtimePay;
    }

    private static OvertimePayFunction overtimePay4Weekday() {
        return (hoursWorked, payRate) -> hoursWorked <= OvertimePayFunction.HOURS_PER_SHIFT ?
                0 : (hoursWorked - OvertimePayFunction.HOURS_PER_SHIFT) * payRate / 2;

    }

    private static OvertimePayFunction overtimePay4Weekend() {
        return (hoursWorked, payRate) -> hoursWorked * payRate / 2;
    }

    @FunctionalInterface
    private interface OvertimePayFunction {
        int HOURS_PER_SHIFT = 8;
        double apply(double hoursWorked, double payRate);
    }
}


