class Solution {
    public void backtrack(int n,int k,List<List<Integer>> res,ArrayList<Integer> list,int start){
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=start;i<=n;i++){
            list.add(i);
            backtrack(n,k-1,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        backtrack(n,k,res,new ArrayList<Integer>(),1);
        return res;
    }
}