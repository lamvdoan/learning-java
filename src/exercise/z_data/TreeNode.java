package exercise.z_data;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Integer val = null;

    public TreeNode() {}

    public TreeNode(Integer val) {
        if (val != null) {
            this.val = val;
        }
    }

    public Integer getVal() {
        return val != null ? val : null;
    }
}
