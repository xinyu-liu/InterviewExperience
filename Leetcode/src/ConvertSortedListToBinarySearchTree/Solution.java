package ConvertSortedListToBinarySearchTree;

public class Solution {
	// sample
    public static TreeNode sortedListToBST(ListNode head) {  
        return rec(head, null);  
    }  
    // 在区间[start, end)里递归，后面的end是包括在内的，这样可以避免要多用一个指针来记录mid前的节点  
    public static TreeNode rec(ListNode start, ListNode end){  
        if(start == end){  
            return null;  
        }  
        // 一次遍历找到中点的方法：快慢指针  
        ListNode mid = start;           // 该指针最终会指向中点  
        ListNode probe = start;         // 探针最终会到达end  
        while(probe!=end && probe.next!=end){
        	/////////////////// 探针完成搜索，注意停止条件是和end比较而不是和null比！  
            mid = mid.next;  
            probe = probe.next.next;  
        }          
        TreeNode root = new TreeNode(mid.val);  
        root.left = rec(start, mid);  
        root.right = rec(mid.next, end);  
        return root;  
    }  
   
	// mine
    public TreeNode sortedListToBST_MINE(ListNode head) {
        return transfer(head,null);     
    }
    public TreeNode transfer(ListNode start, ListNode end) {
    	if(start == end){
    		return null;
    	}
    	// find mid
    	ListNode mid = start;
    	ListNode fast = start;
    	while(fast!= end && fast.next!= end){
    		fast = fast.next.next;
    		mid = mid.next;
    	}
    	
        TreeNode root = new TreeNode(mid.val);
        root.left = transfer(start, mid);
        root.right = transfer(mid.next, end);
        return root;   
    }
}
