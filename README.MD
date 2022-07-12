
# CAMINHO MAIS CURTO EM UMA MALHA RODOVIARIA

Implementação do algoritmo de Dijkstra para o Trabalho Final da disciplina de Grafos ministrada por Elizabeth Ferreira Gouvea Goldbarg.


## Rodando localmente

- Clone o projeto

```bash
  git clone https://github.com/TarsilaSamille/Caminho-Mais-Curto.git
```

- Entre no diretório do projeto

```bash
  cd Caminho-Mais-Curto
```

- Baixe do repositório, http://www.diag.uniroma1.it//~challenge9/download.shtml todos os arquivos da coluna do grafo de tempo de viagem (Travel time graph) e coloque-os na pasta "Caminho-Mais-Curto/demo/src/mapas/"(não foi possivel fazer o upload dos datasets para o github, não é permitido arquivos maiores que 25MB).


- Execute a classe App.class, depois de todos os arquivos copilados. 

-- A execussão da classe pode ser feita usando o código abaixo, substituindo os campos {jdk-path} e {repository-path}
pela localização do jdk e do repositorio. A MaxHeapSize precisa ser aumentada para rodar todos os datasets.

```bash
    filerootfolder>'${jdk-path}\openjdk-11.0.13_8\bin\java.exe' '-agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:52688' '-Xmx6G' '-cp' 
    '${repository-path}\demo\target\classes' 'com.graph.App'
```

