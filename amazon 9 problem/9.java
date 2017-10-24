public class OverLap {
     // rectangle A, B
     // time O(1), space O(1)
    public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {

        //！！"="不确定有没有，边，点的重叠不知道算不算
        // if one rectangle is above other
        if (bottomRightA.y <= topLeftB.y || bottomRightB.y <= topLeftA.y) {
            return false;
        }

        // if one rectangle is on left side of other
        if (topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x) {
            return false;
        }
        return true;
    }
    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y; 
        }
    }
}
//更简单的，一行解决
// return !(bottomRightA.y <= topLeftB.y || bottomRightB.y <= topLeftA.y || topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x);

import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

public class kNearestPoint {
    public Point[] Solution(Point[] array, Point origin, int k) {
        Point[] rvalue = new Point[k];  
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });

        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            rvalue[index++] = pq.poll();
        return rvalue;
    ｝

    private double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

import java.util.List;
import java.util.ArrayList;

/**
 * Created by lisifei on 9/24/16.
 */
public class WinSum {
    public List<Integer> GetSum(List<Integer> A, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        int len = A.size();
        for (int i = 0; i + k - 1 < len; ++i) {
            int sum = 0;
            for (int j = 0; j < k; ++j) {
                sum += A.get(i+j);
            }
            res.add(i,sum);
        }
        return res;

        /*
        ArrayList<Integer> result  = new ArrayList<>();
        if (A == null || A.size() == 0 || k <= 0) return result;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }
        return result;
        */

    }
}

public class SumOfWindow {
    public int[] Solution(int[] array, int k) {
        if (array == null || array.length < k || k <= 0)    return null;
        int[] rvalue = new int[array.length - k + 1];
        for (int i = 0; i < k; i++)
            rvalue[0] += array[i];
        for (int i = 1; i < rvalue.length; i++) {
            rvalue[i] = rvalue[i-1] - array[i-1] + array[i+k-1];
        }
        return rvalue;
    }
}

public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
  if (head == null) return null;
  
  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
  
  // loop 1. copy all the nodes
  RandomListNode node = head;
  while (node != null) {
    map.put(node, new RandomListNode(node.label));
    node = node.next;
  }
  
  // loop 2. assign next and random pointers
  node = head;
  while (node != null) {
    map.get(node).next = map.get(node.next);
    map.get(node).random = map.get(node.random);
    node = node.next;
  }
  
  return map.get(head);
}
}

public class Solution {
    private int N = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        return result;
    }
    
    private boolean isCyclic(Course cur, int[] result) {
        if (cur.tested == true) return false;
        if (cur.visited == true) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }
    
    class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
    }
}

import java.util.*;
class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
public class High_Five {
    public static Map<Integer, Double> getHighFive(Result[] results){
        Map<Integer, Double> map = new HashMap<>();
        //这里pValue的命名,就是每个person都有哪些value。
        Map<Integer, ArrayList<Integer>> pValue = new HashMap<>();
        //对照着ID把成绩塞给对应的人。
        for (Result res : results){
            int id = res.id;
            if (pValue.containsKey(id)){
                //这里curL表示current List
                ArrayList<Integer> curL = pValue.get(id);
                curL.add(res.value);
                pValue.put(id, curL);
            }
            else {
                ArrayList<Integer> curL = new ArrayList<>();
                curL.add(res.value);
                pValue.put(id, curL);
            }
        }
        for (Integer id : pValue.keySet()){
            ArrayList<Integer> list = pValue.get(id);
            //这里写法有些风骚了,就是懒的重写comparator
            Collections.sort(list);
            Collections.reverse(list);
            double value = 0;
            for (int k = 0; k < 5; k++){
                value += list.get(k);
            }
            value = value/5.0;
            map.put(id, value);
        }
        return map;
    }
    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}

public class Connection {
        String city1;
        String city2;
        int cost;
        Connection (String city1, String city2, int cost) {
                this.city1 = city1;
                this.city2 = city2;
                this.cost = cost;
        }

