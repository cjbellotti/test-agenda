var currentRecord = {};
var currentDomicilioRecord = {};

var localidades = [];

var editing = false;
var editingDomicilio = false;

function save() {
    currentRecord.nombre = $('#nombre').val();
    currentRecord.apellido = $('#apellido').val();
    currentRecord.observaciones = $('#observaciones').val(); 

    $.ajax({
        method : 'POST',
        url : 'http://localhost:8080/personas',
        contentType : 'application/json',
        data : JSON.stringify(currentRecord),
        success : () => {
            currentRecord = {};
            alert('Se guardo la persona correctamente.');
            $('#nombre').val('');
            $('#apellido').val('');
            $('#observaciones').val('');
            $('#nombre').focus()
            load();
        },
        error : () => {
            alert('Ha ocurrido un error');
        }
    })
}

function load() {

    var lista = $('#lista');
    lista.html('');
    $.ajax({
        method : 'GET',
        url : 'http://localhost:8080/personas',
        success : (response) => {
            response.forEach((item) => {
                lista.append($(`<div class="lista-item d-flex justify-content-between"><span>${item.nombre} ${item.apellido}</span><button class="btn btn-primary" onclick="loadPersona(${item.id})">Ver</button></div>`));
            });
        },
        error : () => {
            alert('Ha ocurrido un error')
        }
    })

}

function loadPersona(id) {

    $.ajax({
        method : 'GET',
        url : 'http://localhost:8080/personas/' + id,
        success : function (response) {
            currentRecord = response;
            console.log(currentRecord);
            $('#nombre').val(response.nombre);
            $('#apellido').val(response.apellido);
            $('#observaciones').val(response.observaciones);
            cargarDomicilios();
            cargarContactos();
        },
        error : function () {
            alert('Ha ocurrido un error al leer la persona');
        }
    })
}

function cargarDomicilios() {
    var listaDomicilios = $('#lista-domicilios');
    listaDomicilios.html('');
    if (currentRecord.domicilios != null && currentRecord.domicilios.length > 0) {
        currentRecord.domicilios.forEach(domicilio => {
            listaDomicilios.append($(`
                        <div class="domicilio-item d-flex align-items-center justify-content-between">
                            <span>${domicilio.calle} ${domicilio.numero} Piso ${domicilio.piso}</span>
                            <span>${domicilio.localidades.nombre}</span>
                            <div>
                                <button class="btn btn-primary" onclick="editDomicilio(${domicilio.id})">Editar</button>
                                <button class="btn btn-danger" onclick="quitarDomicilio(${domicilio.id})">Borrar</button>
                            </div>
                        </div>
                        `))
        });
    }

}

function cargarContactos() {
    var listaContactos = $('#lista-contactos');
    listaContactos.html('');
    if (currentRecord.contactos != null && currentRecord.contactos.length > 0) {
        currentRecord.contactos.forEach(contacto => {
            listaContactos.append($(`
                        <div class="contacto-item d-flex align-items-center justify-content-between">
                            <span>${contacto.contacto}</span>
                            <span>${contacto.tipocontacto.nombre}</span>
                            <div>
                                <button class="btn btn-primary" onclick="editContacto(${contacto.id})">Editar</button>
                                <button class="btn btn-danger" onclick="quitarContacto(${contacto.id})">Borrar</button>
                            </div>
                        </div>
                        `))
        });
    }
}

function editDomicilio(id) {
    var formDomicilio = $('#form-domicilio');
    currentDomicilioRecord = currentRecord.domicilios.find(item => item.id == id);
    console.log(currentDomicilioRecord);
    $('#calle').val(currentDomicilioRecord.calle);
    $('#numero').val(currentDomicilioRecord.numero);
    $('#piso').val(currentDomicilioRecord.piso);
    $('#localidad').val(currentDomicilioRecord.localidades.id);
    formDomicilio.show();
}

function saveDomicilio() {
    console.log('Save Domicilio')
    currentDomicilioRecord.calle = $('#calle').val();
    currentDomicilioRecord.numero = parseInt($('#numero').val());
    currentDomicilioRecord.piso = parseInt($('#piso').val());
    currentDomicilioRecord.localidades = localidades.find(item => item.id == parseInt($('#localidad').val()));
    for (var i = 0; i < currentRecord.domicilios.length; i++) {
        console.log('Itera')
        console.log(currentRecord.domicilios[i].id, currentDomicilioRecord)
        if (currentRecord.domicilios[i].id == currentDomicilioRecord.id) {
            console.log('Acutaliza')
            currentRecord.domicilios[i] = currentDomicilioRecord;
            break;
        }
    }
    cerrarFormDomicilio();
    cargarDomicilios();
}
function cerrarFormDomicilio() {
    $('#form-domicilio').hide();
}

function loadLocalidades() {
    $.ajax({
        method : 'GET',
        url : 'http://localhost:8080/localidades',
        success : function (response) {
            localidades = response;
            var localidad = $('#localidad');
            localidad.html('<option value="0" disabled="true">Seleccione Localidad...</option>');
            localidades.forEach(item => {
                localidad.append($(`<option value="${item.id}">${item.nombre}</option>`));
            });
            localidad.val(0)
        }
    })
}
$(() => {
 load();   
 loadLocalidades();
})

