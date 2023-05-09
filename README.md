# Advanced JAVA
University lesson on Java

## Threads methods
- `getState()` returns `RUNNABLE`, `BLOCKED`, `NEW` or `TERMINATED`
- `getPriority()` returns the priority of the thread. Priority is an integer between 1 and 10. The higher the priority the more efficient the execution is
- `setPriority()` sets the priority of the thread
- `start()` starts the thread, calls the `run()` method in the thread class
- `join()` ou `join(ms)` waits for the thread to end. If a ms delay is specified, the main thread will force finish the other thread after waiting for the delay even if other thread is not finished.

## Collection Interface
Collection Interface has a multiples methods : 
- `add(Elt)` : adds a new element to the collection, regardless wether or not the element is already in the collection.
- `addAll(Collection)` : adds all the elements the called collection elements in the calling collection.
- `remove(index)` : removes the element at the **index** from the collection, returns the removed element.
- `remove(Elt)` : removes the **first occurence** of the element from the collection, returns **true** or **false** depending on whether the element is removed or not.
- `removeAll(Collection)` : removes **all** elements from the collection if they are contained in the collection given as **argument**.
- `retainAll(Collection)` : removes all elements if they are not present in the collection given as **argument**.
- `contains(Element)` : **true** or **false**
- `containsAll(Collection)` : returns **true** if the collection contains all elements the collection given as **argument** contains. Regardless of **quantity**. Returns false else.
- `size()` : int
- `clear()` : empty the collection
- `interator()` : returns an interator of the collection
- `toArray()` : returns an array of the collection,
- `toArray(Array)` : modifies the array given as argument with the content of the list. If not enough room, the array will not be filled

Exemple of toArray() functions : 
```java
List<String> l = new LinkedList<>();
l.add("a");
l.add("b");
String[] tab = new String[0];
tab = d.toArray(new String[0]);
System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [a, b]"
// =============================================================================
List<String> l = new LinkedList<>();
l.add("a");
l.add("a");

    // 1st version
    String[] tab = new String[2];
    l.toArray(tab);
    System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [a, b]"

    // 2nd version

    String[] tab = new String[1];
    l.toArray(tab);
    System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [null]"
```

- `forEach(Consumer)` : iterates over the collection and consumes the elements, for example to print the elements.



Collection Interface Inherits from **Iterable** interface. The collection interface has **3** son-interfaces. 
- Set : No order, no duplicates, `add()`, `remove()`, `contains()`... > **HashSet** and **TreeSet** are implementing the **Set** Interface.
- List : Order, duplicates, access an element via its position, `add()`, `remove()`, `contains()`, `get()`... > **ArrayList** and **LinkedList** are implementing the **List** Interface.
- Queue : FIFO behaviour,  `add()`, `remove()`, `peek()` to get but don't remove queue element ... > **PriorityQueue** and **LinkedList** are implementing the **Queue** interface.


## Map Interface
Map Interface comes with a bunch of methods. The idea behind Map interface is to pair a **key** with an **Object**. It can be done withe these methods :
- `put(key, value)` pairs the value with the given key. If a value already exists for the given key, it will be replaced with the new value.
- `get(key)` gets the object with the given key. Returns null if there ar no value for the given key.
- `containsKey(key)` Returns wether or not a given key **present**, even if it's linked to a null object.
- `containsValue(value)` Returns wether or not a given value is **present**. `containsValue(null)` will be true only if null has been inserted into the map.
- `values()` returns an object **array** of the values present in the Map.
- `keySet()` returns an object **Set** of the keys (no repetitions and no order).

Many Classes implements Map Interface : 
- HashMap > stores the keys in a Hash Table. **Linear** complexity.
- TreeMap > stores the keys in a **tree** structure and needs a **comparator** to do it. **Logarithmic** complexity.
- LinkedHashMap > stores the keys in a **LinkedList** structure. **Linear** complexity.

### Boxing / Unboxing / Auto-boxing

When using an interface like Map, Collection... we are using a **generic** interface.
Generic types needs to be specified explicitly. For example : 
```java
Map<Integer, String> map = new TreeMap<>(); // ==== will create a map with Integers as keys and Strings as values
List<String> l = new ArrayList<>(); // ============ will create a list of Strings
List<List<Integer>> list_l = new LinkedList<>(); // will create a list of List of Integer, ie a 2D mutable Array
```
We can't create a list or a Map of `int`, `float`, `double`... they are primitive types and they are not supported for this use.
The solution is **boxing**. instead of keeping an `int`, we will keep an `Integer`. 
Today's java is doing **Auto-boxing**. Inside an `Integer` list we can put an int. Java will automatically cast the `int` into an `Integer`.
It's the same process for `double` and `Double`, `float` and `Float`...

#### Diamond operator
The diamond operator `<>` is used to infer the type of the data : 
```java
Map<Integer, String> map = new HashMap<Integer, String>();  // long and too much informations
Map<Integer, String> map = new HashMap<>(); // =============== short and easier to read
```

## Iterator 
An iterator is an object used to iterate over a collection. It is basically a pointer that points to an object inside the collection.
**Warning** : An iterator must be used as soon as it's created. If the collection is modified between creation and use of the iterator, it can throw an exception.
Here are the **Iterator** methods : 
- hasNext() returns wether or not the actual pointed element has a next element.
- next() points to the next element and returns its value. Throws an exception if the next element does not exists.
- remove() removes the element that is actually pointed out by the iterator. next() must have been called at least once.

