Desafio #7DaysOfCode
Este repositório contém a minha solução para o Desafio #7DaysOfCode, onde tenho como objetivo aprender e aplicar várias habilidades técnicas em um projeto real.

Dia 1: Consumindo a API do IMDB
No primeiro dia do desafio, o objetivo é consumir a API do IMDB (Internet Movie Database) para pesquisar os Top 250 filmes e imprimir o JSON correspondente no console da IDE.

O IMDB é uma das plataformas mais famosas que agrega informações sobre filmes, séries, programas de TV, atores e outros elementos relacionados ao mundo do cinema e da televisão.

Etapas:
Criei uma conta no IMDB para obter uma chave de acesso ao serviço (API Key). Importante: essa chave não deve ser commitada no Github ou em qualquer outro repositório!

Usei o site do Spring Initializr (https://start.spring.io/) para criar um novo projeto Spring Boot.

Implementei um serviço para consumir a API do IMDB usando o RestTemplate do Spring Framework. Este serviço faz uma chamada GET para a API e deserializa a resposta JSON em um objeto Java.

Imprimi a resposta JSON no console da IDE.

Tecnologias Utilizadas:
Java
Spring Boot
Spring Web
Jackson (para deserialização JSON)
Como Executar o Projeto
Para executar este projeto, você precisará ter o Java e o Maven instalados na sua máquina.

Em seguida, faça o clone do projeto:
git clone https://github.com/seuusuario/seuprojeto.git

Vá para o diretório do projeto:
cd seuprojeto

E execute o projeto com o Maven:
mvn spring-boot:run

Agora você deve ver a saída do programa no console.

Nota: Substitua "seuusuario" e "seuprojeto" pelo nome de usuário e nome do projeto correspondente no GitHub.

Fique atento para o próximo dia de desafio onde expandirei ainda mais este projeto!
