package com.example.fismo.ui.achievements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.databinding.FragmentAchievementsBinding;

public class AchievementsFragment extends Fragment {

    private AchievementsViewModel achievementsViewModel;
    private FragmentAchievementsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        achievementsViewModel =
                new ViewModelProvider(this).get(AchievementsViewModel.class);

        binding = FragmentAchievementsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        /*
        final TextView textView = binding.;
        creditsViewModelViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
