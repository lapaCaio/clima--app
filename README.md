# Gerenciamento de Dados Climáticos

## Descrição do Projeto

Esta aplicação Java foi desenvolvida para gerenciar dados climáticos utilizando o padrão de projeto MVP (Model-View-Presenter) Passive View e Swing para a interface gráfica. O projeto é gerenciado com Maven e faz uso do JFreeChart para exibir gráficos. A aplicação permite a inserção, listagem e remoção de registros climáticos, e inclui funcionalidades para registro de logs de operações realizadas.
## Estrutura do Projeto
```
src
│
└── main
    │
    └── java
        │
        └── com.pss
            │
            ├── dadosclima
            │   ├── logador
            │   ├── model
            │   ├── presenter
            │   ├── view
            │   └── DadosClima.java
            │
            ├── enums
            │
            └── service
│
pom.xml
```
## Funcionalidades

- **Inserção de Registros Climáticos:** Tela para adicionar novos registros climáticos.
- **Listagem e Remoção de Registros Climáticos:** Tela para listar e remover registros existentes.
- **Gráficos Climáticos:** Apresentação de dados climáticos em formato de gráfico utilizando JFreeChart.
- **Configurações:** Tela acessível pelo menu para configurar formato de logs.
- **Log de Operações:** Registro de operações de inclusão e remoção de registros, gravando data, hora e tipo de operação.
- **Atualização Automática:** Atualização de todas as telas e do rodapé da tela principal ao inserir ou remover um registro, utilizando o padrão Observer.
- **Interface MDI:** Utilização do MDI (Multiple Document Interface) para navegação entre telas abertas.

# Dependências

- Java 11+
- Maven 3.6.0+
- JFreeChart 1.5.3

# Configuração e Execução

## Configurar o Maven

Certifique-se de que você tem o Maven instalado e configurado em seu sistema. Adicione as dependências necessárias no arquivo `pom.xml`.

## Executar a Aplicação

Para executar a aplicação, use o seguinte comando Maven na raiz do projeto:

```sh
mvn clean install
mvn exec:java -Dexec.mainClass="com.example.Main"
```
## Navegação na Aplicação

Ao iniciar a aplicação, todas as telas (painéis) serão abertas automaticamente e não poderão ser fechadas. Apenas a tela de Configurações estará acessível pelo menu. Utilize a interface MDI para navegar entre as telas.

## Padrões de Projeto Utilizados

- **MVP Passive View**: Gerencia a separação entre a lógica de apresentação e a lógica de negócios.
- **Observer**: Utilizado para atualizar as telas e o rodapé da tela principal ao inserir ou remover registros.
- **Adapter**: Utilizado para registrar logs em diferentes formatos configurados.

## Contribuição

Este projeto foi desenvolvido em dupla conforme solicitado no exercício. Contribuições adicionais podem ser feitas através de pull requests.
