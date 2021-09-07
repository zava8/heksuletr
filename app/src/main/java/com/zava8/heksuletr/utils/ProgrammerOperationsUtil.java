package com.zava8.heksuletr.utils;

import com.zava8.heksuletr.model.ProgrammerCalcModel;
import com.zava8.heksuletr.model.int_size_enum;

import java.math.BigDecimal;

public class ProgrammerOperationsUtil {
    public static long calculateWithData(ProgrammerCalcModel data) {
        switch (data.getOperator()) {
            case ADD: return addSubtract(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case SUBTRACT: return addSubtract(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue().negate());
            case MULTIPLY: return multiply(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case remainder_divide: return divide(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case LSH: return lsh(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case RSH: return rsh(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case OR: return or(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case XOR: return xor(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case AND: return and(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case get_remainder: return mod(data.getBytelengthenum(), data.getFirstValue(), data.getSecondValue());
            case CHANGE_SIGN: return changeSign(data.getBytelengthenum(), data.getFirstValue());
            case NOT: return not(data.getBytelengthenum(), data.getFirstValue());
            default: return 0;
        }
    }

    private static long addSubtract(int_size_enum mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case l8: return value1.longValue() + value2.longValue();
            case l4: return value1.intValue() + value2.intValue();
            case l2: return (short) (value1.shortValue() + value2.shortValue());
            case l1: return (byte) (value1.byteValue() + value2.byteValue());
            default: return 0;
        }
    }

    private static long changeSign(int_size_enum mode, BigDecimal value) {
        switch (mode) {
            case l8: return value.negate().longValue();
            case l4: return value.negate().intValue();
            case l2: return value.negate().shortValue();
            case l1: return value.negate().byteValue();
            default: return 0;
        }
    }

    private static long lsh(int_size_enum mode, BigDecimal value, BigDecimal shift) {
        switch (mode) {
            case l8: return value.longValue() << shift.intValue();
            case l4: return value.intValue() << shift.intValue();
            case l2: return (short) (value.shortValue() << shift.intValue());
            case l1: return (byte) (value.byteValue() << shift.intValue());
            default: return 0;
        }
    }

    private static long rsh(int_size_enum mode, BigDecimal value, BigDecimal shift) {
        switch (mode) {
            case l8: return value.longValue() >> shift.intValue();
            case l4: return value.intValue() >> shift.intValue();
            case l2: return (short) (value.shortValue() >> shift.intValue());
            case l1: return (byte) (value.byteValue() >> shift.intValue());
            default: return 0;
        }
    }

    private static long not(int_size_enum mode, BigDecimal value) {
        switch (mode) {
            case l8: return ~value.longValue();
            case l4: return ~value.intValue();
            case l2: return (short) (~value.shortValue());
            case l1: return (byte) (~value.byteValue());
            default: return 0;
        }
    }

    private static long or(int_size_enum mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case l8: return value1.longValue() | value2.longValue();
            case l4: return value1.intValue() | value2.intValue();
            case l2: return (short) (value1.shortValue() | value2.shortValue());
            case l1: return (byte) (value1.byteValue() | value2.byteValue());
            default: return 0;
        }
    }

    private static long xor(int_size_enum mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case l8: return value1.longValue() ^ value2.longValue();
            case l4: return value1.intValue() ^ value2.intValue();
            case l2: return (short) (value1.shortValue() ^ value2.shortValue());
            case l1: return (byte) (value1.byteValue() ^ value2.byteValue());
            default: return 0;
        }
    }

    private static long and(int_size_enum mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case l8: return value1.longValue() & value2.longValue();
            case l4: return value1.intValue() & value2.intValue();
            case l2: return (short) (value1.shortValue() & value2.shortValue());
            case l1: return (byte) (value1.byteValue() & value2.byteValue());
            default: return 0;
        }
    }

    private static long mod(@org.jetbrains.annotations.NotNull int_size_enum mode, BigDecimal dividend, BigDecimal divider) {
        switch (mode) {
            case l8: return dividend.longValue() % divider.longValue();
            case l4: return dividend.intValue() % divider.intValue();
            case l2: return (short) (dividend.shortValue() % divider.shortValue());
            case l1: return (byte) (dividend.byteValue() % divider.byteValue());
            default: return 0;
        }
    }

    private static long multiply(int_size_enum mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case l8: return value1.longValue() * value2.longValue();
            case l4: return value1.intValue() * value2.intValue();
            case l2: return (short) (value1.shortValue() * value2.shortValue());
            case l1: return (byte) (value1.byteValue() * value2.byteValue());
            default: return 0;
        }
    }
    private static long divide(int_size_enum mode, BigDecimal dividend, BigDecimal divider) {
        switch (mode) {
            case l8: return dividend.longValue() / divider.longValue();
            case l4: return dividend.intValue() / divider.intValue();
            case l2: return (short) (dividend.shortValue() / divider.shortValue());
            case l1: return (byte) (dividend.byteValue() / divider.byteValue());
            default: return 0;
        }
    }
}
