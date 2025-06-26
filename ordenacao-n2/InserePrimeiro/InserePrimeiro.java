import java.util.*;

class InserePrimeiro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");

        int[] nums = new int[lista.length];

        for(int i = 0; i < lista.length; i++) {
            nums[i] = Integer.parseInt(lista[i]);
        }

        int ini = 0;

        while(nums[ini] > nums[ini+1]) {
            swap(nums, ini, ini+1);
            ini++;

            if(ini == nums.length - 1) {
                break;
            }
        }

        System.out.println(Arrays.toString(nums));

    }


    public static void swap(int v[], int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
