package com.zava8.calculator.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.zava8.calculator.R;
import com.zava8.calculator.model.Operator;
import com.zava8.calculator.model.ProgrammerCalcModel;
import com.zava8.calculator.model.int_size_enum;
import com.zava8.calculator.utils.InstanceStateUtil;
import com.zava8.calculator.utils.ProgrammerOperationsUtil;

public class ProgrammerFragment extends Fragment {
    private TextView u5h_tekst_viyu; private TextView u2b_tekst_viyu;
    private TextView dizit_tekst_viyu; private TextView ekuation_tekst_viyu;
    private ProgrammerCalcModel calcModel = new ProgrammerCalcModel();
    private boolean secondValueInputStarted = false;
    private String packageName;
    private int_size_enum bytelengthenum = int_size_enum.l8;
    private boolean limit_phen_dizits_recahed = false ;
    private int limit_dizits = 14 ; private String key_hist="";
    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            calcModel = InstanceStateUtil.restoreProgrammerSavedInstance(savedInstanceState);
        }
        return inflater.inflate(R.layout.fragment_programmer, container, false);
    }
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);
        u5h_tekst_viyu = getView().findViewById(R.id.result_tekst_viyu); u2b_tekst_viyu = getView().findViewById(R.id.result_binary_viyu);
        dizit_tekst_viyu = getView().findViewById(R.id.dizit_tekst_viyu); ekuation_tekst_viyu = getView().findViewById(R.id.ekuation_tekst_viyu);
        setupNumberButtons();setupOperatorButtons();setupLetterButtons();setupCalculateButton();setupDeleteButton();
        setupSignButton();
        calcModel.setNmbr_base(16);
        enableButtonsALL();
        setup_heks_cb();
        setup_decimal_spinner();
        setupWordLengthButton();
    }
    @Override public void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState);
        InstanceStateUtil.saveInstanceState(outState, calcModel, packageName);
    }
    public void setupFragment(String packageName) { this.packageName = packageName; }
    private void setupNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i, "id", packageName));
            int finalI = i;
            button.setOnClickListener((v) -> {
                if (!limit_phen_dizits_recahed) {
                    switch (finalI) {
                        case 0: dizit_tekst_viyu.setText("suny");break; case 1: dizit_tekst_viyu.setText("ek");break;
                        case 2: dizit_tekst_viyu.setText("wo");break; case 3: dizit_tekst_viyu.setText("xiin");break;
                        case 4: dizit_tekst_viyu.setText("car");break; case 5: dizit_tekst_viyu.setText("pac");break;
                        case 6: dizit_tekst_viyu.setText("che");break; case 7: dizit_tekst_viyu.setText("sax");break;
                        case 8: dizit_tekst_viyu.setText("qath");break; case 9: dizit_tekst_viyu.setText("no");break;
                    }
                    usePressedNumber(((Button) v).getText().toString());
                    if (!limit_phen_dizits_recahed) {
                        if ((finalI > 0 || finalI < 10)) {
                            int khlen = key_hist.length();
                            if (khlen > 15) key_hist = key_hist.substring(khlen - 15);
                            key_hist = key_hist + finalI;
                            ekuation_tekst_viyu.setText(key_hist);
                        }
                    }
                }
            });
        }
    }

    private void setupLetterButtons() {
        int[] letterButtonIDs = new int[]{R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF};
        for (int buttonID : letterButtonIDs) {
            Button button = getView().findViewById(buttonID);
            button.setOnClickListener((v) -> {
                if (!limit_phen_dizits_recahed) {
                    switch (buttonID) {
                        case R.id.buttonA : dizit_tekst_viyu.setText("ws"); break;
                        case R.id.buttonB : dizit_tekst_viyu.setText("zyarh"); break;
                        case R.id.buttonC : dizit_tekst_viyu.setText("barh"); break;
                        case R.id.buttonD : dizit_tekst_viyu.setText("xerj"); break;
                        case R.id.buttonE : dizit_tekst_viyu.setText("chowj"); break;
                        case R.id.buttonF : dizit_tekst_viyu.setText("pnwrj"); break;
                    }
                    String hekstr = ((Button) v).getText().toString() ;
                    usePressedNumber(hekstr);
                    if (!limit_phen_dizits_recahed) {
                        int khlen = key_hist.length();
                        if (khlen > 15) key_hist = key_hist.substring(khlen - 15);
                        key_hist = key_hist + hekstr;
                        ekuation_tekst_viyu.setText(key_hist);
                    }
                }
                else {
                    disableAllButtons();
                    disableOperatorButtons();
                    limit_phen_dizits_recahed = true ;
                }
            });
        }
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIDs = new int[]{R.id.button_pover, R.id.button_zor, R.id.buttonOR, R.id.buttonAND,
                R.id.buttonLSH, R.id.buttonRSH, R.id.buttonNOT, R.id.buttonRDivide, R.id.buttonMultiply,
                R.id.buttonMinus, R.id.buttonPlus};
        for (int buttonID : operatorButtonIDs) { Button button = getView().findViewById(buttonID);button.setOnClickListener((v) -> {
            if (!limit_phen_dizits_recahed) {
                String btn_lebl = button.getText().toString() ;
                Operator operator = Operator.operatorForTitle(btn_lebl);
                int khlen = key_hist.length();
                if (khlen>12)
                {
                    key_hist = key_hist.substring(khlen - 12);
                }
                key_hist = key_hist + btn_lebl ;
                ekuation_tekst_viyu.setText(key_hist);
                usePressedOperator(operator);
            }
            else {
                disableAllButtons();
                disableOperatorButtons();
                limit_phen_dizits_recahed = true ;
            }
            });
        }
    }

    private void setupCalculateButton() { Button equalsButton = getView().findViewById(R.id.buttonEquals);equalsButton.setOnClickListener(v -> {
            Button button = (Button) v;
            //System.out.println(button.getText().toString());
            useEqualsOperator();
        });
    }
    private String currentString() { return u5h_tekst_viyu.getText().toString(); }
    private void setupDeleteButton() { Button delButton = getView().findViewById(R.id.buttonDel); delButton.setOnClickListener(v -> {
            String currentString = currentString();
            if (limit_phen_dizits_recahed) {
                enableButtonsALL();
                enableOperatorButtons();
                limit_phen_dizits_recahed = false ;
            }
            else if (!currentString.equals("-") && currentString.length() > 1) {
                    currentString = currentString.substring(0, currentString.length() - 1);
                    int khlen = key_hist.length();
                    if (khlen > 1)
                    {
                        key_hist = key_hist.substring(0, khlen - 1);
                        ekuation_tekst_viyu.setText(key_hist);
                    }
                    updateText(currentString);
            }
            else {
                key_hist = ""; ekuation_tekst_viyu.setText(key_hist);
                updateText(calcModel.textForValue(0.0));
            }
    }); }

    private void setupSignButton() { Button signButton = getView().findViewById(R.id.buttonSign);signButton.setOnClickListener(v -> {
            long currentValue = Long.parseLong(currentString(), calcModel.get_nmbr_base());
            if (currentValue == 0) return;
            String updatedString = formatText(currentValue);
            if (currentValue > 0) updatedString = "-" + updatedString; else updatedString = updatedString.substring(1);
            updateText(updatedString);
        });
    }
    private void setupWordLengthButton() { Button modeButton = getView().findViewById(R.id.buttonLength);modeButton.setOnClickListener(v -> {
            long val = Long.parseLong(currentString(), calcModel.get_nmbr_base());
            if (bytelengthenum.ordinal() < 3) {
                int num = bytelengthenum.ordinal();
                bytelengthenum = int_size_enum.values()[++num];
            } else bytelengthenum = int_size_enum.l8;
            switch (bytelengthenum) {
                case l4: val = (int) val;break;
                case l2: val = (short) val;break;
                case l1: val = (byte) val;
            }
            calcModel.setBytelengthenum(bytelengthenum);
            updateText(formatText(val));
            Log.d("LengthChanged", "Length button pressed, current value: " + bytelengthenum.toString());
            modeButton.setText(bytelengthenum.toString());
        });
    }
    private void setup_heks_cb() {
        CheckBox heks_cb = getView().findViewById(R.id.heks_check_boks); heks_cb.setOnCheckedChangeListener( (v, id) -> {
            long number = Long.parseLong(u5h_tekst_viyu.getText().toString(), calcModel.get_nmbr_base());
            if (heks_cb.isChecked()) { calcModel.setNmbr_base(16); enableButtonsALL(); }
            else {calcModel.setNmbr_base(10); enableButtonsDEC();}
            updateText(formatText(number));
        });
    }
    private void setup_decimal_spinner() {
        Spinner spinner = getView().findViewById(R.id.decimal_precision_spinner);
        String[] decimal_points_items = getResources().getStringArray(R.array.decimal_points_selection_array);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( spinner.getContext(), R.array.decimal_points_selection_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
//        c_handle_decimal_spinboks spinboks_listener = new c_handle_decimal_spinboks() ;
//        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) spinboks_listener);
    }
    private void usePressedNumber(String number) {
        if (currentString().equals("0") && !number.equals(".")) { u5h_tekst_viyu.setText(""); u2b_tekst_viyu.setText(""); }
        String newString;
        if (secondValueInputStarted) { newString = number;secondValueInputStarted = false; }
        else newString = u5h_tekst_viyu.getText().toString() + number;
        updateText(newString);
    }

    private void usePressedOperator(Operator operator) {
        boolean readyToSaveOperator = calcModel.getFirstValue() != null;
        if (!readyToSaveOperator) return;
        boolean readyToCalcOneSide = !operator.requiresTwoValues() && calcModel.getFirstValue() != null;
        if (readyToCalcOneSide) { calcModel.setOperator(operator);calculateResult();return; }
        boolean readyToCalcTwoSides = calcModel.getOperator() != null && calcModel.getFirstValue() != null && calcModel.getSecondValue() != null;
        if (readyToCalcTwoSides) calculateResult(); else secondValueInputStarted = true;
        calcModel.setOperator(operator);
    }

    private void useEqualsOperator() { if (calcModel.getOperator() == null) return;calculateResult(); }
    private void calculateResult() {
        long result = ProgrammerOperationsUtil.calculateWithData(calcModel);
        calcModel.resetCalcState();
        calcModel.updateAfterCalculation(result);
        updateText(formatText(result));
        secondValueInputStarted = true;
    }

    private String formatText(long number) { return Long.toString(number, calcModel.get_nmbr_base()).toUpperCase(); }

    private void updateText(String updatedText) {
        if(updatedText.length() > limit_dizits - 1 )
        {
            disableAllButtons();
//            disableOperatorButtons();
            limit_phen_dizits_recahed = true ;
        }
        else
        {
            if (updatedText.length() > 12) {
                int input1_tekst_size_small = (int) (getResources().getDimension(R.dimen.input1_tekst_size_small));// / getResources().getDisplayMetrics().density) ;
                int input3_tekst_size_small = (int) (getResources().getDimension(R.dimen.input3_tekst_size_small));// / getResources().getDisplayMetrics().density) ;

                u5h_tekst_viyu.setTextSize(18);
                u2b_tekst_viyu.setTextSize(27);
            }
            else {
                int input1_tekst_size_big = (int) (getResources().getDimension(R.dimen.input1_tekst_size_big));// / getResources().getDisplayMetrics().density) ;
                int input3_tekst_size_big = (int) (getResources().getDimension(R.dimen.input3_tekst_size_big));// / getResources().getDisplayMetrics().density) ;
                u5h_tekst_viyu.setTextSize(26);
                u2b_tekst_viyu.setTextSize(39);
            } ;
            u5h_tekst_viyu.setText(updatedText);
            u2b_tekst_viyu.setText(updatedText);
//            ekuation_tekst_viyu.setText(c_nmbr_utils.heks_nmbr_string_to_vrdsstring(updatedText));
            calcModel.updateValues(updatedText);
        }
    }

    private void setTextViewValue(Double value) {
        boolean isWholeValue = value % 1 == 0;
        if (isWholeValue) {
            u5h_tekst_viyu.setText(String.format("%.0f", value)); u2b_tekst_viyu.setText(String.format("%.0f", value));
        } else {
            u5h_tekst_viyu.setText(Double.toString(value)); u2b_tekst_viyu.setText(Double.toString(value));
        }
    }

    private void disableOperatorButtons() { setOperatorButtonsClickable(false); }
    private void enableOperatorButtons() { setOperatorButtonsClickable(true); }
    private void disableAllButtons() {
        setNumberButtonsClickable(10, false);
        setLetterButtonsClickable(false);
    }
    private void enableButtonsDEC() {
        setLetterButtonsClickable(false);
        setNumberButtonsClickable(10, true);
    }
    private void enableButtonsALL() {
        setLetterButtonsClickable(true);
        setNumberButtonsClickable(10, true);
    }
    private void setLetterButtonsClickable(boolean mode) {
        int[] letterButtonIDs = new int[]{R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF};
        for (int buttonID : letterButtonIDs) {
            Button button = getView().findViewById(buttonID);
            if(null != button) {
                button.setEnabled(mode);
                if (button.isEnabled()) button.setAlpha(1);
                else button.setAlpha(0.3f);
            }
        }
    }
    private void setNumberButtonsClickable(int range, boolean mode) {
        for (int i = 0; i < range; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i, "id", packageName));
            if(null != button) {
                button.setEnabled(mode);
                if (button.isEnabled()) button.setAlpha(1);
                else button.setAlpha(0.3f);
            }
        }
    }

    private void setOperatorButtonsClickable(boolean mode) {
        int[] letterButtonIDs = new int[]{
                R.id.button_decimal_point,  R.id.buttonRDivide,
                R.id.button_pover,
                R.id.buttonMinus, R.id.buttonPlus , R.id.buttonMultiply, R.id.buttonPower,
                R.id.button_decimal_point, R.id.buttonEquals,
                R.id.button_zor, R.id.buttonOR, R.id.buttonNOT , R.id.buttonAND , R.id.buttonLSH , R.id.buttonRSH,
        };
        for (int buttonID : letterButtonIDs) {
            Button button = getView().findViewById(buttonID);
            if(null != button) {
                button.setEnabled(mode);
                if (button.isEnabled()) button.setAlpha(1);
                else button.setAlpha(0.3f);
            }
        }
    }
}
