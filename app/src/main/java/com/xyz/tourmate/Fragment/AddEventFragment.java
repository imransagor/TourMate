package com.xyz.tourmate.Fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xyz.tourmate.R;


public class AddEventFragment extends Fragment {
    private TextInputEditText eventNameEt,startPointEt,destinationEt,dateEt,budgetEt;
    private Button createBtn;


    public AddEventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_event, container, false);


        eventNameEt=view.findViewById(R.id.eventNameET);
        startPointEt=view.findViewById(R.id.startPointET);
        destinationEt=view.findViewById(R.id.destinationET);
        dateEt=view.findViewById(R.id.dateET);
        budgetEt=view.findViewById(R.id.budgetET);
        createBtn=view.findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
