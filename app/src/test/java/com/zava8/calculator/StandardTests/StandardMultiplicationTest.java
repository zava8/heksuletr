package com.zava8.calculator.StandardTests;

import com.zava8.calculator.model.CalculationModel;
import com.zava8.calculator.utils.StandardOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zava8.calculator.model.Operator.MULTIPLY;
import static org.junit.Assert.assertEquals;

public class StandardMultiplicationTest {
    @Test
    public void testPositiveIntegers() {
        assertEquals(25, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(BigDecimal.valueOf(5), BigDecimal.valueOf(5), MULTIPLY)), 0);
    }

    @Test
    public void testPositiveAndNegativeIntegers() {
        assertEquals(-25, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(BigDecimal.valueOf(-5), BigDecimal.valueOf(5), MULTIPLY)), 0);
    }

    @Test
    public void testDecimalSmall() {
        assertEquals(0.00001, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(BigDecimal.valueOf(0.000005), BigDecimal.valueOf(2), MULTIPLY)), 0);
    }

    @Test
    public void testFirstDecimalParameter() {
        assertEquals(3, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(BigDecimal.valueOf(1.5), BigDecimal.valueOf(2), MULTIPLY)), 0);
    }

    @Test
    public void testSecondDecimalParameter() {
        assertEquals(1, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(BigDecimal.valueOf(2), BigDecimal.valueOf(0.5), MULTIPLY)), 0);
    }
}
