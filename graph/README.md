# 图问题

### 实现

| 问题 | 备注 | 链接 |
|---|---|---|
| DenseGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseGraph.java) |
| SparseGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseGraph.java) |
| ReadGraphHelper | 读取文件数据，并存进 Graph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/ReadGraphHelper.java) |
| DenseAndSparseGraph | 借助 ReadGraphHelper 测试 DenseGraph 和 SparseGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseAndSparseGraph.java) |
| Component | 采用 DFS 求联通分量 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Component.java) |
| Path | 采用 BFS 求最短路径 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Path.java) |

### 实验

```
"C:\Program Files\Java\jdk1.8.0_172\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.4\lib\idea_rt.jar=11499:C:\Program Files\JetBrains\IntelliJ IDEA 2018.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_172\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_172\jre\lib\rt.jar;C:\Users\Patrick-lenovo\Documents\Workspace\DataStructures-Algorithmns\out\production\DataStructures-Algorithmns" DenseAndSparseGraph
test G1 in Dense Graph:
false	true	true	false	false	true	true	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
false	false	false	false	true	true	false	false	false	false	false	false	false	
false	false	false	true	false	true	true	false	false	false	false	false	false	
true	false	false	true	true	false	false	false	false	false	false	false	false	
true	false	false	false	true	false	false	false	false	false	false	false	false	
false	false	false	false	false	false	false	false	true	false	false	false	false	
false	false	false	false	false	false	false	true	false	false	false	false	false	
false	false	false	false	false	false	false	false	false	false	true	true	true	
false	false	false	false	false	false	false	false	false	true	false	false	false	
false	false	false	false	false	false	false	false	false	true	false	false	true	
false	false	false	false	false	false	false	false	false	true	false	true	false	
component = 3
0
0 -> 1
0 -> 2
0 -> 5 -> 3
0 -> 5 -> 4
0 -> 5
0 -> 6
7
8
9
10
11
12

test G1 in Sparse Graph:
vertex 0:	5	1	2	6	
vertex 1:	0	
vertex 2:	0	
vertex 3:	4	5	
vertex 4:	3	6	5	
vertex 5:	0	4	3	
vertex 6:	4	0	
vertex 7:	8	
vertex 8:	7	
vertex 9:	12	10	11	
vertex 10:	9	
vertex 11:	12	9	
vertex 12:	9	11	
component = 3
0
0 -> 1
0 -> 2
0 -> 5 -> 3
0 -> 5 -> 4
0 -> 5
0 -> 6
7
8
9
10
11
12

test G2 in Dense Graph:
false	true	true	false	false	true	true	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
false	false	false	false	true	true	false	false	false	false	false	false	false	
false	false	false	true	false	true	true	false	false	false	false	false	false	
true	false	false	true	true	false	false	false	false	false	false	false	false	
true	false	false	false	true	false	false	false	false	false	false	false	false	
false	false	false	false	false	false	false	false	true	false	false	false	false	
false	false	false	false	false	false	false	true	false	false	false	false	false	
false	false	false	false	false	false	false	false	false	false	true	true	true	
false	false	false	false	false	false	false	false	false	true	false	false	false	
false	false	false	false	false	false	false	false	false	true	false	false	true	
false	false	false	false	false	false	false	false	false	true	false	true	false	
component = 1
0
0 -> 1
0 -> 2
0 -> 1 -> 3
0 -> 1 -> 4
0 -> 5

test G2 in Sparse Graph:
vertex 0:	5	1	2	6	
vertex 1:	0	
vertex 2:	0	
vertex 3:	4	5	
vertex 4:	3	6	5	
vertex 5:	0	4	3	
vertex 6:	4	0	
vertex 7:	8	
vertex 8:	7	
vertex 9:	12	10	11	
vertex 10:	9	
vertex 11:	12	9	
vertex 12:	9	11	
component = 1
0
0 -> 1
0 -> 2
0 -> 1 -> 3
0 -> 1 -> 4
0 -> 5


Process finished with exit code 0
```