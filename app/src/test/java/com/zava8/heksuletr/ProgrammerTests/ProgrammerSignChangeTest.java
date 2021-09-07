package com.zava8.heksuletr.ProgrammerTests;


import com.zava8.heksuletr.model.ProgrammerCalcModel;
import com.zava8.heksuletr.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zava8.heksuletr.model.Operator.CHANGE_SIGN;
import static com.zava8.heksuletr.model.int_size_enum.*;
import static org.junit.Assert.*;

public class ProgrammerSignChangeTest {
    @Test
    public void programmerSignChangeQWORD_isCorrect() {
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, l8)));
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, l8)));
        assertEquals(0xC000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), CHANGE_SIGN, l8)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), CHANGE_SIGN, l8)));
        assertEquals(0x8000000000000001L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), CHANGE_SIGN, l8)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFFFFFFFFFFL), CHANGE_SIGN, l8)));
    }

    @Test
    public void programmerSignChangeDWORD_isCorrect() {
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, l4)));
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, l4)));
        assertEquals(0xC0000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), CHANGE_SIGN, l4)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), CHANGE_SIGN, l4)));
        assertEquals(0x80000001, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), CHANGE_SIGN, l4)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFF), CHANGE_SIGN, l4)));
    }

    @Test
    public void programmerSignChangeWORD_isCorrect() {
        assertEquals((short) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, l2)));
        assertEquals((short) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, l2)));
        assertEquals((short) 0xC000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), CHANGE_SIGN, l2)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), CHANGE_SIGN, l2)));
        assertEquals((short) 0x8001, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), CHANGE_SIGN, l2)));
        assertEquals((short) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFF), CHANGE_SIGN, l2)));
    }

    @Test
    public void programmerSignChangeBYTE_isCorrect() {
        assertEquals((byte) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, l1)));
        assertEquals((byte) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, l1)));
        assertEquals((byte) 0xC0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), CHANGE_SIGN, l1)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), CHANGE_SIGN, l1)));
        assertEquals((byte) 0x81, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), CHANGE_SIGN, l1)));
        assertEquals((byte) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFF), CHANGE_SIGN, l1)));
    }
}
