package com.provinciasverdes.negocio;

import com.provinciasverdes.modelo.RegistroEnergia;
import com.provinciasverdes.modelo.Reporte;
import com.provinciasverdes.enumeraciones.TipoReporte;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorReporte {

    public Reporte generarReporte(TipoReporte tipo, List<RegistroEnergia> datos) {
        if (datos == null || datos.isEmpty()) {
            return null;
        }
        return new Reporte(0, tipo, new Date(), datos);
    }
}
