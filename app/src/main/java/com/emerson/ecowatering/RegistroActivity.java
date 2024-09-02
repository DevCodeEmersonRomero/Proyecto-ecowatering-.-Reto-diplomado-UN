package com.emerson.ecowatering;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

    Button btnGuardar;
    EditText etnombreApellido, etcorreoElectronico, etDireccion;
    Spinner spOcupacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        etnombreApellido = findViewById(R.id.etnombreApellido);
        etcorreoElectronico = findViewById(R.id.etcorreoElectronico);
        etDireccion = findViewById(R.id.etDireccion);
        spOcupacion = findViewById(R.id.spOcupacion);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etnombreApellido.getText().toString().isEmpty() ||
                        etcorreoElectronico.getText().toString().isEmpty() ||
                        etDireccion.getText().toString().isEmpty() ||
                        spOcupacion.getSelectedItem().toString().equals("Seleccione Ocupación")) {
                    Toast.makeText(RegistroActivity.this, "ingrese la información correspondiente", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(RegistroActivity.this, ConfirRegistroActivity.class);
                    intent.putExtra("nombreApellido", etnombreApellido.getText().toString());
                    intent.putExtra("correoElectronico", etcorreoElectronico.getText().toString());
                    intent.putExtra("ocupacion", spOcupacion.getSelectedItem().toString());
                    intent.putExtra("direccion", etDireccion.getText().toString());
                    startActivity(intent);
                }
            }

        });
    }

}