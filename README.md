# Liking-App

### Objetivo

Repositório simples para entendimento dos principais conceitos de android alem da oportunidade da criação de uma aplicação do zero a um nível técnico intermediário. 

### Pré requisitos
- O projeto deve ser desenvolvido para contemplar a última versão (30.0.3);
- O projeto deve ser desenvolvido para uma versão mínima de sdk 23;
- O projeto deve ser desenvolvido em Java;
- Não falar mal da pessoa que vos escreve isto;
- Se for utilizar como portfólio pessoal não esquecer dos créditos.

### Padrões de código sugeridos

- Todas as **strings**, quando não afetar o comportamento, devem ser declarado em um arquivo _`strings.xml`_;
- Usar o máximo de abstração possível no código;
- Quebrar o máximo os métodos e em classes que façam sentido, _ex.: singletons, utils, constants e etc_;
- Escrever em **inglês**;
- _Commitar_ usando uma ação e a descrição do que foi realizado:

` git commit -m "`**`Add`**`: MainActivity's XML design | login and password's validation"`

Onde as ações podem ser _**Add**_,  _**Up/Update**_,  _**Rf/Refactoring**_,  _**Fix**_ e  _**Rm/Remove**_;

- _Commitar_ cada tarefa em separado e seguindo os seguintes padrões:
- Toda tarefa deve possuir o identificador de branch no seguinte modelo:

_`tarefa 01 =>`_ **task-01**

_`tarefa 02 =>`_ **task-02**

_`...`_

_`tarefa N =>`_ **task-N**

  De modo que ao fim o repositório contenha todas as tarefas para acompanhamento de evolução de projeto;

- Devem ser submetidas todas as tarefas para o repositório;
- A branch **main** deve ter os merges das tarefas conforme forem sendo finalizadas;

### Padrões de projeto

Uso de DataBiding:

- Faz-se necessário este recurso por ser importante na nova fase do android, o mesmo deverá ser embutido em releases futuras nas aplicações de destino. Já foi anunciado que na chegada do _gradle 5.0_ os identificadores dos [recursos](https://developer.android.com/guide/topics/resources/providing-resources?hl=pt-br) não serão mais fixos, então o android dará prioridade de identificadores à bibliotecas nativas e de parceiros associados. [O aviso já é descrito pela ide](); **_____________________att_______________**
### <a name="head1234"></a> Recursos disponibilizados 

Haverá no decorrer das tarefas links e recursos para ajudar tanto no entendimento quanto para explicar algum conceito.

> UX

A UX do projeto pode ser encontrada neste [link](https://xd.adobe.com/view/9c944bf5-471b-43f6-b5f5-5236bbfdd896-c9c7/grid).

> Assets

Serão disponibilizados alguns [recursos/assets](https://github.com/Ana-Dias-ACD/Linking-App/tree/main/assets) para uso dentro do projeto. **_____________________att_______________**

> Apk

Uma apk para instalação que pode ser utilizada como uma prévia/ajuda na montagem da aplicação.

### Tarefas ###


#### Tarefa 01 - Here we go! First Design. 

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task01.md)

A primeira tarefa busca aprimorar a capacidade de traduzir um design em um layout organizado e bem formatado. Deseja-se que seja criado ao menos a tela de nome **`1 - Login Up - Register`**


#### Tarefa 02 - Identity is required!
[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task02.md)

Criar a identidade visual do aplicativo e definir o Manifesto.


#### Tarefa 03 - What do you think about Splash Screen?!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task03.md)

Criar a Splash Screem e adicionar no código com _1.5s_ de espera.


#### Tarefa 04 - Are you only a designer?! Let's start coding!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task04.md)

Construir a lógica, as validações e as conexões em relação ao XML da tela principal.


#### Tarefa 05 - Don't leave things behind!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task05.md)

Essa tarefa consiste em transmitir informações para outra tela usando do recurso Bundle.


#### Tarefa 06 - take a time!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task06.md)

Essa tarefa consiste em transmitir informações para outra tela usando do recurso Bundle, mas utilizando do empilhamento de activity e ciclo de vida onde a informação deve ser aguardada para retornar para a activity anterior.


#### Tarefa 07 - If you did it once, do it again!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task07.md)

Chegou a hora de adaptar o código para MVP (padrão de projeto).


#### Tarefa 08 - Record all of the things!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task08.md)

Chegou a hora de trabalhar com banco de dados. Adicione a biblioteca do sprinkles e salve as informações já obtidas. 


#### Tarefa 09 - Is it not done yet?!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task09.md)

Termine todos os designs restantes para restar apenas a parte de código. (obs.: Acredito que será repassado os designs, fica a tarefa de adaptar ao estilo existente). Deve ser criada as rotas. 


#### Tarefa 10 - Who is your friends?!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task10.md)

Cadastre pessoas no aplicativo, mostre-as na lista geral de pessoas.


#### Tarefa 11 - Are you right about your friends?!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task11.md)

Edite e exclua pessoas adicionadas.


#### Tarefa 12 - picking a date!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task12.md)

Deve ser inserido um _Calendar_ que seja possível escolher uma data. 

> this part ahead is not done!


#### Tarefa 13 - Wow! Super heroes!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task13.md)

Essa tarefa consiste em adicionar os scripts da biblioteca Retrofit e fazer requisição à uma API publica da Marvel, requisitando assim dados referentes a super heróis do universo Marvel.


#### Tarefa 14 - Search and picking your favorite!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task14.md)

Deve ser exibida uma lista de acordo com o design da aplicação - [UX](#head1234) - e a lista deve estar de acordo com as informações obtidas da tarefa 13. Deve ser criado o filtro de pesquisa. 


#### Tarefa 15 - Make a collection! Love and hate'em!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task15.md)

Deve ser adicionados os super heróis a uma lista pessoal. Na sua lista pessoal exclua ou abra a exibição detalhada do super herói.


#### Tarefa 16 - Wow! Bring the house down!!

[see more...](https://github.com/GabrielC-12/Liking-App/blob/main/assets/docs/Task16.md)

Com tudo pronto resta gerar uma apk e mergear tudo na **main**.

