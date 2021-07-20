public class SegmentTree<T>{
    //size of the segment tree array.
    int dataSize;
    T[]tree;
    T neutralValue;

    //Segment Tree constructor
    public SegmentTree(T[] data, T[] tree, T neutral){
        this.neutralValue = neutral;
        this.tree = tree;
        dataSize = data.length - 1;
        buildTree(0,0, dataSize, data);
    }

    //specify how to combine child node results to form parent node result.
    public T combine(T obj1, T obj2){
        return (T) Main.sum((Integer)obj1, (Integer)obj2);
    }

    //used to calculate the size of data array.
    public int calculateSize(int n)
    {
        int pow2 = 1;
        while( pow2 < n)
        {
            pow2 = pow2 << 1;
        }
        return pow2;
    }

    //query the range l to r, 0 based array indexing.
    public T query(int l, int r)
    {
        int st = 0, ed = dataSize;
        return queryHelper(l, r,0, st, ed);
    }

    //helps to solve a range query.
    public T queryHelper(int l, int r, int root, int st, int ed){
        if(r < st || ed < l){
            return neutralValue;
        }
        if(l <= st && ed <= r){
            return tree[root];
        }
        int mid = (st + ed)/2;
        return combine(queryHelper(l, r,2*root + 1, st ,mid), queryHelper(l, r,2*root + 2,mid + 1, ed));
    }

    //builds the segment tree.
    public void buildTree(int root, int lx, int rx, T[] data){
        if(lx==rx) {
            tree[root] = data[lx];
            return;
        }

        int mid = (lx+rx)/2;

        buildTree(2*root+1, lx, mid, data);
        buildTree(2*root+2, mid+1 , rx, data);

        tree[root] = combine(tree[2*root+1], tree[2*root+2]);
    }

    //update the element at index idx to value val.
    public void update(int idx, T val){
        updateHelper(idx, val,0,0, dataSize);
    }

    // perform update query
    public void updateHelper(int idx, T val, int root, int lx, int rx ){
        if(lx==rx){
            tree[root] = val;
            return;
        }
        int mid = (lx+rx)/2;
        if(idx <= mid){
            updateHelper(idx,val,2*root+1 , lx, mid);
        }
        else{
            updateHelper(idx,val,2*root+2 , mid+1 , rx);
        }
        tree[root] = combine(tree[2*root+1], tree[2*root+2]);
    }
}