package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void deschideActivitateAdaugare(View view) {

        Intent it = new Intent(this, Adauga_Imprimanta.class);
        startActivityForResult(it , 10);



    }

    public void deschideActivitateAdaugareAI(View view) {
        Intent it = new Intent(this, Adauga_Imprimanta_AI.class);
        startActivityForResult(it, 20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == 10 || requestCode == 20) && resultCode == RESULT_OK && data != null){

            Bundle bundle = data.getExtras();

            if (bundle != null) {
                String marca = bundle.getString("marca");
                String model = bundle.getString("model");
                boolean estePornita = bundle.getBoolean("estePornita");
                boolean areWIFI = bundle.getBoolean("areWIFI");
                float notaTiparire = bundle.getFloat("notaTiparire");

                Imprimanta imprimanta = new Imprimanta(marca, model, estePornita, areWIFI, notaTiparire);

                TextView tv = findViewById(R.id.textView);
                tv.setText(imprimanta.toString());
            }

        }


    }
}