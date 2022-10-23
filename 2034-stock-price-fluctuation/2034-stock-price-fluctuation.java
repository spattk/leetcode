class StockPrice {

	Map<Integer, Integer> timePrice;
	//value, freq
	TreeMap<Integer, Integer> prices;
	int maxTimeStamp = -1;
   public StockPrice() {
   	timePrice = new HashMap<>();
		prices = new TreeMap<>();
   }
    
   public void update(int timestamp, int price) {
 		maxTimeStamp = Math.max(maxTimeStamp, timestamp);
		
		Integer old = timePrice.get(timestamp);
		if(old != null) {
			prices.put(old, prices.getOrDefault(old, 0) - 1);
			
			if(prices.get(old) == 0)
				prices.remove(old);
		}
		
		timePrice.put(timestamp, price);
		prices.put(price, prices.getOrDefault(price,0) + 1);
   }
    
   public int current() {
   	return timePrice.get(maxTimeStamp);
   }
    
   public int maximum() {
      return prices.lastEntry().getKey();
   }
    
   public int minimum() {
   	return prices.firstEntry().getKey();    
   }
}
