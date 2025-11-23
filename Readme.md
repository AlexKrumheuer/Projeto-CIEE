<h2>Como rodar o projeto</h2>

<p>Abra o terminal do seu editor de código e digite:</p>

<pre>
<code>
git clone https://github.com/AlexKrumheuer/Projeto-CIEE.git
cd Projeto-CIEE/animais-info/
npm install
npm run dev

# Em outro terminal:
cd ./Projeto-CIEE/animalcare-hub
./mvnw spring-boot:run
</code>
</pre>

<p>Pronto, agora é só abrir o localhost do Vue e o projeto estará funcionando.</p>

<hr>

<h2>Objetivos</h2>
<p>
    Além do solicitado para o desafio, eu planejava criar uma forma de associar o cuidado ao animal cadastrado. 
    Por exemplo: um cachorro pode ter como cuidado "tomar banho 2 vezes na semana" ou "tomar vitaminas 1 vez na semana". 
    Contudo, no fim, não consegui terminar essa parte da associação. A aplicação ficou apenas com um CRUD para Cuidados e Animais.
</p>

<h2>Escolha de Tecnologias</h2>
<ul>
    <li>
        <strong>Vue.js:</strong> Entendo que o solicitado foi Angular ou React, mas esse é o framework web que mais tive contato até então. 
        Para o desafio preferi seguir com ele, já que o objetivo principal era verificar a lógica de programação do candidato.
    </li>
    <li>
        <strong>Springboot:</strong> Quanto ao framework para o Backend, escolhi Springboot por ser o que estou estudando atualmente.
    </li>
    <li>
        <strong>MySQL:</strong> O banco de dados foi feito com MySQL, escrevendo pelo Workbench.
    </li>
</ul>

<h2>Desafios</h2>
<p>
    O maior desafio definitivamente foi o backend. Mesmo sabendo a "teoria" de como funciona um backend e a lógica das APIs, 
    ainda não estou acostumado com a sintaxe do Springboot, então tive que pesquisar bastante e enfrentei diversos bugs.
</p>
<p>
    Quanto ao Frontend, tive dificuldade na sincronização das ações de editar ou criar tarefas. 
    Havia muitas possibilidades de interação do usuário, o que frequentemente ocasionava erros na atualização da tela.
</p>
