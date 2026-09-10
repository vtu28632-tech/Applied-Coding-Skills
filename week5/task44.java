import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private static void findPaths(TreeNode node, int remainingSum,
                                  List<Integer> path,
                                  List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null
                && node.val == remainingSum) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, remainingSum - node.val, path, result);
            findPaths(node.right, remainingSum - node.val, path, result);
        }

        path.remove(path.size() - 1);     }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
           }
}