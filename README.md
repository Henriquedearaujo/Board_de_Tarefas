# Board_de_Tarefas

---

**Board de Tarefas - Funcionalidades e Estrutura**

O board de tarefas é criado contendo a data e a hora exatas de sua criação, garantindo um registro preciso do momento inicial. Ele é composto por **três colunas principais**:

1. **Coluna Inicial**: Onde os cards começam.
2. **Coluna de Concluídos**: Para os cards que foram finalizados.
3. **Coluna de Cancelados**: Para os cards que não serão mais executados.

### Funcionalidades do Menu do Board

O menu do board inclui as seguintes opções de gerenciamento de cards:

- **Criar um Card**: Adicionar uma nova tarefa ao board.
- **Mover um Card**: Transferir o card para a próxima coluna, de acordo com o progresso.
- **Cancelar um Card**: Marcar um card como cancelado, movendo-o para a coluna "Cancelados".
- **Bloquear um Card**: Restringir a edição ou movimentação de um card. Para bloquear, é necessário fornecer um motivo explicando o bloqueio.
- **Desbloquear um Card**: Reverter o bloqueio de um card. Para desbloquear, é necessário fornecer um motivo que justifique a ação.

Essa estrutura e funcionalidade ajudam a organizar e monitorar o progresso de suas tarefas de maneira clara e eficiente.

### Vamos ultilizar Migrations com a ferramenta Liquibase
Para gestão de alterações em bancos de dados vamos atualizar para modificar o esquema de um banco de dados de maneira controlada e segura, garantindo consistência e rastreabilidade das mudanças.

---

## Diagrama da Solução
```mermaid

classDiagram
class Board {
+id: Long
+name: String
}

class BoardColumn {
+id: long
+name: String
+kind: String
+order: Int
}

    class Card {
        +id: Long
        +title: String
        +description: String
        +createdAT: OffsetDateTime
    }

    class Block {
        +id: Long
        +blockCause: String
        +blockln: OffseDateTime
        +unblockCause: String
        +unblockin: OffsetDateTime
    }

    Board "1" --> "N" BoardColumn
    BoardColumn "1" --> "N" Card
    Card "1" --> "N" Block
    
    ```