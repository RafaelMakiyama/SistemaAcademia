<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iTrainner </title>
        <!-- Importação do CSS -->
        <link id="bootstrap-style" href="tema/css/bootstrap.min.css" rel="stylesheet">

        <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
            <link type="text/css" rel="stylesheet" href="js/toastr.js">
            <link type="text/css" rel="stylesheet" href="js/toastr.min.css.js">

        <script src="js/jquery.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <link href="tema/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="js/toastr.min.css" rel="stylesheet">
        <link id="base-style" href="tema/css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="tema/css/style-responsive.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <!-- FIM da importação CSS -->

    </head>

    <body>
        <div class="container-fluid-full">
            <div class="row-fluid">

                <div class="row-fluid">
                    <div class="login-box">
                        <div class="icons">
                            <a href="index.jsp"><i class="halflings-icon home"></i></a>
                            <a href="cadastro.jsp"><i class="halflings-icon user"></i></a>
                        </div>
                        <h2>Entre na sua conta</h2>
                        <form class="form-horizontal" action="ControleUsuario" method="get">
                            <fieldset>

                                <div class="input-prepend" title="Username" >
                                    <span class="add-on"><i class="halflings-icon user"></i></span>
                                    <input class="input-large span10" name="txtLogin" id="txtLogin" type="text" placeholder="Digite usuario"/>
                                </div>
                                <div class="clearfix"></div>

                                <div class="input-prepend" title="Password">
                                    <span class="add-on"><i class="halflings-icon lock"></i></span>
                                    <input class="input-large span10" name="txtSenha" id="password" type="password" placeholder="Digite a senha."/>
                                </div>
                                <div class="clearfix"></div>

                                <label class="remember" for="remember"><input type="checkbox" id="remember" />Lembrar - me</label>

                                <div class="button-login">	
                                    <input  type="hidden" value="validar" name="acao">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                                <div class="clearfix"></div>
                        </form>
                        <hr>
                        <h3> Não possui cadastro?</h3>
                        <p>
                            Junte-se a nós, <a href="cadastro.jsp"> cadastre-se.</a>
                        </p>
                        <h3>Esqueceu sua senha?</h3>
                        <p>
                            Sem problema, <a href="recuperar-senha.jsp">clique aqui</a> e recupere sua senha.
                        </p>	

                    </div><!--/span-->
                </div><!--/row-->
            </div>

        </div><!--/.fluid-container-->


        <%
            if (request.getAttribute("falhalogin") != null && request.getAttribute("falhalogin") == "true") {
        %>

        <script>toastr.error('Usuário ou Senha Inválidos')</script>
        <%
            }
        %>

        <%
            if (request.getAttribute("senhaComSucesso") != null && request.getAttribute("senhaComSucesso") == "true") {
        %>

        <script>toastr.success('Uma nova senha foi enviada para seu Email.')</script>
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

