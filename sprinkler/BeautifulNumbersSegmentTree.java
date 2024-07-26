import java.util.Scanner;

public class BeautifulNumbers {
    private static final int MOD = (int) 1e9;
    private static final int MAX_VAL = 1000000; // Adjust based on problem constraints
    private static long[] prefixSum = new long[MAX_VAL + 1];

    // Function to count the number of 0 bits in the binary representation of a number
    private static int countZeroBits(int x) {
        return Integer.SIZE - Integer.bitCount(x);
    }

    // Precompute beautiful numbers and their cubes up to MAX_VAL
    private static void precomputeBeautifulCubes() {
        for (int i = 1; i <= MAX_VAL; i++) {
            int zeroBits = countZeroBits(i);
            if (1 <= zeroBits && zeroBits <= 3) {
                long cube = (long) i * i * i % MOD;
                prefixSum[i] = (prefixSum[i - 1] + cube) % MOD;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
    }

    // Function to process a single query
    private static long processQuery(int l, int r) {
        if (l > r) {
            return 0;
        }
        return (prefixSum[r] - prefixSum[l - 1] + MOD) % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Precompute beautiful numbers and their cubes
        precomputeBeautifulCubes();
        
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(processQuery(l, r));
        }
        
        scanner.close();
    }
}




import java.util.Scanner;

public class BeautifulNumbersSegmentTree {
    private static final int MOD = (int) 1e9;
    private static final int MAX_VAL = 1000000; // Adjust based on problem constraints
    private static long[] segmentTree;
    private static long[] beautifulCubes;

    // Function to count the number of 0 bits in the binary representation of a number
    private static int countZeroBits(int x) {
        return Integer.SIZE - Integer.bitCount(x);
    }

    // Build the segment tree
    private static void buildSegmentTree(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = beautifulCubes[start];
        } else {
            int mid = (start + end) / 2;
            buildSegmentTree(2 * node, start, mid);
            buildSegmentTree(2 * node + 1, mid + 1, end);
            segmentTree[node] = (segmentTree[2 * node] + segmentTree[2 * node + 1]) % MOD;
        }
    }

    // Range sum query
    private static long rangeSum(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        long leftSum = rangeSum(2 * node, start, mid, l, r);
        long rightSum = rangeSum(2 * node + 1, mid + 1, end, l, r);
        return (leftSum + rightSum) % MOD;
    }

    // Main function to handle input and output
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize arrays
        segmentTree = new long[4 * MAX_VAL];
        beautifulCubes = new long[MAX_VAL + 1];

        // Precompute beautiful numbers and their cubes up to MAX_VAL
        for (int i = 1; i <= MAX_VAL; i++) {
            int zeroBits = countZeroBits(i);
            if (1 <= zeroBits && zeroBits <= 3) {
                beautifulCubes[i] = (long) i * i * i % MOD;
            } else {
                beautifulCubes[i] = 0;
            }
        }

        // Build the segment tree
        buildSegmentTree(1, 1, MAX_VAL);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long result = rangeSum(1, 1, MAX_VAL, l, r);
            System.out.println(result);
        }

        scanner.close();
    }
}
