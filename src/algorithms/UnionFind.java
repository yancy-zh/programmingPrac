class UnionFind{//并查集类
    int[] roots;//每个集合的代表，即在该集合的所有元素的根节点。
    int size;//集合块数。
    public UnionFind(int n){
        roots=new int[n];
        for(int i=0;i<n;i++){//最开始每个元素都是一块集合，各自为政
            roots[i]=i;
        }
        size=n;
    }
    public int find(int i){//找集合的代表元素
        if(i==roots[i])//这种情况是集合内只有一个元素。
            return i;
        return roots[i]=find(roots[i]);//继续找，直到找到代表元素。
    }
    public void union(int p,int q){//两个元素相连看他们是否是在同一个集合中
        int proot=find(p);//找代表元素
        int qroot=find(q);//找代表元素
        if(qroot!=proot){//代表元素不同则说明在不同集合中，但这两个集合有连接部分
            roots[qroot]=proot;//将两个集合合并
            size--;//集合块数--
        }
    }
}