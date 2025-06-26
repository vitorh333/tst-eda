import java.util.*;

class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String linha = input.nextLine();
        String[] lista = linha.split(" ");

        int[] nums = new int[lista.length];

        for(int i = 0; i < lista.length; i++) {
            nums[i] = Integer.parseInt(lista[i]);

        }

        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;    
            while(j > 0 && nums[j] < nums[j-1]) {
                swap(nums, j, j-1);
                j--;

            }

            System.out.println(Arrays.toString(nums));

        }
    }

    public static void swap(int v[], int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;

    }
}
