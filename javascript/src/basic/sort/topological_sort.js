/**
 * tarjan 求强连通分量
 * @param {number} number 节点个数
 * @param {number[][]} prerequisites 依赖关系
 */
function topologicalSort(number, prerequisites) {
    let adjacency = Array();
    let ans = Array();
    for (let i = 0; i < number; i++) {
        adjacency[i] = Array()
    }
    for (let i in prerequisites) {
        let end = prerequisites[i][0]
        let start = prerequisites[i][1]
        adjacency[start].push(end)
    }

    var stack = []
    var time = 1 //时间戳，节点被访问的时间点
    var dfn = Array(number).fill(0) //每个节点被访问的真实时间点
    var low = [] //为u或者u的子树能够追溯到的最早的栈中的节点的次序号。

    var tanjin = function (x) {
        stack.push(x)
        dfn[x] = low[x] = time++
        // x所有的子节点y
        for (let y = 0; y < adjacency[x].length; y++) {
            let v = adjacency[x][y]
            if (dfn[v] == 0) {
                tanjin(v)
                low[x] = Math.min(low[x], low[v])
            } else if (stack.indexOf(v) >= 0) {
                // 在栈中
                low[x] = Math.min(low[x], dfn[v])
            }
        }

        if (dfn[x] == low[x]) {
            let cnt = 0
            let result = Array()
            while (1) {
                let now = stack.pop()
                cnt++
                result.push(now)
                if (now == x) {
                    break
                }
            }
            if (result.length > 1) {
                ans.push(result)
            }
        }
    }

    for (let i = 0; i < number; i++) {
        if (dfn[i] == 0) {
            tanjin(i)
        }
    }

    return ans
}

function testTanjin() {
    var result = topologicalSort(5, [
        [0, 4],
        [1, 0],
        [1, 2],
        [3, 1],
        [2, 3]
    ])
    console.log("result:" + result)
}

{
    testTanjin()
}