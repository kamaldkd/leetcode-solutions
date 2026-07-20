class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0, left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0; right<fruits.length; right++) {
            int curr = fruits[right];

            // 1. Add current fruit first 
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // 2. Then check whether window became inavalid 
            while(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left])-1);

                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }
            
            // 3. Valid window 
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}