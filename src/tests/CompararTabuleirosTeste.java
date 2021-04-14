package tests;

import entity.Tabuleiro;

import java.util.HashSet;
import java.util.Set;

public class CompararTabuleirosTeste {

    public static void main(String[] args) {

        Set<Tabuleiro> tabuleiros = new HashSet<>();

        Tabuleiro tabuleiro1 = new Tabuleiro(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        Tabuleiro tabuleiro2 = new Tabuleiro(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        System.out.println("Os tabuleiros são iguais? " + tabuleiro1.equals(tabuleiro2));

        tabuleiros.add(tabuleiro1);

        System.out.println("Achou tabuleiro? " + tabuleiros.contains(tabuleiro2));
    }
}
