package com.zava8.heksuletr.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.zava8.heksuletr.R;
import com.zava8.heksuletr.model.kl_lang_setting;
import com.zava8.heksuletr.utils.SharedPreferencesUtil;

public class langs_fragment extends Fragment {
    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_languages, container, false);
    }
    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RadioButton zing_radio = getActivity().findViewById(R.id.lang_zing_button);
        RadioButton hindi_radio = getActivity().findViewById(R.id.lang_hinDi_button);
        SharedPreferencesUtil prefUtil = new SharedPreferencesUtil(getActivity());
        kl_lang_setting lang_setting = prefUtil.load_language_setting();
        switch (lang_setting) {
            case zinglish: zing_radio.setChecked(true);hindi_radio.setChecked(false);break;
            case hindi: zing_radio.setChecked(false);hindi_radio.setChecked(true);break;
            case UNKNOWN: zing_radio.setChecked(false);hindi_radio.setChecked(false);break;
        }
        zing_radio.setOnClickListener((v) -> { kl_lang_setting lang = kl_lang_setting.zinglish;
            prefUtil.save_lang_setting(kl_lang_setting.zinglish);
            Log.d("lang changed", "mode_enum radio pressed, current value: " + lang.toString());
            getActivity().recreate();
        });
        hindi_radio.setOnClickListener((v) -> { kl_lang_setting lang = kl_lang_setting.hindi;
            prefUtil.save_lang_setting(kl_lang_setting.hindi);
            Log.d("lang changed", "mode_enum radio pressed, current value: " + lang.toString());
            getActivity().recreate();
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
