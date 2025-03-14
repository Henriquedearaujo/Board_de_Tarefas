package br.com.haraujo.ui;

import br.com.haraujo.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class BoardMenu {

    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private  final BoardEntity entity;

    public void execute() {
        System.out.printf("Benvindo ao board %s, selecione a operação desejada", entity.getId());
        var option  = -1;
        while (option != 9){
            System.out.println("1 - Criar um card");
            System.out.println("2 - Mover um card");
            System.out.println("3 - Bloquear um card");
            System.out.println("4 - Desbloquear o card");
            System.out.println("5 - Cancelar um card");
            System.out.println("6 - Ver board");
            System.out.println("7 - Ver coluna com cards");
            System.out.println("8 - Ver card");
            System.out.println("9 - Voltar para o menu anterior");
            System.out.println("10 - Sair");
            option =scanner.nextInt();
            switch (option){
                case 1 -> criateCard();
                case 2 -> moveCardTonextColumn();
                case 3 -> blockCard();
                case 4 -> unblockCard();
                case 5 -> cancelCard();
                case 6 -> showBoard();
                case 7 -> showColumn();
                case 8 -> showCard();
                case 9 -> System.out.println("Voltar para o menu anterior");
                case 10 -> System.exit(0);
                default -> System.out.println("Opção inválida, informe uma opção do menu");
            }
        }
    }

    private void criateCard() {
    }
    private void moveCardTonextColumn() {
    }
    private void blockCard() {
    }
    private void unblockCard() {
    }
    private void cancelCard() {
    }
    private void showBoard() {
    }
    private void showColumn() {
    }
    private void showCard() {
    }
}
