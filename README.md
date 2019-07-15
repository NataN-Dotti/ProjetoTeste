<h1> Teste Técnico - JL Informática </h1>

  <hr></hr>
  
  <h2>Pré-Requisitos</h2>
  <ul>
    <li>README bem descrito para implantação e utilização do sistema.</li>
    <li>Java 8</li>
    <li>Maven</li>
    <li>Tomcat</li>
    <li>PostgreSQL</li>
    <li>Github</li>
    <li>Swing (aplicação Desktop)</li>
    <li>JSF (aplicação Web)</li>
    <li>JPA (Hibernate ou Eclipselink)</li>
  </ul>
  
  <hr></hr>

  <h2>Sistema proposto</h2>
  <p>Uma empresa necessita de uma ferramenta para controlar manualmente o estoque de
  produtos diversos. Sabendo disto, desenvolver duas aplicações.</p>
  <ol>
    <li>Aplicação Desktop
      <ol>
        1.1. Tela para cadastrar e editar produtos<br>
        1.2. Tela para controlar a entrada e saída de estoque
      </ol>
    </li>
  </ol>
  
  <hr></hr>

  <h2>Sistema Desenvolvido (até o momento)</h2>
  <h3>Aplicação Desktop</h3>
  <p>O sistema desenvolvido até o momento conta com um padrão de arquitetura MVC (com uma camada extra para a conexão com o banco),
  bem como o padrão de projeto Singleton para obter a comunicação com o banco sem ter que instânciar a classe de conexão.
  O Front-End de Produto conta com as opções de Cadastrar, Atualizar e uma Tabela que lista e faz uma pesquisa dinâmica conforme o
  usuário vá digitando o nome do produto.</p>
