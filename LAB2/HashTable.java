import javax.swing.plaf.PanelUI;
import java.lang.reflect.Array;
import java.util.*;

class Node<K, V>{
    K key;
    V value;
    Node<K , V> next;

    public Node(K key, V value){
        this.key = key;
        this. value = value;
        next = null;
    }
}

public class HashTable<K , V> {
    private ArrayList<LinkedList<Node<K , V>>> table;
    private int capacity;
    private int size;


    public HashTable(int capacity){
        this.capacity = capacity;
        table = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            table.add(new LinkedList<>());
        }
        size = 0;
    }

    private int HashCode(K key){
        long hashCode = 0;
        long primeBase = 999331;
        String keyString = key.toString();

        for(int i = 0; i < keyString.length(); i++){
            hashCode = (hashCode * primeBase + keyString.charAt(i)) % capacity;
        }
        return (int)hashCode;
    }

    public V get(K key){
        int index = HashCode(key);
        LinkedList<Node<K , V>> list = table.get(index);
        for(Node<K , V> node : list){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return  null;
    }

    public void put(K key, V value){
        int index = HashCode(key);
        LinkedList<Node<K , V>> list = table.get(index);
        for(Node<K , V> node : list){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        list.add(new Node<>(key , value));
        size++;
    }

    public void remove(K key){
        int index = HashCode(key);
        LinkedList<Node<K , V>> list = table.get(index);
        Iterator<Node<K , V>> iterator = list.iterator();
        while(iterator.hasNext()){
            Node<K , V> node = iterator.next();
            if(node.key.equals(key)){
                iterator.remove();
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key){
        int index = HashCode(key);
        LinkedList<Node<K , V>> list = table.get(index);
        for(Node<K , V> node : list){
            if(node.key.equals(key)){
                return true;
            }
        }
        return  false;
    }

    public Set<K> ketSet(){
        Set<K> keySet = new HashSet<>();
        for(LinkedList<Node<K , V>> bucket : table){
            for(Node<K , V> node : bucket){
                keySet.add(node.key);
            }
        }
        return keySet;
    }

    public int Size(){
        return  size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}