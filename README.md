《疯狂Java讲义》学习
========
此仓库仅用于记录本人Java的学习过程以及方便在不同设备上同步

2017/07/15:
--------
### 1.网络编程

* 向站点发送GET请求、POST请求，并取得响应
* 基于TCP协议的网络编程

2017/07/14:
--------
### 1.多线程

* 线程和进程的概念
* 线程的创建和启动：
继承Thread类创建线程类(共享线程类实例变量)、
实现Runnable接口创建线程类(共享线程类的实例变量)、
使用Callable和Future创建线程
* 控制线程：join线程、后台线程、线程睡眠(sleep)、线程让步(yield)、改变线程优先级
* 同步代码块，同步方法synchronized
* 同步锁：ReentrantLock锁(具有重入性)
* 死锁
* 线程通信
* 线程池

### 2.网络编程

* Java的基本网络支持：
InetAddress、URLDecoder/URLEncoder、URL/URLConnection/URLPermission

2017/07/13:
--------
### 1.输入输出

* 对象序列化、对象引用的序列化
* 使用Buffer和Channel
* 文件锁
* Path、Paths和Files核心API
* 使用FileVisitor来遍历文件和目录
* 使用WatchService监控文件变化
* 访问文件属性

2017/07/12:
--------
### 1.Annotation注释

### 2.输入输出

* File类访问本地文件系统
* 文件过滤器 FilenameFilter
* FileInputStream、FileReader用法
* FileOutputStream、FileWriter用法
* 使用PrintStream处理流来包装OutputStream节点流
* 使用字符串作为物理节点的字符输入/输出流
* 转换流：由于BufferedReader具有readLine()方法，可以非常方便地一次读入一行的内容，所以经常把读取文本的输入流包装成BufferedReader
* 重定向标准输入/输出
* RandomAccessFile类：支持读写、随机（任意）访问的文件内容访问类

2017/07/11:
--------
### 1.JDBC

* 使用ResultSetMetaData分析结果集
* 使用RowSetFactory创建JdbcRowSet
* CachedRowSet测试(离线RowSet)
* 离线RowSet(CachedRowSet)的查询分页
* JDBC的事务支持
* 使用Java8增强的批量更新：addBatch()和executeBatch()方法
* 使用DatabaseMetaData分析数据库信息

2017/07/10:
--------
### 1.JDBC

* JDBC基础编程
* 使用Statement的executeQuery()方法执行sql查询语句
* 使用Statement的executeUpdate()方法执行DML和DDL语句
* 使用Statement的execute()方法执行任意的SQL语句
* 使用PreparedStatement执行SQL语句：性能更好，无须拼接Sql语句，防止Sql注入。
* 使用CallableStatement调用存储过程
* 创建可滚动、可更新的结果集(必须来自同一个表并包含主键)

### 2.简易图片管理程序

* 程序路径：src/lightProgram/ImageManager.java
* 通过Blob将图片保存到数据库中
* 图形化界面本地选择上传图片
* 查询数据库表中的图片并显示

2017/07/09:
--------
### 1.AWT编程

* 基本组件的综合运用
* AWT编程暂时告一段落，以后再学

### 2.Swing编程

* 由于时间原因，Swing编程以后再学

### 3.MySQL数据库与JDBC编程

* MySQL基础回顾
* 连接查询
* 子查询

2017/07/08:
--------
### 1.异常处理

* 异常跟踪栈
* 异常处理规则

### 2.AWT编程

* 基本的控件
* 各种Layout布局

2017/07/07:
--------
### 1.泛型

* 定义泛型接口、类
* 设定被限制的泛型通配符（类型通配符的上限）
* 定义泛型方法
* 定义泛型构造器
* 设定通配符上限

### 2.异常处理

* 异常类的继承体系
* Java7新增的多异常捕获
* Java7的自动关闭资源的try语句
* Checked异常和Runtime异常
* 同时使用catch和throw

2017/07/06更新：
--------
### 1.ArrayUtils类：

* 实现了ArrayUtils类的static int search(String[] array, String target)方法，该方法用于在数组中查找指定元素的索引，若没有该元素，则返回-1

### 2.梭哈小游戏：

* 实现了梭哈小游戏的基本框架，路径：src/lightProgram/ShowHand.java
* 实现了扑克牌类的封装，实现了扑克牌之间的大小比较等方法

待开发：

* 玩家跟注、弃牌等操作
* 牌面最大的玩家先下注
* 例如同花顺等牌型的大小比较，确定最后胜负

### 3.Java的各种集合学习
