package entity;

import java.util.*;

public class Estado {

    Tabuleiro tabuleiro;
    List<Posicao> acoes;

    public Estado(Tabuleiro aTabuleiro) {
        this.tabuleiro = aTabuleiro;
        this.acoes = new LinkedList<>();
    }

    public Estado(Tabuleiro aTabuleiro, List<Posicao> aAcoes) {
        this.tabuleiro = aTabuleiro;
        this.acoes = aAcoes;
    }

    public void fazerAcao(Posicao posicao) {
        this.acoes.add(posicao);
        this.tabuleiro.fazerAcao(posicao);
    }

    public Estado deepCopy() {
        List<Posicao> novasAcoes = new LinkedList<>(this.acoes);
        return new Estado(this.tabuleiro.deepCopy(), novasAcoes);
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public List<Posicao> getAcoes() {
        return this.acoes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tabuleiro == null) ? 0 : tabuleiro.hashCode());
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
        Estado other = (Estado) obj;
        if (tabuleiro == null) {
            if (other.tabuleiro != null)
                return false;
        } else if (!tabuleiro.equals(other.tabuleiro))
            return false;
        return true;
    }

}
