package com.oscar.notas.BaseDatos;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by oemy9 on 04/11/2017.
 */

public class Dbcrud {
    private Context ctx;
    private Dbhelper dbhelper;

    private Dbhelper getDbhelper(){
        if(dbhelper==null){
            dbhelper= OpenHelperManager.getHelper(ctx,Dbhelper.class);
        }
        return dbhelper;
    }

    public void agregar(Notas n){
        try {
            getDbhelper().getNotaDao().create(n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notas> obtenerNotas() throws SQLException {
        List<Notas>list=getDbhelper().getNotaDao().queryForAll();
        return list;
    }

    public Dbcrud(Context ctx) {
        this.ctx = ctx;
    }



}
