## TASK 11

Essa tarefa é a continuação da tarefa anterior e consiste em atualizar os valores em banco e da *recyclerView* quando houver deleção de objetos da lista e repassar um objeto para ser editado. Completar um CRUD.

#### Tarefas inclusas:

##### Apagar um registro de usuário:

Descrição:

Nesta tarefa deve ser complementado a tela `3 - People`  onde a ação de excluir deve ser efetivada, ao realizar o clique deve:

- assegurar que o objeto seja excluído do banco;
- assegurar que a visibilidade do item na RecyclerView seja atualizada -> pode ser utilizado um *listener* que a partir da classe base de 3 - People atualize os valores da lista dentro do *adapter* ou atualizar a lista pela própria *Adapter*;
- Lembre-se de utilizar **notifyDataSetChanged()** ao modificar a lista para que a *Adapter* saiba da ação;

##### Encaminhe o registro de um item da recycler para a tela de cadastro de usuário:

Repasse a partir da ação de editar o registro do usuário atual para a tela `4 - Register Person` para que possa ser alterado seus valores, para isso:

- Crie uma ação de clique para o ícone de editar;
- crie um *listener* para efetivar a ação em  `3 - People` que será de iniciar a outra tela: `4 - Register Person`;
- passe um *Bundle* ou uma *flag* para identificar qual usuário que deve ser usado na outra tela;
- controlar o fluxo na tela `4 - register Person` caso receba de uma *Intent* um valor de Usuário;

Ao salvar novamente atualize o cadastro do usuário no banco e na tela `3 - People`;

#### Observações:

- Valide se o telefone começa com 9 ou 8;
- Não permita o cadastro de um usuário com mesmo CPF;
- Valide se todos os campos estejam preenchidos;

#### Bônus:

validações de tipos e mascaras são interessantes de serem feitos o máximo possível.

#### Links de ajuda:

[RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)

[RecyclerView 2](https://www.androidpro.com.br/blog/design-layout/recyclerview-cardview/)

[ViewHolder e aproveitamento de memória](https://www.alura.com.br/artigos/utilizando-o-padrao-viewholder)

[View Holder métodos](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.ViewHolder)

