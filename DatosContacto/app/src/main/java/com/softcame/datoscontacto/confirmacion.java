package com.softcame.datoscontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class confirmacion extends AppCompatActivity {
    TextView txtacNombre;
    TextView txtacfecha;
    TextView txtactel;
    TextView txtacemail;
    TextView txtacdescripcion;
    Button btnEditar;
    int diafecha;
    int mesfecha;
    int añofecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");
        diafecha = parametros.getInt("diafecha");
        Log.i("Fecha", String.valueOf(diafecha));
        mesfecha = parametros.getInt("mesfecha");
        Log.i("Fecha",String.valueOf(mesfecha + 1));
        añofecha = parametros.getInt("añofecha");
        Log.i("Fecha",String.valueOf(añofecha));
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        txtacNombre = (TextView) findViewById(R.id.txtacNombre);
        txtacfecha = (TextView) findViewById(R.id.txtacFecha);
        txtactel = (TextView) findViewById(R.id.txtacTelefono);
        txtacemail = (TextView) findViewById(R.id.txtacEmail);
        txtacdescripcion = (TextView) findViewById(R.id.txtacDescrip);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        txtacNombre.setText(nombre);
        txtacdescripcion.setText(descripcion);
        txtactel.setText(telefono);
        txtacemail.setText(email);
        txtacdescripcion.setText(descripcion);
        mesfecha++;
        txtacfecha.setText("Fecha Nacimiento:" + diafecha + "/" + mesfecha + "/" + añofecha);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(confirmacion.this, MainActivity.class);
                intent.putExtra("nombre",txtacNombre.getText().toString());
                intent.putExtra("diafecha", diafecha);
                intent.putExtra("mesfecha", mesfecha);
                intent.putExtra("añofecha", añofecha);
                intent.putExtra("telefono",txtactel.getText().toString());
                intent.putExtra("email",txtacemail.getText().toString());
                intent.putExtra("descripcion",txtacdescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
