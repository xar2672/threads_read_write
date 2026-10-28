# EP02 - Implementação de Readers e Writers

Este projeto compara o tempo de execução de múltiplas threads acessando uma base de dados na memória sob duas abordagens diferentes: com prioridade para leitores (Readers/Writers) e com bloqueio total (Mutex).


## Estrutura do Projeto

O sistema está organizado nas seguintes classes principais:

* `Database.java`: Gerencia a leitura do arquivo texto inicial e o armazena em memória (RAM) como uma lista de palavras;
* `AccessController.java`: Interface que define os métodos de entrada e saída na região crítica;
* `ReadController.java`: Implementação da sincronização resolvendo o problema dos Leitores e Escritores (priorizando leitores);
* `MutexController.java`: Implementação básica que bloqueia o acesso à base independentemente se a thread é leitora ou escritora;
* `ThreadReader.java`: Thread leitora. Realiza 100 leitores em posições aleatórias da base e "dorme" por 1ms;
* `ThreadWriter.java`: Thread escritora. Modifica 100 posições aleatórias da base para "MODIFICADO" e "sleep" por 1ms.

## Pré-requisitos

* **Java Development Kit (JDK):** Versão 8 ou superior;
* **Base de dados:** O arquivo `bd.txt` deve estar no diretório raiz do projeto, no mesmo nível que a pasta `src`.

## Como Executar

1. Abra o terminal e navegue até o diretório onde os arquivos `.java` estão localizados.
2. Compile todos os arquivos Java com o comando:
   ```bash
   javac *.java
   ```
3. Para rodar o experimento, execute qualquer classe que estiver na pasta <Programa>, por exemplo:
   ```bash
   java Programa_Teste1
   ```


