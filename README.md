
# clientes-java

### Features

- CRUD Agências
- CRUD Clientes
- Swagger 

[Imagem Docker][id/name] 

[id/name]: https://cloud.docker.com/u/jhonata/repository/docker/jhonata/clientes-banco-java
[![](https://cdn.iconscout.com/icon/free/png-128/docker-226091.png)](https://cloud.docker.com/u/jhonata/repository/docker/jhonata/clientes-banco-java)



# Passo a passo para executar o container com Kubernates

No meu caso, utilizo linux, especificamente o Debian. No entanto, todos os comandos aqui listados, é fácilmente encontrado na documentação do kubernates. https://kubernetes.io/docs/home/

O primeiro passo, é instalar o minikube. O minikube é quem permite criarmos nossos clusters.

- Instale minikube

Também precisamos no kubectl. O kubectl é uma ferramenta de linha de comando que nos permite enviar comandos para o cluster.

-  Instale kubectl

- De permissão de execução para kubectl 

- Adicione o binário ao seu path 

    chmod +x ./kubectl
	
A documentação do kubernates é bem simples e explicativa. Nesta página temos todos os detalhes necessário para instalar o kuberctl: https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl-on-linux

### Depois de instalado o kuberctl e o minikube
#### É hora de começar a brincadeira, criando um cluster:

O minikube, como já dito anteriormente, vai nos  permitir criar o cluster.
 Para isso vamos startá-lo com o seguinte comando:
 
 ```
     minikube start
 ```
 
Uma vez que ele foi startado, vamos rodar o seguinte comando, pegando como base o container que criamos para o desafio: 

    kubectl run clientes-banco-java --image=jhonata/clientes-banco-java:0.0.1 --port=8080


Se tudo correu bem, teremos a seguinte saída:

    deployment.apps/clientes-banco-java created

Legal! o cluster foi criado. Agora precisamos expor este serviço. Para isso utilizamos o seguinte comando: 

    kubectl expose deployment clientes-banco-java --type=NodePort

E se tudo correu bem, novamente, teremos a seguinte saída:

    service/clientes-banco-java exposed

Para verificarmos se realmente está tudo ok, utilizamos o comando: 

    kubectl get pod

E na saida teremos algumas informações. Umas delas, que o serviço está running. Ou seja, rodando!

    NAME                                   READY   STATUS    RESTARTS   AGE
    clientes-banco-java-798bb8b448-bn8xg   1/1     Running   0          3m44s
    
    
   
   ![alt text](https://github.com/JhonataRibeiro/tmp-img/blob/master/Captura%20de%20tela%20de%202019-06-12%2002-53-28.png)



Agora vamos descobrir onde o serviço está rodando:

    minikube service clientes-banco-java --url

e voa-lá:

Observe que o serviço está rodando em uma porta específica do kubernates, ou seja, nosso container está sendo executado pelo kubernate. Neste caso, podemos especifícar várias estratégias para o cluster, exemplo: Eu posso dizer que essa aplicação deve rodar com 100 pods que seriam os containers. Se por acaso um desses containers falhar, automaticamente o kubernates irá levantar outro container. Existe também a checagem de saúde desses containers, dependendo da configuração, um container pode ser substituido por outro automaticamente.

    http://192.168.99.100:30557
    
    
![alt text](https://github.com/JhonataRibeiro/tmp-img/blob/master/Captura%20de%20tela%20de%202019-06-12%2002-56-22.png)

