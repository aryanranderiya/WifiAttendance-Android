package com.example.impromptussiphackathon2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class TakeAttendaceActivity extends AppCompatActivity {
    Spinner branchSpinner,groupSpinner,divisionSpinner;
    Button btn_startAttendanceSession;
    String[] branchArray,divisionArray, groupArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendace);

        Init();
        SpinnerSelectItem();
        Buttons();
    }

    private void Buttons() {
        btn_startAttendanceSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelectionValid()) {
                    Intent intent = new Intent(TakeAttendaceActivity.this, AttendanceSubmitted.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TakeAttendaceActivity.this, "Please select all three options", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isSelectionValid() {
        // Check if all three spinners have valid selections
        return (branchSpinner.getSelectedItemPosition() > 0) &&
                (groupSpinner.getSelectedItemPosition() > 0) &&
                (divisionSpinner.getSelectedItemPosition() > 0);
    }

    private void SpinnerSelectItem() {
        Boolean submit_btn = false;
    }

    private void Init() {
        branchSpinner = findViewById(R.id.branchSpinner);
        groupSpinner = findViewById(R.id.groupSpinner);
        divisionSpinner = findViewById(R.id.divisionSpinner);
        btn_startAttendanceSession = findViewById(R.id.btn_startAttendanceSession);
        
        branchArray = getResources().getStringArray(R.array.branch_array);
        ArrayAdapter<String> branchArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_list, branchArray);
        branchArrayAdapter.setDropDownViewResource(R.layout.spinner_list);
        branchSpinner.setAdapter(branchArrayAdapter);
        branchSpinner.setSelection(0, false);

        groupArray = getResources().getStringArray(R.array.group_array);
        ArrayAdapter<String> groupArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_list, groupArray);
        groupArrayAdapter.setDropDownViewResource(R.layout.spinner_list);
        groupSpinner.setAdapter(groupArrayAdapter);
        groupSpinner.setSelection(0, false);

        divisionArray = getResources().getStringArray(R.array.division_array);
        ArrayAdapter<String> divisionArrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_list, divisionArray);
        divisionArrayAdapter.setDropDownViewResource(R.layout.spinner_list);
        divisionSpinner.setAdapter(divisionArrayAdapter);
        divisionSpinner.setSelection(0, false);
    }
}