/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    
    public String getHostName(String url) {
        String str = url.substring(7);
        String[] arr = str.split("/");
        return arr[0];
    }
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = getHostName(startUrl);
        ExecutorService es = Executors.newFixedThreadPool(5, r-> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        
        Queue<Future> tasks = new LinkedList<>();
        List<String> res = new ArrayList<>();
        BlockingQueue<String> q = new LinkedBlockingQueue<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(startUrl);
        
        while(true){
            String url = q.poll();
            if(url != null) {
                if(getHostName(url).equals(hostName) && !visited.contains(url)){
                    res.add(url);
                    visited.add(url);
                    
                    tasks.add(es.submit(() -> {
                        List<String> newUrls = htmlParser.getUrls(url);
                        for(String newUrl: newUrls){
                            q.add(newUrl);
                        }
                    }));
                }
            } else {
                if(!tasks.isEmpty()){
                    Future nextTask = tasks.poll();
                    try {
                        nextTask.get();
                    } catch (Exception e){}
                } else {
                    break;
                }
            }
        }
        
        return res;
    }
}