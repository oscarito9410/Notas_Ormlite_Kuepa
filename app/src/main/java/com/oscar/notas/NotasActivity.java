package com.oscar.notas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import com.oscar.notas.BaseDatos.Dbcrud;
import com.oscar.notas.BaseDatos.Notas;

import java.sql.SQLException;
import java.util.Date;


public class NotasActivity extends AppCompatActivity {

    private static final String TAG = "NotasActivity";
    ListView listNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(NotasActivity.this,AgregarActivity.class);
                startActivity(i);

            }
        });
        mostrarNotas();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarNotas();
    }

    private void mostrarNotas(){
        listNotas=(ListView)findViewById(R.id.listNotas);
        Dbcrud Db=new Dbcrud(this);
        try {
            AdaptadorNotas adpt=new AdaptadorNotas(this,Db.obtenerNotas());
            listNotas.setAdapter(adpt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notas, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_mapa) {
            startActivity(new Intent(this,MapsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
