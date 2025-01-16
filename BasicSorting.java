class BasicSorting{

    /**   function to  print the array */
    public static  void printArr(int arr []){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void buubleSort(int arr[]){
        for (int i = 0; i< arr.length-1; i++){
            for (int j = 0; j<arr.length - 1-i; j++){
                // swap
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        printArr(arr);
    }



    /**    optmizedBuubleSort    */
    public static void optmizedBuubleSort(int arr[]){
        for (int i = 0; i< arr.length-1; i++){
            boolean isSwap = false;
            for (int j = 0; j<arr.length - 1-i; j++){
                // swap
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }

            if (! isSwap){
                break;
            }
        }

        printArr(arr);
    }


    public static void selectionSort(int arr[]){
        for (int i=0; i<arr.length-1; i++){
            int min = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }

            if (min != i){
                // swap
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        printArr(arr);
    }

    public static void main(String[] args) {
        int arr[] = {5,9,2,7,1};
        printArr(arr);
        selectionSort(arr);
    }
}