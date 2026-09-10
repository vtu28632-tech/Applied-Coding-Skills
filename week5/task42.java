import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        // Sort: column -> row -> value
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        List<List<Integer>> result = new ArrayList<>();
        int previousColumn = Integer.MIN_VALUE;

        for (int[] node : nodes) {
            int col = node[0];
            int value = node[2];

            if (col != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = col;
            }

            result.get(result.size() - 1).add(value);
        }

        return result;
    }

    private static void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(new int[]{col, row, node.val});

        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }

    public static void main(String[] args) {
        // Tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
        // Output: [[9], [3, 15], [20], [7]]
    }
}