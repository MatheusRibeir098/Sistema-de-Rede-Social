
# 📚 Sistema de Rede Social

Este repositório contém um projeto desenvolvido como parte das atividades do curso técnico em Desenvolvimento de Sistemas. O objetivo é implementar um sistema básico de rede social utilizando Java puro, sem frameworks ou banco de dados, aplicando conceitos de programação orientada a objetos (POO).

## 📝 Descrição do Projeto
O sistema é uma aplicação de console que permite aos usuários:
- Gerenciar perfis de usuário (cadastro, login, atualização e exclusão).
- Criar, visualizar e interagir com posts.
- Gerenciar amizades e acessar um feed de notícias.

O projeto segue uma estrutura de pacotes organizada e utiliza coleções (`ArrayList`, `List`) para armazenamento de dados em memória.

---

## 📌 Funcionalidades Principais
### 1. Gerenciamento de Usuários
- Cadastro, login, atualização e exclusão de usuários.
- Busca e listagem de usuários.
- Validações: username e email únicos, senha segura.

### 2. Gerenciamento de Posts
- Criação, edição e exclusão de posts.
- Listagem de posts por usuário.
- Curtidas e comentários em posts.

### 4. Interface de Usuário
- Navegação interativa via menus no console.
- Mensagens claras para feedback e confirmações de ações.

---

## 🛠 Estrutura de Pacotes

```plaintext
com.redesocial/
├── modelo/       # Classes de modelo (Usuario, Post, Comentario)
├── gerenciador/  # Gerenciamento de dados (Usuários, Posts)
├── ui/           # Interface com usuário (menus)
├── util/         # Classes utilitárias
└── exception/    # Exceções personalizadas
```

---

## 📅 Detalhes da Atividade
- **Linguagem**: Java 17 ou superior.
- **Entrega**: Repositório GitHub público.
- **Prazo**: 25/11/2024.
- **Critérios de Avaliação**:
  - Funcionalidade (40%): Implementação completa e funcional.
  - Qualidade do código (30%): Organização, POO, boas práticas.
  - Versionamento (15%): Commits frequentes e bem descritos.
  - Documentação (15%): README.md e código bem documentados.

---

## 📖 Como Executar
1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/sistema-rede-social.git
   ```
2. **Compile o código**:
   Use um IDE como IntelliJ ou Eclipse, ou execute no terminal:
   ```bash
   javac -d bin src/com/redesocial/**/*.java
   ```
3. **Execute o sistema**:
   ```bash
   java -cp bin com.redesocial.Main
   ```

---

## 📌 Sugestões de Melhorias Futuras
- Persistência de dados com banco de dados.
- Interface gráfica.
- Integração com API REST.
- Sistema de notificações e mensagens privadas.

---

## 🖊 Autor
- **Nome**: Matheus de Paula Ribeiro
- **Curso**: Técnico em Desenvolvimento de Sistemas
