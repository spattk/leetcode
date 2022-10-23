class SnapshotArray {

	//snapId -> Map
	//array of TreeMap for each index stores the snapId and value
	TreeMap<Integer, Integer>[] snapMap;
    Integer snapId;
   	public SnapshotArray(int length) {
  		snapMap = new TreeMap[length];
		for(int i=0; i<length; i++){
			snapMap[i] = new TreeMap<>();
			snapMap[i].put(0,0);
		}
		snapId = 0;
  	 }
    
	public void set(int index, int val) {
		snapMap[index].put(snapId, val);
 	}
    
public int snap() {
   	snapId++;
	return snapId-1;
 }
    
   	public int get(int index, int snap_id) {
		return snapMap[index].floorEntry(snap_id).getValue();
	}
}
