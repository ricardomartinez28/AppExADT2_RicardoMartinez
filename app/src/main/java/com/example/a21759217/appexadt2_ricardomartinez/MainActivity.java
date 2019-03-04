package com.example.a21759217.appexadt2_ricardomartinez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a21759217.appexadt2_ricardomartinez.db.EventoDatasource;
import com.example.a21759217.appexadt2_ricardomartinez.db.MunicipioDatasource;
import com.example.a21759217.appexadt2_ricardomartinez.model.Evento;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etMunicipio;
    private EditText etDescripcion;
    private EditText etFecha;
    private EditText etHora;

    private Button btnRegistrar;
    private Button btnConsultar;
    private Button btnModificar;
    private Button btnEliminar;

    Evento evento=null;

    EventoDatasource eds;
    MunicipioDatasource mds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=findViewById(R.id.etNombre);
        etMunicipio=findViewById(R.id.etMunicipio);
        etDescripcion=findViewById(R.id.etDescripcion);
        etFecha=findViewById(R.id.etFecha);
        etHora=findViewById(R.id.etHora);

        eds= new EventoDatasource(this);
        mds= new MunicipioDatasource(this);

        btnRegistrar=findViewById(R.id.btnRegistrar);
        btnConsultar=findViewById(R.id.btnConsultar);
        btnModificar=findViewById(R.id.btnModificar);
        btnEliminar=findViewById(R.id.btn_eliminar);

    }

    public void registrarEvento(View v){

         String nombre=etNombre.getText().toString().trim();
         String municipio=etMunicipio.getText().toString().trim();
         String descripcion=etDescripcion.getText().toString().trim();
         String fecha=etFecha.getText().toString().trim();
         String hora=etHora.getText().toString().trim();
        evento= new Evento(nombre,municipio,descripcion,fecha,hora);

         if(nombre.isEmpty() || municipio.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || hora.isEmpty()){
             Toast.makeText(this,"Debes introducir todos los datos",Toast.LENGTH_LONG).show();

         }
         else{
             if(mds.consultarMunicipio(municipio.toUpperCase())){

                 long resultado = eds.registarEvento(evento);

                 if(resultado!=-1){
                     Toast.makeText(this,"Se han introducido los datos correctamente",Toast.LENGTH_LONG).show();


                 }else{
                     Toast.makeText(this,"Se ha producido un error en la insercion",Toast.LENGTH_LONG).show();

                 }

             }else{

                 Toast.makeText(this,"El municipio introducido no existe",Toast.LENGTH_LONG).show();

             }
         }
    }
    public void consultarEvento(View v){

        String nombre=etNombre.getText().toString().trim();

        if (nombre.isEmpty()){
            Toast.makeText(this,"Debes introducir el nombre de un evento",Toast.LENGTH_LONG).show();

        }else{
            evento= eds.consultarEvento(nombre);

            if(evento==null){

                Toast.makeText(this,"El evento no existe",Toast.LENGTH_LONG).show();

            }else{
                etNombre.setText(evento.getNombre());
                etMunicipio.setText(evento.getMunicipio());
                etDescripcion.setText(evento.getDescripcion());
                etFecha.setText(evento.getFecha());
                etHora.setText(evento.getHora());

                etNombre.setEnabled(false);

                btnRegistrar.setEnabled(false);
                btnConsultar.setEnabled(false);
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }
        }

    }
    public void modificarEvento(View v){

        String nombre=etNombre.getText().toString().trim();
        String municipio=etMunicipio.getText().toString().trim();
        String descripcion=etDescripcion.getText().toString().trim();
        String fecha=etFecha.getText().toString().trim();
        String hora=etHora.getText().toString().trim();

        evento= new Evento((eds.consultarEvento(nombre)).getId(),nombre,municipio,descripcion,fecha,hora);

        if(nombre.isEmpty() || municipio.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || hora.isEmpty()){
            Toast.makeText(this,"Debes introducir todos los datos",Toast.LENGTH_LONG).show();

        }else{

            if(mds.consultarMunicipio(municipio.toUpperCase())){

                eds.modificarEvento(evento);
                Toast.makeText(this,"El evento se ha modificado correctamente",Toast.LENGTH_LONG).show();

                etNombre.setText("");
                etMunicipio.setText("");
                etDescripcion.setText("");
                etFecha.setText("");
                etHora.setText("");

                etNombre.setEnabled(true);

                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnRegistrar.setEnabled(true);
                btnConsultar.setEnabled(true);


            }else{
                Toast.makeText(this,"El municipio introducido no existe",Toast.LENGTH_LONG).show();

            }


        }


    }
    public void eliminarEvento(View v){

        String nombre=etNombre.getText().toString().trim();

        evento=eds.consultarEvento(nombre);

        int resultado=eds.borrarEvento(evento.getId());
        if(resultado==1){
            Toast.makeText(this,"Se ha borrado correctamente",Toast.LENGTH_LONG).show();

            etNombre.setText("");
            etMunicipio.setText("");
            etDescripcion.setText("");
            etFecha.setText("");
            etHora.setText("");

            etNombre.setEnabled(true);

            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnRegistrar.setEnabled(true);
            btnConsultar.setEnabled(true);


        }else{
            Toast.makeText(this,"No se ha podido borrar ",Toast.LENGTH_LONG).show();

        }


    }
}
