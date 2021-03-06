package entity.estruturas;

import entity.Estado;

public interface EstadoAbertos {

    public void push(Estado estado);
    public Estado pop();
    public int size();
    public boolean contains(Estado estado);
}
