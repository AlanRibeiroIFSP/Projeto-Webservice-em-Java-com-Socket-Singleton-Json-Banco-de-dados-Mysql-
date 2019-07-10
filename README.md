<ol><hr>
<h3><li>Tecnologias/padrões </li></h3>
<ul> 
      <li>WEBSERVICE  </li>
      <li>SOCKET      </li>
      <li>SINGLETON   </li> 
      <li>JSON        </li>
      <li>BD MySQL    </li> 
      <li>JAVA        </li> 
</ul><hr>   
      
<h3><li>Descrição Geral</li></h3>
 
<h4><p align="justify">
 
Este projeto é baseado em Padrões de Projetos (Design Patterns) chamado Singleton. O Padrão Singleton tem como definição garantir que uma classe tenha apenas uma instância de si mesma e que forneça um ponto global de acesso a ela.

</p><p align="justify">
 
A comunicação entre é realizada através de sockets java disponibilizadas para serem usadas por nós no pacote java.net.
</p><p align="justify">
Possui um banco de dados MySQL, tendo como base um cliente e um servidor para demonstrar foi utilizado dois projeto. O primeiro projeto (ServerSocket) é o server ou servidor que recebe várias soluções e através dele são feitas as queries com as operações do banco de dados.
</p><p align="justify">      
O segundo projeto (CaixaEletronico) é a parte cliente, caracterizada com o padrão de projeto Singleton. Detalhando o processo de envio dos dados entre cliente e servidor foi inserido o JSON, ele é um formato de representação de dados baseado na linguagem de programação Javascript, simplificando chave e valor, sendo um dos formatos mais utilizados para comunicação entre serviços web (webservices).
</p></h4><hr>
<h3><li>Passo a passo</li></h3>
<h4>
<ul><li align="justify">
 
1º Passo: Instalar um servidor web, neste projeto foi utilizado o Xampp que fornece um pacote com banco de dados servidor e Apache e entre outros.
</li> <br> 
<li  align="justify">
2º Passo: Criação do banco de dados, ao fazer o download dos arquivos disponíveis aqui neste projeto existe um chamado dbcaixaeletronico.sql,  é através deste que será realizado a criação do banco, através do phpmyadmin disponível no Xampp, para isso o usuário deve criar o banco com o título  de dbcaixaeletronico em seguida importe o arquivo com extensão .sql.
</li><br><li  align="justify">
3º Passo: Como este projeto não está compilado é necessário que rode ele no netbeans IDE de desenvolvimento de projetos java, sendo necessários todos os requisitos exigidos para tal funcionalidade.
</li>
</ul>
</h4>
</ol>
