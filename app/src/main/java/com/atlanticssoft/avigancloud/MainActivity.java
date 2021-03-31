package com.atlanticssoft.avigancloud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mikhaellopez.circularimageview.CircularImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    // Views de la Interfaz Gráfica
    private TextView userId, userNombre, userEmail;
    private Button btnLogout, btnEliminarCuenta;
    private CircularImageView userImagen;

    //Variable para gestionar FirebaseAuth
    private FirebaseAuth mAuth;

    //Variables opcionales para desloguear de google también
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userImagen = findViewById(R.id.userImagen);
        userId     = findViewById(R.id.userId);
        userNombre = findViewById(R.id.userNombre);
        userEmail  = findViewById(R.id.userEmail);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();


        // Establecer datos en la interfaz gráfica
        userId.setText(currentUser.getUid());
        userNombre.setText(currentUser.getDisplayName());
        userEmail.setText(currentUser.getEmail());
        // Cargar la imágen con glide:
        Glide.with(this).load(currentUser.getPhotoUrl()).into(userImagen);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Cierro sesión de firebase
                mAuth.signOut();

                // Cierro la sesión de google también : Google sign out
                mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                    //Abrir MainActivity con SigIn button
                    if(task.isSuccessful()){
                        Intent inicioActivity = new Intent(getApplicationContext(), Inicio.class);
                        startActivity(inicioActivity);
                        MainActivity.this.finish();
                    }else
                        {
                        Toast.makeText(getApplicationContext(), "No se pudo cerrar sesión con google",
                                Toast.LENGTH_LONG).show();
                    }
                }
                });

            }
        });

        btnEliminarCuenta = findViewById(R.id.btnEliminarCuenta);
        btnEliminarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        // Configurar las gso (GoogleSignInOptions) para google signIn con el fin de luego desloguear de google
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);



    }
}