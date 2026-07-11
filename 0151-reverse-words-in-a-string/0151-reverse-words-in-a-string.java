class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = s1.length-1;
        while(i >= 0){
            if(i==s1.length-1){
                sb.append(s1[i]);
            }
            else{
                sb.append(" ");
                sb.append(s1[i]);
            }
            i--;
        }
        return sb.toString();
    }
}