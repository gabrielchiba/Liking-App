## TASK 13

Essa tarefa consiste em adicionar os scripts da biblioteca **Retrofit** e fazer requisição à uma *API* publica da **Marvel**, requisitando assim dados referentes a super heróis do universo Marvel.

#### Tarefas inclusas:

##### Instalar a biblioteca de Retrofit:

Obs.: Nesse tutorial será descrito com instalar a biblioteca do Retrofit 1, Caso sinta curiosidade em usar a ultima versão da biblioteca, Retrofit 2, fique a vontade - terá de estudar mais a fundo sobre, o que é interessante! Caso opte ainda, é possível usar o código descrito abaixo, testar e ao fim desta tarefa refatorar a parte de requisição para Retrofit 2.

Descrição;

- No *build.gradle (app)* insira na parte de *dependecies* as linhas que se seguem;

```groovy
implementation 'com.google.code.gson:gson:2.8.7'
implementation 'com.squareup.retrofit:retrofit:1.9.0'
implementation 'com.squareup.okhttp:okhttp:2.7.5'
implementation 'com.squareup.okhttp3:okhttp:4.2.2'
```

##### Criar rotas de conexão a API utilizando o Retrofit:

- Então crie um diretório com nome de **api** na base do projeto, dentro da mesma crie uma classe chamada **MarvelApi** para receber as informações de super heróis da API pública da Marvel;

- Coloque o conteúdo abaixo na classe criada:

  ```java
  package <CHANGE_HERE_WITH_YOUR_PROJECT_PATH>.api;
  
  import android.content.Context;
  import android.util.Log;
  
  import com.google.gson.Gson;
  import com.google.gson.GsonBuilder;
  
  import java.util.Date;
  
  import retrofit.RestAdapter;
  import retrofit.client.OkClient;
  import retrofit.converter.GsonConverter;
  import retrofit.http.GET;
  import retrofit.http.Query;
  
  public class MarvelApi {
  
      public static MarvelApi.Routes routes;
  
      public static MarvelApi.Routes getApiMarvel(Context context) {
  
          if (routes == null) {
              Gson gson = new GsonBuilder()
                      .setDateFormat("dd/MM/yyyy")
                      .create();
  
              RestAdapter.Builder builder = new RestAdapter.Builder()
                      .setEndpoint(<SET_THE_URL_BASE>)
                      .setConverter(new GsonConverter(gson))
                      .setLogLevel(RestAdapter.LogLevel.FULL)
                      .setClient(new OkClient())
                      .setLog(message -> Log.d("API", message));
  
              RestAdapter restAdapter = builder.build();
  
              routes = restAdapter.create(MarvelApi.Routes.class);
          }
          return routes;
      }
      
      public interface Routes {
     	
          <REST_METHOD>("<URI_DA_API>")
          <OBJECT_WITH_SERIALIZED_THAT_WILL_RECEIVE_DATA> <NAME_METHOD_CAMEL_CASE>(
                  @Query("ts") String ts,
                  @Query("apikey") String apikey,
                  @Query("hash") String hash,
                  @Query("...") <TYPE> <NAME>,
              	...
          );
      }
  }
  ```

  

- Note que alguns parametros devem ser alterados, são eles: 

  -  *CHANGE_HERE_WITH_YOUR_PROJECT_PATH* deve representar o caminho do seu projeto, *ex.: com.study.app..*;
  - *SET_THE_URL_BASE* deve possuir a API da documentação da marvel (primeiro e segundo link);
  - *URI_DA_API* deve ser a URI que trará as informações (terceiro link);
  - *REST_METHOD* que deve ser substituído por **@GET, @POST, @PATCH, @PUT, @DELETE** que são os métodos de uma *API* *RESTFULL*;
  - *OBJECT_WITH_SERIALIZED_THAT_WILL_RECEIVE_DATA* reflete o objeto que irá receber os dados do conversor Gson para Objeto (quarto link); 
  - *NAME_METHOD_CAMEL_CASE* é o nome do método que vai ser chamada dentro de seu código para retornar os dados da API da Marvel;

- Note que alguns estão servindo apenas como exemplo:

  - **@Query** refrete os parâmetros da URL do método **GET**, será necessário adicionar alguns a mais dependendo de quais filtros e especificações for utilizar da API da Marvel, fica o estudo;

- Se por ventura tiver dúvidas em algum desses parâmetros **GET** pode me procurar até mesmo para explicar. 

- Dentro de **Routes** crie quantas rotas achar necessário. 

##### Crie ou pegue uma chave pública e privada da Marvel:

- Obtenha as chaves criando um cadastro na API da Marvel ou caso prefira passo a minha tranquilamente; 
- Depois de conseguir as chaves imagine uma forma disto não subir para o repositório para que outras pessoas não utilizem sua chave (MUITO IMPORTANTE), isso vale até de dica de segurança: Não exponha chaves privadas em locais públicos;
- Use o método a abaixo para criar a Hash MD5 que deve ser usada para conectar a API - veja segundo link;

```java
public static String md5(final String s) {
    final String MD5 = "MD5";
    try {
        // Create MD5 Hash
        MessageDigest digest = java.security.MessageDigest
            .getInstance(MD5);
        digest.update(s.getBytes());
        byte[] messageDigest = digest.digest();

        // Create Hex String
        StringBuilder hexString = new StringBuilder();
        for (byte aMessageDigest : messageDigest) {
            StringBuilder h = new StringBuilder(Integer.toHexString(0xFF & aMessageDigest));
            while (h.length() < 2)
                h.insert(0, "0");
            hexString.append(h);
        }
        return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return "";
}
```

- O parâmetro TS também pedido pela API pode ser obtido pelo código abaixo:

```java
long tsLong = System.currentTimeMillis() / 1000;
<TS_VARIABLE> = Long.toString(tsLong);
```

##### Manipule os Dados:

- Converta o conteúdo do JSON recebido da API para Objetos que possam ser usados dentro do projeto: Uso da biblioteca Gson (quarto link em diante);
- Verifique se os dados estão sendo recebidos no LogCat e não apresentam erros ; 

##### Links de ajuda:

[URL Base](https://webtech.training.oregonstate.edu/faq/what-base-url)

[URL full discover Marvel](https://developer.marvel.com/documentation/authorization) > parte de **Authentication for Server-Side Applications** tem um exemplo de URL completa, extraia a URL base;

[API Marvel](https://developer.marvel.com/docs)

[GSON](https://github.com/google/gson/blob/master/UserGuide.md) > Caso precise usar nome diferente do JSON em relação a variável receptora leia o link abaixo

[GSON SERIALIZED_NAME](https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5/com/google/gson/annotations/SerializedName.html)

[Mais exemplos de Gson](https://sites.google.com/site/aulasvictormenegusso/programacao-web-2-1-semestre-2017/trabalhando-com-json-com-a-biblioteca-gson)

