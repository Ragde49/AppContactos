package com.softcame.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView vnombre;
    private TextView vtelefono;
    private TextView vemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));

        vnombre = (TextView) findViewById(R.id.txtNombre);
        vtelefono = (TextView) findViewById(R.id.txtTelefono);
        vemail = (TextView) findViewById(R.id.txtemail);


        vnombre.setText(nombre);
        vtelefono.setText(telefono);
        vemail.setText(email);
        Log.i("datos", vtelefono.getText().toString());
        Log.i("datos", vemail.getText().toString());
    }

    public void llamar(View V) {
        String telefono = vtelefono.getText().toString();
        Log.i("datos", telefono);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));

    }

    public void enviarmail(View v){
        String email = vemail.getText().toString();
        Intent emailintent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",email,null));
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "Test subjet.");
        startActivity(Intent.createChooser(emailintent,"Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}

