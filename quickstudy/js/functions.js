function cadastrarNovoProfessor() {
    
    $.ajax({
        url: 'http://127.0.0.1:7200/cadastraProfessor',
        type: 'POST',
        data: ({
            email: $('#email').val(),
            senha: $('#senha').val(),
            cpf: $('#cpf').val(),
            nome: $('#nome').val(),
            formacao: $('#formacao').val(),
        }),
        success: function (response) {
            console.log(response.message);
            window.location.href="meuperfil.html"
        },
        error: function (event) {
            msgError(event);
        }
    });
}
function submitNovoCurso() {
    $.ajax({
        url: 'http://127.0.0.1:7200/adicionaCurso',
        type: 'POST',
        data: ({
            nome: $('#nome').val(),
            categoria: $('#categoria').val(),
            descrição: $('#descrição').val(),
        }),
        success: function (response) {
            console.log(response.message);
            window.location.href="meuscursos.html"
        },
        error: function (event) {
            msgError(event);
        }
    });
}
