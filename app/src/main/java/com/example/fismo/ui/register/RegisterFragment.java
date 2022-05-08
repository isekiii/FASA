package com.example.fismo.ui.register;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.MainActivity;

import com.example.fismo.RegisterActivity;
import com.example.fismo.databinding.FragmentInfoBinding;
import com.example.fismo.databinding.FragmentRegisterBinding;
import com.example.fismo.ui.register.RegisterFragment;
import com.example.fismo.ui.register.RegisterViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterFragment extends Fragment {

    private RegisterViewModel registerViewModel;
    private FragmentRegisterBinding binding;

    TextInputEditText nameField;
    TextInputEditText ageField;
    TextInputEditText weightField;
    Button registerBtn;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registerViewModel =
                new ViewModelProvider(this).get(RegisterViewModel.class);

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        registerBtn = binding.registerBtn;
        nameField = binding.nameField;
        ageField = binding.ageField;
        weightField = binding.weightField;



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
