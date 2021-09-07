package com.zava8.heksuletr.ProgrammerTests;

import com.zava8.heksuletr.model.ProgrammerCalcModel;
import com.zava8.heksuletr.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zava8.heksuletr.model.Operator.MULTIPLY;
import static com.zava8.heksuletr.model.int_size_enum.*;
import static org.junit.Assert.*;

public class ProgrammerMultiplicationTest {
    @Test
    public void programmerMultiplicationQWORD_isCorrect() {
        assertEquals(25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), MULTIPLY, l8)));
        assertEquals(-25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), MULTIPLY, l8)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), new BigDecimal(2), MULTIPLY, l8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(0x8000000000000000L), MULTIPLY, l8)));
        assertEquals(0xFFFFFFFFFFFFFFFEL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(2), MULTIPLY, l8)));
        assertEquals(0x7FFFFFFFFFFFFFFEL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x3FFFFFFFFFFFFFFFL), new BigDecimal(2), MULTIPLY, l8)));
    }

    @Test
    public void programmerMultiplicationDWORD_isCorrect() {
        assertEquals(25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), MULTIPLY, l4)));
        assertEquals(-25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), MULTIPLY, l4)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), new BigDecimal(2), MULTIPLY, l4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(0x80000000), MULTIPLY, l4)));
        assertEquals(0xFFFFFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(2), MULTIPLY, l4)));
        assertEquals(0x7FFFFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x3FFFFFFF), new BigDecimal(2), MULTIPLY, l4)));
    }

    @Test
    public void programmerMultiplicationWORD_isCorrect() {
        assertEquals((short) 25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), MULTIPLY, l2)));
        assertEquals((short) -25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), MULTIPLY, l2)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), new BigDecimal(2), MULTIPLY, l2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(0x8000), MULTIPLY, l2)));
        assertEquals((short) 0xFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(2), MULTIPLY, l2)));
        assertEquals((short) 0x7FFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x3FFF), new BigDecimal(2), MULTIPLY, l2)));
    }

    @Test
    public void programmerMultiplicationBYTE_isCorrect() {
        assertEquals((byte) 25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), MULTIPLY, l1)));
        assertEquals((byte) -25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), MULTIPLY, l1)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), new BigDecimal(2), MULTIPLY, l1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(0x80), MULTIPLY, l1)));
        assertEquals((byte) 0xFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(2), MULTIPLY, l1)));
        assertEquals((byte) 0x7E, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x3F), new BigDecimal(2), MULTIPLY, l1)));
    }
}
