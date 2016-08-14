package Algorithms;

import tool.Matrix;

import java.util.PriorityQueue;

/**
 * Created by zhangrunlin on 16/8/6.
 */

//维护一个size为k的最大堆，存放着最小的k个元素。
// 如果是最大堆，则二叉树的顶点是保存的最大值，最小堆则保存的最小值。
//遍历数组当遍历到大于k个元素后，判断每个元素是否小于堆顶，若小于，则加入堆，并维持堆size不变。
//
//遍历完成，则堆顶就是第k个元素

//PriorityQueue 实现按照自己的意愿进行优先级排列的队列的话，需要实现Comparator接口。

public class kthSmallestSolution {
    public static class ValuePair {
        int val;
        int x;
        int y;

        public ValuePair(int v, int i, int j) {
            val = v;
            x = i;
            y = j;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return -1;

        PriorityQueue<ValuePair> q = new PriorityQueue<ValuePair>((a, b) -> (a.val - b.val));

        for (int i = 0; i < matrix.length; i++) {
            ValuePair p = new ValuePair(matrix[i][0], i, 0);
            q.add(p);
        }

        ValuePair peek = null;
        for (int i = 0; i < k - 1; i++) {
            peek = q.poll();
            peek.y++;
            if (peek.y < matrix[0].length) {
                peek.val = matrix[peek.x][peek.y];
                q.add(peek);
            }
        }
        peek = q.poll();
        return peek.val;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3, 1);
        matrix.setM(0, 0, 1);
        matrix.setM(0, 1, 5);
        matrix.setM(0, 2, 9);
        matrix.setM(1, 0, 10);
        matrix.setM(1, 1, 11);
        matrix.setM(1, 2, 13);
        matrix.setM(2, 0, 12);
        matrix.setM(2, 1, 13);
        matrix.setM(2, 2, 15);
        matrix.displayMatrix();

        System.out.println(kthSmallest(matrix.getM(),8));

    }
}
