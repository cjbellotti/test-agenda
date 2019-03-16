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

var currentRecord = null;

function save() {
    if (currentRecord == null) {
        currentRecord = {};
    }
    currentRecord.nombre = $('[name="nombre"]').val();
    currentRecord.apellido = $('[name="apellido"]').val();
    currentRecord.observaciones = $('[name="observaciones"]').val();

    $.ajax({
        type : "POST",
        url : "http://localhost:8080/personas",
        contentType : 'application/json',
        data : JSON.stringify(currentRecord),
        success : function () {
            alert("Persona guardada correctamente.");
            currentId = null;
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
            var lista = $('#lista');
            lista.html('');
            // respuesta.forEach(function (item) {
            //     console.log(item)
            //     var li = $(`
            //                 <li>
            //                     ${item.nombre} <button onclick="modificar(${item.id})">Modificar</button>
            //                 </li>
            //                 `);
            //     lista.append(li);
            // })

            for (var i = 0; i < respuesta.length; i++) {
                var item = respuesta[i];
                console.log(item)
                var li = $(`
                            <li>
                                ${i}. ${item.nombre} <button onclick="modificar(${item.id})">Modificar</button>
                            </li>
                            `);
                lista.append(li);
            }
        },
        error : function() {
            alert("Ocurrió un error");
        }
    });
}

function modificar(id) {
    $.ajax({
        method : 'GET',
        url : 'http://localhost:8080/personas/' + id,
        success : function (response) {
            console.log(response);
            currentRecord = response;
            $('[name=nombre]').val(response.nombre);
            $('[name=apellido]').val(response.apellido);
            $('[name=observaciones]').val(response.observaciones);
        },
        error : function() {
            alert('Error al cargar la persona')
        }
    })
}

$(document).ready(() => {
    console.log('Iniciando....')
    load();
});