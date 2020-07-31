import java.util.*;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/7/21 14:49
 * @description :
 * @modified By  :
 */
public class Graph {

    //Node节点类
    class Node {
        public Integer value;
        public HashMap<Integer, Edge> to;

        //构造器
        public Node(Integer value) {
            this.value = value;
            to = new HashMap<Integer, Edge>();
        }
    }

    //Edge节点类
    class Edge {
        public Node to;
        public Integer weight;

        //构造器
        public Edge(Node to, Integer weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    //Node集合
    private HashMap<Integer, Node> graph;

    //Graph类构造器
    public Graph() {
        graph = new HashMap<>();
    }

    //插入一个节点
    public void insertNode(int nodeValue) {
        graph.put(nodeValue, new Node(nodeValue));
    }

    //插入一条边
    public void insertEdge(int from, int to, int weight) {
        Node node = graph.get(from);
        node.to.put(to, new Edge(graph.get(to), weight));
    }

    //找到一条边
    public Edge find(int from, int to) {
        return graph.get(from).to.get(to);
    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.insertNode(1);
        graph.insertNode(2);
        graph.insertNode(3);
        graph.insertNode(4);

        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 4);
        graph.insertEdge(2, 3, 3);
        graph.insertEdge(4, 1, 5);
        graph.insertEdge(2, 1, 6);

        //测试找到一条边
        System.out.println(graph.find(2, 1).weight);

    }
}
