class Solution {
    public String simplifyPath(String path) {
        String[] a = path.split("/");
    StringBuilder sb = new StringBuilder();
    Stack<String> st = new Stack <>();

    for(int i=0; i<a.length; i++){
    if(!st.isEmpty()  && a[i].equals("..")) st.pop();
     else if(!a[i].equals(".")&&!a[i].equals("..")&&!a[i].equals("")){
        st.push(a[i]);
     }
    }
    
    if(st.isEmpty()) return "/";
    while(!st.isEmpty()){
      sb.insert(0,st.pop()).insert(0,"/");
    }  
    return sb.toString();
    }
}