import java.util.LinkedList;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//
////        TreeNode root = new TreeNode(1,
////                new TreeNode(2,
////                        new TreeNode(4,
////                                new TreeNode(8, null, null),
////                                null),
////                        new TreeNode(5,
////                                null,
////                                new TreeNode(9, null, null))),
////                new TreeNode(3,
////                        new TreeNode(6, null, null),
////                        new TreeNode(7, null, null)));
//
//        TreeNode root = new TreeNode(5,
//                new TreeNode(3,
//                        new TreeNode(1,
//                                null,
//                                new TreeNode(2, null, null)),
//                        null),
//                new TreeNode(10,
//                        new TreeNode(6, null, null),
//                        new TreeNode(15, null, null)));
//
//        System.out.println(new Main().inOrder(root));
//        System.out.println(new Main().isValidBST(root));
//    }

    // DFS
    // left subtree, root, right subtree
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        result.addAll(inOrder(root.left));
        result.add(root.value);
        result.addAll(inOrder(root.right));

        return result;
    }

    // Напишите функцию, которая определяет, является ли бинарное дерево деревом поиска.
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    // проверить что каждая вершина левого поддерева МЕНЬШЕ чем корень
    // проверить что каждая вершина правого поддерева БОЛЬШЕ чем корень

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        // проверка на нарушение условия
        if (root.value >= max) {
            return false;
        }

        // проверка на нарушение условия
        if (root.value <= min) {
            return false;
        }

        return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);

    }

    public void failsOnNull(TreeNode root) {
        System.out.println(root.value);
    }

}

// больше-меньше это BST
// binary search tree