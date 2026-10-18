package com.example.registroscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVidaApp";

    private EditText etNombre, etCorreo, etTelefono;
    private RadioGroup rgOpcion;
    private RecyclerView rvContactos;
    private ContactoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate()");

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        rgOpcion = findViewById(R.id.rgOpcion);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        rvContactos = findViewById(R.id.rvContactos);

        rvContactos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactoAdapter(ListaContactos.getLista());
        rvContactos.setAdapter(adapter);

        btnEnviar.setOnClickListener(v -> validarYEnviar());
    }

    private void validarYEnviar() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        if (nombre.isEmpty()) {
            etNombre.setError("El nombre no puede estar vacío");
            etNombre.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("El correo no puede estar vacío");
            etCorreo.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingrese un correo válido");
            etCorreo.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("El teléfono no puede estar vacío");
            etTelefono.requestFocus();
            return;
        } else if (telefono.length() != 8) {
            etTelefono.setError("El teléfono debe tener exactamente 8 dígitos");
            etTelefono.requestFocus();
            return;
        }

        int selectedId = rgOpcion.getCheckedRadioButtonId();
        RadioButton rbSeleccionado = findViewById(selectedId);
        String opcion = (rbSeleccionado != null) ? rbSeleccionado.getText().toString() : "Personal";

        Contacto contacto = new Contacto(nombre, correo, telefono, opcion);

        Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);
        intent.putExtra("contacto", contacto);
        startActivity(intent);
    }



    @Override protected void onStart() { super.onStart(); Log.d(TAG, "MainActivity: onStart()"); }
    @Override protected void onPause() { super.onPause(); Log.d(TAG, "MainActivity: onPause()"); }
    @Override protected void onStop() { super.onStop(); Log.d(TAG, "MainActivity: onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d(TAG, "MainActivity: onDestroy()"); }
}