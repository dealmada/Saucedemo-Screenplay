package com.saucedemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saucedemo.models.DatosCompra;
import java.io.File;

public class JsonReader {

    public static DatosCompra leerDatosCompra(String rutaArchivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(rutaArchivo), DatosCompra.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
