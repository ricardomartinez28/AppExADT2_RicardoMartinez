package com.example.a21759217.appexadt2_ricardomartinez.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a21759217.appexadt2_ricardomartinez.model.Evento;

public class EventoDatasource {

    private EventoSQLiteHelper esh;

    public EventoDatasource(Context contexto) {
        esh= new EventoSQLiteHelper(contexto);
    }

    public SQLiteDatabase openReadable() {
        return esh.getReadableDatabase();
    }
    public SQLiteDatabase openWriteable() {
        return esh.getWritableDatabase();
    }
    public void close(SQLiteDatabase database) {
        database.close();
    }


    public long registarEvento(Evento evento){

        SQLiteDatabase sdb = openWriteable();
        sdb.beginTransaction();

        ContentValues cv = new ContentValues();
        cv.put(EventoContract.EventoEntity.COLUMN_NAME,evento.getNombre());
        cv.put(EventoContract.EventoEntity.COLUMN_MUNICIPO,evento.getMunicipio());
        cv.put(EventoContract.EventoEntity.COLUMN_DESCRIPCION,evento.getDescripcion());
        cv.put(EventoContract.EventoEntity.COLUMN_FECHA,evento.getFecha());
        cv.put(EventoContract.EventoEntity.COLUMN_HORA,evento.getHora());

        long id= sdb.insert(EventoContract.EventoEntity.TABLE_NAME,null,cv);

        if(id!=-1){
            sdb.setTransactionSuccessful();
        }
        sdb.endTransaction();
        close(sdb);

        return id;
    }

    public Evento consultarEvento(String nombreEv){
        SQLiteDatabase sdb = openReadable();

        String select = "SELECT * FROM " + EventoContract.EventoEntity.TABLE_NAME +
                " WHERE " + EventoContract.EventoEntity.COLUMN_NAME + " = ?";

        String[] args = {nombreEv};

        Cursor cursor= sdb.rawQuery(select,args);

        Evento evento=null;
        int id;
        String nombre;
        String municipio;
        String descripcion;
        String fecha;
        String hora;

        if (cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_ID));
            nombre=cursor.getString(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_NAME));
            municipio=cursor.getString(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_MUNICIPO));
            descripcion=cursor.getString(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_DESCRIPCION));
            fecha=cursor.getString(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_FECHA));
            hora=cursor.getString(cursor.getColumnIndex(EventoContract.EventoEntity.COLUMN_HORA));
            evento= new Evento(id,nombre,municipio,descripcion,fecha,hora);

        }

        cursor.close();
        sdb.close();
        return evento;
    }

    public void modificarEvento(Evento evento){


        SQLiteDatabase sdb=openWriteable();
        sdb.beginTransaction();

        ContentValues cv= new ContentValues();

        cv.put(EventoContract.EventoEntity.COLUMN_NAME,evento.getNombre());
        cv.put(EventoContract.EventoEntity.COLUMN_MUNICIPO,evento.getMunicipio());
        cv.put(EventoContract.EventoEntity.COLUMN_DESCRIPCION,evento.getDescripcion());
        cv.put(EventoContract.EventoEntity.COLUMN_FECHA,evento.getFecha());
        cv.put(EventoContract.EventoEntity.COLUMN_HORA,evento.getHora());

        String clausulaWhere= EventoContract.EventoEntity.COLUMN_ID +" =?";
        String[] argumentos={String.valueOf(evento.getId())};

        sdb.update(EventoContract.EventoEntity.TABLE_NAME,cv,clausulaWhere,argumentos);

        sdb.setTransactionSuccessful();
        sdb.endTransaction();
        close(sdb);

    }

    public int borrarEvento(int idEvento){

        SQLiteDatabase sdb = openWriteable();
        sdb.beginTransaction();

        String clausulaWhere=EventoContract.EventoEntity.COLUMN_ID+" = "+idEvento;

        int i=sdb.delete(EventoContract.EventoEntity.TABLE_NAME,clausulaWhere,null);

        if(i==1){
            sdb.setTransactionSuccessful();
        }

        sdb.endTransaction();
        close(sdb);

        return i;
    }
}
