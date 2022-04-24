# Purpose
The purpose of this program is to show how JDK's command line tools can be used to find the heap size of a running Java program.

# Prerequisites
* JDK 17 or higher. Either [OpenJDK](https://openjdk.java.net/projects/jdk/) or [Oracle's JDK](https://www.oracle.com/java/technologies/downloads/) should be sufficient.
* [Gradle](https://gradle.org/install/).

# How to run
1. Clone this repository.
2. In a shell window, `cd` to the root directory where you cloned this repo.
3. Run `gradle clean test` to verify that the application is correctly working. The tests should pass and produce an output which ends with these lines:
       
          BUILD SUCCESSFUL in 3s
          4 actionable tasks: 4 executed
4. Run `gradle clean run` in the same shell window. This starts up the application. You should see this line in the output:

          Program running. 10000 objects created on heap. Press CTRL-C to terminate.

5. Leave this shell window running for now. Do not press CTRL-C.
6. In a different shell window. Type `jps` and hit enter. This runs the [JVM Process Status tool](https://docs.oracle.com/javase/7/docs/technotes/tools/share/jps.html). You should see a list of running JVMs on your machine. Your list will look different, but it should be _similar_ to this:

         90464 GradleMain
         90474 JavaHeapMain
         87696 GradleDaemon
         ...

8. In particular, you should see an entry for `JavaHeapMain`. Copy the lvmid (Local VM ID) in the first column -- `90464` in the example above.
9. In the same shell window, run the `jcmd <lvmid> GC.heap_info` command with the lvmid from the previous step. This runs the [Java Diagnostic Command](https://docs.oracle.com/en/java/javase/14/docs/specs/man/jcmd.html) tool. E.g. `jcmd 90464 GC.heap_info` for the example above.
10. You should see the heap information for the running `GradleMain` application. It should look similar to this.


      garbage-first heap   total 65536K, used 23694K [0x00000007fc000000, 0x0000000800000000)
      region size 1024K, 17 young (17408K), 3 survivors (3072K)
      Metaspace       used 7675K, committed 7936K, reserved 1114112K
      class space    used 1041K, committed 1152K, reserved 1048576K

11. You may run the `jcmd` command multiple times to see the running heap size. The heap size _may_ change in the first few seconds after the application is up. However, the heap size for the `JavaHeapMain` progam _should_ stabilize after a while (e.g. one minute).
12. When you're done observing the heap size, terminate the `JavaHeapMain` program by entering CTRL-C in the first shell window.
