import java.util.*;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        BIT bit = new BIT(n+m+1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            bit.add(n+i, 1);
            map.put(i, n+i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = map.remove(queries[i]);
            res[i] = bit.prefixSum(index-1);

            int new_index = n - i;
            bit.add(index, -1);
            bit.add(new_index, 1);
            map.put(queries[i], new_index);
        }
        return res;
    }

    class BIT {
        int[] a;

        public BIT(int n) {
            a = new int[n];
        }

        public void add(int index, int delta) {
            while (index < a.length) {
                a[index] += delta;
                index += index & (-index);
            }
        }

        public int prefixSum(int index) {
            int res = 0;
            while (index > 0) {
                res += a[index];
                index -= index & (-index);
            }
            return res;
        }
    }
}