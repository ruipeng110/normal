/*
 * Copyright (c) 2017. crp work @home
 */

package priv.test.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CRPTreeMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    static final boolean red = true;
    static final boolean black = false;

    private transient Entry<K, V> root;

    @Override
    public V get(Object key) {
        return find(root, (K) key).value;
    }

    @Override
    public int size() {
        return countDeep(root);
    }

    private int countDeep(Entry<K, V> root) {
        int currentCount = 0;
        if (root.nil){
            if (root.left != null || root.right != null){
                System.out.println("ops");
            }
            return currentCount;
        }
        currentCount ++;
        currentCount += countDeep(root.left);
        currentCount += countDeep(root.right);
        return currentCount;
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>();
        entry.setKey(key);
        entry.setValue(value);
        if (root == null) {
            entry.color = black;
            root = entry;
            addNil(root);
            return null;
        } else {
            //根节点不是空，那需要先查找未知，然后插入
            Entry<K, V> node = find(root, key);
            if (node.nil) {
                //插入
                insert(node, entry);
                return null;
            } else {
                //替换
                V v = node.value;
                node.value = value;
                return v;
            }
        }
    }

    private void insert(Entry<K, V> targetNode, Entry<K, V> newNode) {
        if (targetNode.nil == false) throw new RuntimeException("never show");
        newNode.color = red;
        addNil(newNode);
        newNode.parent = targetNode.parent;
        if (targetNode == targetNode.parent.left) {
            targetNode.parent.left = newNode;
        } else {
            targetNode.parent.right = newNode;
        }
        if (newNode.parent.color == red) {
            fix(newNode);
        } else {
            //父亲是黑色的不管完成了
        }
    }

    private void fix(Entry<K, V> node) {
        if (node.color == red && node.parent == null) {
            node.color = black;
            return;
        }
        if (node.color == red && node.parent.color == red) {
        } else return;
        if ((node.parent.parent.left == node.parent && node.parent.parent.right.color == red)
                || (node.parent.parent.right == node.parent && node.parent.parent.left.color == red)) {
            node.parent.color = black;
            node.parent.parent.right.color = black;
            node.parent.parent.color = red;
            fix(node.parent.parent);
        } else {
            if (node.parent.right == node) {
                leftRotate(node.parent);
                fix(node.left);
            } else {
                Entry<K, V> uncle ;
                if (node.parent == node.parent.parent.left){
                    uncle = node.parent.parent.right;
                } else {
                    uncle = node.parent.parent.left;
                }
                node.parent.color = black;
                node.parent.parent.color = red;
                rightRotate(node.parent.parent);
                fix(uncle);
            }
        }
        root.color = black;
    }

    private void leftRotate(Entry<K, V> node) {
        Entry<K, V> target = node.right;
        node.right = target.left;
        if (target.left != null) {
            target.left.parent = node;
        }
        target.left = node;
        if (node.parent == null)
            root = target;
        else if (node.parent.left == node)
            node.parent.left = target;
        else
            node.parent.right = target;
        target.parent = node.parent;
        node.parent = target;
    }

    private void rightRotate(Entry<K, V> node) {
        Entry<K, V> target = node.left;
        node.left = target.right;
        if (target.right != null) {
            target.right.parent = node;
        }
        target.right = node;
        if (node.parent == null)
            root = target;
        else if (node.parent.left == node)
            node.parent.left = target;
        else
            node.parent.right = target;
        target.parent = node.parent;
        node.parent = target;

    }

    /**
     * 查找key应该在的未知
     *
     * @param key
     * @return not null
     */
    private Entry<K, V> find(Entry<K, V> thisNode, K key) {
        if (thisNode.nil) {
            return thisNode;
        }
        switch (compare(key, thisNode.key)) {
            case 0:
                return thisNode;
            case -1:
                return find(thisNode.left, key);
            case 1:
                return find(thisNode.right, key);
            default:
                throw new RuntimeException("never show");
        }
    }

    /**
     * 承诺0就是相等的意思，-1代表key1&lt!key2 1 key1&gt!key2
     *
     * @param key1
     * @param key2
     * @return
     */
    private int compare(K key1, K key2) {
        if (key1.hashCode() == key2.hashCode()) {
            if (key1.equals(key2)) {
                return 0;
            } else {
                return -1;
            }
        }

        if (key1.hashCode() < key2.hashCode()) {
            return -1;
        } else {
            return 1;
        }
    }

    private void addNil(Entry<K, V> node) {
        if (node.left == null) {
            Entry nil = new Entry();
            nil.nil = true;
            nil.color = black;
            nil.parent = node;
            node.left = nil;
        }
        if (node.right == null) {
            Entry nil = new Entry();
            nil.nil = true;
            nil.color = black;
            nil.parent = node;
            node.right = nil;
        }
    }


    /**
     * 树的每一个节点
     *
     * @param <K>
     * @param <V>
     */
    private static class Entry<K, V> {

        K key;
        V value;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;
        boolean color = black;
        boolean nil = false;

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V v = this.value;
            this.value = value;
            return v;
        }
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }


    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
