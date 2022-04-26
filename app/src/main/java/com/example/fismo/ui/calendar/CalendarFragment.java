package com.example.fismo.ui.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fismo.databinding.FragmentCalendarBinding;
import com.example.fismo.ui.calendar.CalendarViewModel;

public class CalendarFragment extends Fragment {

    private CalendarViewModel calendarViewModelViewModel;
    private FragmentCalendarBinding binding;

    CalendarView calendarView;
    TextView selectedDate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModelViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);

        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        calendarView = binding.calendarView;
        selectedDate = binding.calendarSelectedText;

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectedDate.setText("Selected date: " + dateBuild(i, i1+1, i2));
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    String dateBuild(int year, int month, int day){
        String mm, dd;

        if (month < 10) mm = "0"+month;
        else mm = month + "";

        if (day < 10) dd = "0"+day;
        else dd = day + "";

        return dd+"/"+mm+"/"+year;
    }
}