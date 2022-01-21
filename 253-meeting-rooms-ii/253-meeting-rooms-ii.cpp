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
          //  cout<<"top "<<pq.top()<<endl;
            while(!pq.empty() && its[i][0]>=pq.top())
            {
            //    cout<<"check "<<endl;
                pq.pop();
            }
            
            pq.push(its[i][1]);
            //cout<<"size "<<pq.size()<<endl;
            
            if(pq.size()>maxi)
            {
                maxi=pq.size();    
            }
            
            
        }
        
        return maxi;
    }
};