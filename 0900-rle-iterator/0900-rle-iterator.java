class RLEIterator {

	int[] arr;
	int len;
	int idx = 0;
    public RLEIterator(int[] encoding) {
        len = encoding.length;
        arr = encoding;
    }
    
    public int next(int n) {
        while(idx < len){
            while(arr[idx] == 0 && idx < len){
                idx += 2;
            }

            if(idx >= len){
                return -1;
            }

            while(idx < len){
                if(n <= arr[idx] && arr[idx] != 0){
                    arr[idx] -= n;
                    return arr[idx+1];
                }
                else {
                    n -= arr[idx];
                    arr[idx] = 0;
                    idx += 2;
                }
            }

        return -1;
    }

    return -1;
    }
}
