function submitNovoProfessor() {
    $.ajax({
        url: 'http://127.0.0.1:7200/cadastraProfessor',
        type: 'POST',
        data: ({
            email: $('#nome').val(),
            senha: $('#senha').val(),
            cpf: $('#cpf').val(),
            nome: $('#senha').val(),
            formacao: $('#formacao').val(),
        }),
        success: function (response) {
            console.log(response.message);
            window.location.replace("meuperfil.html")
        },
        error: function (event) {
            msgError(event);
        }
    });
}
