package com.atlanticssoft.avigancloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikhaellopez.circularimageview.CircularImageView;

public class Login extends AppCompatActivity {

    // Views de la Interfaz Gráfica
    private TextView tvOlvidoClave;
    private EditText etUsuario, etClave;
    private Button btnIniciar;

    //Variable para gestionar FirebaseAuth
    private FirebaseAuth mAuth;

    //Variables opcionales para desloguear de google también
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

    // Variables globales
    private ProgressDialog mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Status bar transparente
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave);


        // Enlazo view del botón de Iniciar
        btnIniciar = findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarCredenciales();
            }
        });

        mProgressBar = new ProgressDialog(Login.this);
        mAuth = FirebaseAuth.getInstance();

    }

    private void verificarCredenciales() {

        String email = etUsuario.getText().toString().trim();
        String clave = etClave.getText().toString().trim();

        if (email.isEmpty() || !email.contains("@"))
        {
            showError(etUsuario, "Email no válido");
        }else if (clave.isEmpty() || clave.length() < 7)
        {
            showError(etClave, "Clave no válida");
        }
        else
        {
            // Mostrar ProgressBar
            mProgressBar.setTitle("Acceso");
            mProgressBar.setMessage("Espera un momento ...");
            //mProgressBar.setCanceledOnTouchOutside(false);
            mProgressBar.show();

            // Pasos para iniciar sesion
            mAuth.signInWithEmailAndPassword(email,clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())
                    {
                        // Oculto la barra de progreso
                        mProgressBar.dismiss();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else {

                        Toast.makeText(getApplicationContext(), "No es posible Iniciar sesión, verifique Correo/Contraseña", Toast.LENGTH_SHORT).show();
                        //mProgressBar.dismiss();
                    }
                }
            });
        }
    }

    private void showError(EditText input, String s)
    {
        input.setError(s);
        input.requestFocus();
    }

    @Override
    protected void onStart() {
        FirebaseUser user = mAuth.getCurrentUser();
        // Verfico si el usuario ya está logueado
        if (user != null)
        {
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        super.onStart();
    }
}