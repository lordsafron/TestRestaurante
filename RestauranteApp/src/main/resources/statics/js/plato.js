$(document).ready(function () {
    $("#add_plato").click(function () {

        
        var linea = $("#plantillaPlato").html();
        linea = linea.replace(/{ID}/g, $('#cargarPlato tbody tr').length + 1);
        linea = linea.replace(/{NOMBRE}/g, $("#plato").val());

        $("#cargarPlato tbody").append(linea);

    });

    $("#cargarPlato").bind('change keypress', function () {
        
        $('#cargarPlato tbody tr').each(function () {
            var precio = $(this).find('td').eq(1).find('input').val();
            var cantidad = $(this).find('td').eq(2).find('input').val();

            var total = parseInt(precio) * parseInt(cantidad);

            $(this).find('td').eq(4).find('span').html(total);
            
            calcularGranTotal();

        });

    });

    //$("#form").submit(function(){
    //    $("#plantillaPlato").remove();
    //    return;
    //});
});

function eliminarPlato(id) {
        $("#row_" + id).remove();
        calcularGranTotal();
    }
    
function calcularGranTotal() {
    var total = 0;
    $('span[id^="total_importe_"]').each(function() {
        total += parseInt($(this).html());
        
        $("#gran_total").html(total);
    });
}