        public void printConnection () {
                System.out.println("{ " + this.city1 + " , " + this.city2 + "} " + this.cost);
        }
}

public class solution {
        public static void main (String[] args) {
                Connection[] citys = new Connection[10];
                citys[0] = new Connection("A","B",6);
                citys[1] = new Connection("A","D",1);
                citys[2] = new Connection("A","E",5);
                citys[3] = new Connection("B","C",3);
                citys[4] = new Connection("B","D",5);. 1point3acres.com/bbs
                citys[5] = new Connection("C","D",6);
                citys[6] = new Connection("C","F",6);
                citys[7] = new Connection("D","F",4);
                citys[8] = new Connection("D","E",5);
                citys[9] = new Connection("E","F",2);-google 1point3acres
                ArrayList<Connection> list = new ArrayList<Connection> ();
                for (Connection temp : citys) {
                        list.add(temp);
                }

                for (Connection temp : findPath(list)){
                        temp.printConnection();
                }

        }

        public static List<Connection> findPath (List<Connection> list) {
                ArrayList<Connection> result = new ArrayList<Connection> ();
                ArrayList<String> cityTree = new ArrayList<String> ();        //to Maintain the cities have been traversed.

                while (!list.isEmpty()) {
                        //find the minimum cost to the city from cityTree among the result.
                        Connection temp = findMin(list, cityTree);. visit 1point3acres.com for more.
                        if (temp == null) {// we finished
                                break;
                        }
                        list.remove(temp);        //remove the current minimum cost from grand set
                        cityTree.add(temp.city1);
                        cityTree.add(temp.city2);
                        result.add(temp);
                }
                //override compare make it alphabet order
                Comparator<Connection> cmp = new Comparator<Connection>(){
                        public int compare(Connection c1, Connection c2) {
                                if (c1.city1.equals(c2.city1)) {
                                        return c1.city2.compareTo(c2.city2);
                                }
                                return c1.city1.compareTo(c2.city1);
                        }};
                result.sort(cmp);

                return result;
        }

        //find the minimum cost between the city we traversed and we did not traverse.
        public static Connection findMin(List<Connection> list, ArrayList<String> cityTree) {
                Connection result = null;
                int minCost = Integer.MAX_VALUE;        //minimum cost

                for (Connection con : list) {
                        if (con.cost <= minCost) {
                                //if none of the city we traversed 
                                //or the connection is connected to either city from cityTree.
                                if ((cityTree.contains(con.city1) && !cityTree.contains(con.city2)) ||
                                                cityTree.contains(con.city2) && !cityTree.contains(con.city1)) {
                                        minCost = con.cost;. visit 1point3acres.com for more.
                                        result = con;
                                }
                                if (cityTree.isEmpty()) {
                                        minCost = con.cost;
                                        result = con;
                                }
                        }
                }

                return result;
        }

}

import java.util.*; //这次差点儿忘了这个
class Node { //这个是题目给好的
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
//这个类是自己写的,要不不好找,两个成员变量分别是当前的总和和人数
class SumCount{
    int sum;
    int count;
    public SumCount(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}
public class Company_Tree {
    //两个全局变量用来找最小的平均值,和对应的节点
    private static double resAve = Double.MIN_VALUE;
    private static Node result;
    public static Node getHighAve(Node root){
        if (root == null) return null;
        dfs(root);
        return result;
    }
    //后序遍历递归。
    private static SumCount dfs(Node root){
        // 这里必须先把叶子节点刨掉，注意看我的手法，其实没什么。
        if (root.children == null || root.children.size() == 0){
            return new SumCount(root.val, 1);
        }
        //把当前root的材料都准备好
        int curSum = root.val;
        int curCnt = 1;
        //注意了这里开始遍历小朋友了
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            //每次遍历一个都把sum,count都加上，更新
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum/curCnt;
        //这里看一下最大值要不要更新
        if (resAve < curAve){
            resAve = curAve;
            result = root;
        }

        return new SumCount(curSum,curCnt);
    }
    //这回测试的code行数有点儿多。
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        System.out.println(res.val + " " + resAve);
    }
}