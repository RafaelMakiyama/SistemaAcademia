function validar() {
    if (document.cad.altura.value == "") {
        alert("Campo altura vazio.");
        document.cad.altura.focus();
        return false;
    }

    if (document.cad.peso.value == "") {
        alert("Campo peso vazio.");
        document.cad.peso.focus();
        return false;
    }
    if (document.cad.peito.value == "") {
        alert("Campo peito vazio.");
        document.cad.peito.focus();
        return false;
    }
    if (document.cad.cintura.value == "") {
        alert("Campo cintura vazio.");
        document.cad.cintura.focus();
        return false;
    }
    if (document.cad.pantDireita.value == "") {
        alert("Campo panturrilha direita vazio.");
        document.cad.pantDireita.focus();
        return false;
    }
    if (document.cad.pantEsquerda.value == "") {
        alert("Campo panturrilha esquerda vazio.");
        document.cad.pantEsquerda.focus();
        return false;
    }

    if (document.cad.bracoDireito.value == "") {
        alert("Campo braço direito vazio.");
        document.cad.bracoDireito.focus();
        return false;
    }

    if (document.cad.bracoEsquerdo.value == "") {
        alert("Campo braço esquerdo vazio.");
        document.cad.bracoEsquerdo.focus();
        return false;
    }
   
    if (document.cad.antDireito.value == "") {
        alert("Campo antebraço direito vazio.");
        document.cad.antDireito.focus();
        return false;
    }
    
     if (document.cad.antEsquerdo.value == "") {
        alert("Campo antebraço esquerdo vazio.");
        document.cad.antEsquerdo.focus();
        return false;
    }
    if (document.cad.gluteo.value == "") {
        alert("Campo glúteo vazio.");
        document.cad.gluteo.focus();
        return false;
    }
};