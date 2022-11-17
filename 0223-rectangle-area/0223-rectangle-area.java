class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a1 = (ax2 - ax1) * (ay2 - ay1);
        int a2 = (bx2 - bx1) * (by2 - by1);
        int d1 = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1)); //x
        int d2 = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1)); //y
        int overlapp = d1 * d2;
        
        return a1 + a2 - overlapp;
    }
}