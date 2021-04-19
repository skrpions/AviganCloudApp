package com.atlanticssoft.avigancloud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    private ImageView logo, appName, splashImg;
    private LottieAnimationView lottieAnimationView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Status bar transparente
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Simulamos el inicio del proceso
        init();
        progressBar.setVisibility(View.VISIBLE);

        // Simulamos fin del proceso
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                // Salto a la actividad de inicio
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(Splash.this, Acceso.class);
                startActivity(intent);

                finish();
                // Animación tipo fade
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

        }, 3000);

        // Enlazo los demás view
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.imagen);
        //lottieAnimationView = findViewById(R.id.lottie);

        // Animaciones
        splashImg.animate().translationY(-2900).setDuration(1000).setStartDelay(2200); // El Background sube
        appName.animate().translationY(2900).setDuration(1000).setStartDelay(2200); // El nombre de la app baja
        logo.animate().translationY(2900).setDuration(1000).setStartDelay(2200); // El logo baja
    }

    private void init() {
        this.progressBar = findViewById(R.id.progressBar);
    }
}