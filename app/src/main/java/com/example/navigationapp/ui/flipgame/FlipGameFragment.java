package com.example.navigationapp.ui.flipgame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationapp.R;

public class FlipGameFragment extends Fragment {

    private ItemGame[][] matrixGame = new ItemGame[7][6];
    private Button btnReset;
    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_images_flip_game, container, false);

        initGame();
        initActionGame();
        btnReset = root.findViewById(R.id.btn_reset);

        resetGame();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });


        return root;
    }

    private void initGame() {
        matrixGame[1][1] = new ItemGame((Button) root.findViewById(R.id.btn_1x1));
        matrixGame[1][2] = new ItemGame((Button) root.findViewById(R.id.btn_1x2));
        matrixGame[1][3] = new ItemGame((Button) root.findViewById(R.id.btn_1x3));
        matrixGame[1][4] = new ItemGame((Button) root.findViewById(R.id.btn_1x4));
        matrixGame[1][5] = new ItemGame((Button) root.findViewById(R.id.btn_1x5));
        matrixGame[2][1] = new ItemGame((Button) root.findViewById(R.id.btn_2x1));
        matrixGame[2][2] = new ItemGame((Button) root.findViewById(R.id.btn_2x2));
        matrixGame[2][3] = new ItemGame((Button) root.findViewById(R.id.btn_2x3));
        matrixGame[2][4] = new ItemGame((Button) root.findViewById(R.id.btn_2x4));
        matrixGame[2][5] = new ItemGame((Button) root.findViewById(R.id.btn_2x5));
        matrixGame[3][1] = new ItemGame((Button) root.findViewById(R.id.btn_3x1));
        matrixGame[3][2] = new ItemGame((Button) root.findViewById(R.id.btn_3x2));
        matrixGame[3][3] = new ItemGame((Button) root.findViewById(R.id.btn_3x3));
        matrixGame[3][4] = new ItemGame((Button) root.findViewById(R.id.btn_3x4));
        matrixGame[3][5] = new ItemGame((Button) root.findViewById(R.id.btn_3x5));
        matrixGame[4][1] = new ItemGame((Button) root.findViewById(R.id.btn_4x1));
        matrixGame[4][2] = new ItemGame((Button) root.findViewById(R.id.btn_4x2));
        matrixGame[4][3] = new ItemGame((Button) root.findViewById(R.id.btn_4x3));
        matrixGame[4][4] = new ItemGame((Button) root.findViewById(R.id.btn_4x4));
        matrixGame[4][5] = new ItemGame((Button) root.findViewById(R.id.btn_4x5));
        matrixGame[5][1] = new ItemGame((Button) root.findViewById(R.id.btn_5x1));
        matrixGame[5][2] = new ItemGame((Button) root.findViewById(R.id.btn_5x2));
        matrixGame[5][3] = new ItemGame((Button) root.findViewById(R.id.btn_5x3));
        matrixGame[5][4] = new ItemGame((Button) root.findViewById(R.id.btn_5x4));
        matrixGame[5][5] = new ItemGame((Button) root.findViewById(R.id.btn_5x5));
        matrixGame[6][1] = new ItemGame((Button) root.findViewById(R.id.btn_6x1));
        matrixGame[6][2] = new ItemGame((Button) root.findViewById(R.id.btn_6x2));
        matrixGame[6][3] = new ItemGame((Button) root.findViewById(R.id.btn_6x3));
        matrixGame[6][4] = new ItemGame((Button) root.findViewById(R.id.btn_6x4));
        matrixGame[6][5] = new ItemGame((Button) root.findViewById(R.id.btn_6x5));
    }

    private void initActionGame(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 5; j++) {
                matrixGame[i][j].getBtn_ixj().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }
    }

    private void resetGame(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 5; j++) {
                Log.i("info",i+"_"+j);
                matrixGame[i][j].getBtn_ixj().setVisibility(View.VISIBLE);
                matrixGame[i][j].getBtn_ixj().setText("△");
                matrixGame[i][j].setValue(i*j);
            }
        }
    }
}
