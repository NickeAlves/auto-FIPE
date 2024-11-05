# 🚗 Auto-FIPE

Auto-FIPE é um projeto desenvolvido em Java que consome a API FIPE para realizar consultas de preços de veículos a partir de informações como marca, modelo e ano. Este projeto foi desenvolvido usando Java com Maven e o framework Spring, sendo testado via Postman para as chamadas de API.

# 💼 Funcionalidades

    Consultar informações de veículos usando a API FIPE
    Permite busca personalizada por marca, modelo e ano do veículo
    Retorna dados relevantes como o preço do veículo

# 💻 Tecnologias Utilizadas

    Linguagem Principal: Java
    Gerenciador de Dependências: Maven
    Framework: Spring (sem dependências de web)
    Ferramenta para Consultas API: Postman
    API Utilizada: FIPE API
        🔗 URL Base: https://parallelum.com.br/fipe/api/v1/

# 🔄 Estrutura do Projeto

auto-fipe  
|_ .idea  
|_ .mvn  
|_ src  
|    |_ main  
|    |    |_ java  
|    |         |_ br.com.auto_fipe  
|    |              |_ model  
|    |              |    |_ Dados.java  
|    |              |    |_ Modelos.java  
|    |              |    |_ Veiculo.java  
|    |  
|    |              |_ principal  
|    |              |    |_ main.java  
|    |  
|    |              |_ service  
|    |                   |_ ConsumoApi.java  
|    |                   |_ ConverteDados.java  
|    |                   |_ IConverteDados.java  
|    |  
|    |              |_ AutoFipeApplication.java  
|_ target  

# 📋 Descrição das Principais Classes

    Modelos e Veiculo (Pacote: model): Representam as estruturas de dados retornadas da API, incluindo propriedades como código, nome, e modelo.
    ConsumoApi (Pacote: service): Gerencia as requisições HTTP para a API FIPE.
    ConverteDados e IConverteDados (Pacote: service): Realizam a conversão de dados JSON para os objetos Java.
    AutoFipeApplication: Classe principal que inicializa a aplicação.

# 🧩 Como Executar

    Pré-requisitos:
        JDK 8 ou superior
        Maven
        Postman (para testar as consultas)

    Configuração:
        Clone o repositório e abra o projeto na sua IDE preferida.

    Executar o Projeto:
        Navegue até a classe AutoFipeApplication e execute-a;
        1º - Escolha o automóvel desejado (Carros, Motos ou Caminhões);
        2º - Informe o código da marca desejada, conforme as marcas disponibilizadas pelo programa;
        3º - Diante os modelos disponíveis da marca desejada, digite um trecho do modelo desejado;
        4º - Será filtrado de acordo com o modelo desejado, informe o código do modelo específico;

        Por fim, de acordo com as escolhas, será impresso os dados:
          Marca:
          Modelo:
          Ano:
          Valor (R$):
          Combustível:
