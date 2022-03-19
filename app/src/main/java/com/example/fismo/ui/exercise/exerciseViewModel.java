package com.example.fismo.ui.exercise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class exerciseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public exerciseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is exercise fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}