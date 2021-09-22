package com.zava8.calculator.model;
import java.math.BigDecimal;

//public class ProgrammerCalcModel extends CalculationModel {
public class ProgrammerCalcModel {
    private BigDecimal firstValue;
    private BigDecimal secondValue;
    private Operator operator;
    private int_size_enum bytelengthenum;
    private int nmbr_base = 16;

    public ProgrammerCalcModel() { firstValue = null; secondValue = null; operator = null; bytelengthenum = int_size_enum.l8;
    }
    public ProgrammerCalcModel(BigDecimal afirstValue, Operator aoperator) {
        firstValue = afirstValue; operator = aoperator; bytelengthenum = int_size_enum.l8;
    }
    public ProgrammerCalcModel(BigDecimal fv, BigDecimal sv, Operator op)
        { firstValue = fv; secondValue = sv; operator = op; bytelengthenum = int_size_enum.l8; }

//    public ProgrammerCalcModel() { this.bytelengthenum = l8; }
    public ProgrammerCalcModel(BigDecimal afirstValue, Operator aoperator, int_size_enum abytelengthenum) {
        firstValue = afirstValue; operator = aoperator; bytelengthenum = abytelengthenum;
    }

    public ProgrammerCalcModel(BigDecimal afirstValue, BigDecimal asecondValue, Operator aoperator, int_size_enum abytelengthenum) {
        firstValue = afirstValue; secondValue = asecondValue; operator = aoperator; bytelengthenum = abytelengthenum;
    }


    public BigDecimal getFirstValue() { return firstValue; }
    public BigDecimal getSecondValue() { return secondValue; }
    public Operator getOperator() { return operator; }
    public int get_nmbr_base() { return nmbr_base; }
    public int_size_enum getBytelengthenum() { return bytelengthenum; }

    public void setFirstValue(double value) { firstValue = BigDecimal.valueOf(value); }
    public void setSecondValue(double value) { secondValue = BigDecimal.valueOf(value); }
    public void setSecondValueEqualToFirst() { secondValue = firstValue.add(BigDecimal.ZERO); }
    public void setOperator(Operator aoperator) { operator = aoperator; }
    public void setNmbr_base(int argbase) {
        if (16 == argbase || 10 == argbase)
        {
            this.nmbr_base = argbase;
        }
    }
    /////////from calc
    public void resetCalcState() { firstValue = null; secondValue = null; operator = null; }
    public void updateValues(String text) {
        if (10 == this.nmbr_base) {
            if (operator == null) setFirstValue(Double.parseDouble(text)); else setSecondValue(Double.parseDouble(text));
        }
        else if (16 == this.nmbr_base) {
            if (operator == null) setFirstValue(Long.parseLong(text,16)); else setSecondValue(Long.parseLong(text,16));
        }
    }
    public void updateAfterCalculation(double calculationResult) { resetCalcState(); setFirstValue(calculationResult); }
    public String textForValue(double value) {
        boolean isWholeValue = value % 1 == 0;
        return isWholeValue ? String.format("%.0f", value) : (Double.toString(value));
    }
    public boolean isNotNumber() {
        return (operator == Operator.remainder_divide && secondValue.doubleValue() == 0) ||
                (operator == Operator.DENOMINATOR && firstValue.doubleValue() == 0);
    }
    public boolean isFirstIntegerValue() { return firstValue.stripTrailingZeros().scale() <= 0; }

    ////////// from calc
    public void setBytelengthenum(int_size_enum bytelengthenum) { this.bytelengthenum = bytelengthenum; }

}
