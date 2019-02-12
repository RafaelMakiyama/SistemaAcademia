<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <link rel="stylesheet" href="tema/css/bootstrap2.css">
        <link rel="stylesheet" href="tema/css/bootstrap.min.css">

        <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

        <script src="${request.contextPath}js/jquery.js"></script>
        <script src="js/toastr.js"></script>

        <link type="text/css" rel="stylesheet" href="${request.contextPath}js/toastr.min.css">
        <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

        <title>Recuperar Usuário</title>

    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                </div>
                <div class="col-md-12">
                    <h1> Recuperar senha </h1>
                </div>

                <div class="col-md-12">
                    <form name="cad" action="ControleUsuario" method="post"  role="form" > 
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="txtEmail" id="txtEmail" placeholder="Entre com o email." required>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-default" name="acao" value="AtualizarSenha" type="submit">Recuperar</button>

                        </div>
                    </form>
                </div>
            </div>     
            <script src="${request.contextPath}js/jquery.maskedinput.js" type="text/javascript" charset="utf-8"></script>


            <%
                if (request.getAttribute("senhaSemSucesso") != null && request.getAttribute("senhaSemSucesso") == "true") {
            %>

            <script>toastr.error('E-mail não encontrado!')</script>
            <%
                }
            %>    

            <script>


                //BEGIN CHECKBOX & RADIO
                $('input[type="checkbox"]').iCheck({
                    checkboxClass: 'icheckbox_minimal-grey',
                    increaseArea: '20%' // optional
                });
                $('input[type="radio"]').iCheck({
                    radioClass: 'iradio_minimal-grey',
                    increaseArea: '20%' // optional
                });

                //END CHECKBOX & RADIO</script>


    </body>

</html>