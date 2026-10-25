package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adauga_Imprimanta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_imprimanta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void culegeDate(View view) {

        EditText etmarca = findViewById(R.id.textMarca);
        EditText etmodel = findViewById(R.id.textModel);
        Switch sw = findViewById(R.id.switch1);
        CheckBox cb =findViewById(R.id.checkBox);
        RatingBar rb = findViewById(R.id.ratingBar);

        String marca = etmarca.getText().toString();
        String model = etmodel.getText().toString();
        Boolean estePornita = sw.isChecked();
        Boolean areWIFI = cb.isChecked();
        Float notaTiparire = rb.getRating();



        Bundle bundle = new Bundle();
        bundle.putString("marca", marca);
        bundle.putString("model", model);
        bundle.putBoolean("estePornita", estePornita);
        bundle.putBoolean("areWIFI", areWIFI);
        bundle.putFloat("notaTiparire", notaTiparire);


        Intent it = new Intent();
        it.putExtras(bundle);

        setResult(RESULT_OK, it);
        finish();

    }
}