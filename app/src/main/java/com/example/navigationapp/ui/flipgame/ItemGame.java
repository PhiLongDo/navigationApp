package com.example.navigationapp.ui.flipgame;

import android.widget.Button;

public class ItemGame {
    private Button btn_ixj;
    private Integer value;

    public ItemGame(Button btn_ixj) {
        this.btn_ixj = btn_ixj;
    }

    public ItemGame(Button btn_ixj, Integer value) {
        this.btn_ixj = btn_ixj;
        this.value = value;
    }

    public Button getBtn_ixj() {
        return btn_ixj;
    }

    public void setBtn_ixj(Button btn_ixj) {
        this.btn_ixj = btn_ixj;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
