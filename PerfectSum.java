import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSum {
    static boolean[][] dp;
    static List<Integer> minSubset = Arrays.asList(new Integer[10]);

    static void display(ArrayList<Integer> v) {
        System.out.println(v);
    }

    static void display2DArray(boolean[][] w) {
        System.out.println(Arrays.deepToString(w));
    }

    static void minimumSubset(ArrayList<Integer> p) {
        // condition to check which one is the minimum array
        // check which has less number of elements
        // store whichever has less number of elements
        if (p.size() < minSubset.size()) {
            minSubset = new ArrayList<>(p);
        }
    }

    static void printMinimumSubset() {
        System.out.println("The optimal subset is: " + Arrays.toString(minSubset.toArray()));
    }

    static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) {
        if (i == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[i]);
            display(p);
            minimumSubset(p);
            p.clear();
            return;
        }

        if (i == 0 && sum == 0) {
            display(p);
            minimumSubset(p);
            p.clear();
            return;
        }

        if (dp[i-1][sum]) {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i-1, sum, b);
        }

        if (sum >= arr[i] && dp[i-1][sum-arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i-1, sum-arr[i], p);
        }

    }

    static void printAllSubsets(int arr[], int n, int sum) {
        if (n == 0 || sum < 0) {
            return;
        }


        // calculate the max sum which you can get
        int max = 0;
        for (int i=0; i<n; i++) {
            max += arr[i];
        }

        // create number of columns based on max sum
        dp = new boolean[n][max+1];

        // initializing the 2d array with first column as true and rest all of it as false
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        // display2DArray(dp);
        if (arr[0] < sum)
            dp[0][arr[0]] = true;
        // display2DArray(dp);

        // logic to fill 2d array as true or false
        for (int i=1; i<n; i++) {
            for (int j=1; j< max+1; j++) {
                dp[i][j] = (arr[i] <= j) ?(dp[i-1][j] || dp[i-1][j-arr[i]]): dp[i-1][j];
            }
        }

        // display2DArray(dp);

        ArrayList<Integer> p = new ArrayList<>();
        int flag = 0;
        // let us find the first value which is equal to or greater than our given sum
        for (int i=sum; i<max+1; i++) {
            if (dp[n-1][i]) {
                flag = i;
                break;
            }
        }
        printSubsetsRec(arr, n-1, flag, p);

    }

    public static void  main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        int sum = 5;
        printAllSubsets(arr, n, sum);
        printMinimumSubset();
    }
}
