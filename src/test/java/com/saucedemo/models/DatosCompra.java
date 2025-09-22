package com.saucedemo.models;

import java.util.List;

public class DatosCompra {
    private String usuario;
    private String contrasena;
    private List<String> productos;
    private Formulario formulario;

    // Getters
    public String getUsuario() {
        return usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public List<String> getProductos() {
        return productos;
    }
    public Formulario getFormulario() {
        return formulario;
    }

    public static class Formulario {
        private String nombre;
        private String apellido;
        private String codigoPostal;

        // Getters
        public String getNombre() {
            return nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public String getCodigoPostal() {
            return codigoPostal;
        }
    }
}
