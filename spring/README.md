# Tutorial de Execução do Projeto no PC da Faculdade

Este guia tem tudo que você precisa fazer para rodar o projeto do **Desafio 07** no computador da faculdade usando o XAMPP.

---

## 1. Banco de Dados (XAMPP e MySQL)

1. Abra o **XAMPP Control Panel**.
2. Clique no botão **Start** na linha do **Apache** e do **MySQL**.
3. Abra o navegador e acesse o **phpMyAdmin** na URL:
   ```text
   http://localhost/phpmyadmin
   ```
4. Na aba **SQL** do phpMyAdmin, abra o arquivo `database.sql` (que está na pasta principal `spring`), copie todo o conteúdo e cole na caixa de texto.
5. Clique em **Executar (Go)**. Isso vai criar o banco `prova3` e a tabela `cliente` automaticamente.

---

## 2. Iniciar o BackEnd (Java Spring)

1. Abra a sua IDE (Eclipse, VSCode, IntelliJ) no computador da faculdade.
2. Importe o projeto da pasta `clientes-api-rest`.
   - Lembre-se de certificar-se de que a IDE está usando o **Java 21**.
3. O BackEnd já está configurado para se conectar ao MySQL usando o usuário padrão do XAMPP (`root` com senha vazia).
4. Rode a classe principal do projeto (geralmente onde fica o `@SpringBootApplication`). 
5. O BackEnd começará a rodar na porta **8080**.

---

## 3. Iniciar o FrontEnd (Node.js)

1. Abra um terminal (ou prompt de comando) e navegue até a pasta `clientes-api-front`:
   ```bash
   cd caminho/para/sua/pasta/spring/clientes-api-front
   ```
2. Caso seja a primeira vez abrindo no PC da faculdade, instale as dependências executando:
   ```bash
   npm install
   ```
3. Depois que terminar de instalar, inicie o servidor rodando:
   ```bash
   node app.js
   ```
4. O servidor vai exibir no terminal: `Servidor rodando na porta 3000`.

---

## 4. Testar a Aplicação

1. Abra seu navegador de internet (Chrome, Firefox, etc).
2. Acesse a URL:
   ```text
   http://localhost:3000
   ```
3. Na tela de login, preencha:
   - **Usuário:** `dog`
   - **Senha:** `dog`
4. Aproveite! Agora você pode cadastrar, pesquisar, editar e excluir clientes.
