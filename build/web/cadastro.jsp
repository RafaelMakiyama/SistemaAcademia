<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <link rel="stylesheet" href="tema/css/bootstrap2.css">
        <link rel="stylesheet" href="tema/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="${request.contextPath}js/jquery.maskedinput.min.js" type="text/javascript" ></script>
        <script src="${request.contextPath}js/valida-usuario.js" type="text/javascript" ></script>
      
        <title>Cadastro Usuário</title>

    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                </div>
                <div class="col-md-12">
                    <h1> Cadastrar Usuário </h1>
                </div>

                <div class="col-md-12">
                    <form name="cad" action="ControleUsuario" method="post"  onsubmit="return validar();" > 
                        <input type="hidden" value="salvarUsuario" name="acao">
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="txtEmail" id="txtEmail" placeholder="Entre com o email." required>
                        </div>
                        <div class="form-group">
                            <label>Login</label>
                            <input type="text" class="form-control" name="txtLogin" id="txtLogin" placeholder="Entre com usuário."   data-error="Você deve marcar este campo!" ></div>
                        <div class="help-block with-errors"></div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" class="form-control" name="txtSenha" placeholder="Entre com a descrição." required>
                        </div>
                        <div class="form-group">
                            <label>Perfil de acesso</label>
                            <select id="txtPerfil" name="txtPerfil">
                                <option value="Personal">Personal</option>
                                <option value="Atleta">Atleta</option>
                            </select>
                        </div>
                      
                        <input type="submit" name="acao" value="Adicionar" class="btn btn-default" onclick="validarDadosUsuario();">
                    </form>
                </div>
            </div>
        </div>     
  <script src="${request.contextPath}js/jquery.maskedinput.js" type="text/javascript" charset="utf-8"></script>



    </body>

</html>
