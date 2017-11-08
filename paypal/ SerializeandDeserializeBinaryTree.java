    private static final String splider = ",";
        private static final String NN= "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        BuilderStr(root,sb);
        return sb.toString();
    }
    private void BuilderStr(TreeNode node,StringBuilder sb)
    {
        if (node==null) sb.append(NN).append(splider);
        else
        {
            sb.append(node.val).append(splider);
            BuilderStr(node.left,sb);
            BuilderStr(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> node = new LinkedList<>();
        node.addAll(Arrays.asList(data.split(splider)));
        return BuilderNode(node);
    }
    private TreeNode BuilderNode(Deque<String> nodes)
    {
        String val = nodes.remove();
            if (val.equals(NN)) return null;
                else
                {
                    TreeNode node = new TreeNode(Integer.valueOf(val));
                    node.left = BuilderNode(nodes);//left's out first
                    node.right= BuilderNode(nodes);
                    return node;
                }
    }