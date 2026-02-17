package Review.BFS_DFS;

import java.util.*;
import static java.util.Arrays.asList;

/**
 * Represents a node in a weighted undirected graph.
 * @param <T> a type for data stored in a graph node
 * @param neighbours the neighbouring nodes (connected via an edge) of
 *                   the graph node
 * @param neighboursCosts   a map from the neighbouring nodes (connected via an edge) of
 *                          the graph node to the cost of the corresponding edge. Edge
 *                          costs are assumed to be non-negative integer numbers.
 *
 * @implSpec Invariants:
 *    - neighbours does not contain repeated elements.
 *    - for every GraphNode<T> in neighbours, the result of calling
 *      getNeighbours() contains this
 *    - neighbours contains the same elements as the key set of the
 *      neighboursCosts map
 *    - all the values in neighboursCosts are non-negative
 */
public class GraphNode<T> {
    private final T value;
    private final List<GraphNode<T>> neighbours = new ArrayList<>();
    private final Map<GraphNode<T>, Integer> neighboursCosts = new HashMap<>();

    /**
     * Creates a new GraphNode<T> given the value, neighbours, and associated costs.
     * @param value The value to be stored within the newly created graph node.
     * @param neighbours A list of neighbours of the newly created graph node.
     * @param neighboursCosts A list with the costs associated to the edges that connect the newly
     *                        created node with its neighbours. All costs have to be non-negative.
     *
     * Effects:
     *          - the newly created node is added to neighbours.
     *          - Besides, a new key-value pair is added
     *            to neighboursCosts with the key being the newly created node,
     *            and the value the cost of the corresponding connection.
     *
     * @implSpec Precondition: The size of neighbours and neighboursCosts must match.
     * @implSpec Precondition: neighboursCosts[i] must contain the cost of the edge
     *                         that connects the newly created node and neighbours[i] for all i.
     * @implSpec Postcondition: All invariants of GraphNode<T> are satisfied for the
     *                          newly created node
     */

    public GraphNode(T value, List<GraphNode<T>> neighbours, List<Integer> neighboursCosts) {
        this.value = value;
        for (int i=0; i<neighbours.size();i++) {
            var neighbour = neighbours.get(i);
            var cost = neighboursCosts.get(i);

            // Add neighbour to this and the reciprocal connection
            this.neighbours.add(neighbour);
            neighbour.neighbours.add(this);

            // Add cost to the connection among this and neighbour
            // and to the reciprocal connection
            this.neighboursCosts.put(neighbour, cost);
            neighbour.neighboursCosts.put(this, cost);
        }
    }

    /**
     * @return the value associated with the current graph node
     */
    T getValue() {
        return value;
    }

    /**
     * @return the neighbouring nodes (connected via an edge) of
     * the graph node
     * @implSpec Postcondition: the returned Collection contains the same
     *   elements as the key set of the map returned by getCostedNeighbours
     * @implSpec Postcondition: for every GraphNode<T> in the result,
     *   the result of calling getNeighbours() on that node contains this
     */
    Collection<GraphNode<T>> getNeighbours() {
        return neighbours;
    }

