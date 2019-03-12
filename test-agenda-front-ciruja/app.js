$('#enviar').click(function (e) {
    e.preventDefault();
    e.stopPropagation();
    save();
});

$('#refresh').click(function (e) {
    e.preventDefault();
    e.stopPropagation();
    load();
});
function save() {
    var nombre = $('[name="nombre"]').val();
    var apellido = $('[name="apellido"]').val();
    var observaciones = $('[name="observaciones"]').val();

    $.ajax({
        type : "POST",
        url : "http://localhost:8080/personas",
        contentType : 'application/json',
        data : JSON.stringify({
            "nombre" : nombre,
            "apellido" : apellido,
            "observaciones" : observaciones
        }),
        success : function () {
            alert("Persona guardada correctamente.");
            load();
        },
        error : function() {
            alert("Ocurrió un error");
        }
    })
}

function load() {
    $.ajax({
        type : 'GET',
        url : 'http://localhost:8080/personas',
        success : function (respuesta) {
            var ul = $('#lista');
            ul.html('');
            respuesta.forEach(function (item) {
                console.log(item)
                var li = $('<li></li>').html(item.nombre);
                ul.append(li);
            })
        },
        error : function() {
            alert("Ocurrió un error");
        }
    });
}

$(document).ready(() => {
    console.log('Iniciando....')
    load();
});