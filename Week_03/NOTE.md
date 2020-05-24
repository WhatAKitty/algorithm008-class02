## 学习笔记

### 递归总结

代码模板：
* 递归终结条件
* 当前层逻辑处理
* 递归函数
* 重置当前状态

三个要点：
* 抵制人肉递归
* 找最近重复性
* 数学归纳法思想


### 代码模板

分治代码模板

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states

```

### 附带资料

[牛顿迭代法快速寻找平方根](http://www.matrix67.com/blog/archives/361)
