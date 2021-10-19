package graph;

/**
 * @Author:guoj
 * @Time: 2021/10/14
 * @Description: 加权有向图的边
 */
public class DirectedEdge{
    //边的两个顶点
    private int v;//起点
    private int w;//终点
    //权重值
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 边的起点
     *
     * @return
     */
    public int from() {
        return this.v;
    }

    /**
     * 边的一个终点
     *
     * @param i
     * @return
     */
    public int to() {
        return this.w;
    }

    public double getWeight() {
        return weight;
    }


}
