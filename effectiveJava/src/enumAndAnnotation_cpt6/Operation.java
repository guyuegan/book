package enumAndAnnotation_cpt6;

/**
 *  enum type that switches on its own value - questionable
 *  这里每个常量和不同的行为关联，但是这种关联方式比较脆弱
 *  当新添加枚举常量，却忘记给switch添加相应的条件，
 *  枚举任然可以编译，但是试图运行新运算时，就会运行失败
 */
public enum Operation {
    PLUS, MINUS, TIMES, DEVICE;

    /* do the arithmetic op represented by this constant */
    double apply(double x, double y) {
        switch (this) {
            case PLUS:    return x + y;
            case MINUS:   return x - y;
            case TIMES:   return x * y;
            case DEVICE:  return x / y;
        }
        throw new AssertionError("unknwon op: " + this);
    }
}
