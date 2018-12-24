(function ($) {
   /**
     * jqChart Spanish Translation
     * http://www.jqchart.com/ 
     * 
     * In order to use a particular language pack, you need to include the javascript language
     * pack to the head of your page, after the jQuery library reference (since language
     * packs depend on jQuery) and after referencing the jqChart javascript file.
     * 
     * <script src="../js/jquery.min.js" type="text/javascript"></script>
     * <script src="../js/jquery.jqChart.min.js" type="text/javascript"></script>
     * <script src="../js/i18n/chart.locale-xx.js" type="text/javascript"></script>
     **/
    $.jqChartDateFormat = {
        dayNames: [
            "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa",
            "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
        ],
        monthNames: [
            "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic",
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        ],
        amPm: ["am", "pm", "AM", "PM"],
        s: function (j) { return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th' },
        masks: {
            shortDate: "m/d/yyyy",
            shortTime: "h:MM TT",
            longTime: "h:MM:ss TT"
        }
    };
})(jQuery);
