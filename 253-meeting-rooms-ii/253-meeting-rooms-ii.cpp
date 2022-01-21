bool cmp(vector<int> a, vector<int> b)
{
    return a[0]<b[0];
}


class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& its) {
        
    
        sort(its.begin(),its.end(),cmp);
        
        priority_queue <int, vector<int>, greater<int> > pq;
        pq.push(its[0][1]);
        int i,n=its.size(),maxi=1;
        
        for(i=1;i<n;i++)
        {
            while(!pq.empty() && its[i][0]>=pq.top())
            {
                pq.pop();
            }
            
            pq.push(its[i][1]);
            
            if(pq.size()>maxi)
            {
                maxi=pq.size();    
            }
        }
        
        return maxi;
    }
};