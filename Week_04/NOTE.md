## 学习笔记

### 代码模板

DFS二叉树递归模板
```js
visited = [];

function dfs(treeNode) {
    if (visited.includes(treeNode)) {
        return;
    }
    
    visited.add(treeNode);
    
    // process tree node
    
    dfs(treeNode.left);
    dfs(treeNode.right);
} 
```

DFS多叉树递归模板
```js
visited = [];

function dfs(treeNode) {
    visited.add(treeNode);
    
    // process tree node
    
    for (const item : treeNode.children) {
        if (!visited.includes(item)) {
            dfs(item);
        }   
    }
} 
```

BFS多叉树递归模板
```js
visited = [];

function bfs(treeNode) {
    queue = [];
    
    queue.push(treeNode);

    while (queue.length > 0) {
        const node = queue.pop();
        if (!visited.includes(node)) {
            visited.add(node);
            
            for (const item : node.children) {
                queue.push(item);
            }
        }
        
    }
}
```

### 贪心算法

#### VS 回溯以及动态规划

* 贪心：当下做局部最优判断，不能回退
* 回溯：能够回退
* 动态规划：保存当前的结果、最优判断 + 回退

#### 特点

* 比较高效
* 解法一般接近甚至就是最优解
