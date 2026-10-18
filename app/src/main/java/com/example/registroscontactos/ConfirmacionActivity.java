package com.example.registroscontactos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacionActivity extends AppCompatActivity {

    private static final String TAG = "CicloVidaApp";
    private Contacto contactoTemporal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Log.d(TAG, "ConfirmacionActivity: onCreate()");

        TextView tvResumen = findViewById(R.id.tvResumen);
        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        if (getIntent() != null && getIntent().hasExtra("contacto")) {
            contactoTemporal = (Contacto) getIntent().getSerializableExtra("contacto");
            if (contactoTemporal != null) {
                String resumen = "Nombre: " + contactoTemporal.getNombre() + "\n" +
                        "Correo: " + contactoTemporal.getCorreo() + "\n" +
                        "Teléfono: " + contactoTemporal.getTelefono() + "\n" +
                        "Tipo: " + contactoTemporal.getOpcion();
                tvResumen.setText(resumen);
            }
        }

        btnVolver.setOnClickListener(v -> finish());

        btnConfirmar.setOnClickListener(v -> {
            if (contactoTemporal != null) {
                ListaContactos.agregarContacto(contactoTemporal);
                Toast.makeText(ConfirmacionActivity.this, "Contacto guardado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override protected void onStart() { super.onStart(); Log.d(TAG, "ConfirmacionActivity: onStart()"); }
    @Override protected void onResume() { super.onResume(); Log.d(TAG, "ConfirmacionActivity: onResume()"); }
    @Override protected void onPause() { super.onPause(); Log.d(TAG, "ConfirmacionActivity: onPause()"); }
    @Override protected void onStop() { super.onStop(); Log.d(TAG, "ConfirmacionActivity: onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d(TAG, "ConfirmacionActivity: onDestroy()"); }
}