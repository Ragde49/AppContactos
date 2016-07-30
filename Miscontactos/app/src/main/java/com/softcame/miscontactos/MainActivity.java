package com.softcame.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Edgar Cantu Moreno","6144148529","ecantu@softcame.com"));
        contactos.add(new Contacto("Ivan Cantu Moreno","6144134483","icantu@softcame.com"));
        contactos.add(new Contacto("Emma Cantu Arguello","614410209","emmcantu@softcame.com"));
        contactos.add(new Contacto("Endy Arguello Marrufo","6141111","earguello@softcame.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombreContacto.add(contacto.getNombre());
            Log.i("email",contacto.getEmail());
        }

        ListView lstcontactos = (ListView) findViewById(R.id.lstContactos);
        lstcontactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));

        lstcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                Log.i("email2",contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }
}
