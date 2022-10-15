class Solution {
    private Map < Integer, Integer > memo = new HashMap < > ();
    Set < Integer > add = Set.of(1, 9, 99);
    public int getLengthOfOptimalCompression(String s, int k) {
        return dp(s.toCharArray(), 0, (char)('a' + 26), 0, k);
    }

    private int dp(char[] chs, int idx, char lastChar, int lastCharCount, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE / 2;
        }

        if (idx == chs.length) {
            return 0;
        }

        int key = idx * 101 * 27 * 101 + (lastChar - 'a') * 101 * 101 + lastCharCount * 101 + k;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int keepChar;
        int deleteChar = dp(chs, idx + 1, lastChar, lastCharCount, k - 1);
        if (chs[idx] == lastChar) {
            keepChar = dp(chs, idx + 1, lastChar, lastCharCount + 1, k) + (add.contains(lastCharCount) ? 1 : 0);
        } else {
            keepChar = dp(chs, idx + 1, chs[idx], 1, k) + 1;
        }
        int res = Math.min(keepChar, deleteChar);
        memo.put(key, res);

        return res;
    }
}