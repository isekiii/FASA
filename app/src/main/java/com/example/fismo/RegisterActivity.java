package com.example.fismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fismo.ui.register.RegisterFragment;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        Reg();
    }

    private void Reg(){
        Button registerBtn = findViewById(R.id.registerBtn);
        TextInputEditText nameField, ageField, weightField;
        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);
        weightField = findViewById(R.id.weightField);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                System.out.println("Name: " + nameField.getText() + " Age: " + ageField.getText() + " Weight: " + weightField.getText());
                editor.putString("userName", nameField.getText().toString());
                editor.putInt("userAge", Integer.parseInt(ageField.getText().toString()));
                editor.putInt("userWeight", Integer.parseInt(weightField.getText().toString()));
                editor.apply();

                finish();
            }
        });
    }
}