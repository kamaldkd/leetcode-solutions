class Solution {
    public static int search(int[] arr, int si, int ei, int target){
        
        if(si > ei){
            return -1;
        }
        
        int mid = si + (ei-si)/2;

        if(target == arr[mid]){
            return mid;
        }
        //mid is on line 1
        if(arr[mid] >= arr[si]){
            if(target >= arr[si] && target <= arr[mid]){
                return search(arr, si, mid-1, target);
            }else{
                return search(arr, mid+1, ei, target);
            }
        }else{//mid is on line 2
            if(target >= arr[mid] && target <= arr[ei]){
                return search(arr, mid+1, ei, target);
            }else{
                return search(arr, si, mid-1, target);
            }                  
        }
    }
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        return search(nums, si, ei, target);
    }
}