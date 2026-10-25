package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adauga_Imprimanta_AI extends AppCompatActivity {

    private Spinner spinnerTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_imprimanta_ai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerTip = findViewById(R.id.spinnerTipAI);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tip_imprimanta_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTip.setAdapter(adapter);
    }

    public void culegeDateAI(View view) {
        EditText etmarca = findViewById(R.id.textMarcaAI);
        EditText etmodel = findViewById(R.id.textModelAI);
        Switch sw = findViewById(R.id.switch1AI);
        CheckBox cb = findViewById(R.id.checkBoxAI);
        RatingBar rb = findViewById(R.id.ratingBarAI);

        String marca = etmarca.getText().toString();
        String model = etmodel.getText().toString();
        Boolean estePornita = sw.isChecked();
        Boolean areWIFI = cb.isChecked();
        Float notaTiparire = rb.getRating();
        String tip = spinnerTip.getSelectedItem() != null ? spinnerTip.getSelectedItem().toString() : "Laser";

        Bundle bundle = new Bundle();
        bundle.putString("marca", marca + " [AI]");
        bundle.putString("model", model + " (" + tip + ")");
        bundle.putBoolean("estePornita", estePornita);
        bundle.putBoolean("areWIFI", areWIFI);
        bundle.putFloat("notaTiparire", notaTiparire);

        Intent it = new Intent();
        it.putExtras(bundle);

        setResult(RESULT_OK, it);
        finish();
    }
}
