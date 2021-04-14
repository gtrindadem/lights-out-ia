package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.estruturas.EstadoAbertos;

public class EspacoDeEstados {

    public static Estado OBJETIVO;

    Estado inicial;
    EstadoAbertos estadosAbertos;
    Set<Estado> estadosFechados;

    public EspacoDeEstados(Estado aInicial, EstadoAbertos aEstruturaAbertos) {
        this.inicial = aInicial;
        this.estadosAbertos = aEstruturaAbertos;
        estadosAbertos.push(this.inicial);
        estadosFechados = new HashSet<>();
        declaraOBJETIVO();
    }

    public Estado solve() {

        if (inicial.equals(OBJETIVO)) {
            System.out.println("-----------------ENCONTROU SOLUCAO-----------------");
            return inicial;
        }

        while (estadosAbertos.size() > 0) {
            Estado e = estadosAbertos.pop();

            Collection<Estado> filhos = geraFilhos(e);

            if (filhos == null) {
                return null;
            }
        }

        System.out.println("Não encontrou solução!");

        return null;
    }

    public Collection<Estado> geraFilhos(Estado estado) {

        Collection<Estado> filhos = new ArrayList<>();
        for (int i = 0; i < Tabuleiro.N; i++) {
            for (int j = 0; j < Tabuleiro.N; j++) {

                Estado filho = estado.deepCopy();
                filho.fazerAcao(new Posicao(i, j));

                if (estadosFechados.contains(filho) || estadosAbertos.contains(filho)) {
                    continue;
                }

                System.out.println("TESTANDO ESTADO:");
                System.out.println(filho.getTabuleiro().toString());
                if (filho.equals(OBJETIVO)) {
                    System.out.println("-----------------ENCONTROU SOLUCAO-----------------");
                    System.out.println(filho.getAcoes());
                    return null;
                }

                if (!estadosAbertos.contains(filho)) {
                    estadosAbertos.push(filho);
                }

                System.out.println("não é solução");
                System.out.println("Estados abertos: " + estadosAbertos.size());
                System.out.println("Estados fechados: " + estadosFechados.size());
                System.out.println("-----------------");


                filhos.add(filho);
            }
        }

        estadosFechados.add(estado);

        return filhos;
    }

    private void declaraOBJETIVO() {
        int[][] luzes = new int[Tabuleiro.N][Tabuleiro.N];
        for (int i = 0; i < Tabuleiro.N; i++) {
            for (int j = 0; j < Tabuleiro.N; j++) {
                luzes[i][j] = 0;
            }
        }
        EspacoDeEstados.OBJETIVO = new Estado(new Tabuleiro(luzes));
    }
}