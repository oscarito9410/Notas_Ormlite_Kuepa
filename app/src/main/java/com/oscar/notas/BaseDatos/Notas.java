package com.oscar.notas.BaseDatos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by oemy9 on 04/11/2017.
 */
@DatabaseTable(tableName = "Notas")
public class Notas
{
    public static final String _ID="ID";
    public static final String _TITULO="TITULO";
    public static final String _DESCRIPCION="DESCRIPCION";
    public static final String _FECHA="FECHA";

    @DatabaseField(columnName = _ID, generatedId = true)
    private int id;
    @DatabaseField(columnName = _TITULO)
    private String titulo;
    @DatabaseField(columnName =_DESCRIPCION )
    private String descripcion;
    @DatabaseField(columnName = _FECHA)
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
