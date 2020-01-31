package com.example.boomdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectNumberActivity extends AppCompatActivity {

    private RecyclerView recyclerNumber;
    private ArrayList<PhoneNumberModel> phoneNumberModels = new ArrayList<>();
    /**
     * RecyclerAdapter
     **/
    private SelectNumberAdapter selectNumberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclr_select_number);

        recyclerNumber = findViewById(R.id.recyclr_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerNumber.setLayoutManager(linearLayoutManager);
        selectNumberAdapter = new SelectNumberAdapter(this, phoneNumberModels);
        recyclerNumber.setAdapter(selectNumberAdapter);

        onSelection();


        selectNumberAdapter.setOnItemClikListeners(new SelectNumberAdapter.onItemClikListeners() {
            @Override
            public void onItemClikListeners(View view, int position, String phoneNumberModel) {

                if (selectNumberAdapter.getSelected() != null) {
                    Toast.makeText(getApplicationContext(), selectNumberAdapter.getSelected().getPhoneNumber(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onSelection() {
        phoneNumberModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PhoneNumberModel phoneNumberModel = new PhoneNumberModel();
            phoneNumberModel.setPhoneNumber("Employee" + (i + 1));
            phoneNumberModels.add(phoneNumberModel);
        }
        selectNumberAdapter.setPhoneNumber(phoneNumberModels);
    }
}
