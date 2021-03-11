# JVM

## 使用CMS推荐的参数配置
### VM Options
```shell
#/bin/sh
java -jar xxx.jar
-Xmx4096M
-Xms4096M
-Xmn1536M 
-XX:MaxMetaspaceSize=512M
-XX:MetaspaceSize=512M 
-XX:+UseConcMarkSweepGC 
-XX:+UseCMSInitiatingOccupancyOnly 
-XX:CMSInitiatingOccupancyFraction=70 
-XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses 
-XX:+CMSClassUnloadingEnabled 
-XX:+ParallelRefProcEnabled 
-XX:+CMSScavengeBeforeRemark 
-XX:ErrorFile=/home/admin/logs/xelephant/hs_err_pid%p.log 
-Xloggc:/home/admin/logs/xelephant/gc.log 
-XX:HeapDumpPath=/home/admin/logs/xelephant 
-XX:+PrintGCDetails 
-XX:+PrintGCDateStamps 
-XX:+HeapDumpOnOutOfMemoryError
```

### Explain
| 编号 | 参数名称 | 解释 |
| --- | --- | --- |
| 1 | -Xmx | [JVM启动时分配的内存大小](https://www.cnblogs.com/ceshi2016/p/8447989.html) |
| 2 | -Xms | [JVM运行时分配的最大内存](https://www.cnblogs.com/ceshi2016/p/8447989.html) |
| 3 | -Xmn | [JVM内存堆区新生代的内存大小](https://www.cnblogs.com/ceshi2016/p/8447989.html) |
| 4 | -Xss | [JVM启动时每个线程分配的内存大小](https://www.cnblogs.com/ceshi2016/p/8447989.html) | 
| 4 | -XX:MaxMetaspaceSize | [JVM元空间区域的内存最大值](https://www.jianshu.com/p/5ee71f1724cd) |
| 5 | -XX:MetaspaceSize | [JVM元空间首次使用不够而触发FGC的阈值](https://www.jianshu.com/p/5ee71f1724cd) |
| 6 | -XX:UseConcMarkSweepGC | 启用CMS收集器 |
| 7 | -XX:UseCMSInitiatingOccupancyOnly | 关闭CMS的动态检查机制，只通过预设的阈值来判断是否启动并发收集周期 |
| 8 | -XX:CMSInitiatingOccupancyFraction | 老年代空间占用到多少的时候启动并发收集周期，跟UseCMSInitiatingOccupancyOnly一起使用 |
| 9 | -XX:ExplicitGCInvokesConcurrentAndUnloadsClasses | 将System.gc()触发的Full GC转换为一次CMS并发收集，并且在这个收集周期中卸载     Perm（Metaspace）区域中不需要的类 |
| 10 | -XX:CMSClassUnloadingEnabled | 在CMS收集周期中，是否卸载类 |
| 11 | -XX:ParallelRefProcEnabled | 是否开启并发引用处理 |
| 12 | -XX:CMSScavengeBeforeRemark | 如果开启这个参数，会在进入重新标记阶段之前强制触发一次minor gc |
| 13 | -XX:ErrorFile | [当JVM发生致命错误导致崩溃时，会生成一个hs_err_pid_xxx.log这样的文件，该文件包含了导致 JVM crash 的重要信息，我们可以通过分析该文件定位到导致 JVM Crash 的原因，从而修复保证系统稳定](https://blog.csdn.net/weixin_39609541/article/details/113082717) |
| | -XX:+HeapDumpOnOutOfMemoryError | [当JVM发生OOM时，自动生成DUMP文件](https://blog.csdn.net/lusa1314/article/details/84134458) |
| 14 | -XX:HeapDumpPath | [生成DUMP文件的路径，也可以指定文件名称](https://blog.csdn.net/lusa1314/article/details/84134458) |
| 15 | -XX:PrintGCDetails | [] |
| 16 | -XX:PrintGCDateStamps |  |
| 17 | -XX:HeapDumpOnOutOfMemoryError |  |

### Reference
* [阿里云云栖号——不可错过的CMS学习笔记](https://zhuanlan.zhihu.com/p/61944015)

## 使用G1
### VM Options

### Reference
