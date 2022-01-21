class Solution {
    class Node {
        char ch;
        int val;
        
        Node(int v, char c){
            this.val = v;
            this.ch = c;
        }
        
        public String toString(){
            return this.ch + ":" + this.val;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        List<Node> list = new ArrayList<>();
        for(int[] i: intervals){
            list.add(new Node(i[0], 's'));
            list.add(new Node(i[1], 'e'));
        }
        
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                int c = Integer.compare(n1.val, n2.val);
                if(c == 0){
                    return Character.compare(n1.ch, n2.ch);
                }
                
                return c;
            }
        });
        
        System.out.println(list);
        int count =0;
        int max = 0;
        
        for(Node num: list){
            if(num.ch == 's'){
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        
        return max;
    }
}