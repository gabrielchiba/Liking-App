## TASK 01

Esta primeira tarefa consiste em criar o design da tela _`1 - Login Up - Register`_ baseado em uma UX definida. Atente-se a valores de margem e de tamanho dos itens. 

#### Recomendações
- É recomendável o uso de [Styles](https://developer.android.com/guide/topics/ui/look-and-feel/themes) para definir padrões de layout;
- É recomendavel o uso da biblioteca de _[DataBiding](https://developer.android.com/topic/libraries/data-binding#java)_ como mencionado no [README]https://github.com/GabrielC-12/Liking-App/blob/main/README.md).

Existem vários tipos de layout no Android, todavia, existem 4 layouts que são os mais comumente utilizados, são eles:

- ##### LinearLayout
É um layout que respeita a ordem do mais próximo e que sempre segue uma orientação para o agrupamento de seus filhos: _`vertical`_ e _`horizontal`_. É o layout mais simples menos problemático a se trabalhar, 
mas de equivalente poder de uso - por mais que tenha grandes restritividades. recomendá-se o uso do atributo _**weight**_ para ter responsividade.

> [doc](https://developer.android.com/reference/android/widget/LinearLayout)

- ##### FrameLayout
Permite o agrupamento no eixo z (conhecido como _**index-z**__ no **css**) podendo colocar componentes sobrepostos um ao outro e definir a distancia da base não dependendo unicamente da ordem de 
inserção dos elementos no XML - este ainda vale. É o layout que mais vem ganhando adeptos por este diferencial em relação ao RelativeLayout.

> [doc](https://developer.android.com/reference/android/widget/FrameLayout)

- ##### RelativeLayout 
Permite que um item seja relativo na posição que ocupa na tela sem depender do posicionamento do _`parent`_ de grade maior.

> [doc](https://developer.android.com/guide/topics/ui/layout/relative)

- ##### ConstraintLayout
Permite o agrupamento de mais de um filho onde a distancia e espaçamento serão equivalentes em relação as bordas concorrentes do_`parent`_ mais de grade maior. 
É também o layout mais problemático de ser adicionado e ajsutado. 

> [doc](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)
