package com.example.laborator2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activitate_Noua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void deschideActivitateaTrei(View view) {
        Intent it = new Intent(this, A_Treia_Activitate.class);

        Bundle bundle =new Bundle();
        bundle.putString("MESAJ", "Mesaj din activitate!!!!");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);

        it.putExtras(bundle);


        startActivityForResult(it, 70);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 70){

            if(resultCode==RESULT_OK){
                String mesaj = data.getStringExtra("mesaj");
                int suma = data.getIntExtra("suma",0);

                StringBuilder builder = new StringBuilder(mesaj);
                builder.append(" ").append(suma);
                Toast.makeText(this, builder.toString(),Toast.LENGTH_SHORT).show();


            }
        }
    }
}