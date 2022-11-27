<img src="https://portal.ufpel.edu.br/wp-content/themes/Portal/imagens/header.svg">
<h2> Trabalho final da disciplina de Programação de Sistemas </h2>
<h2> Desenvolvido por Arthur Souza, Hector Fernandes, Rafael Rocha, Matheus Cardoso, Willian do Espirito Santo, Leonardo
  Marotta, Patrick Rosa </h2>
<h2> O emulador de Computador Hipotético possui </h2>
<ul>
  <li> Memória </li>
  <p> Memória do computador onde todas informações e dados são armazenados de modo sequencial, com exceção da pilha </p>
  <ul>
    <li> Registradores </li>
    <ol>
      <li> PC - Contador de Programa </li>
      <li> SP - Ponteiro de Pilha </li>
      <li> ACC - Acumulador </li>
      <li> MOP - Modo de Operação </li>
      <li> RI - Registrador de Instrução </li>
      <li> RE - Registrador de Memória </li>
    </ol>
    <li> Modos de Endereçamento </li>
    <ol type="1">
      <li> Direto </li>
      <li> Indireto </li>
      <li> Imediato </li>
    </ol>
    <li> Pilha </li>
    <p> Usada para armazenar os endereços de retornos de sub-rotinas </p>
    <p> Armazenada na última posição de memória e incrementada de modo contrário, possuindo o tamanho máximo de memória-2 </p>
    <li> Instruções </li>
    <ol type="0">
      <li> ADD </li>
      <li> BR </li>
      <li> BRNEG </li>
      <li> BRPOS </li>
      <li> BRZERO </li>
      <li> CALL </li>
      <li> COPY </li>
      <li> DIVIDE </li>
      <li> LOAD </li>
      <li> MULT </li>
      <li> READ </li>
      <li> RET </li>
      <li> STOP </li>
      <li> STORE </li>
      <li> SUB </li>
      <li> WRITE </li>
      <br>
  </ul>
  <li> Montador </li>
  <p> Responsável pela tradução do código assembly em linguagem de máquina, traduzindo cada instrução do programa
    para uma sequência representando a instrução </p>
  <p> Usado para criar uma tabela de símbolos, realiza a montagem do código e também a classifica quanto ao modo de endereçamento das instruções </p>
  <p> Suas saídas são um código objeto (nome_do_arquivo.obj) e um arquivo lst (nome_do_arquivo.lst)</p>

  <li> Processador de Macros </li>
  <p> De maneira geral, o processador de macros deve reconhecer as definições de macros no programa, inclusive
    macros aninhadas, salvar as definições e fazer a sua expansão posteriormente </p>
  <p> É feita a atualização e a expansão das macros, através de uma tabela auxiliar, na qual podemos procurar as
    definições de macro e onde elas terminam</p>
  <p> Sua saída salva o conteúdo em um código asm (MASMAPRG.asm) que é o código expandido</p>

  <li> Ligador de Duas Passos</li>
  <p> Responsável pela relocação completa dos endereços </p>
  <p> Utiliza o header gerado pelo montador saber a posição inicial onde devem ser armazenados os dados na memória</p> 
  <p> Sua saída salva o conteúdo em um código hpx (linkedCode.hpx)</p>
  <p> A sua primeira passagem é responsável pela unificação das tabelas geradas pelo montador, na qual é gerada tabela de símbolos globais usando a tabela de definição e os valores de endereços</p>
  <p>Na segunda passagem atualiza os endereços da tabela já unida e o restante do código é copiado e gerando assim o
  arquivo de saída</p>

  <li> Carregador Absoluto</li>
  <p> Responsável pela carga do conteúdo do arquivo gerado no ligador</p>
  
  <li> Interface gráfica</li>
  <p> Responsável pela exibição do conteúdo ao usuário</p>
  <p> Nessa interface, temos uma entrada para o código e respectivamente sua saída</p>
  <p> Além de entrada e saída, exibe a memória do programa e os registradores</p>
</ul>

