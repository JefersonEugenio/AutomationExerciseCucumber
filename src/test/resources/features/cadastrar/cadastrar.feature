#encoding: UTF-8
#language: pt

Funcionalidade: Cadastrar no sistema Automation Exercise

  Cenário: Cadastras com validas
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com aleatório
    E o usuario clica no botao signup
    E redireciona para a tela cadastrar
    E o usuario clica no botao de radio Mr.
    E o usuario preenche o campo criar uma senha com "0123456789"
    E o usuario seleciona DAY com "10"
    E o usuario seleciona MONTH com "May"
    E o usuario seleciona YEAR com "1999"
    E o usuario clica no checkout SIGN UP FOR OUR NEWSLETTER!
    E o usuario clica no checkout RECEIVE SPECIAL OFFERS FROM OUR PARTNERS!
    E o usuario preenche o campo primeiro nome com "Jeferson"
    E o usuario preenche o campo sobrenome com "Oliveira Silva"
    E o usuario preenche o campo company com "DBServer"
    E o usuario preenche o campo address com "Av. Ipiranga"
    E o usuario seleciona COUNTRY com "United States"
    E o usuario preenche o campo state com "Texas"
    E o usuario preenche o campo city com "Dallas"
    E o usuario preenche o campo zipcode com "56123408"
    E o usuario preenche o campo mobile number com "9032145687"
    Então o usuario clica no botao Create Account
    E o sistema exibe a mensagem "ACCOUNT CREATED!"
    E o usuario clica no botao Continue

  Cenário: Cadastro preenchendo apenas campos obrigatórios
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    E que o usuario esta na pagina de login do sistema Automation Exercise
    Quando o usuario preenche o campo nome com "Jeferson"
    E localizar a seção New User Signup e o usuario preenche o campo email com aleatório
    E o usuario clica no botao signup
    E redireciona para a tela cadastrar
    E o usuario preenche o campo criar uma senha com "0123456789"
    E o usuario seleciona DAY com "10"
    E o usuario seleciona MONTH com "May"
    E o usuario seleciona YEAR com "2005"
    E o usuario preenche o campo primeiro nome com "Jeferson"
    E o usuario preenche o campo sobrenome com "Oliveira Silva"
    E o usuario preenche o campo address com "Av. Ipiranga"
    E o usuario seleciona COUNTRY com "United States"
    E o usuario preenche o campo state com "Texas"
    E o usuario preenche o campo city com "Dallas"
    E o usuario preenche o campo zipcode com "56123408"
    E o usuario preenche o campo mobile number com "9032145687"
    Então o usuario clica no botao Create Account
    E o sistema exibe a mensagem "ACCOUNT CREATED!"
    E o usuario clica no botao Continue
