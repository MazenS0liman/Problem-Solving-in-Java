import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        int [] arr = {5,2,7,5,2};

        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int result = -1;
        int length = arr.length;

        for (int i = 0; i < length; i++) { // O(n)
            if (!hashMap.containsKey(arr[i])) { // O(1)
                hashMap.put(arr[i], false);
            }
            else {
                hashMap.put(arr[i], true);
            }
        }

        for (int j : arr) { // O(n)
            if (!hashMap.get(j)) { // O(1)
                result = j;
            }
        }

        System.out.println(result);
    }

}