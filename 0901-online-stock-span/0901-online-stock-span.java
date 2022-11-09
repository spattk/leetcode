class StockSpanner {

    Stack<int[]> st;
    int i;
    public StockSpanner() {
        st = new Stack<>();
        i = 0;
    }
    
    public int next(int price) {
		int ret = 0;
     	if(st.isEmpty()){
			ret = i+1;
		}
		else {
			while(!st.isEmpty() && st.peek()[0] <= price){
				st.pop();
			}

			if(st.isEmpty()){
				ret = i+1;
			}
			else {
				ret = i - st.peek()[1];
			}
		}

		st.push(new int[]{price, i});
		i++;
		return ret;
    }
}


