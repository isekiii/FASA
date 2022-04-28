package com.example.fismo.ui.train;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrainViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TrainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is training fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
