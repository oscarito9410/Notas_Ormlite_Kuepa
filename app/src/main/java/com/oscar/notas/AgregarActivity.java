package com.oscar.notas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.oscar.notas.BaseDatos.Dbcrud;
import com.oscar.notas.BaseDatos.Notas;

import java.util.Calendar;
import java.util.Date;

public class AgregarActivity extends AppCompatActivity {

    EditText txtTitulo, txtDescripcion;
    DatePicker dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        txtTitulo=(EditText)findViewById(R.id.txtTitulo);
        txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);
        dt=(DatePicker)findViewById(R.id.dt);
        dt.setMinDate(new Date().getTime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_agregar,menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          switch (item.getItemId()){
            case R.id.action_guardar:
                 agregarNota();
                break;
        }
        return true;
    }

    private void agregarNota(){
        String titulo=txtTitulo.getText().toString();
        String des=txtDescripcion.getText().toString();

        if(titulo.isEmpty()){
            txtTitulo.setError("Ingresa un titulo");
            txtTitulo.requestFocus();
        }
        else if(des.isEmpty()){
            txtDescripcion.setError("Ingresa una descripciòn");
            txtDescripcion.requestFocus();
        }
        else {
            //AQUÌ SE AGREGA LA NOTA A LA BASE DE DATOS
            Dbcrud dbcrud=new Dbcrud(this);
            Notas nota=new Notas();
            nota.setTitulo(titulo);

            nota.setDescripcion(des);
            nota.setFecha(new Date());
            //GUARDAMOS EN LA BD CON LA SIG INSTRUCCIÒN
            dbcrud.agregar(nota);

            Toast.makeText(this,"Nota agregada correctamente",Toast.LENGTH_SHORT)
                    .show();

        }


    }


}
