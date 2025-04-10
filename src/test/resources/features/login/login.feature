#encoding: UTF-8
#language: pt

Funcionalidade: Login no sistema Automation Exercise

  Cenário: Login com validas
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema autentica o usuario
    E redireciona para a tela principal

  Cenário: Login invalida sem preenche os campos email e password
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo email
    E o usuario não preenche o campo password
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  Cenário: Login invalida sem peenche o campo no password
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario não preenche o campo password
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  Cenário: Login invalida sem preenche o campo no email
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo email
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  Cenário: Login invalida preenche não correto no email
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "falhar@gmail.com"
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  Cenário: Login invalida preenche não correto no password
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "password_invalido"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  Cenário: Login invalida preenche não correto no email e password
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "falhar@gmail.com"
    E o usuario preenche o campo password com "password_invalido"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  Cenário: Criar um conta que ja existe
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario clica no botao signup
    Então o sistema login exibe a mensagem "Email Address already exist!"

    Cenário: Cria um nome e não preenche email
      Dado que o usuario esta na pagina de login do sistema Automation Exercise
      Quando o usuario preenche o campo nome com "Jeferson"
      E localizar a seção New User Signup e o usuario não preenche o campo email
      E o usuario clica no botao signup
      Então o sistema exibe a mensagem Preenche este campo

  Cenário: Cria um email e não preenche nome
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo nome
    E localizar a seção New User Signup e o usuario preenche o campo email com "jefynhu@teste.com"
    E o usuario clica no botao signup
    Então o sistema exibe a mensagem Preenche este campo

  Cenário: Não preenche os campos no nome e email
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo nome
    E localizar a seção New User Signup e o usuario não preenche o campo email
    E o usuario clica no botao signup
    Então o sistema exibe a mensagem Preenche este campo

  Cenário: Preenche os campos no nome e email para criar conta
    Dado que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com "eugenio@teste.com"
    E o usuario clica no botao signup
    Então redireciona para a tela cadastrar