<div align="center">
  <img src="https://user-images.githubusercontent.com/91095083/204101151-ebc047ed-5042-4fe7-82b7-50cf7a3842ab.jpg"
    width=650px>
</div>

<li> Módulos Interface gráfica </li>
<br>
<div align="center">
  <img src="https://user-images.githubusercontent.com/91095083/204101152-beb386dc-f01f-42eb-b794-7ffde4f26b02.jpg"
    width=650px>
</div>
<p> Visualização da interface</p>
<ol type="1">
  <li> Address: posição de endereço da memória</li>
  <li> Content: conteúdo relacionado ao endereço de memória </li>
  <li> Registradores: conteúdo armazenado nos registrados ao longo da execução </li>
  <li> Entrada de código: onde é adicionado o path do arquivo que será executado </li>
  <li> Saída de código: apresenta mensagens ao longo da execução </li>
  <li> Botão executar: executa o programa exibindo o resultado somente ao término da execução </li>
  <li> Botão executar visual: executa o programa exibindo os resultados ao longo da execução </li>
  <li> Botão debug: executa o programa linha a linha </li>
  <li> Botão ajuda: exibe uma janela de ajuda para o usuário </li>
</ol>
<h2> Documentação Completa </h2>
<p> Para acessar a documentação completa do código, basta seguir o passo a passo </p>
<ol type="1">
  <li> Navegar a pasta PS </li>
  <li> Navegar a pasta doc </li>
  <li> Abrir o arquivo index.html </li>
  <li> Navegar pelas classes de acordo com o interesse </li>
</ol>
<h2> Execução </h2>
<p> Para executar o programa é necessário possuir o NetBeans instalado</p>
<li> Para instalação do NetBeans é necessário o pacote JDK, disponível no link abaixo.</li>
<a href="https://www.oracle.com/br/java/technologies/downloads/"> Download Java </a>
<br>
<br>
<li> Link para download do NetBeans (versão 12 ou superior)</li>
<a href="https://netbeans.apache.org/download/nb15/"> Download NetBeans </a>
<br>
<br>
<li> Link para repositório do github</li>
<a href="https://github.com/msouzarthur/programacao-de-sistemas"> Repositório Github </a> <br><br>

<li> Instruções para executar o projeto </li>
<p> Concluido o download da IDE NetBeans e sua instalação, teremos essa janela inicialmente </p>
  <div align="center">
    <img src="https://user-images.githubusercontent.com/91095083/204004513-3ff59ab3-461a-4c8e-94cc-aab9ff0bfae8.jpg"
      width=650px>
  </div>
  <p> Seguindo as indicações da tela</p>
  <ol type="1">
    <li> Clique em File </li>
    <li> Clique em Open Project </li>
  </ol>
  <p> Após fazer todos processos descritos anteriormente, temos a seguinte visualização </p>
  <div align="center">
    <img src="https://user-images.githubusercontent.com/91095083/204004516-561a5abf-958d-4201-b127-391d881bd1c3.jpg"
      width=650px>
  </div>
  <ol type="1">
    <li> Procure o arquivo baixado </li>
    <li> Indicação que o arquivo correto foi selecionado </li>
    <li> Clique em Open Project </li>
  </ol>

  <p>Compilando o projeto</p>
  <div align="center">
    <img src="https://user-images.githubusercontent.com/91095083/204004517-a6b59565-10b1-472a-bb58-39ab1262fd4f.jpg"
      width=650px>
  </div>
  <p> Com o projeto já selecionado como mostra a indicação numero 1 na imagem acima, podemos fazer a execução do mesmo</p>
  <ol type="1">
    <li> Indica o projeto a ser executado </li>
    <li> Execute o projeto com as opções grifadas que melhor atender suas necessidades </li>
    <li> Após clicar em executar, a tela da interface gráfica será aberta </li>
    <li> Com a tela aberta, basta inserir o path absoluto do arquivo txt e clicar no modo de execução </li>
  </ol>
  

  Autores : Arthur Souza,Leonardo Marotta, Matheus Cardoso, Patrick Rosa.
