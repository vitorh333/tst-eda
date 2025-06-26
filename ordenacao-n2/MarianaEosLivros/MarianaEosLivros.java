import java.util.*;

class MarianaEosLivros {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] livros = linha.split(",");

        for(int i = 0; i < livros.length; i++) {
            if (i != livros.length - 1) {
                System.out.print(livros[i] + ", ");
            } else {
                System.out.print(livros[i]);
            }

        }

        System.out.println();

        for(int i = 0; i < livros.length - 1; i++) {
            int j = i + 1;

            while(j > 0 && livros[j].compareTo(livros[j-1]) < 0) {
                swap(livros, j, j-1);
                j--;
            }

            for(int k = 0; k < livros.length; k++) {
                if(k != livros.length - 1) {
                    System.out.print(livros[k] + ", ");
                } else {
                    System.out.print(livros[k]);
                }
            }

            System.out.println();

        }
    }

    public static void swap(String[] l, int i, int j) {
        String aux = l[i];
        l[i] = l[j];
        l[j] = aux;
    }
}
