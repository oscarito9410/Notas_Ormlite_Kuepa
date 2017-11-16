package com.oscar.notas.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by oemy9 on 04/11/2017.
 */

public class Dbhelper extends OrmLiteSqliteOpenHelper {
    public static final int VERSION=    1;
    public static final String DB_NAME="NOTAS.db";

    public Dbhelper (Context ctx){

        super(ctx,DB_NAME,null,VERSION);
    }

   private Dao<Notas,Integer>notaDao;

   public Dao<Notas,Integer>getNotaDao() throws SQLException {
       if(notaDao==null){
           notaDao=getDao(Notas.class);
       }
       return notaDao;
   }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource,Notas.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
    }
}
