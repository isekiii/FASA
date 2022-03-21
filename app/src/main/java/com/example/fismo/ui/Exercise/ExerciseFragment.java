package com.example.fismo.ui.Exercise;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.databinding.FragmentExerciseBinding;

public class ExerciseFragment extends Fragment {

    private ExerciseViewModel exerciseViewModelViewModel;
    private FragmentExerciseBinding binding;
    public TextView countdownText;
    public Button countdownButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 12000;
    private boolean timerRunning = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exerciseViewModelViewModel =
                new ViewModelProvider(this).get(ExerciseViewModel.class);

        binding = FragmentExerciseBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        final TextView textView = binding.textExercise;
        exerciseViewModelViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText(s);
            }


        });
        countdownText = binding.exerciseTimer;
        countdownButton = binding.exerciseButton;

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });


        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void startStop(){
        if (!timerRunning) startTimer();
        else stopTimer();
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                 timeLeftInMilliseconds = l;
                 updateTimer();
            }

            @Override
            public void onFinish() {
                countdownText.setText("DONE!");
            }
        }.start();
        timerRunning = true;
        countdownButton.setVisibility(View.INVISIBLE);
    }

    public void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer(){
        int seconds = (int) timeLeftInMilliseconds / 1000;
        String timeLeft = "";
        if (seconds < 10) timeLeft += "0";
        timeLeft += "" + seconds;
        countdownText.setText(timeLeft);
    }
}