public class ListaSimplesmenteEncadeada {
    private Nodo inicio;
    private Nodo fim;
    private int quantidade;

    public ListaSimplesmenteEncadeada(){
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void adicionar(int valor){
        Nodo nodo = new Nodo(valor);
        this.quantidade++;
        if(this.inicio == null){
            this.inicio = nodo;
            this.fim = nodo;
            return;
        }
        Nodo oldTail = this.fim;
        this.fim = nodo;
        oldTail.proximo = this.fim;
    }

    public void adicionar(int valor, int posicao){
        if(posicao < 0 || posicao >= this.quantidade){
            throw new IndexOutOfBoundsException();
        }
        Nodo nodo = new Nodo(valor);
        if(posicao == 0){
            nodo.proximo = this.inicio;
            this.inicio = nodo;
            this.quantidade++;
            return;
        }

        if(posicao == this.quantidade - 1){
            this.adicionar(valor);
            return;
        }

        Nodo aux = this.inicio;
        for(int i = 0; i < posicao - 1; i++){
            aux = aux.proximo;
        }
        nodo.proximo = aux.proximo;
        aux.proximo = nodo;
        this.quantidade++;
        return;
    }

    public int removePelaPosicao(int index){
        Nodo aux = this.inicio;
        Nodo element;
        if(index == 0){
            this.inicio = aux.proximo;
            element = aux;
            aux = null;
            this.quantidade--;
            return element.elemento;
        }
        for(int i = 0; i < index - 1; i++){
            aux = aux.proximo;
        }
        this.quantidade--;
        element = aux.proximo;
        aux.proximo = aux.proximo.proximo;
        return element.elemento;
    }

    public int remove(int elemento){
        int index = this.retornaPosicao(elemento);
        return this.removePelaPosicao(index);
    }

    public int tamanho(){
        return this.quantidade;
    }

    public int get(int index){
        Nodo aux = this.inicio;
        for(int i = 0; i < index; i++){
            aux = aux.proximo;
        }
        return aux.elemento;
    }

    public int retornaPosicao(int elemento){
        int index = 0;
        Nodo aux = this.inicio;
        while(true){
            if(aux == null){
                return -1;
            }

            if(aux.elemento == elemento){
                break;
            }

            aux = aux.proximo;
            index++;
        }

        return index;
    }

    public boolean vazia(){
        return this.quantidade == 0;
    }

    public boolean contains(int element){
        Nodo aux = this.inicio;
        while(true){
            if(aux == null){
                return false;
            }

            if(aux.elemento == element){
                break;
            }

            aux = aux.proximo;
        }

        return true;
    }

    public void override(int index, int element){
        Nodo aux = this.inicio;
        for(int i = 0; i < index; i++){
            aux = aux.proximo;
        }
        aux.elemento = element;
    }

    public void limpa(){
        Nodo aux = this.inicio;
        while(true){
            if(aux == null){
                break;
            }
            this.remove(aux.elemento);
            aux = aux.proximo;
        }
    }

    @Override
    public String toString() {
        String aux = "[ ";
        Nodo paux = inicio;
        while (paux != null) {
            aux = aux + paux.elemento + " ";
            paux = paux.proximo; // avanca para proximo novo
        }
        aux += "]";
        return aux;
    }
}
