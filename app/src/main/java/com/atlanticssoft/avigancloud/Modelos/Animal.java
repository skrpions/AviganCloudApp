package com.atlanticssoft.avigancloud.Modelos;

import java.util.Date;

public class Animal {

    private int idanimal;
    private String nombre;
    private String codigo;
    private String qr;
    private Date fechanacimiento;
    private Date fechacompra;
    private double costo;

    public Animal() {}

    public Animal(int idanimal, String nombre, String codigo, String qr, Date fechanacimiento, Date fechacompra, double costo)
    {
        this.idanimal = idanimal;
        this.nombre = nombre;
        this.codigo = codigo;
        this.qr = qr;
        this.fechanacimiento = fechanacimiento;
        this.fechacompra = fechacompra;
        this.costo = costo;
    }


    public int getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(int idanimal) {
        this.idanimal = idanimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
