public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};
        int[] output = getStartOfEachValues(arr, values);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];

        for(int i=0; i<values.length; i++){
            int left = 0, right = arr.length-1;

            while(left<right){
                int mid = left+(right-left)/2;
                if(arr[mid]>=values[i]){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
            }

            if(values[i]==arr[left]){
                indexes[i] = left;
            }else{
                indexes[i] = -1;
            }
        }

        return indexes;
    }
}