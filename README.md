
# linkedin java collections
[course](https://www.linkedin.com/learning/learning-java-collections)

# Collections
useful to work with data

# Map
key-value collection
![](img/java_map.png)  
- (key,value) pair is call entry

# List
linear indexed collection
![](img/java_list.png)  
  
# java collection framework
![](img/data_structure_feature.png)
![](img/java_collection_framework.png)    
## collection operations
- store: some collection store data pretty faster
- organize: some collections put the new value at the beginning or at the end
- manage: each collection has different operations
- retrieve: some collections are slower than other retrieving data



# store
![](img/collection_store.png)  
# organize
![](img/collection_organize.png)  
- Queue: insert right remove from left (FIFO)
- Stack: insert to right remove from right (LIFO)  

![](img/collection_organize_2.png)  

- Tree: handle hierarchy
- Hash: handle keys and buckets 

![](img/collection_manage.png)  
operations over the collection object

![](img/collection_retrieve.png)  
each collection object retrieve the element different, some of them are really good doing this

# collection framework history
![](img/collection_framework_history.png)  
# Dictionary
# Enumeration
# Hashtable (Deprecated)
- let you work with objects
- some issues with the performance

# Iterable
- just go in one direction
- contains two basic methods
    - has next
    - next
- each Iterable implementation could be use in a foreach loop

# Collection
![](img/java_collection_interface.png)  
is the general interface for all collection objects in the collections api, contains methods for :
- check if contain
- add element
- does not contain get, because by default it is not indexablew
- return an stream 
- some implementations may throw an exception when the method is called  

# List
# Vector (implementation)
- fail-fast implementation: if you change the vector inside a for iteration, then it will throw an exception to prevent unexpected behavior

- thread safe collection
```java
Vector vector = new Vector<>();
vector.add("daniel");
vector.add("molina");
vector.stream().forEach(System.out::println);
```
# ArrayList  (implementation)

# LinkedList (implementation)
![](img/java_linkedlist.png)  
is an implementation for Queue, Deque and List, linked implementation let the collection add elements in any position and iterate in any direction  
- deque  let you addFirst, addLast, getFirst, getLast, pollFirst, pollLast
- queue let you add, poll and peak
- list let you add, get and remove

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("daniel");
deque.addLast("name last");

Queue<String> queue = new LinkedList<>();
queue.add("test");
queue.peak();

List<String> list = new LinkedList<>();
list.add("name");
list.add("lastname");
list.get(0);
list.remove(0);

deque.stream().forEach(System.out::println);
queue.stream().forEach(System.out::println);
list.stream().forEach(System.out::println);

deque.pollFirst();
deque.pollLast();

queue.poll();

list.remove(0);
```

# ListIterator  (interface)
- let you add, remove and reverse the iteration

# Stack

# List
# Map
# Set
# Queue

# Deque Interface
let you add and remove from the beginning and the end of the collection

# ArrayDeque Implementation
implementation base on array
```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("name first");
deque.addLast("name last");
deque.getFirst();
deque.getLast();

deque.iterator().
    forEachRemaining(System.out::println);

deque.descendingIterator().
    forEachRemaining(System.out::println);

deque.pollFirst();
deque.stream().forEach(System.out::println);
deque.pollLast();
```

# List sorting
```java
class Employee{
    private String name;
    private Integer age;
    public Employee(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public String getName(){return this.name;}
    public String setName(String name){return this.name;}

    public Integer getAge(){return this.age;}
    public Integer setAge(Integer age){return this.age;}
}
List<Employee> employees = new ArrayList<>();
employees.add(new Employee("juan", 20));
employees.add(new Employee("daniel", 25));
employees.add(new Employee("jose", 30));
employees.add(new Employee("maria", 20));
employees.add(new Employee("leidy", 25));
employees.add(new Employee("carlos", 30));

employees.sort(
    Comparator.comparing(Employee::getName)
		.thenComparing(Employee::getAge));

employees.stream().map(Employee::getName).forEach(System.out::println);
```

# Sort complex comparator
let you sort the collection using multiple object properties

```java
Comparator.comparing(Employee::getName)
		.thenComparing(Employee::getAge)
```

# List.of
```java
class Employee{
    private String name;
    private Integer age;
    public Employee(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public String getName(){return this.name;}
    public String setName(String name){return this.name;}

    public Integer getAge(){return this.age;}
    public Integer setAge(Integer age){return this.age;}
}
Collection<Employee> employees = List.of(
    new Employee("juan", 20),
    new Employee("daniel", 25),
    new Employee("jose", 30),
    new Employee("maria", 20),
    new Employee("leidy", 25),
    new Employee("carlos", 30)
);
employees.stream().mapToInt(Employee::getAge).sum();
```

# Collections types (basic interfaces)
![](img/collection_interfaces.png)  

- Map
- Collection
    - List
    - Set
    - Queue
    - Deque

![](img/collections_java_full.png)  
![](img/java_collection_implementation_and_interfaces.png)  

# Collections implementation
there are four basic implementations
1. base on array
2. base on hash
3. base on linked list
4. base on tree

# Collection naming convention
- <implementation><interface>
- the interface comes at the end
![](img/java_collection_naming.png)  

```java
ArrayList
HashMap
LinkedHashSet
```

# Collection common implementations
![](img/common_implementation.png)  

# Collection TreeMap
- the keys are sorted automatically
- uses a tree as it's implementation
- slow for retrieving data
- slow for putting data

```java
Map<String,String> map = new TreeMap<>();
map.put("name", "daniel");
map.put("age", "zack");
map.put("zipcode", "cii");
map.put("city", "d");
map.values().stream().forEach(System.out::println);
map.keySet().stream().forEach(System.out::println);
map.entrySet().stream().forEach(System.out::println);
```

# Collections class 
# Collection synchronized set
let you keep the set thread safe
```java
Set<String> set = new TreeSet();
set.add("test");
set.add("test");

Set<String> synset = Collections.synchronizedSet(set);
```

# Collections and null values
some collection implementation doesn't allow null values in there

- there is a group of implementation that doesn't not allow null values
1. TreeSet: null values doesn't have any order
2. TreeMap: is hard to determine where to put a null value in a sorted collection
3. ArrayDeque: null value is already an indicator for an empty deque
4. PriorityQueue: is hard to determine a priority for a null value

on sorted collections, you could not insert null values
```java
Set<String> treeSet = new TreeSet<>();
treeSet.add(null); //⚠

Set<String> hashSet = new HashSet<>();
hashSet.add(null);

Set<String> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add(null);

List<String> arrayList = new ArrayList<String>();
arrayList.add(null);

List<String> linkedList = new LinkedList<String>();
linkedList.add(null);

Deque<String> deque = new ArrayDeque<>();
deque.add(null); //⚠

Deque<String> linkedDeque = new LinkedList<>();
linkedDeque.add(null);

Queue<String> queue = new LinkedList<>();
queue.add(null);

Queue<String> priorityQueue = new PriorityQueue<>();
priorityQueue.add(null); //⚠
```

