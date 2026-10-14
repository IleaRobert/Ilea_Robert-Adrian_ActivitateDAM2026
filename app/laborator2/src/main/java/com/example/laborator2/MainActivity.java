package com.example.laborator2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar", "onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Seminar", "onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Seminar", "onPause ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Seminar","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Seminar","onDestroy");
    }


    public void deschideActivitate(View view) {

        Intent it = new Intent(this, Activitate_Noua.class);
        Bundle bundle =new Bundle();
        bundle.putString("MESAJ", "Mesaj din activitate!!!!");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        it.putExtras(bundle);


        startActivity(it);


    }
}