class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs) {
            
        String sorted = sort(s);
        
        if(map.containsKey(sorted)) {
             map.get(sorted).add(s);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            map.put(sorted, list);
        }
        }
        
        
        List<List<String>> ans = new ArrayList<>();
        for(ArrayList<String> list : map.values()) {
            ans.add(list);
        }
        
        return ans;
    }
    public String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}