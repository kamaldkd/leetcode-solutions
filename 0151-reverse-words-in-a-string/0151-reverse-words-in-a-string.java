import java.util.Stack;
class Solution {
    public String reverseWords(String s) {
    Stack<String> st = new Stack <>();
    StringBuilder sb;
        for(int i=0; i<s.length(); i++){
            sb = new StringBuilder();
            while( i<s.length()&& s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }
            if(sb.length() != 0){
                st.push( sb.toString());
            }
        }
        sb = new StringBuilder();
        while ( st.size() != 1){
            sb.append( st.pop() );
            sb.append(" ");
        }
        sb.append( st.pop());

        return sb.toString();
    }
}