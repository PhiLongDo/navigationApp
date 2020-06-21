package com.example.navigationapp.ui.touchCounter;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationapp.R;

public class TouchCounterFragment extends Fragment {

    private TouchCounterViewModel galleryViewModel;
    private Integer counter = 0;
    private TextView tvShowCounter;
    private Button btnTouch, btnReset;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(TouchCounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_touch_counter, container, false);
        tvShowCounter = root.findViewById(R.id.tvShowCouter);
        btnReset = root.findViewById(R.id.btnReset);
        btnTouch = root.findViewById(R.id.btnTouch);

        tvShowCounter.setText("0");

        /*galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        //Add listeners
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                tvShowCounter.setText(counter.toString());
                tvShowCounter.setTextColor(Color.WHITE);
            }
        });
        btnTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter += 1;
                tvShowCounter.setText(counter.toString());
                if (counter >=20){
                    tvShowCounter.setTextColor(Color.YELLOW);
                }
                if (counter >=50){
                    tvShowCounter.setTextColor(Color.RED);
                }

                btnTouch.setBackgroundColor(Color.parseColor("#8a8b8c"));
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 0.1s = 100ms
                        btnTouch.setBackgroundColor(Color.parseColor("#A1414D46"));
                    }
                }, 100);
            }
        });
        return root;
    }

    /*public void resetNumber(View view) {
        counter = 0;
        tvShowCounter.setText(counter.toString());
        tvShowCounter.setTextColor(Color.WHITE);
    }*/

    /*public void pushNumber(View view) {
        counter += 1;
        tvShowCounter.setText(counter.toString());
        if (counter >=20){
            tvShowCounter.setTextColor(Color.YELLOW);
        }
        if (counter >=50){
            tvShowCounter.setTextColor(Color.RED);
        }

        btnTouch.setBackgroundColor(Color.parseColor("#8a8b8c"));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 0.1s = 100ms
                btnTouch.setBackgroundColor(Color.parseColor("#A1414D46"));
            }
        }, 100);
    }*/
}