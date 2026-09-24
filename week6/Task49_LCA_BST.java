class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class Task49_LCA_BST {
    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(4);
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        System.out.println("LCA in BST = " + lca(root, p, q).val);
    }
}
