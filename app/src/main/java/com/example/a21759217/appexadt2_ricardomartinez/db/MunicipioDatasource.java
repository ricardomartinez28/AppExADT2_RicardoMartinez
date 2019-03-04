package com.example.a21759217.appexadt2_ricardomartinez.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a21759217.appexadt2_ricardomartinez.model.Municipio;

public class MunicipioDatasource {

    private EventoSQLiteHelper esh;

    public MunicipioDatasource(Context contexto) {
        esh= new EventoSQLiteHelper(contexto);
    }

    public SQLiteDatabase openReadable() {
        return esh.getReadableDatabase();
    }
    public SQLiteDatabase openWriteable() {
        return esh.getWritableDatabase();
    }

    public void close(SQLiteDatabase database){
        database.close();
    }

    public boolean consultarMunicipio(String municipio){

        SQLiteDatabase sdb=openReadable();

        String select = "SELECT * FROM " + EventoContract.MunicipioEntity.TABLE_NAME +
                " WHERE " + EventoContract.MunicipioEntity.COLUMN_NAME + " = ?";
        String[] args={municipio};

        Cursor cursor=sdb.rawQuery(select,args);

        Municipio municipioConsulta=null;

        int id;
        String nombre;

        if(cursor.moveToFirst()) {
            id= cursor.getInt(cursor.getColumnIndex(EventoContract.MunicipioEntity.COLUMN_ID));
            nombre= cursor.getString(cursor.getColumnIndex(EventoContract.MunicipioEntity.COLUMN_NAME));

            municipioConsulta= new Municipio(id,nombre);
        }

        if(municipioConsulta!=null){
            return true;
        }else{
            return false;
        }

    }


}
