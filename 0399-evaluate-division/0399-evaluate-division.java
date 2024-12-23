class Solution {

    Map<String, Map<String,Double>> map = new HashMap<>();
    Set<String> seen = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] ans = new double[n];

        for(int i=0; i<equations.size(); i++){
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());

            map.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);
        }

        for(int i=0; i<queries.size(); i++){
            seen.clear();
            ans[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),1.0);
        }
        return ans;
    }

    private double dfs(String a, String b, double num){
        if(!map.containsKey(a)) return -1.0;
        if(a.equals(b)) return num;
        seen.add(a);

        for(var div: map.get(a).entrySet()){

            if (!seen.contains(div.getKey())) {
                double ans = dfs(div.getKey(), b, div.getValue());
                if(ans != -1) return num * ans;
            }
        
        }    
        return -1.0;
    }

}