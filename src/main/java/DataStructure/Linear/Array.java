/*
线性结构：数组
*/
package DataStructure.Linear;

import java.util.concurrent.ThreadLocalRandom;

public class Array<T> {
    private int size; // 大小
    private T[] data; // 数据

    // 初始化数组，设置容量大小
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 获取当前长度
    public int getSize() {
        return size;
    }

    // 获取当前容量
    public int getCapacity() {
        return data.length;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 随机访问元素
    public T get() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, size);
        checkAccessIndex(randomIndex);
        return data[randomIndex];
    }

    // 获取指定位置元素
    public T get(int index) {
        checkAccessIndex(index);
        return data[index];
    }

    // 添加元素(尾插)
    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    /**
     * 在指定位置插入元素。
     * 允许 index == size（等价于尾插）
     */
    public void insert(int index, T value) {
        checkInertIndex(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    // 修改元素
    public void set(int index, T value) {
        checkAccessIndex(index);
        data[index] = value;
    }

    // 删除指定位置元素
    public void remove(int index) {
        checkAccessIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // 按值删除元素
    public boolean remove(T value) {
        int index = indexOf(value);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // 清空数组
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // 查找元素索引
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (data[i] == null) return i;
            } else {
                if (data[i].equals(value)) return i;
            }

        }
        return -1;
    }

    // 判断是否包含某元素
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    // 边界检查
    private void checkInertIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    private void checkAccessIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    // 自动扩容
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = data.length == 0 ? 1 : data.length * 2;
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            arr.add(i);
            System.out.println(arr.get(i));
        }
    }
}


