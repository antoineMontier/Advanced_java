# Advanced JAVA
University lessons on Java.

## Java threads methods:
- `getState()` returns `RUNNABLE`, `BLOCKED`, `NEW` or `TERMINATED`. ( which are the states that a thread can be in.)
- `getPriority()` returns the priority of the thread. Priority is an integer between 1 and 10. The higher the priority the sooner the execution will end. (high priority = execute first).
- `setPriority()` sets the priority to the thread.
- `start()` starts the thread, calls the `run()` method of the sepecified instance. This instance either implements `java.lang.Runnable`, or extends `java.lang.Thread`. 
- `join()` ou `join(ms)` waits for the a thread to end. This method can take a timeout in `ms`. This informs the main thread how long it should wait. At the end of the timeout the main thread continues whether if the other thread is done or not.

## Collections:

Collections has multiple methods : 
- `add(Elt)` : adds a new element to the collection, regardless wether or not the element is already in the collection.
- `addAll(Collection)` : adds a collection of elements to the "caller" collection.
- `remove(index)` : removes the element at the **index** from the collection, returns the removed element.
- `remove(Elt)` : removes the **first occurence** of the element from the collection, returns **true** or **false** depending on whether if the element is removed or not.
- `removeAll(Collection)` : removes **all** elements from the collection if they are contained in the collection given as the **argument**.
- `retainAll(Collection)` : removes all elements if they are not present in the collection given as the **argument**.
- `contains(Element)` : returns **true** or **false**
- `containsAll(Collection)` : returns **true** if the "caller" collection contains all elements in the collection given as the **argument**. Returns false otherwise.
- `size()` : returns the length as an int.
- `clear()` : emptys the collection
- `interator()` : returns an interator of the collection. ( can be used for the foreach )
- `toArray()` : returns an array containing the elements of the collection,
- `toArray(Array)` : modifies the array given as the argument with the content of the list. If not enough room, the array will not be filled

Examples of toArray() functions : 

<br>

```java

    List<String> l = new LinkedList<>();
    l.add("a");
    l.add("b");

    // no need to specify the correct length, toArray() will figure it out
    tab = l.toArray(new String[0]);         
    
    System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [a, b]"
  
    // =============================================================================
    List<String> l = new LinkedList<>();
    l.add("a");
    l.add("a");

    // 1st version
    String[] tab = new String[2];

    // if you pass in a constructed array, make sure that the length matches
    l.toArray(tab);
    System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [a, b]"

    // 2nd version

    String[] tab = new String[1];

    // if the array is already constructed and do not match the needed length
    // if will be filled with a null value; that is it ! 
    l.toArray(tab);
    System.out.println("tab :  " + Arrays.toString(tab)); // returns "tab :  [null]"

```

<br>

- `forEach(Consumer)` : iterates over the collection and consumes the elements, for example to print the elements.



The Collection interface inherits from the **Iterable** interface. The collection interface has **3** derived interfaces. 
- Set : No order, no duplicates, `add()`, `remove()`, `contains()`... > **HashSet** and **TreeSet** are implementing the **Set** Interface.
- List : Order, duplicates, access an element via its position, `add()`, `remove()`, `contains()`, `get()`... > **ArrayList** and **LinkedList** are implementing the **List** Interface.
- Queue : FIFO behaviour,  `add()`, `remove()`, `peek()` to get but don't remove queue element ... > **PriorityQueue** and **LinkedList** are implementing the **Queue** interface.

*Keep in mind that each collection implementation provides its own data structuring, but at the end of the day all they do is CRUD operations. a.k.a: add elements, see if an element is present, remove elements, access/read/update the value of the elements*


## Map Interface
Map Interface comes with a bunch of methods. The idea behind Map interface is to pair a **key** with an **Object**. It can be done withe these methods :
- `put(key, value)` pairs the value with the given key. If a value already exists for the given key, it will be updated with the new value.
- `get(key)` gets the object with the given key. Returns null if there are no value for the given key.
- `containsKey(key)` Returns wether or not a given key is **present**, even if it's linked to a null object.
- `containsValue(value)` Returns wether or not a given value is **present**. `containsValue(null)` will be true only if null has been inserted into the map.
- `size()` Returns the number of pairs in the map.
- `values()` returns an **array** of the values present in the Map.
- `keySet()` returns a **Set** of the keys (no repetitions and no order).

