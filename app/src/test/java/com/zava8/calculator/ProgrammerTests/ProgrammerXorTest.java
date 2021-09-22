package com.zava8.calculator.ProgrammerTests;

import com.zava8.calculator.model.ProgrammerCalcModel;
import com.zava8.calculator.model.int_size_enum;
import com.zava8.calculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zava8.calculator.model.Operator.XOR;
import static org.junit.Assert.*;

public class ProgrammerXorTest {
    @Test
    public void xorTestAll_isCorrect() {
        for (int_size_enum mode : int_size_enum.values()) {
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), XOR, mode)));
            assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(0), XOR, mode)));
            assertEquals(-2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-1), new BigDecimal(1), XOR, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-1), new BigDecimal(0), XOR, mode)));
        }
    }
}