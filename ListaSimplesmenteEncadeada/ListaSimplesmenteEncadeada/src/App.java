public class App {
    public static void main(String[] args) throws Exception {
        ListaSimplesmenteEncadeada ls1 = new ListaSimplesmenteEncadeada();

        ls1.adicionar(12);
        ls1.adicionar(13);
        ls1.adicionar(14);
        ls1.adicionar(15);
        System.out.println(ls1);

        ls1.adicionar(19, 0);
        System.out.println(ls1);

        System.out.println(ls1.retornaPosicao(19));
        System.out.println(ls1.retornaPosicao(14));

        ls1.removePelaPosicao(0);

        System.out.println(ls1);

        ls1.remove(15);

        System.out.println(ls1);

        ls1.override(2, 22);

        System.out.println(ls1);
    }
}