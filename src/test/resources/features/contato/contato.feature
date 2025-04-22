#encoding: UTF-8
#language: pt

Funcionalidade: A pagina do contato

  Cenário: Validar envio bem-sucedido do formulário de contato
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Contact us
    E que o usuario esta na pagina de contato do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E o usuario preenche o campo email aleatorio
    E o usuario preenche o campo assunto
    E o usuario preenche o campo mensagem
    E o usuario seleciona arquivo
    Então o usuario clica no botao submit
    E o usuario clica alerta no botao ok
    E o sistema exibe a mensagem sucesso
    E o usuario clica no botao home
    E redireciona para a tela principal
