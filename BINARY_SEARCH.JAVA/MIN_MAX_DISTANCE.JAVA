import java.util.*;

public class Solution {
    public boolean check(List<Integer> stations, int K, double ans) {
        int cnt = 0;
        for (int i = 1; i < stations.size(); i++) {
            double diff = (double) stations.get(i) - (double) stations.get(i - 1);
            if (diff > ans) {
                cnt += (int) (diff / ans);
            }
        }
        return cnt <= K;
    }

    public double findSmallestMaxDist(List<Integer> stations, int K) {
        int n = stations.size();
        double l = 0;
        double h = (double) stations.get(n - 1) - (double) stations.get(0);

        double ans = 0.0;
        while (l <= h) {
            double mid = (l + h) / 2;
            if (check(stations, K, mid)) {
                h = mid - 0.000001;
                ans = mid;
            } else {
                l = mid + 0.000001;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> stations = Arrays.asList(0, 5, 10, 15);
        int K = 2;
        System.out.println(sol.findSmallestMaxDist(stations, K));
    }
}
