#encoding: UTF-8
#language: pt

Funcionalidade: Login no sistema Automation Exercise

  @valida
  Cenário: Login com validas
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema autentica o usuario e redireciona para a tela principal

  @invalida
  Cenário: Login invalida sem preenche os campos email e password
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo email
    E o usuario não preenche o campo password
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  @invalida
  Cenário: Login invalida sem peenche o campo no password
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario não preenche o campo password
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  @invalida
  Cenário: Login invalida sem preenche o campo no email
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo email
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema exibe a mensagem Preenche este campo

  @invalida
  Cenário: Login invalida preenche não correto no email
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "falhar@gmail.com"
    E o usuario preenche o campo password com "1234567890"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  @invalida
  Cenário: Login invalida preenche não correto no password
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "password_invalido"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  @invalida
  Cenário: Login invalida preenche não correto no email e password
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando localizar a seção Login to your account e o usuario preenche o campo email com "falhar@gmail.com"
    E o usuario preenche o campo password com "password_invalido"
    E o usuario clica no botao login
    Então o sistema login exibe a mensagem "Your email or password is incorrect!"

  @valida
  Cenário: Criar um conta que ja existe
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario clica no botao signup
    Então o sistema login exibe a mensagem "Email Address already exist!"

  @invalida
  Cenário: Cria um nome e não preenche email
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario não preenche o campo email
    E o usuario clica no botao signup
    Então o sistema exibe a mensagem Preenche este campo

  @invalida
  Cenário: Cria um email e não preenche nome
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo nome
    E localizar a seção New User Signup e o usuario preenche o campo email com "jefynhu@teste.com"
    E o usuario clica no botao signup
    Então o sistema exibe a mensagem Preenche este campo

  @invalida
  Cenário: Não preenche os campos no nome e email
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario não preenche o campo nome
    E localizar a seção New User Signup e o usuario não preenche o campo email
    E o usuario clica no botao signup
    Então o sistema exibe a mensagem Preenche este campo

  @valida
  Cenário: Preenche os campos no nome e email para criar conta
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com aleatório
    E o usuario clica no botao signup
    Então redireciona para a tela cadastrar