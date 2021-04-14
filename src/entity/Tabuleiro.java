package entity;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class Tabuleiro {
    public static int N;

    int[][] luzes;

    public Tabuleiro(int[][] posicoes) {
        this.luzes = posicoes;
    }

    private void inverterLuz(int linha, int coluna) {
        if(this.luzes[linha][coluna] == 1) {
            this.luzes[linha][coluna] = 0;
        } else {
            this.luzes[linha][coluna] = 1;
        }
    }

    public void fazerAcao(Posicao posicao) {
        this.inverterLuz(posicao.linha, posicao.coluna);

        if(posicao.linha != 0) { //inverte cima
            this.inverterLuz(posicao.linha - 1, posicao.coluna);
        }
        if(posicao.linha != Tabuleiro.N - 1) { //inverte baixo
            this.inverterLuz(posicao.linha + 1, posicao.coluna);
        }
        if(posicao.coluna != 0) { //inverte esquerda
            this.inverterLuz(posicao.linha, posicao.coluna - 1);
        }
        if(posicao.coluna != Tabuleiro.N - 1) { //inverte direita
            this.inverterLuz(posicao.linha, posicao.coluna + 1);
        }
    }

    public Tabuleiro deepCopy() {
        int[][] novoluzes = new int[Tabuleiro.N][Tabuleiro.N];
        for(int i=0; i<Tabuleiro.N; i++) {
            for(int j=0; j<Tabuleiro.N; j++) {
                novoluzes[i][j] = this.luzes[i][j];
            }
        }
        return new Tabuleiro(novoluzes);
    }

    public static void setN(int n) {
        Tabuleiro.N = n;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(luzes);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tabuleiro other = (Tabuleiro) obj;
        if (!Arrays.deepEquals(luzes, other.luzes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String res = "";

        for(int i=0; i<Tabuleiro.N; i++) {
            for(int j=0; j<Tabuleiro.N; j++) {
                res += this.luzes[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }
}
