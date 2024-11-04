# Spring Kafka Project

Este projeto utiliza **Spring Boot** e **Apache Kafka** para implementar um sistema de mensagens e gerenciamento de dados de carros à venda, incluindo um serviço de análise de dados para gerar estatísticas sobre as publicações. A aplicação conta com uma API REST para gerenciar os dados e utiliza Kafka para comunicação assíncrona entre os serviços.

## Funcionalidades

- **Publicação e Consumo de Mensagens**: Microsserviços que publicam e consomem mensagens de tópicos Kafka.
- **ms-data (Analytics Service)**: Processa e armazena dados analíticos, como o número de posts por marca, modelo e preços dos carros.
- **Configuração com Docker Compose**: Configuração de Kafka e Zookeeper para simplificar o gerenciamento de contêineres.
- **Monitoramento com Kafka UI e Conduktor**: Monitoramento de tópicos e mensagens usando o Kafka UI e Conduktor.

## Microsserviços

### API

A **API** é o ponto central para manipulação dos dados de vendas de carros e proprietários, permitindo a criação, listagem, atualização e exclusão de dados. A API é responsável por enviar eventos de novos posts de carros à venda para o Kafka, onde serão consumidos pelo serviço de análise **ms-data**.

- Porta: **8085**
- Principais endpoints:
  - **CarPostController**:
    - **POST** `/api/car/post`: Publica um novo carro para venda e envia os dados para um tópico Kafka.
    - **GET** `/api/car/posts`: Retorna uma lista de carros à venda.
    - **PUT** `/api/car/{id}`: Atualiza os dados de um carro à venda, identificando-o pelo `id`.
    - **DELETE** `/api/car/{id}`: Remove um carro da lista de vendas, identificando-o pelo `id`.
  - **OwnerPostController**:
    - **POST** `/owner`: Cria um novo proprietário de carro.

### ms-car

O **ms-car** é o microsserviço que gerencia as operações sobre os dados de vendas de carros, além de se comunicar com outros serviços para manter os dados sincronizados. Ele utiliza o Kafka para receber e enviar mensagens e usa o **RestTemplate** para fazer chamadas a serviços externos, incluindo o gerenciamento de dados do proprietário.

- Principais responsabilidades:
  - Receber dados de novos carros à venda e atualizá-los ou removê-los conforme necessário.
  - Comunicar-se com outros serviços via chamadas REST e Kafka.
  - Implementar lógica de negócio para validações e operações sobre os dados de carros à venda.

### ms-data (Analytics Service)

O **ms-data** é responsável por receber e processar mensagens do tópico Kafka `car-post-topic`, contendo dados de novos carros publicados para venda. Ele armazena estatísticas, como:

- **Marca do Carro**: Conta a quantidade de posts por marca.
- **Modelo do Carro**: Conta a quantidade de posts por modelo.
- **Preço por Modelo**: Armazena o preço de cada publicação do modelo.

### Estrutura do ms-data

1. **KafkaConsumerConfigs**: Configuração do consumidor Kafka para o serviço de análise, incluindo o deserializador para `CarPostDto`.
2. **KafkaConsumerMessage**: Ouve as mensagens do tópico `car-post-topic` e delega para o `PostAnalyticsService`.
3. **PostAnalyticsServiceImpl**: Contém a lógica para armazenar dados analíticos, usando repositórios para gerenciar contagens de posts por marca, modelo e preços.

## Arquitetura do Projeto

1. **Controller Layer**: Exposição dos endpoints REST para manipulação dos dados de vendas e proprietários.
2. **Service Layer**: Implementação da lógica de negócio para criação, atualização e exclusão de registros.
3. **Kafka Integration**: Integração com Kafka para envio e consumo de mensagens.
4. **Analytics Service (ms-data)**: Microsserviço separado para coleta e armazenamento de dados analíticos.
5. **Configurações**: `application.properties` com porta do servidor e configurações do Kafka.

## Tecnologias Utilizadas

- **Java** e **Spring Boot**
- **Apache Kafka** e **Zookeeper**
- **Docker e Docker Compose**
- **Kafka UI** e **Conduktor**

## Pré-requisitos

- **Docker** e **Docker Compose**
- **Java 17** ou superior
