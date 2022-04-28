package com.example.fismo.ui.training;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.R;
import com.example.fismo.databinding.FragmentTrainingBinding;
import com.example.fismo.ui.Exercise.ExerciseFragment;
import com.example.fismo.ui.achievements.AchievementsFragment;
import com.example.fismo.ui.training.TrainingViewModel;

public class TrainingFragment extends Fragment {

    private TrainingViewModel trainingViewModel;
    private FragmentTrainingBinding binding;

    String desc = "Step 1: Lie on your back on a mat with your knees bent, feet flat on the floor and heels fully placed on the ground.\n" +
            "Step 2: Place your hands behind your head, squeezing your shoulder blades together and pulling your elbows back without arching your low back. Align your head with your spine, but allow it to move into slight flexion during the upward phase of the exercise.\n" +
            "Step 3: Upward phase: Exhale, contract your abdominal and core muscles and flex your chin slightly towards your chest while slowly curling your torso towards your thighs. Your feet, tailbone and lower back should remain in contact with the mat at all times. Continue curling up until your upper back is lifted off the mat. \n" +
            "Step 4: Downward phase: gently inhale and slowly uncurl your torso back towards the mat in a controlled fashion keeping your feet, tailbone and low back in contact with the mat.\n";

    String desc2 = "Step 1: Starting position: lie on your right side on an exercise mat with your left leg lying directly over your right leg and bend your knees to a comfortable position. Raise your upper body to support yourself on your right arm, your right elbow should bend to 90 degrees and be positioned directly under your shoulder. Align your head with your spine and keep your hips and lower knee in contact with the exercise mat.\n" +
            "\n" +
            "Step 2: Upward phase: exhale, gently contact your core muscles to stiffen your spine and lift your hips off the mat, but keeping contact with your knee, and head aligned with your spine.\n" +
            "Step 3: Lowering phase: inhale and gently return yourself to your starting position.\n";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        trainingViewModel =
                new ViewModelProvider(this).get(TrainingViewModel.class);

        binding = FragmentTrainingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button crunches = binding.crunchesBtn;
        Button plank = binding.sidePlankBtn;
        Button test = binding.test;

        crunches.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Crunches", desc, 12000, R.drawable.crunches));
                fr.commit();
                crunches.setVisibility(View.INVISIBLE);
                plank.setVisibility(View.INVISIBLE);
                test.setVisibility(View.INVISIBLE);
            }
        });

        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new ExerciseFragment("Side Plank", desc2, 30000, R.drawable.sideplank));
                fr.commit();
                crunches.setVisibility(View.INVISIBLE);
               test.setVisibility(View.INVISIBLE);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
