package second; // Package names should be in lowercase

import java.util.HashMap;

public class Second { 

    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int kVal = arr[j] - arr[i];
                if (kVal < arr[i] && indexMap.containsKey(kVal)) {
                    int k = indexMap.get(kVal);
                    String key = k + "," + i;
                    int currentLen = dp.getOrDefault(key, 2) + 1;
                    dp.put(i + "," + j, currentLen);
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }


        return maxLen >= 3 ? maxLen : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lenLongestFibSubseq(arr)); 
    }
}
