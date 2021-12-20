//用了大量的字符串处理，速度很慢。
class Solution {
    Map<String,List> map = new HashMap<>();
    String path = "";
    List<Integer> list = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) { 
         List<List<Integer>> res = new ArrayList<>();
         visited = new boolean[nums.length];
         int level = 0;
        dfs(nums,0,level);
        Set<Map.Entry<String,List>> set = map.entrySet();
        for(Map.Entry<String,List> o : set){
            res.add(o.getValue());
        }
        return res;
        
    }
    public void dfs(int[] nums,int i,int level){
        if(level == nums.length){
            String s = new String();
            s = path;
            List<Integer> temp = new ArrayList<>(list);
            map.put(s,temp);
            return;
        }
        for(int j = 0;j < nums.length;j++){
            if(!visited[j]){
            visited[j] = true;
            list.add(nums[j]);
            if(nums[j] == 10){
                path +='#';
            }else if(nums[j] == -10){
                path +='*';
            }else{
                path += "" + nums[j];
            }
            dfs(nums,j,level + 1);
            visited[j] = false;
            list.remove(list.size() - 1);
            if(path.length() < 2){
                path = path.substring(0,path.length() - 1);
            }else if(path.charAt(path.length() - 2) == '-'){
                path = path.substring(0,path.length() - 2);
            }else{
                path = path.substring(0,path.length() - 1);
            }
            }
            
        }

    }
}
//利用了剪枝
//O(N×N!)
//O(N×N!)
class Solution {
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) { 
         visited = new boolean[nums.length];
         int level = 0;
         Arrays.sort(nums);
         dfs(nums,level);
         return res;
        
    }
    public void dfs(int[] nums,int level){
            if(level == nums.length){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0;i < nums.length;i++){
                if(visited[i])
                    continue;
                if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                    continue;
                }
                path.add(nums[i]);
                visited[i] = true;
                dfs(nums,level + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
           
            
        }

    
}