Example of use : 
```java
List<String> l = new ArrayList<>();
l.add("a"); l.add("b"); l.add("c"); l.add("d"); l.add("a");
Iterator<String> it = l.iterator();
while(it.hasNext())
    System.out.printf("it : %s\t", it.next());
    System.out.println("");
```
Iterators can be used to iterate over an `array` or an `HashMap` but it's not optimal.

## Collections Class
**Do not mismatch with Collection interface**
The Collections class is a polymorph class that implements lots of algorithms, as `sort()` and `reverse()`. It operates on Collections.

### Difference with List Class
The List class extends the Collections Class. It adds `add(index)`, `remove(index, Elt)`, `addAll(index, Collection)` and so on...
These are the classes that extends the List Class : 
1. ArrayList            > better for access
2. LinkedList           > better for add and remove
3. Stack                > particular use
4. Vector               > particular use
5. CopyOnWriteArrayList > thread safe

## Iterate over a List
Here are 4 usual ways to iterate over a List of the Collections class : 

#### basic iteration
```java
for(int i = 0; i < l.size() ; ++i) System.out.println(l.get(i));
```
#### Iterator iteration
```java
Iterator<String> it = l.iterator();
while(it.hasNext()) System.out.println(it.next());
```
#### foreach iteration
```java
l.forEach(s -> System.out.println(s));
```
#### advanced foreach iteration
```java
l.forEach(System.out::println);
```

## Sort a list

#### sort method with a comparator
```java
l.sort((a, b) -> a - b);
```
#### prebuilt comparators
```java
l.sort(Comparator.naturalOrder());
l.sort(Comparator.reverseOrder());
```
#### Collections sorting
```java
Collections.sort(l);
```
#### streams sorting
```java
l = l.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
```

# Files 
Most of the files classes are contained in the **java.io** package.


### Main Classes
- InputStream    > **bytes** streams *Abstract*
- OutputStream   > **bytes** streams *Abstract*
- Reader         > Unicode **char** streams *Abstract*
- Writer         > Unicode **char** streams *Abstract*
- File           > **File** and **directory** manipulation
- StremTokenizer > **lexical** analysis of an entry stream
- BufferedReader > Adds a **buffer** to read a character stream

`read()` and `write()` are the two mains methods of streams Classes.


### Traditional use
3 steps of usage with streams : 
1. Open
2. Use
3. Close

### Why to use streams ?
With streams, you can read and write from multiple sources / destinations : 
- Files
- Socket (network communication)
- Images
- communication between two executions files
- bytes arrays
- strings
- URL...

### Zoom on `Java.io.InputStream` Class
- `public InputStream ()`                       Constructor.
- `abstract int read ()`                        Returns the byte **(0-255)** in the input stream or **-1** if it's the end of the input stream.
- `public int read (byte[] buff)`               Fills up the buffer with the bytes from the input stream.
- `public int read (byte[] buff, start, nb)`    Fills up `nb` of the buffer slots from `start` with the bytes from the input stream.
- `public long skip (n)`                        Passes `n` bytes in the input stream.
- `public int available ()`                     Returns how many bytes are available for reading.
- `public void close ()`                        Closes the InputStream.
- `synchronized void mark (bytes_limit)`        Places a mark to maybe go back in the future. `bytes_limit` stands for the number of bytes read after the mark can be forgotten.
- `synchronized void reset ()`                  Places the stream at the last mark.
- `public boolean markSupported ()`             Indicates if the stream supports mark notion (used to go backwards).

---

### Zoom on `java.io.OutputStream` Class
- `public OutputStream ()`                              Constructor.
- `abstract void write (byte)`                          Writes the given `byte` into the stream.
- `public abstract int write (byte[] buff)`             Writes the `buff` array into the stream.
- `public abstract int write (byte[] buff, start, len)` Writes `len` slots the `byte` array into the stream from `start`.
- `public void close ()`                                Closes the OutputStream.

### Commented example of file **writing**

```java
System.out.println("about to write in file " + filename + " type 'STOP' to end :");
try{
    Scanner sc = new Scanner(System.in); // scanner used to read user input
    FileWriter fw = new FileWriter(filename); // writing stream
    String buff = "";
    while(!(buff = sc.next()).contains("STOP") && buff != null)
        fw.append(buff + "\n"); // write the buffer into the stream
    fw.flush(); // commit changes
    fw.close(); // close the stream
    sc.close(); // close the scanner
}catch(IOException e){
    e.printStackTrace();
}
```

### Commented example of file **reading**
```java
try{
    FileReader fr = new FileReader(filename); // reading stream
    Scanner sc = new Scanner(fr);   // scanner to read from file
    while(sc.hasNextLine()) // read while next line exists
        System.out.println(sc.nextLine()); // prints a line and go to the next
    sc.close(); // close the scanner
    fr.close(); // close the reading stream
}catch(IOException e){
    e.printStackTrace();
}
```

### Commented example of different File functions : 
#### test wether or not the specified file exists in the current directory
```java
String filename = "random_name.txt";
File myfile = new File(filename); // file to test
System.out.println(filename + " exists : " + test.exists()); 
```
#### Prints the files/directories in the current directory
```java
File current = new File(".");
File[] files_array = file.listFiles(); // returns an array of files
Arrays.stream(files_array).forEach(System.out::println); // prints the array
```




