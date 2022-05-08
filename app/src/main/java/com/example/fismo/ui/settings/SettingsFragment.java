package com.example.fismo.ui.settings;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.MainActivity;
import com.example.fismo.databinding.FragmentSettingsBinding;
import com.example.fismo.ui.settings.SettingsViewModel;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModelViewModel;
    private FragmentSettingsBinding binding;
    Button resetBtn;
    TextView aboutMe;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModelViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        resetBtn = binding.reset;
        aboutMe = binding.aboutMe;
        SharedPreferences prefs = getContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);

        aboutMe.setText("Name: "+prefs.getString("userName", "Unset")+" \nAge: "+prefs.getInt("userAge", 0)+" \nWeight: "+prefs.getInt("userWeight", 0)+" KG\n");

        System.out.println("Name: "+prefs.getString("userName", "Unset")+" \nAge: "+prefs.getInt("userAge", 0)+" \nWeight: "+prefs.getInt("userWeight", 0)+" KG\n");
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("firstTime", true);
                editor.apply();

                Intent mStartActivity = new Intent(getContext(), MainActivity.class);
                int pendingIntentID = 9999999;
                PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), pendingIntentID, mStartActivity, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager mgr = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, pendingIntent);
                System.exit(0);
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