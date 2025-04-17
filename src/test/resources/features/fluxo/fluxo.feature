#encoding: UTF-8
#language: pt

Funcionalidade: Fluxo de compra

  Cenário: Finalizar a compra de um produto
    Dado que o usuario esta na pagina de principal do sistema Automation Exercise
    E o usuario clica aba Login
    Quando o usuario preenche o campo email com "jeferson@teste.com"
    E o usuario preenche o campo password com "1q2w3e4r5t6y7u8i9o0p"
    E o usuario clica no botao login
    Então o sistema autentica o usuario e redireciona para a tela principal
    E o usuario escolhe o produto "Blue Top" e clica no botao Add to cart
    E Clica no link View Cart
    E Clica no botão Proceed To Checkout
    E Validacao nome do produto
    E Validacao preco do produto
    E Validacao quantidade do produto
    E Validacao total do produto
    E Clicar no botao Place Order
    E o usuario preenche o campo nome do cartao "jeferson dbserver"
    E o usuario preenche o campo numero do cartao "5612 7894 0321 7410"
    E o usuario preenche o campo CVC do cartao "570"
    E o usuario preenche o campo mes do cartao "06"
    E o usuario preenche o campo ano do cartao "2030"
    E Clica no botao Pay and Confirm Order
    Então o sistema exibe a mensagem "ORDER PLACED!"
    E o usuario clica no botao Continue