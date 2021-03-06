/**
 *  The MIT License (MIT)
 * Copyright (c) 2014 Velik Georgiev Chelebiev
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Contendra todos los objetos de ImageSlider
var imageSliderObj = { };

$(document).ready(function(){
    var imageSliderElements = $("body .imageSlider");

    /**
     * Crea un ID para cada contenedor padre y ajusta
     * el contador de imagenes.
     */
    imageSliderElements.each(function(index) {
        var totalImageItems = $(this).find(".container > ul > li").length;
        var counterObj = $(this).find(".counter");
			
		  // Deshabilitamos la opcion Drag
		  $(this).on('dragstart', function(event) { event.preventDefault(); });
			
        /**
         * Si el contenedor de todo el conjunto no tiene
         * una ID le asignamos una.
         */
        if($(this).attr("id") == "" || $(this).attr("id") == null) {
            $(this).attr("id", "ImageSlider_" + index);
        }

        /** Ajustamos el contador de los imagenes. Se crea un div con forma circular para cada imagen **/
        if(counterObj.length > 0) {
            for(var i = 0; i < totalImageItems; i++) {
                counterObj.html(counterObj.html() + "<div class='dot' id='dot_" + $(this).attr("id") + "_" + i + "'></div>");
            }

            // Marcamos el primer ciculito como actual
            $("#dot_" + $(this).attr("id") + "_0").css("background-color", "#fff");
        }
    });

    /**
     * Agrega el evento onclick a las flechas para
     * cambiar a la imagen previa
     */
    imageSliderElements.on("click", ".btn.prev", function(event) {
        var parentObj = $(event.target).parent();

        if(imageSliderObj[parentObj.attr("id")] == null) {
            imageSliderObj[parentObj.attr("id")] = new ImageSlider();
        }

        imageSliderObj[parentObj.attr("id")].prev(parentObj);
    });

    /**
     * Agrega el evento onclick a las flechas para
     * cambiar a la imagen siguiente
     */
    imageSliderElements.on("click", ".btn.next", function(event) {
        var parentObj = $(event.target).parent();

        if(imageSliderObj[parentObj.attr("id")] == null) {
            imageSliderObj[parentObj.attr("id")] = new ImageSlider();
        }

        imageSliderObj[parentObj.attr("id")].next(parentObj);
    });
});

/**
 * Cambio entre imagenes.
 * Image Slided.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
function ImageSlider() {
    /**
     * La imagen actual mostrada al usuario
     * @type {Number}
     */
    var currentImage = 0;

    /**
     * Indica si existe algun cambio de imagenes en proceso.
     * @type {bool}
     */
    var animationPlay = false;

    /**
     * Cambia a la foto anterior.
     * 
     * @param {object} caller
     */
    this.prev = function (caller) {
        switchImage(false, caller);
    };

    /**
     * Cambia a la siguiente foto.
     * 
     * @param {object} caller
     */
    this.next = function (caller) {
        switchImage(true, caller);
    };

    /**
     * Cambio entre imagenes.
     * 
     * @param {bool} isNext TRUE si deseamos ver la imagen siguiente y FALSE en caso contrario
     * @param {object} caller El contenedor del conjunto
     * @author Velik Georgiev Chelebiev
     * @version 0.0.2
     */
    var switchImage = function (isNext, caller) {
        // Si existe alguna cambio de imagenes en proceso, NO permitimos
        // hacer otro mientras el activo no termine
        if (animationPlay === true)
            return;

        // La ID del padre es decir el DIV principal
        // que contendra todo el slider
        var parentID = caller.attr("id");

        // La velocidad de la transicion
        var speed = 1000;

        // Selector base
        var baseSelector = "#" + parentID + " > .container";

        // La imagen actual que se debera de esconder
        var currentImageObj = $(baseSelector + " > ul").children().eq(currentImage);

        // El total de las imagenes que existen en el contenedor
        var totalImageItems = $(baseSelector + " > ul > li").length;

        $("#dot_" + parentID + "_" + currentImage).css("background-color", "transparent");

        /**
         * Comprobamos si se quiere la imagen siguiente o la imagen previa.
         * Segun los requisimos a currentImage le indicamos la imagen
         * que se debe de mostrar.
         */
        if (isNext === true) {
            currentImage = (currentImage > (totalImageItems - 2)) ? 0 : currentImage + 1;
        } else {
            currentImage = (currentImage <= 0) ? totalImageItems - 1 : currentImage - 1;
        }

        // La siguiente imagen. Esa se debe de mostrar
        var nextImageObj = $(baseSelector + " > ul").children().eq(currentImage);

        /** 
         * Propiedas CSS de las imagenes.
         * imageSizeHideWidth y imageSizeShowWidth tendran un valor
         * positivo o negetivo en funcion de si la imagen es la siguiente o 
         * la previa. 
         */
        var imageSizeHideWidth = (isNext) ? $(baseSelector).css("width") : "-" + $(".container").css("width");
        var imageSizeShowWidth = (isNext) ? "-" + $(baseSelector).css("width") : $(".container").css("width");
        
        // Calculamos la distancia entre el elemento y el punto inicial del contenedor
        var imagePositionOnTop = -(currentImage * ($(baseSelector + " > ul > li > img").innerHeight() + $(baseSelector + " > ul > li > div").innerHeight())); 
        var containerHeight = $(baseSelector).css("height");

        // Indica que hay un cambio de imagenes en proceso
        animationPlay = true;

        // Escondemos la imagen actual
        currentImageObj.animate({
                left: imageSizeShowWidth
            }, (speed + 10), "linear", function() {
                // Para que los elementos no se pongan uno encima de otro
                // si redimensionamos la ventana hacemos invisible el elemento 
                // ... escondido :D
               currentImageObj.css( { "visibility":"hidden", "z-index":"0" });
            }
        );

        $("#dot_" + parentID + "_" + currentImage).css("background-color", "#fff");

        /**
         * Ajustamos la imagen a mostrar detras de la imagen actual
         * despues mediante un efecto liner de transicion la posicionamos
         * como imagen actual.
         */
        nextImageObj.css({
            top: imagePositionOnTop + "px", 
            left: imageSizeHideWidth,
            visibility: "visible", // hacemos el elemento visible
            "z-index": "10"
        });

        // La siguiente animacion muestra la nueva imagen
        nextImageObj.animate({
                left: "0"
            }, speed, "linear", function () {
                // Indicamos que la transicion de imagenes ha terminado
                animationPlay = false;
            }
        );
    };
}