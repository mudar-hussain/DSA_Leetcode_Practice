class Pair{
    int dsum,val,idx;
    public Pair(int d,int a,int b)
    {
        this.dsum = d;
        this.val = a;
        this.idx = b;
    }
}
class Solution {
    public int digitSum(int num)
    {
        int s = 0;
        while(num != 0)
        {
            s += num%10;
            num = num/10;
        }
        return s;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new Pair(digitSum(nums[i]),nums[i],i));
        }
        Collections.sort(list,(a,b)->{
            if(a.dsum == b.dsum) return Integer.compare(a.val,b.val);
            return Integer.compare(a.dsum,b.dsum);
        });

        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            if(list.get(i).idx != i)
            {
                cnt++;
                swap(list,i,list.get(i).idx);
                i--;
            }
        }
        return cnt;
    }
    private void swap(List<Pair> list,int a,int b)
    {
        Pair temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }
}