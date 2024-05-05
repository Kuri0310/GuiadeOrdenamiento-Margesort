public class App {
    public static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            //encuetra el punto medio del arreglo 
            int mid = (left + right) / 2;
    
            //ordea recursivamente la mitad de la izquierda
            mergeSort(arr, left, mid);

            //ordena recursivamente la mitad de la derecha
            mergeSort(arr, mid + 1, right);
    
            //combina as 2 mitades ordenadas
            merge(arr, left, mid, right);
        }
    
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        //tamaños de los subarrelogs a fusionar 
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;
    
        //arreglos temporales para almacear los subarreglos
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];
    
        //copia datos a los arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }
    
        //fusiona los subarreglos temporales en el arrelo original
        int i = 0, j = 0;
        int k = left; //indice inicial para el arreglo fusionado 
    
        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }
    
        //copia los elementos restantes de temLeft[] si los hay
        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }
    
        //copia elementos restantes de temRight[] si los hay
        while (j < sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
    
        }
    }
    public static void main(String[] args) throws Exception {

        int[] arr = {50, 86, 30, 90, 5, 4, 6};
        int n = arr.length;
        System.out.println("Arreglo desordenado:");
        for (int num : arr) {
            System.out.println(num +  "");
        }

        mergeSort(arr,  0, n - 1); // //llamada al metodo del ordenamiento MergeSort

        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.println(num +  "");
        }
    }
}
