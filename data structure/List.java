import java.util.Arrays;

class List {
    private int[] arr;
    private int capacity = 10;
    private int size = 0;
    private int extendRatio = 2;

    public List() {
        arr = new int[capacity];
    }

    // 获取列表长度（当前元素数量）
    public int size() {
        return size;
    }

    // 获取列表容量
    public int capacity() {
        return capacity;
    }

    // 访问元素
    public int get(int index) {
        // 索引越界情况
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];

    }

    // 更新元素
    public void set(int index, int num) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        arr[index] = num;
    }

    // 在尾部添加元素
    public void add(int num) {
        // 容量限制情况,触发扩容机制
        if (size == capacity()){
            extendCapacity();
        }
        arr[size] = num;
        size++;
    }

    // 在中间插入元素
    public void insert(int index, int num) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (size == capacity()) {
            extendCapacity();
        }
        // 后移元素
        for (int j = size - 1; j >= index; j--) {
            arr[j + 1] = arr [j];
        }

        arr[index] = num;
        size ++;
    }

    // 删除元素
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int num = arr[index];
        for (int j = index; j < size; j++) {
            arr[j] = arr[j + 1];
        }

        size -- ;
        return num;
    }

    // 列表扩容
    public void extendCapacity() {
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        capacity = arr.length;
    }

    // 将列表转为数组
    public int[] toArray() {
        int size = size();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = get(i);
        }

        return arr;
    }
}
