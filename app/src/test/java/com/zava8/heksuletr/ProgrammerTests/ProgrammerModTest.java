package com.zava8.heksuletr.ProgrammerTests;

import com.zava8.heksuletr.model.ProgrammerCalcModel;
import com.zava8.heksuletr.model.int_size_enum;
import com.zava8.heksuletr.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.zava8.heksuletr.model.Operator.get_remainder;
import static org.junit.Assert.*;

public class ProgrammerModTest {
    @Test
    public void modTestAll_isCorrect() {
        for (int_size_enum mode : int_size_enum.values()) {
            assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(3), new BigDecimal(2), get_remainder, mode)));
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(2), new BigDecimal(2), get_remainder, mode)));
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0), new BigDecimal(2), get_remainder, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-3), new BigDecimal(2), get_remainder, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-3), new BigDecimal(-2), get_remainder, mode)));
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-2), new BigDecimal(-2), get_remainder, mode)));
        }
    }
}
