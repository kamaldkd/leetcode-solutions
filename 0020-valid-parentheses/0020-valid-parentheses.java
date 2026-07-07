import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
     Stack<Character> st = new Stack<>();

     for(int i=0; i<s.length(); i++){
        if(st.size()==0){
            if(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']' ) return false;
            else st.push(s.charAt(i));     
        }
        else{
            if(st.peek()=='(' && s.charAt(i)==')' ) st.pop();
         else if(st.peek()=='[' && s.charAt(i)==']' ) st.pop();
         else if(st.peek()=='{' && s.charAt(i)=='}' ) st.pop();
         else st.push(s.charAt(i));
        }
     }
     if(st.isEmpty()) return true;
     else return false;
    }
}