package tests;

import dao.InputInstance;
import entity.EspacoDeEstados;
import entity.Estado;
import entity.Tabuleiro;
import entity.estruturas.Fila;
import entity.estruturas.Pilha;

public class SolveTeste {
    public static void main(String[] args) {
        Tabuleiro t = InputInstance.getInstance("files/inst_4_0001.in");

        Estado e = new Estado(t);
        System.out.println("Começando com o estado:");
        System.out.println(e.getTabuleiro().toString());

        EspacoDeEstados ee = new EspacoDeEstados(e, new Pilha());
        ee.solve();
    }
}
