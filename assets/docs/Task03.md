## TASK 03

Essa tarefa consiste em tratar da identidade do app. 

#### Tarefas inclusas:

##### Inserir uma tela de Splash Screen confor UX do adobe XD:

Deve ser inserida uma tela inicial de Splash Screen simples com _`delay`_ de exibição de 1.5s (espera até a tela principal aparecer - tela anteriormente criada);

- Criar a tela;

- Criar transição;

- Chamar a _**intent**_ para a outra tela;

##### Observações:

- Será necessário editar o Android Manifest;

- Para fazer o _`delay de exibição`_ será necessário utilizar um _`Handler`_ que será explicado mais a frente na tarefa de **número 10** a qual também explicará o que é a_**`UiMainThread`**_ e as formas de acessa-la (muito importante).
O _`Handler`_ faz parte dos recursos de acesso a esta Thread. Por hora Adicione o código abaixo para atribuir o delay de exibição;

```java
    new Handler(Looper.myLooper()).postDelayed(this::<function>, <tempo>);
``` 

Onde **`function`** deve ser substítuida pela função que encaminha para a tela principal e **`tempo`** é o tempo de 1.5s em milisegundos (obs.: retirar `<` e `>`; 

##### Links de ajuda:

[Databinding](https://developer.android.com/topic/libraries/data-binding)

[Intent](https://developer.android.com/guide/components/intents-filters?hl=pt-br)

[android Manifest](https://developer.android.com/guide/topics/manifest/manifest-intro)
