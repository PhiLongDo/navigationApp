package com.example.navigationapp.ui.touchCounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TouchCounterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TouchCounterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}