/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willy
 */
public class Farmacia {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idFarmacia;
    private String nombre;
    private String direccion;
    private String numero;
    private int activo;

    public Farmacia() {
    }

    public Farmacia(int idFarmacia, String nombre, String direccion, String numero, int activo) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.activo = activo;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM farmacias";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM farmacias WHERE idFarmacia = " + idFarmacia;
        DefaultTableModel res = dataAccess.Query(query);
        idFarmacia = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
        direccion = (String) res.getValueAt(0, 2);
        numero = (String) res.getValueAt(0, 3);
        activo = (int) res.getValueAt(0, 4);
    }

    public boolean Add() {
        //Insertar a la tabla
        String query = "INSERT INTO farmacias(nombre, direccion, numero, activo) "
                + "VALUES('" + nombre + "','" + direccion + "','" + numero + "," + activo + ")";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM farmacias WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        //Actualizar tabla
        String query = "UPDATE farmacias SET "
                + "nombre = '" + nombre + "', "
                + "direccion = '" + direccion + "', "
                + "numero = '" + numero + "', "
                + "activo = " + activo + " "
                + "WHERE idFarmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }

}
