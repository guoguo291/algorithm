package graph;

/**
 * @Author:guoj
 * @Time: 2021/10/12
 * @Description: 加权无向图的边
 */
public class Edge implements Comparable<Edge> {
    //边的两个顶点
    private int v;
    private int w;
    //权重值
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 返回边的一个顶点
     *
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * 指定一个顶点，返回边的另外一个顶点
     *
     * @param i
     * @return
     */
    public int other(int i) {
        if (i == w) {
            return this.v;
        } else {
            return this.w;
        }
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge that) {
        int cmp;
        if (this.weight > that.getWeight()) {
            //当前边的权重大返回1
            cmp = 1;
        } else if (this.weight < that.getWeight()) {
            cmp = -1;
        } else {
            cmp = 0;
        }
        return cmp;
    }

}
