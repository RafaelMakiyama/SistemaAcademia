function validar() {
    if (document.cad.txtLogin.value == "") {
        alert("Por favor, preencha o campo login.");
        document.cad.txtLogin.focus();
        return false;
    }
    if (document.cad.txtLogin.value.length < 5 ) {  
        alert("Login deve ser maior do que 5 caracteres.");
        document.cad.txtLogin.focus();
        return false;
    }
}

