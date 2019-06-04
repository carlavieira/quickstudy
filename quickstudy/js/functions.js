function fazerLogin(){
    $.ajax({
        url: 'http://127.0.0.1:7200/validaUsuario',

        type: 'POST',

        data:({
            user: $('#login').val(),
            senha: $('#senha').val()
        }),

        success: function(response){
            switch(response.status){
                case(1):
                window.location.href = "meuperfil.html";
                break;
                case(2):
                alert('Senha incorreta!')
                break;
                case(3):
                alert('Usuário inexistente! Cadastre-se no sistema.')
                break;

            }
        },

        error: function(event) {
            msgError(event);
         }

    })
}


function cadastrarNovoUsuario() {
    $.ajax({
        url: 'http://127.0.0.1:7200/cadastraUsuario',
        type: 'POST',
        data: ({
            usuario: $('#usuario').val(),
            senha: $('#senha').val(),
            nome: $('#nome').val(),
            email: $('#email').val(),
            cpf: $('#cpf').val(),
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

function submitNovaTurma() {
    $.ajax({
        url: 'http://127.0.0.1:7200/adicionaTurma',
        type: 'POST',
        data: ({
            // curso: $('#curso').val(),
            data_inicio: $('#data_inicio').val(),
            data_fim: $('#data_fim').val(),
            duracao: $('#duracao').val(),
            preco: $('#preco').val(),
            qtd_min: $('#qtd_min').val(),
            qtd_max: $('#qtd_max').val(),
        }),
        success: function (response) {
            console.log(response.message);
            window.location.href="minhasTurmas.html"
        },
        error: function (event) {
            msgError(event);
        }
    });
}

// function mostraDados() {

//     console.log('Yeah');

//     $.ajax({
//         url: 'http://127.0.0.1:7200/mostraDados',

//         type: 'POST',

//         data: ({
//         }),

//         success: function (response) {
//             if (response.status == 0) {
//                 console.log('Status 0');
//                 console.log(response.type);
//             }

//             else if (response.status == 1) {
//                 console.log('Status 1');
//                 var dados = '';
//                 response.dados[ `<div class="produtoVisualizar"> Usuário: ${usuario} <br>
//                     Senha: ${senha} <br> Nome: ${nome} <br>
//                     Email: ${email} <br> CPF: ${cpf} <br> Formação: ${formacao}</div>`
//             ];
//                 $('#dados').html(dados);
//             }
//         },

//         error: function (event) {
//         }
//     })

// }
