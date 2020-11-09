package com.desarrollo.lab1uni2_asynctask_recyclerview.ENTIDAD;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class TitulosVo implements Serializable {

    public TitulosVo(String titulo, String descripcion, String descripcionlarga, int imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.descripcionlarga = descripcionlarga;
        this.imagen = imagen;
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

    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    private String titulo;
    private String descripcion;
    private String descripcionlarga;
    private int imagen;


}
