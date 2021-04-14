package tests;

import entity.Estado;
import entity.Tabuleiro;

import java.util.LinkedList;
import java.util.Queue;

public class CompararEstadosTeste {

    public static void main(String[] args) {

        Queue<Estado> estados = new LinkedList<>();

        Estado estado1 = new Estado(new Tabuleiro(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }), new LinkedList<>());

        Estado estado2 = new Estado(new Tabuleiro(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }));

        estados.add(estado1);

        System.out.println("Os estados são iguais? " + estado1.equals(estado2));

        System.out.println("Achou estado? " + estados.contains(estado2));
    }
}
