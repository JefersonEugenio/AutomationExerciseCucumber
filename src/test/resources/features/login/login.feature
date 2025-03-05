#encoding: UTF-8
#language: pt

Funcionalidade: Login no sistema Automation Exercise

  Cenário: Login com validas
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema autentica o usuario
    E redireciona para a tela principal