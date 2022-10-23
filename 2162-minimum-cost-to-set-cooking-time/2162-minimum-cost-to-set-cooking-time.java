class Solution {
	public int evaluate(int s, int mc, int pc, int m, int sec) {
		int total = m * 100 + sec;
		List<Integer> pos = new ArrayList<>();
		while(total != 0) {
			pos.add(total % 10);
			total /= 10;
		}

		Collections.reverse(pos);
		int cost = 0;
		for(int num: pos) {
			if(num == s) 
                cost += pc;
			else {
				cost += pc + mc;
				s = num;
			}
		}

		return cost;
	}

	public int minCostSetTime(int s, int mc, int pc, int ts) {
		int ans = Integer.MAX_VALUE;
		if(ts <= 99){
			ans = Math.min(ans, evaluate(s, mc, pc, 0, ts));
            

			if(ts >= 60){
				ans = Math.min(ans, evaluate(s, mc, pc, 1, ts%60));
                
			}
		}

		else {
			int m = ts /60, sec = ts % 60;
            
			if(m < 100){
				ans = Math.min(ans, evaluate(s, mc, pc, m, sec));
			}

			m -= 1;
			sec += 60;

			if(sec <= 99){
				ans = Math.min(ans, evaluate(s, mc, pc, m, sec));
			}
		}

		return ans;
	}
}


