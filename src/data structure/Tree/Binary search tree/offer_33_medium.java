class Solution {
    public boolean verifyPostorder(int[] postorder) {
        /**
        每划分一次左右子树，都要判断左右子树所有节点和根节点的大小关小，不仅仅是根节点
         */
        return help(postorder,0,postorder.length - 1);
    }
    public boolean help(int[] postorder,int start,int end){
        /**
        返回：是否左子树小于根节点并且右子树大于根节点
        终止：start > end,返回true
        每层：找到第一个比根节点大的，以此划分左右子树
         */
         if(start > end){
             return true;
         }
         int root = end;
         for(int i = start;i < end;i++){//找到第一个比根节点大的
             if(postorder[i] > postorder[end]){
                 root = i;
                 break;
             }
         }
         for(int i = start;i < root;i++){//判断是否左子树都小于根节点
             if(postorder[i] > postorder[end])
                return false;
         }
         for(int i = root;i < end;i++){//判断是否右子树都大于根节点
             if(postorder[i] < postorder[end])
                return false;
         }
         return help(postorder,start,root - 1) && help(postorder,root,end - 1);
    }
}