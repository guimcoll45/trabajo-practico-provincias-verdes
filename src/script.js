// BASE DE DATOS COMPLETA DE PROVINCIAS
const datosProvincias = {
    formosa: {
        titulo: "Formosa",
        texto: "Provincia del noreste argentino, con clima subtropical húmedo y temperaturas altas todo el año. Su territorio es mayormente llano, cubierto por selvas, humedales y ríos caudalosos como el Paraguay y el Bermejo. Es una región de enorme biodiversidad, conocida como uno de los pulmones verdes del país, con una vegetación densa y exuberante.",
        imagen: "imagenes/formosa.jpg"
    },
    misiones: {
        titulo: "Misiones",
        texto: "Ubicada en el extremo noreste, limita con Brasil y Paraguay. Su relieve es ondulado y está cubierto casi en su totalidad por la Selva Paranaense, una de las más importantes del mundo. Aquí se encuentran las famosas Cataratas del Iguazú, Patrimonio de la Humanidad. Predominan los bosques altos, ríos rápidos y una fauna y flora únicas en Argentina.",
        imagen: "imagenes/misiones.jpg"
    },
    corrientes: {
        titulo: "Corrientes",
        texto: "Provincia del litoral, rodeada por los ríos Paraná y Uruguay. Su paisaje combina llanuras, esteros, humedales y bosques de galería. Destacan los Esteros del Iberá, uno de los humedales más grandes del planeta, refugio de cientos de especies. El clima es subtropical, con veranos muy calurosos e inviernos suaves, ideal para el desarrollo de la vegetación.",
        imagen: "imagenes/corrientes.jpg"
    },
    chaco: {
        titulo: "Chaco",
        texto: "Parte de la región del Gran Chaco, en el norte del país. Su geografía presenta bosques altos, sabanas y humedales. Es una zona rica en recursos naturales, con especies adaptadas a climas con estaciones secas y húmedas. Su vegetación incluye árboles maderables y plantas resistentes, y es fundamental para la conservación de especies autóctonas.",
        imagen: "imagenes/chaco.jpg"
    },
    entre_rios: {
        titulo: "Entre Ríos",
        texto: "Situada entre los ríos Paraná y Uruguay, es una provincia de lomadas suaves, campos fértiles y abundante vegetación. Cuenta con selvas de río, bosques y humedales. Su clima es templado cálido, con lluvias todo el año. Es reconocida por su riqueza hídrica, su producción agropecuaria y sus parques naturales protegidos.",
        imagen: "imagenes/entre_rios.jpg"
    }
};

// FUNCIÓN QUE CAMBIA LA INFORMACIÓN AL HACER CLIC
function mostrarProvincia(codigo) {
    // Verificamos si la provincia existe en nuestra lista
    if (datosProvincias.hasOwnProperty(codigo)) {
        const provincia = datosProvincias[codigo];
        
        // Cambiamos el título
        document.getElementById("titulo-provincia").textContent = provincia.titulo;
        // Cambiamos el texto descriptivo
        document.getElementById("descripcion").textContent = provincia.texto;
        // Cambiamos la imagen y su descripción
        const img = document.getElementById("imagen-provincia");
        img.src = provincia.imagen;
        img.alt = "Imagen de la provincia de " + provincia.titulo;
    }
}
