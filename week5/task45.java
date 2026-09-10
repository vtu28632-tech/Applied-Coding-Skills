import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPaths(root, "", result);
        return result;
    }

    private static void findPaths(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }

        String currentPath = path.isEmpty()
                ? String.valueOf(node.val)
                : path + "->" + node.val;

        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }

        findPaths(node.left, currentPath, result);
        findPaths(node.right, currentPath, result);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
            }
}