    /**
     * @return a map from the neighbouring nodes (connected via an edge) of
     * the graph node to the cost of the corresponding edge
     * @implSpec Postcondition: the key set of the returned map contains
     *   the same elements as the Collection returned by getNeighbours
     * @implSpec Postcondition: for every GraphNode<T> in the key set of
     *   the result, the key set of calling getCostedNeighbours on that
     *   node contains this
     */
    Map<GraphNode<T>, Integer> getNeighboursCosts() {
        return neighboursCosts;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static GraphNode<Integer> generateExampleGraph1() {
        return new GraphNode<>(5, asList(), asList());
    }

    public static GraphNode<String> generateExampleGraph2() {
        var nodeA = new GraphNode<>("A", asList(), asList());
        var nodeB = new GraphNode<>("B", asList(nodeA), asList(1));
        return nodeA;
    }

    public static GraphNode<Integer> generateExampleGraph3() {
        var node1 = new GraphNode<>(1, asList(), asList());
        var node2 = new GraphNode<>(2, asList(node1), asList(2));
        var node3 = new GraphNode<>(3, asList(node1), asList(1));
        return node1;
    }

    public static GraphNode<Integer> generateExampleGraph4() {
        var node1 = new GraphNode<>(1, asList(), asList());
        var node2 = new GraphNode<>(2, asList(node1), asList(2));
        var node3 = new GraphNode<>(3, asList(node1,node2), asList(4, 1));
        return node3;
    }

    public static GraphNode<String> generateExampleGraph5() {
        var nodeA = new GraphNode<>("A", asList(), asList());
        var nodeB = new GraphNode<>("B", asList(nodeA), asList(15));
        var nodeC = new GraphNode<>("C", asList(nodeB), asList(20));
        var nodeD = new GraphNode<>("D", asList(nodeA,nodeC), asList(10,5));
        var nodeE = new GraphNode<>("E", asList(nodeD,nodeB), asList(11,7));
        return nodeA;
    }

    public static GraphNode<Integer> generateExampleGraph6() {
        var node111 = new GraphNode<>(111, asList(), asList());
        var node222 = new GraphNode<>(222, asList(node111), asList(4));
        var node333 = new GraphNode<>(333, asList(node111), asList(5));
        var node444 = new GraphNode<>(444, asList(node111), asList(17));
        var node555 = new GraphNode<>(555, asList(node222), asList(5));
        var node666 = new GraphNode<>(666, asList(node222), asList(12));
        var node777 = new GraphNode<>(777, asList(node222), asList(6));
        var node888 = new GraphNode<>(888, asList(node333), asList(11));
        var node999 = new GraphNode<>(999, asList(node333), asList(21));
        var node101 = new GraphNode<>(101, asList(node333), asList(19));
        return node111;
    }

    public static GraphNode<String> generateExampleGraph7() {
        var nodeA = new GraphNode<>("A", asList(), asList());
        var nodeB = new GraphNode<>("B", asList(nodeA), asList(4));
        var nodeC = new GraphNode<>("C", asList(nodeA), asList(5));
        var nodeD = new GraphNode<>("D", asList(nodeA), asList(17));
        var nodeE = new GraphNode<>("E", asList(nodeB), asList(5));
        var nodeF = new GraphNode<>("F", asList(nodeB), asList(12));
        var nodeG = new GraphNode<>("G", asList(nodeB), asList(16));
        var nodeH = new GraphNode<>("H", asList(nodeC,nodeD), asList(11,1));
        var nodeI = new GraphNode<>("I", asList(nodeC,nodeG), asList(21,4));
        var nodeJ = new GraphNode<>("J", asList(nodeC,nodeH), asList(19,3));
        return nodeA;
    }

    public static GraphNode<String> generateExampleGraph8() {
        var nodeA = new GraphNode<>("A", asList(), asList());
        var nodeB = new GraphNode<>("B", asList(nodeA), asList(4));
        var nodeC = new GraphNode<>("C", asList(nodeB), asList(5));
        var nodeD = new GraphNode<>("D", asList(nodeC), asList(17));
        var nodeE = new GraphNode<>("E", asList(nodeD), asList(5));
        var nodeF = new GraphNode<>("F", asList(nodeC,nodeE), asList(12,2));
        return nodeA;
    }




        // ADD YOUR METHODS HERE, inside GraphNode
        public List<T> iterativeDFS() {
          List<T> result=new ArrayList<>();
          Stack<GraphNode<T>> stack = new Stack<>();
          Stack<GraphNode<T>> visited = new Stack<>();
          stack.push(this);

          while (!stack.isEmpty()){
              GraphNode<T> current = stack.pop();

              if(visited.contains(current)){
                  continue;
              }
              visited.add(current);
              result.add(current.getValue());

              for (var v:current.getNeighbours()){
                  if(!visited.contains(v)){
                      stack.push(v);
                  }
              }
          }
          return result;
        }

        public List<T> recursiveDFS() {
            // your code here
            List<T> result = new ArrayList<>();
            Set<GraphNode<T>> visited = new HashSet<>();
            recursiveDFSHelper(result, visited);
            return result;
        }

    private void recursiveDFSHelper(List<T> result, Set<GraphNode<T>> visited) {
        visited.add(this);
        result.add(this.getValue());

        for (GraphNode<T> neighbour : this.getNeighbours()) {
            if (!visited.contains(neighbour)) {
                neighbour.recursiveDFSHelper(result, visited);
            }
        }


    }



    /**
     * Returns a list of graph node values resulting from an iterative
     * BFS traversal of the graph starting from the node on which the method
     * is invoked. The order in which adjacent nodes of a node are explored and
     * enumerated should be based on the order in the Collection returned by
     * getNeighbours().
     */
    public List<T> iterativeBFS(){
        List<T> result = new ArrayList<>();
        Queue<GraphNode<T>> queue = new LinkedList<>();
        Set<GraphNode<T>> visited = new HashSet<>();

        queue.add(this);
        visited.add(this);

        while(!queue.isEmpty()){
            GraphNode<T> current = queue.poll();
            result.add(current.getValue());

            for(var x: current.getNeighbours()){
                if(!visited.contains(x)){
                    visited.add(x);
                    queue.add(x);
                }
            }

        }
        return result;
    }

    /**
     * Returns a list of graph node values resulting from a recursive
     * BFS traversal of the graph starting from the node on which the method
     * is invoked. The order in which adjacent nodes of a node are explored and
     * enumerated should be based on the order in the Collection returned by
     * getNeighbours().
     */
    public List<T> recursiveBFS(){
        List<T> result = new ArrayList<>();
        Queue<GraphNode<T>> queue = new LinkedList<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        recursiveBFSHelper1(result,visited,queue);
        return  result;

    }

    private void recursiveBFSHelper1(List<T> result, Set<GraphNode<T>> visited,Queue<GraphNode<T>> queue) {
        if (queue.isEmpty()) return;
        queue.add(this);
        visited.add(this);

        for (var x : this.getNeighbours()) {
            if (!visited.contains(x)) {
                queue.add(x);
                visited.add(x);
            }
        }

        recursiveBFSHelper1(result, visited, queue);
    }


    /**
     * Finds one cycle of nodes in the graph by exploring it starting
     * from this node in some fashion, if such a cycle exists
     * @return A list of at least three distinct nodes, whose first and
     *    last element are the same, and for two adjacent elements in
     *    the list, the elements are contained in each others result
     *    of getNeighbours; or the empty list, if no such sequence of nodes
     *    exists
     */
    public List<GraphNode<T>> findCycle(){
        //需要一个path 来identify 现在的位置和走过的点
        List<GraphNode<T>> path = new ArrayList<>();
        //储存所有走过的点
        Set<GraphNode<T>> visited = new HashSet<>();
        //recursively 找cycle
        List<GraphNode<T>> result = findCycleHelper(this, null, path, visited);
        //题目要求
        return result == null ? new ArrayList<>() : result;

    }
    //需要arguments 1.当前节点 即起始点  2. parent， 当前节点的上一个节点，3. 当前位置和访问过的节点，在当前路径上。4.所有访问过的节点
    private List<GraphNode<T>> findCycleHelper(GraphNode<T> current, GraphNode<T> parent,
                                               List<GraphNode<T>> path, Set<GraphNode<T>> visited) {
        visited.add(current);   // 标记当前节点为已访问
        path.add(current);
        //对于当前节点的所有邻居
        for (GraphNode<T> neighbour : current.getNeighbours()) {
            //如果邻居等于当前节点的上一个节点 忽略？
        if (neighbour == parent) continue;  // skip where we came from

            // 如果 我们已经访问过邻居了
        if (visited.contains(neighbour)) {
            // Found cycle! Reconstruct it
            //尝试建立圆
            List<GraphNode<T>> cycle = new ArrayList<>();
            // 起始点是 当前节点的邻居在已访问过的path中的 index
            int start = path.indexOf(neighbour);
            // 添加cycle的所有点 从当前节点的邻居在已访问过的path中的 index 到 当前path上的最后一个点，即current
            cycle.addAll(path.subList(start, path.size()));
            // cycle 加上邻居 why？
            cycle.add(neighbour);  // close the cycle

            return cycle;
        }

        // recrusive step
        List<GraphNode<T>> result = findCycleHelper(neighbour, current, path, visited);
        //如果loop完所有的点 有cycle 才return result cycle
        if (result != null) return result;
    }

        // 如果没有的情况 我们往回退一个点，继续loop
    path.remove(path.size() - 1);  // backtrack
    return null;
    }


    /**
     * Returns a path of minimum length from the current node to a
     * node whose value matches the given value
     * @param value A value to look for in the graph
     * @return A list of nodes, starting at the current node and ending
     *    at a node whose value is equal to the given value, with every
     *    two consecutive elements in the list contained in each other's result
     *    of calling getNeighbours, such that the number of edges
     *    in the path is the minimum of possible
     *    among all paths connecting this node to a node with the given value;
     *    or null, if no such path exists
     */
    public List<GraphNode<T>> findMinimalLengthPath(T value) {
        // 特殊情况：起点就是目标
        if (this.getValue().equals(value)) return List.of(this);

        // 保存路径 为什么呢？
        //普通BFS queue存节点:只知道当前在哪，不知道怎么来的 [A, B, C, D...]
        // 这里queue存路径 每条路径都记录了完整的走法 [[A], [A,B], [A,C], [A,D]...]
        Queue<List<GraphNode<T>>> queue = new LinkedList<>();  // queue存的是路径！
        // 保存访问过的点，我们的目标是访问直到找到要求的 T value
        Set<GraphNode<T>> visited = new HashSet<>();

        // 这个的作用是什么呢 和queue 冲突吗
        // 不冲突！startPath只是初始化用的：
        //startPath = [A]        ← 创建起点路径
        //queue.add(startPath)   ← 放进queue
        //之后就不用startPath了，全部操作都在queue里
        List<GraphNode<T>> startPath = new ArrayList<>();
        // 从起始点开始
        startPath.add(this);
        // 所以queue是保存所有路径吗
        queue.add(startPath);
        // 访问过一次就添加
        visited.add(this);

        // 因为我们一直会poll queue里面的节点所以，这个while loop会确保我们可以loop through 所有的节点
        while (!queue.isEmpty()) {
            //拿到当前节点？ 为什么是list of graphnode？
            List<GraphNode<T>> currentPath = queue.poll();
            // 当前节点即路径上的最后一个节点 可以理解
            GraphNode<T> current = currentPath.get(currentPath.size() - 1); // 路径最后一个节点

            // 对于当前节点的所有邻居
            for (var neighbour : current.getNeighbours()) {
                // 如果没有访问过
                if (!visited.contains(neighbour)) {
                    // 复制当前路径，加上新邻居
                    List<GraphNode<T>> newPath = new ArrayList<>(currentPath);
                    //相当于当前path 每访问一个节点就会创建一个包含当前节点的最新path？
                    newPath.add(neighbour);

                    // 核心逻辑 如果当前节点和要求数据相同，但是我们怎么确保这是最优路径呢？
                    // BFS按层扩展：
                    //第1层处理: [A]              → 距离0
                    //第2层处理: [A,B],[A,C],[A,D] → 距离1
                    //第3层处理: [A,B,E],[A,C,J]... → 距离2
                    //                         ↑
                    //              第一次碰到J就返回，
                    //              BFS保证这一定是最短的！
                    //              因为更短的路径早就被处理过了
                    if (neighbour.getValue().equals(value)) return newPath; // 找到了！

                    // 结束逻辑后，当前节点已经访问，加入visited
                    visited.add(neighbour);
                    // 为什么？
                    //继续用graph7举例：
                    //
                    //poll [A,C]，处理C的邻居：
                    //  → newPath=[A,C,H] → 加入queue
                    //  → newPath=[A,C,I] → 加入queue
                    //  → newPath=[A,C,J] → 找到J！返回
                    //
                    //如果不加入queue，[A,C,H]和[A,C,I]就永远不会被探索！
                    queue.add(newPath);
                }
            }
        }
        return null;
    }








}
// CODE TEMPLATE
// ... value ... neighbours ... neighboursCosts ...