Many Classes implements Map Interface : 
- HashMap > stores the keys in a Hash Table. **Linear** complexity.
- TreeMap > stores the keys in a **tree** structure and needs a **comparator** to do it. **Logarithmic** complexity.
- LinkedHashMap > stores the keys in a **LinkedList** structure. **Linear** complexity.



### Boxing / Unboxing / Auto-boxing

When using an interface like Map, Collection... we are using a **generic** interface.
Generic types needs to be specified explicitly. For example : 

<br>

```java

Map<Integer, String> map = new TreeMap<>(); // ==== will create a map with Integers as keys and Strings as values
List<String> l = new ArrayList<>(); // ============ will create a list of Strings
List<List<Integer>> list_l = new LinkedList<>(); // will create a list of List of Integer, ie a 2D mutable Array

```
<br>

We can't create a list or a Map of `int`, `float`, `double`... they are primitive types and they are not supported for this use.
The solution is **boxing**. instead of using an `int`, we will use an `Integer`. 
Today, java is doing **Auto-boxing**. Inside an `Integer` list we can put an int. Java will automatically construct an Integer object theat holds the int value. (Boxes it in)
It's the same process for `double` and `Double`, `float` and `Float`...

#### Diamond operator

The diamond operator `<>` is used to infer the type of the data : 

<br>

```java

Map<Integer, String> map = new HashMap<Integer, String>();  // long and too much informations
Map<Integer, String> map = new HashMap<>(); // =============== short and easier to read

```
<br>


#### `?` Wildcard

Java allows its users to specify the content of a generic class : 
for example if we declare a List l as : `List<? extends T> l;` ; l will be able to **hold only the objects that inherit from T**
The oposite is : `List<? super T> l;` ; l will be able to **hold only the objects from which T inherits**.

## Iterator 

An iterator is an object used to iterate over a collection. It is basically a pointer that points to an object inside the collection.
**Warning** : An iterator must be used as soon as it's created. If the collection is modified between creation and use of the iterator, it can throw an exception.
Here are the **Iterator** methods : 
- hasNext() returns wether or not the current element has a next element.
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
The Collections class is a polymorphic class that implements lots of algorithms, as `sort()` and `reverse()`. It operates on Collections.

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
#### foreach iteration ( lambda function )
```java
l.forEach(s -> System.out.println(s));
```
#### foreach iteraction ( method refrencing )
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

`read()` and `write()` are the two main methods of streams Classes.


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

<br>


```java

System.out.println("about to write in file " + filename + " type 'STOP' to end :");
try{
    Scanner sc = new Scanner(System.in); // scanner used to read user input
    FileWriter fw = new FileWriter(filename); // writing stream, the file will be created or replaced if it already exists
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
<br>



### Commented example of file **reading**

<br>

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
<br>



### Commented example of different File functions : 
#### test wether or not the specified file exists in the current directory

<br>

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
<br>


It is possible to know wether a file is a directory or not using the method `isDirectory()`.

#### Copy a file
- Programmatically, If `dest` file already exists it will replace its content.

<br>

```java
try{
    Scanner read = new Scanner(new FileReader(src)); // reader
    FileWriter fw = new FileWriter(dest); // ========== writer

    while(read.hasNextLine()) // ============ while scanner has a next line
        fw.append(read.nextLine() + "\n"); // write every lines
    fw.close(); read.close(); // ============ close ressources (closes also the FileReader explicitly)
}catch(IOException e){e.printStackTrace();}
```
<br>

- Using `java.nio.file.Files`, If `dest` file already exists it will throw an exception.

<br>

```java
try{
    Files.copy(new File(src).toPath(), new File(dest).toPath()); // toPath() returns a path object needed for the copy operation of Files
}catch(IOException e){e.printStackTrace();}
```
<br>


