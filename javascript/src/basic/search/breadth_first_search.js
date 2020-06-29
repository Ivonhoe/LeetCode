function TreeNode (val) {
    this.val = val;
    this.left = this.right = null;
}

function bfs (root) {
    if (!root) {
        return []
    }

    var result = []
    var queue = []
    queue.push(root)
    while (queue.length) {
        var list = []
        var length = queue.length;
        for (i = 0; i < length; i++) {
            var node = queue.shift()
            list.push(node.val)
            if (node.left) {
                queue.push(node.left)
            }
            if (node.right) {
                queue.push(node.right)
            }
        }
        result.push(list)
    }

    return result
}

function testBfs () {
    var root = new TreeNode(3)
    var node1 = new TreeNode(9)
    var node2 = new TreeNode(20)
    var node3 = new TreeNode(15)
    var node4 = new TreeNode(7)

    root.left = node1
    root.right = node2
    node2.left = node3
    node2.right = node4

    bfs(root)
}

{
    testBfs()
}