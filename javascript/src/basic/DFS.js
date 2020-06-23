function TreeNode (val) {
    this.val = val;
    this.left = this.right = null;
}

function dfs (root) {
    if (root == null) {
        return
    }

    var queue = []
    queue.push(root)
    while (queue.length > 0) {
        var node = queue.pop()
        console.log(node.val)
        if (node.right != null) {
            queue.push(node.right)
        }
        if (node.left != null) {
            queue.push(node.left)
        }
    }
}

function testDfs () {
    var root = new TreeNode(3)
    var node1 = new TreeNode(9)
    var node2 = new TreeNode(20)
    var node3 = new TreeNode(15)
    var node4 = new TreeNode(7)

    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4

    dfs(root)
}

{
    testDfs()
}