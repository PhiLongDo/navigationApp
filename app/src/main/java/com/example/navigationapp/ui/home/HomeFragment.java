package com.example.navigationapp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationapp.R;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText edtYear;
    private TextView txtYearOld;
    private Button btnOK;
    private int currentYear;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        currentYear = Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.YEAR);
        edtYear = root.findViewById(R.id.edtYear);
        txtYearOld = root.findViewById(R.id.txtYearOld);
        btnOK = root.findViewById(R.id.btnOK);

        txtYearOld.setText("????");
        /*-------------------------------------------------------------------------------------------------*/
        edtYear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (edtYear.getText().toString().length() >= 4){
                    return;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtYear.getText().toString().equals("")){
                    txtYearOld.setText("----");
                    btnOK.setEnabled(Boolean.FALSE);
                }
                if (edtYear.getText().toString().length() > 4){
                    String newYear = edtYear.getText().toString().substring(0,4);
                    edtYear.setText(newYear);
                }
                txtYearOld.setText("");
                btnOK.setEnabled(Boolean.TRUE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtYear.getText().toString().length() >= 4){
                    btnOK.requestFocus();
                }
            }
        });
        /*------------------------------------------------------------------------------------------------*/
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer year = Integer.parseInt(edtYear.getText().toString());
                    Integer yearOld = currentYear - year;
                    txtYearOld.setText(yearOld.toString());

                    if (yearOld < 0) {
                        txtYearOld.setText("????");
                    }
                }
                catch (NumberFormatException e) {
                    txtYearOld.setText("????");
                }
            }
        });
        // Hide soft keyboard on getting focus
        btnOK.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.getId() == R.id.btnOK){
                    InputMethodManager inm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);
                }
            }
        });
        return root;
    }
}