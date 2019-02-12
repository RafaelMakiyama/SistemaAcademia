window.onload = function () {

 function enche_usuario() {

        $.ajax({
            url: 'ControleAtleta', //lugar onde a servlet está
            type: 'GET',
            data: {
                acao: 'selectEstado'
            },
            complete: function (e, xhr, result) {
                if (e.readyState == 4 && e.status == 200) {
                    try { //Converte a resposta HTTP JSON em um objeto JavaScript
                        var Obj = eval("(" + e.responseText + ")"); //Combo OS

                    } catch (err) { //
                        // Mostra Aviso
                        alert("Algo de errado aconteceu!");

                    }
                    if (Obj != null) {

                        for (var i = 0; i < Obj[0].length; i++) {
                            $("#selectusuario").append("<option value='" + Obj[0][i].idusuario + "'>" + Obj[0][i].email + Obj[0][i].email + "</option>");
                        }
                    }
                }

            }
        });
    }}