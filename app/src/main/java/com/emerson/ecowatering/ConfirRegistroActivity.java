package com.emerson.ecowatering;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirRegistroActivity extends AppCompatActivity {

    EditText etNombres, etDatos;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confir_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombres = findViewById(R.id.etNombres);
        etDatos = findViewById(R.id.etDatos);

        String datosMostrar = "Correo: " + getIntent().getStringExtra("correoElectronico")
                + "\nDireccion: " + getIntent().getStringExtra("direccion")
                + "\nOcupación: " + getIntent().getStringExtra("ocupacion");

        String nombreApellido = getIntent().getStringExtra("nombreApellido");

        etNombres.setText(nombreApellido);
        etDatos.setText(datosMostrar);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirRegistroActivity.this, MainActivity.class);
            startActivity(intent);
        });






    }
}