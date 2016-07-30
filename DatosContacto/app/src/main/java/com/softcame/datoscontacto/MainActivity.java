package com.softcame.datoscontacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnSigueinte;
    TextInputEditText txtNombre;
    DatePicker dtpFechan;
    TextInputEditText txtTelefono;
    TextInputEditText txtemail;
    TextInputEditText txtdescripcion;

    int diafecha;
    int mesfecha;
    int añofecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSigueinte = (Button) findViewById(R.id.btnSiguiente);
        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        txtdescripcion = (TextInputEditText) findViewById(R.id.txtDescrip);
        txtemail = (TextInputEditText) findViewById(R.id.txtEmail);
        txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        dtpFechan = (DatePicker) findViewById(R.id.dtpFecha);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null){
            String nombre = parametros.getString("nombre");
            int diafecha = parametros.getInt("diafecha");
            int mesfecha = parametros.getInt("mesfecha");
            int añofecha = parametros.getInt("añofecha");
            String telefono = parametros.getString("telefono");
            String email = parametros.getString("email");
            String descripcion = parametros.getString("descripcion");

            txtNombre.setText(nombre);
            txtdescripcion.setText(descripcion);
            txtTelefono.setText(telefono);
            txtemail.setText(email);
            mesfecha -= 1;
            dtpFechan.updateDate(añofecha,mesfecha,diafecha);
        }


        btnSigueinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,confirmacion.class);
                intent.putExtra("nombre",txtNombre.getText().toString());
                intent.putExtra("diafecha", dtpFechan.getDayOfMonth());
                intent.putExtra("mesfecha", dtpFechan.getMonth());
                intent.putExtra("añofecha", dtpFechan.getYear());
                intent.putExtra("telefono",txtTelefono.getText().toString());
                intent.putExtra("email",txtemail.getText().toString());
                intent.putExtra("descripcion",txtdescripcion.getText().toString());
                Log.i("info",txtNombre.getText().toString());
                String day = String.valueOf(dtpFechan.getDayOfMonth());
                String mes = String.valueOf(dtpFechan.getMonth());
                String año = String.valueOf(dtpFechan.getYear());
                Log.i("info",day + "/" + mes + 1 + "/" + año);
                startActivity(intent);
                finish();
            }
        });
    }

}



