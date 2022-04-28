package com.example.fismo.ui.train;

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
import com.example.fismo.ui.train.TrainFragment;
import com.example.fismo.ui.train.TrainViewModel;
import com.example.fismo.ui.training.TrainingFragment;

public class TrainFragment extends Fragment {

    private TrainViewModel trainViewModel;
    private FragmentTrainingBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        trainViewModel =
                new ViewModelProvider(this).get(TrainViewModel.class);

        binding = FragmentTrainingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container_train, new TrainingFragment());
        fr.commit();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
