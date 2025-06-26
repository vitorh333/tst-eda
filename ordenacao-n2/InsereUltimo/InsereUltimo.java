import java.util.*;


class InsereUltimo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] nums = linha.split(" ");

        int[] lista = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            lista[i] = Integer.parseInt(nums[i]);
        }

        int fim = lista.length - 1;


        while(lista[fim] < lista[fim-1]) {
            swap(lista, fim, fim - 1);
            fim --;
            if(fim == 0) {
                break;
            }


        }

        System.out.println(Arrays.toString(lista));

    }


    public static void swap(int v[], int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
        
    }

}
