package com.example.a21759217.appexadt2_ricardomartinez.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a21759217.appexadt2_ricardomartinez.model.Municipio;

import java.util.ArrayList;

public class EventoSQLiteHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME="EventosDB";
    static final int DATABASE_VERSION = 2;
    ArrayList<Municipio> listaIniciales;

    static final String CREATE_TABLE_MUNICIPIOS=
            "CREATE TABLE "+EventoContract.MunicipioEntity.TABLE_NAME+"( "+
                    EventoContract.MunicipioEntity.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    EventoContract.MunicipioEntity.COLUMN_NAME+" TEXT NOT NULL);";


    static final String CREATE_TABLE_EVENTOS=
            "CREATE TABLE "+EventoContract.EventoEntity.TABLE_NAME+"( "+
                    EventoContract.EventoEntity.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    EventoContract.EventoEntity.COLUMN_NAME+" TEXT NOT NULL,"+
                    EventoContract.EventoEntity.COLUMN_MUNICIPO+" TEXT UNIQUE,"+
                    EventoContract.EventoEntity.COLUMN_DESCRIPCION+" TEXT NOT NULL,"+
                    EventoContract.EventoEntity.COLUMN_FECHA+" TEXT NOT NULL,"+
                    EventoContract.EventoEntity.COLUMN_HORA+" TEXT NOT NULL);";

    public EventoSQLiteHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EVENTOS);
        db.execSQL(CREATE_TABLE_MUNICIPIOS);
        iniciarDatos();
        cargarDatos(db);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EventoContract.EventoEntity.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EventoContract.MunicipioEntity.TABLE_NAME);
        onCreate(db);
    }

    private void iniciarDatos() {

        listaIniciales = new ArrayList<Municipio>();

        listaIniciales.add(new Municipio("LA ACEBEDA"));
        listaIniciales.add(new Municipio("ALALPARDO"));
        listaIniciales.add(new Municipio("ALAMEDA DEL VALLE"));
        listaIniciales.add(new Municipio("ALCOBENDAS"));
        listaIniciales.add(new Municipio("ALGETE"));
        listaIniciales.add(new Municipio("EL ATAZAR"));
        listaIniciales.add(new Municipio("BERZOSA"));
        listaIniciales.add(new Municipio("EL BERRUECO"));
        listaIniciales.add(new Municipio("BRAOJOS"));
        listaIniciales.add(new Municipio("BUITRAGO"));
        listaIniciales.add(new Municipio("BUSTARVIEJO"));
        listaIniciales.add(new Municipio("CABANILLAS DE LA SIERRA"));
        listaIniciales.add(new Municipio("LA CABRERA"));
        listaIniciales.add(new Municipio("CANENCIA"));
        listaIniciales.add(new Municipio("CERVERA DE BUITRAGO"));
        listaIniciales.add(new Municipio("COLMENAR VIEJO"));
        listaIniciales.add(new Municipio("FUENTE EL SAZ"));
        listaIniciales.add(new Municipio("GARGANTA DE LOS MONTES"));
        listaIniciales.add(new Municipio("GARGANTILLA"));
        listaIniciales.add(new Municipio("GASCONES"));
        listaIniciales.add(new Municipio("GUADALIX DE LA SIERRA"));
        listaIniciales.add(new Municipio("LA HIRUELA"));
        listaIniciales.add(new Municipio("HORCAJO DE LA SIERRA"));
        listaIniciales.add(new Municipio("HORCAJUELO DE LA SIERRA"));
        listaIniciales.add(new Municipio("LOZOYA"));
        listaIniciales.add(new Municipio("LOZOYUELA"));
        listaIniciales.add(new Municipio("MADARCOS"));
        listaIniciales.add(new Municipio("MANZANARES EL REAL"));
        listaIniciales.add(new Municipio("MIRAFLORES DE LA SIERRA"));
        listaIniciales.add(new Municipio("EL MOLAR"));
        listaIniciales.add(new Municipio("MONTEJO DE LA SIERRA"));
        listaIniciales.add(new Municipio("NAVALAFUENTE"));
        listaIniciales.add(new Municipio("NAVARREDONDA"));
        listaIniciales.add(new Municipio("OTERUELO DEL VALLE"));
        listaIniciales.add(new Municipio("PAREDES DE BUITRAGO"));
        listaIniciales.add(new Municipio("PATONES"));
        listaIniciales.add(new Municipio("PRÁDENA DEL RINCÓN"));
        listaIniciales.add(new Municipio("PEDREZUELA"));
        listaIniciales.add(new Municipio("PINILLA DEL VALLE"));
        listaIniciales.add(new Municipio("PIÑUECAR"));
        listaIniciales.add(new Municipio("PUEBLA DE LA SIERRA"));
        listaIniciales.add(new Municipio("PUENTES VIEJAS"));
        listaIniciales.add(new Municipio("RASCAFRÍA"));
        listaIniciales.add(new Municipio("RIBATEJADA "));
        listaIniciales.add(new Municipio("RIDUEÑA"));
        listaIniciales.add(new Municipio("ROBLEDILLO"));
        listaIniciales.add(new Municipio("ROBREGORDO"));
        listaIniciales.add(new Municipio("SAN AGUSTÍN DEL GUADALIX"));
        listaIniciales.add(new Municipio("SAN SEBASTIÁN DE LOS REYES"));
        listaIniciales.add(new Municipio("SERNA DEL MONTELA"));
        listaIniciales.add(new Municipio("SOMOSIERRA"));
        listaIniciales.add(new Municipio("SOTO DEL REAL"));
        listaIniciales.add(new Municipio("TALAMANCA DE JARAMA"));
        listaIniciales.add(new Municipio("TORRELAGUNA"));
        listaIniciales.add(new Municipio("TORREMOCHA DE JARAMA"));
        listaIniciales.add(new Municipio("TRES CANTOS"));
        listaIniciales.add(new Municipio("VALDEMANCO "));
        listaIniciales.add(new Municipio("VALDEOLMOS"));
        listaIniciales.add(new Municipio("VALDEPIÉLAGOS"));
        listaIniciales.add(new Municipio("VALDETORRES DEL JARAMA"));
        listaIniciales.add(new Municipio("EL VELLÓN"));
        listaIniciales.add(new Municipio("VENTURADA"));
        listaIniciales.add(new Municipio("VILLAVIEJA LOZOYA"));

    }
    private void cargarDatos(SQLiteDatabase db) {

        db.beginTransaction();
        ContentValues cv=null;

        for (Municipio municipio: listaIniciales){
            cv = new ContentValues();

            cv.put(EventoContract.MunicipioEntity.COLUMN_NAME,municipio.getNombre());

            db.insert(EventoContract.MunicipioEntity.TABLE_NAME,null, cv);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }
/*






PINILLA DEL VALLE
PIÃ‘UECAR
PUEBLA DE LA SIERRA
PUENTES VIEJAS
RASCAFRÃA
RIBATEJADA
RIDUEÃ‘A
ROBLEDILLO
ROBREGORDO
SAN AGUSTÃN DEL GUADALIX
SAN SEBASTIÃN DE LOS REYES
SERNA DEL MONTELA
SOMOSIERRA
SOTO DEL REAL
TALAMANCA DE JARAMA
TORRELAGUNA
TORREMOCHA DE JARAMA
TRES CANTOS
VALDEMANCO
VALDEOLMOS
VALDEPIÃ‰LAGOS
VALDETORRES DEL JARAMA
EL VELLÃ“N
VENTURADA
VILLAVIEJA LOZOYA
 */

}
