Desafio #7DaysOfCode
Este repositório contém a minha solução para o Desafio #7DaysOfCode, onde tenho como objetivo aprender e aplicar várias habilidades técnicas em um projeto real.

Dia 1: Consumindo a API do IMDB
No primeiro dia do desafio, o objetivo é consumir a API do IMDB (Internet Movie Database) para pesquisar os Top 250 filmes e imprimir o JSON correspondente no console da IDE.

Dia 2: Testando a Resposta da API
No segundo dia do desafio, a tarefa é testar a resposta da API criada no primeiro dia. Nesse sentido, o objetivo é garantir que a API esteja funcionando corretamente e retornando o resultado esperado. 
Utilizamos classes e anotações do Spring Framework para criar um teste automatizado, o qual verifica se a chamada da API retorna um resultado com status 200 OK e um conteúdo não vazio.

Dia 3: Modelando a Classe Movie
No terceiro dia do desafio, organizei a estrutura do meu projeto criando a classe Movie. Essa classe encapsula os atributos de um filme, como título, URL da imagem, nota e ano.
Utilizei o recurso record do Java para criar uma classe imutável de forma simples e concisa. Agora, em vez de ter várias listas separadas, utilizo uma única List<Movie>, onde cada instância representa um filme.

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
