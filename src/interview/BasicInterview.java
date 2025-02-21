package interview;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 基本面试题
 * @date 2025/02/19
 */
public class BasicInterview {
    /**
     * 问：==和equals的区别
     * 答：==比较的是两个对象的地址，equals比较的是两个对象的内容
     * 扩展：Object类中的equals方法默认是采用==来比较两个对象的地址，只不过Java源码中提供了新的思路(例如Integer、String等)，可以通过重写equals方法来比较两个对象的内容
     *
     * -----------------------------------
     * 问：什么是方法重载？返回值算重载吗？
     * 答：方法重载是指在同一个类中定义了多个名称相同，参数不同的方法，方法的重载是发生在编译期，返回值是不参与重载的判断的，因为对于调用方来说，使用相同的方法和参数无法区分返回值到底给什么
     * 扩展：方法重载和重写是两个不同的概念，重写是发生在继承中，父类的方法在子类中重写，并且重写是发生在运行期【可以通过@Override将运行期报错提前到编译期】
     *
     * -----------------------------------
     * 问：finally中的代码一定会执行吗？
     * 答：不一定，虽然finally在很多场景下，确实用于不管return还是出现异常时都会执行的部分，例如：释放内存、资源、连接等。但是在遇到以下情况时，都不会执行finally
     * 1. System.exit(0)
     * 2. Runtime.getRuntime().halt(0)
     * 3. 程序在try块中遇到无限循环或者发生死锁等情况时，程序无法正常跳出try块，finally也就无法正常执行
     * 4. 掉电问题
     * 5. JVM程序崩溃
     * 扩展：System.exit(0)和Runtime.getRuntime().halt(0)都是强行终止正在运行的JVM,但是它们有以下区别
     * 1. System.exit(0)是java.lang.System类的一个静态方法，它接受一个整数参数作为退出状态码，使用0值表示正常终止，非0则是异常终止，但是exit()会执行JVM关闭的钩子程序或终结器
     * 2. Runtime.getRuntime().halt(0)是Runtime类的一个静态方法，它接受一个整数参数作为退出状态码，使用0值表示正常终止，很少使用非0值，halt()不会执行JVM关闭的钩子程序或终结器
     *
     * -----------------------------------
     * 问：多态的实现原理？
     * 答：多态的实现原理是通过动态绑定和虚拟方法调用来实现的
     *      动态绑定：是指在编译时，Java将方法的绑定推迟到运行期，JVM会根据对象的实际类型来决定调用哪个重写的方法
     *      虚方法表：所有非私有、非静态和非final方法都是被隐式指定为虚拟方法。每个类都有一个虚方法表，并且子类会继承父类的虚方法表，并用自己的实现覆盖父类方法的入口地址
     *
     * -----------------------------------
     * 问：ArrayList和LinkedList有什么区别？
     * 答：ArrayList和LinkedList都是Java中List接口的实现类，但是它们存在很多不同之处：
     *   例如：
     *   底层实现方面：ArrayList基于动态数组的数据结构；LinkedList基于链表的数据结构
     *   随机访问的性能不同：ArrayList对元素的随机访问时间复杂度为O(1)；LinkedList对元素的随机访问时间复杂度为O(n);
     *   插入和删除的性能不同：ArrayList插入和删除的时间复杂度为O(n)；LinkedList插入和删除的时间复杂度为O(1);
     * 扩展：在使用场景上，通常随机访问多的尽量使用ArrayList，添加或删除多的场景可以选择LinkedList
     *
     * -----------------------------------
     * 问：ArrayList和Vector有什么区别？
     * 答：ArrayList和Vector都是实现了List接口，也都是采用动态数组来实现的，并且拥有相同的方法。但是它们存在以下区别：
     *   1. 线程安全：Vector是线程安全的，ArrayList是非线程安全的。所以在多线程下使用Vector
     *   2. 性能：由于Vector是线程安全的，所有方法都加了Synchronized，导致性能明显差于ArrayList，所以在单线程下能使用ArrayList就坚决不使用Vector
     *   3. 初始容量增长方式：当容量不足时，ArrayList默认会增加50%的容量，Vector则是将容量翻倍，随之带来的就是ArrayList会需要频繁扩容，但是会更节省内存资源，Vector则无需频繁扩容，但是更浪费内存资源，所以Vector更适合存储大量数据
     * 扩展：Vector目前已经成为了过时的类，如果为了保证线程安全，可以考虑使用CopyOrWriteArrayList或者Collections.synchronizedList
     *
     * -----------------------------------
     * 问：抽象类和普通类有什么区别？
     * 答：抽象类和普通类有以下区别
     *      1. 实例化：普通类可以直接实例化、抽象类不能直接实例化
     *      2. 方法：抽象类中既包含抽象方法，也包含具体方法、普通类只能包含具体方法
     *      3. 实现：普通类实现接口需要重写接口中的方法、抽象类可以实现接口方法也可以不实现
     *
     * -----------------------------------
     * 问：为什么Map不能插入null？
     * 答：Map不一定不能插入null，HashMap是支持key和value都为null，但是ConcurrentHashMap不支持，不仅key不能为null，value也不能为null。因为源码判断了key和value是否为null，如果为null，则抛出空指针异常
     * 扩展：因为ConcurrentHashMap是用于并发环境下，如果再并发环境下key和value为null，则会出现二义性问题。
     *      什么是二义性问题？
     *          null本身有两层含义：这个值本身设置的值就是null，表示null值；null也表示还没有设置值。所以在并发环境下，倒是有没有设置值就成了二义性问题
     *      HashMap是可证伪二义性的，使用hashMap.containsKey(key)区分到底是存入的null还是压根不存在的null
     *      ConcurrentHashMap是不可证伪二义性的，因为在证明二义性问题的同时，可能会有另外的线程影响执行结果，二义性就会一直存在。
     *
     * -----------------------------------
     * 问：抽象类和接口有什么区别？
     * 答：抽象类和接口有以下区别
     *      定义：抽象类采用abstract关键字，接口采用interface关键字
     *      方法：抽象类可以包含抽象方法和具体方法，接口只能包含方法声明、默认方法、静态方法和私有方法
     *      方法访问控制符：抽象类中的抽象方法不能被private修饰；接口默认是public修饰
     *      实现：一个类只能继承一个抽象类，但是可以实现多个接口
     *      变量：抽象类可以包含实例变量和静态变量，而接口只能包含常量
     *      构造函数：抽象类可以有构造函数，接口不能有构造函数
     *
     * ------------------------------------
     * 问：HashMap和Hashtable的区别？
     * 答：HashMap和Hashtable都是Java中Map接口的实现类，并且底层数据结构都是数组加链表。但是它们存在以下区别：
     *      1. 线程安全：HashMap是非线程安全的，Hashtable是线程安全的。所以在多线程下使用Hashtable
     *      2. 性能：因为Hashtable使用了synchronized，所以性能比HashMap差，所以在单线程下使用HashMap
     *      3. 存储：HashMap允许key和value是null，Hashtable不允许key和value是null
     * 扩展：Hashtable不推荐使用，虽然是线程安全的，但是官方也不推荐，因为Hashtable是给整个方法添加了synchronized来实现线程安全的，所以性能非常差。
     *      官方推荐多线程环境下使用ConcurrentHashMap来完成数据存储。因为ConcurrentHashMap锁粒度更细，在多线程环境下表现更好
     *
     * ------------------------------------
     * 问：HashMap和HashSet的区别？
     * 答：HashMap和HashSet都是Java的集合类，它们有以下区别：
     *      1. 接口：HashMap实现了Map接口，HashSet实现了Set接口
     *      2. 存储：HashSet底层采用HashMap来存储数据，将元素存储到HashMap的key中，value始终为null。Hashmap存储的是键值对
     *      3. 因为HashMap的key不允许重复，允许value重复。所以HashSet的元素也是唯一的(如果有重复的值会被覆盖)
     */

}
