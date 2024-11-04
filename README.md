
# Equipe NEXUS - Sistema de Recomendação Personalizado 📚💻

### **Documentação da Aplicação**

Bem-vindo à documentação da aplicação **Java Advanced - Sistema de Recomendação Personalizado**, uma plataforma que oferece recomendações personalizadas de cursos e trilhas de desenvolvimento profissional, ajudando os usuários a aprimorar suas habilidades.

---

## 1. Objetivo da Aplicação 📝
A aplicação foi desenvolvida com o objetivo de fornecer recomendações personalizadas de educação e desenvolvimento profissional para seus usuários, utilizando técnicas avançadas de programação em Java.

---

## 2. Integrantes do Grupo 👥

- **Ruan Guedes de Campos**: RM551096 Desenvolvedor Full Stack. Responsável pelo desenvolvimento do backend e integração com o banco de dados.
- **Ana Beatriz Bento Silva**: RM552536 Desenvolvedora Frontend. Responsável pela criação da interface de usuário e pela experiência do usuário (UX).
- **Guilherme Costa Batista**: RM551173 Engenheiro de Dados. Responsável pelo pipeline de dados, coleta e estruturação das informações usadas no sistema de recomendação.
- **Harthley Fernandes Teixeira Gomes**: RM551359 Especialista em Machine Learning. Responsável pelo desenvolvimento dos algoritmos de recomendação e análise de dados.

---

## 3. Instruções para Rodar a Aplicação ⚙️

Siga as etapas abaixo para configurar e rodar a aplicação localmente:

1. **Clone o repositório do projeto:**
   ```bash
   git clone https://github.com/ruanJS/Java_cs.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd Java_cs
   ```

3. **Instale as dependências necessárias:**
   ```bash
   mvn clean install
   ```

4. **Inicie o servidor de desenvolvimento:**
   - Abra o projeto no IntelliJ ou Eclipse e execute a classe principal.

5. **Abra o navegador e acesse a aplicação:**
   - URL: [http://localhost:8080](http://localhost:8080)

---

## 4. Diagramas do Sistema 📊

Aqui está uma imagem representando os principais diagramas da arquitetura do sistema e a lógica de funcionamento. _(Adicione a imagem do diagrama aqui)_

---

## 5. Vídeo Apresentando a Proposta Tecnológica 🎥

Assista ao vídeo que demonstra nossa proposta tecnológica e a funcionalidade da aplicação:
- **[Link para o vídeo](https://youtu.be/d3qjxVHY7Gw)** 

---

## 6. Documentação da API (Listagem de Endpoints) 📑

Abaixo estão os principais endpoints da API disponíveis para interação com o sistema:

### Endpoints para Usuários
- **Criar Usuário**
  - **POST** `/users` 
    - *URL:* [http://localhost:8080/users](http://localhost:8080/users)
  
- **Buscar Novo Usuário**
  - **GET** `/users/new` 
    - *URL:* [http://localhost:8080/users/new](http://localhost:8080/users/new)

- **Atualizar Usuário pelo ID**
  - **PUT** `/api/users/{id}` 
    - *URL:* [http://localhost:8080/api/users/{id}](http://localhost:8080/api/users/{id})

- **Deletar Usuário pelo ID**
  - **DELETE** `/api/users/{id}` 
    - *URL:* [http://localhost:8080/api/users/{id}](http://localhost:8080/api/users/{id})

- **Buscar Usuário pelo ID**
  - **GET** `/api/users/{id}` 
    - *URL:* [http://localhost:8080/api/users/{id}](http://localhost:8080/api/users/{id})

- **Listar Todos os Usuários**
  - **GET** `/api/users` 
    - *URL:* [http://localhost:8080/api/users](http://localhost:8080/api/users)

### Endpoints para Cursos
- **Atualizar Curso pelo ID**
  - **PUT** `/courses/{id}` 
    - *URL:* [http://localhost:8080/courses/{id}](http://localhost:8080/courses/{id})

- **Deletar Curso pelo ID**
  - **DELETE** `/courses/{id}` 
    - *URL:* [http://localhost:8080/courses/{id}](http://localhost:8080/courses/{id})

- **Buscar Curso pelo ID**
  - **GET** `/courses/{id}` 
    - *URL:* [http://localhost:8080/courses/{id}](http://localhost:8080/courses/{id})

- **Exibir Página para Editar Curso**
  - **GET** `/courses/{id}/edit` 
    - *URL:* [http://localhost:8080/courses/{id}/edit](http://localhost:8080/courses/{id}/edit)

- **Criar Curso**
  - **POST** `/courses` 
    - *URL:* [http://localhost:8080/courses](http://localhost:8080/courses)

- **Listar Todos os Cursos**
  - **GET** `/courses` 
    - *URL:* [http://localhost:8080/courses](http://localhost:8080/courses)

- **Mostrar o Formulário para Adicionar um Curso**
  - **GET** `/courses/add` 
    - *URL:* [http://localhost:8080/courses/add](http://localhost:8080/courses/add)

- **Enviar o Formulário para Adicionar um Curso**
  - **POST** `/courses/add` 
    - *URL:* [http://localhost:8080/courses/add](http://localhost:8080/courses/add)

- **Listar os Cursos do Usuário Logado**
  - **GET** `/courses/my` 
    - *URL:* [http://localhost:8080/courses/my](http://localhost:8080/courses/my)

## Tecnologias Utilizadas
- Spring Framework
- Spring Boot Security
- Spring Actuator
- Loombok
- Lambda
- Oracle DB
- RabbitMQ
- Spring Boot
- Thymeleaf (para templates HTML)

## Como Executar o Projeto
1. Certifique-se de que o Maven ou Gradle está instalado.
2. Clone o repositório.
3. Navegue até o diretório do projeto.
4. Execute `mvn spring-boot:run` ou `gradle bootRun` para iniciar o servidor.
5. Acesse o sistema pelo navegador em [http://localhost:8080](http://localhost:8080).

## Contribuição
Sinta-se à vontade para contribuir com melhorias ou correções. 

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
---

### Fique à vontade para contribuir ou reportar problemas diretamente no repositório! 🚀
