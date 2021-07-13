## TASK 08

Essa tarefa consiste em adicionar o *wrapper* do banco de dados SQLite chamado ***sprinkes*** e começar a salvar as informações necessárias no banco.

### Tarefas inclusas:

### Adicionar a biblioteca do sprinkles:

- 1. No **Android Manifest** dentro da tag `app` adicionar o **`Provider`**:

```xml
<application ... />
    <provider
        android:name="br.com.redetendencia.pdvmobile.pdv.PROVIDER_AUTHORITY"
        android:authorities="br.com.integrati.sprinkles_inti_library.CONTENT_PROVIDER_AUTHORITY"
        android:exported="false" />
</application>
```

- 2. Adicionar a biblioteca do **sprinkles** adaptada (ver com Wesley);

+ 3. Adicionar no `build.gradle/app`:

```groovy
dependencies {
    // sprinkles
    implementation project(":sprinkles-inti-library-release")
}
```

+ 4. Adicionar no arquivo `settings.gradle`:

```groovy
include ':sprinkles-inti-library-release'
include ':app'
```

- 5. Criar um arquivo Java para comportar as migrações do banco e estender de **Application**. Dê o nome desse arquivo de **LikingApplication**. Deve ser equivalente ao que se segue:

```java
public class LikingApplication extends Application {}
```

- 6. Crie o método de ciclo de vida **onCreate** e adicione o conteúdo como se segue abaixo:

```java
@Override
public void onCreate() {
    super.onCreate();
    Sprinkles sprinkles = Sprinkles.init(getApplicationContext());
    sprinkles.registerType(Date.class, new DateSerializerSprinkles());
    sprinkles.registerType(Integer.class, new IntegerTypeSerializer());
    runMigrations(sprinkles);
}
```

- 7. Adicione outro método para gerar o *sistema de migrações* - conforme a aplicação recebe atualizações a mudança do estado do banco anterior para a nova chama-se de migração:

```java
public void runMigrations(Sprinkles sprinkles) {
    /* sprinkles.addMigration(new Create<Table>Migration()); */
}
```

- 8. Adicione os arquivos de *Serialização* utilizados em **6** dentro da pasta `utils`, caso não exista esta pasta crie-a dentro do diretório de código do projeto - comumente sobre algum path, exemplo `'com.example.liking_app'`.

  ```dockerfile
   app/
  	com/
      	example/
  			liking_app/
  				models/
  				view_presenters/
  				>> utils <<
  ```

  - Os arquivos podem ser pegos com Wesley; 

- 9. Novamente no **Android Manifest** adicione mais uma tag em **application**:

+ ```xml
    <application
        android:name=".LikingApplication"
        ... />
    ```

**Obs**.: `android:name` deve referenciar o mesmo nome que em **5**.

#### Salvar a primeira tabela:

- 1. Crie um arquivo dentro da pasta **models** chamado **OwnUser**, caso não exista este diretório crie-o como na parte **8** da tarefa anterior. Estenda o mesmo da classe **Model** e crie uma anotação para servir de referência para o sprinkles entender que se trata de uma tabela do banco de dados:

```java
@Table("own_user")
public class OwnUser extends Model {}
```

Fazendo isto deverá existir uma tabela dentro do banco chamada **own_user**. Adiante será explicado como criar a migração para essa tabela e como adicionar atributos (colunas a mesma);

- 2. Adicione as colunas da tabela: 

```java
@Table("own_user")
public class OwnUser extends Model {

	@Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("name")
    public String name;

    @Column("last_name")
    public String lastName;

    @Column("login")
    public String login;

    @Column("email")
    public String email;

    @Column("save_credentials")
    public boolean saveCredentials;

    @Column("password")
    public String password;
}
```

- Ao fazer isso significa que existirá uma tabela da seguinte forma:

>  **own_user**

| id      | name | last_name | login | email | save_credentials | password |
| ------- | ---- | --------- | ----- | ----- | ---------------- | -------- |
| INTEGER | TEXT | TEXT      | TEXT  | TEXT  | INTEGER          | TEXT     |

Note que a **save_credentials** mesmo sendo **boolean** quando entrar no banco *SQLite* será um inteiro (o *SQLIte* e o *wrapper splinkles* alterarão e gerenciarão seu valor com 1 igual a **true** e 0 como **false**). De mesmo modo o **long** é colocado como **INTEGER** dentro do banco sqlite. 

**Obs**.: No sprinkles sempre use **long** para definir o id único, caso contrário a aplicação irá quebrar. 

- 3. Crie a migração:

Dentro de *LikingApplication* crie a chamada para a *migration*:

```java
public void runMigrations(Sprinkles sprinkles) {
    /* sprinkles.addMigration(new Create<Table>Migration()); */
    sprinkles.addMigration(new CreateOwnUserMigration());
}
```

Dentro do diretório **migrations**, crie o diretório caso não exista conforme **8** na primeira parte, adicione uma classe equivalente ao nome do Objeto criado dentro de *runMigrations*, neste caso **CreateOwnUserMigration** e extenda **Migration**:

```java
public class CreateOwnUserMigration extends Migration {}
```

Isto lhe obrigará a sobrescrever o método **doMigration** então estenda e execute uma query de construção de tabela. O nome da tabela deve ser o mesmo de **1** e as colunas devem ser as mesmas de **2** com os valores mostrados naquela tabela.

```java
public class CreateOwnUserMigration extends Migration {

    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL(
                " CREATE TABLE own_user ( " +
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT, "  +
                " last_name TEXT, "  +
                " login TEXT, "  +
                " email TEXT, " +
                " save_credentials INTEGER, " +
                " password TEXT " +
            " ) "
        );
    }
}
```

- 4. agora dentro da aplicação você terá acesso aos métodos de CRUD do banco. 

Para isso, basta usar a instância do objeto criado em **1** e usar os métodos:

```java
OwnUser ownUser = new OwnUser();

// salvar -> retorna booleano sobre o êxito da operação
ownUser.save();

// salvar assincrono -> chama o banco para salvar e segue o fluxo, capturado o retorno a partir de um callback > OnSavedCallback
ownUser.saveAsync();

// deletar -> causa erro caso não efetivado
ownUser.delete();

// deletar assincrono -> chama o banco para deletar e segue o fluxo, capturado o retorno a partir de um callback > OnDeletedCallback
ownUser.deleteAsync();

// checa se existe o valor no banco
ownUser.exists();

// obtem apenas 1 registro
Query.one(OwnUser.class, " SELECT ATTRIBUTES FROM own_user <CONDITIONALS> ", params).get();

// obtem um cursor que possui uma lista de registro. É importante fechar o cursor logo após como se segue.
CursorList<OwnUser> cursor = Query.many(OwnUser.class, " SELECT ATTRIBUTES FROM own_user <CONDITIONALS> ", params).get();
List<OwnUser> ownUser = cursorList.asList();
cursorList.close();

// obtenha todos os registros 
Query.all(OwnUser.class);

/* Os parametros podem ser passados para a query com uso de ? e onde escrevi params são os valores em ordem que irão substituir os coringas '?' -> em caso de não existor coringas passe o booleano true em 'params' */
```

### Observação:

Mais a frente será necessário criar outras migrações, volte nesta tarefa caso apareçam dúvidas.

#### Links Úteis:

[sprinkles](https://github.com/emilsjolander/sprinkles)



