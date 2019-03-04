package com.example.a21759217.appexadt2_ricardomartinez.db;

import android.provider.BaseColumns;

public class EventoContract {

    public  static abstract class MunicipioEntity implements BaseColumns{

        public static final String TABLE_NAME="MUNICIPIOS";

        public static final String COLUMN_ID=BaseColumns._ID;
        public static final String COLUMN_NAME="NOMBRE";

    }

    public  static abstract class EventoEntity implements BaseColumns{

        public static final String TABLE_NAME="EVENTOS";

        public static final String COLUMN_ID=BaseColumns._ID;

        public static final String COLUMN_NAME="NOMBRE";
        public static  final String COLUMN_MUNICIPO="MUNICIPIO";
        public static final String COLUMN_DESCRIPCION="DESCRIPCION";
        public static final String COLUMN_FECHA="FECHA";
        public static final String COLUMN_HORA="HORA";

    }


}
