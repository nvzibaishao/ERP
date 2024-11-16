package learn.javalearnproject.Thread;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import learn.javalearnproject.Entity.Password;
import learn.javalearnproject.mapper.PasswordMapper;
import learn.javalearnproject.service.PasswordService;
import learn.javalearnproject.service.impl.PasswordServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SpringBootTest
public class HighConcurrency {
    @Autowired
    private  PasswordService passwordService;
    @Autowired
    private PasswordMapper passwordMapper;

    public HighConcurrency() {

    }




    //创建一个线程
    @Test
    public void CreateThread(){
        /**int i=0;
        Instant now = Instant.now();
        while ( i<10){

            Thread thread = new Thread(()->{
                System.out.println("创建一个线程");
            });
            thread.start();
            Thread thread1 = new Thread(()->{
                System.out.println("创建另外一个线程");
            });
            thread1.start();
            i++;

        }
        Instant now1 = Instant.now();
        long millis = Duration.between(now, now1).toMillis();
        System.out.println(millis);
        Instant now3 = Instant.now();
        int q=0;
        while ( q<10) {
            System.out.println("创建一个线程");
            System.out.println("创建另外一个线程");
            q++;
        }
        Instant now2 = Instant.now();
        long millis1 = Duration.between(now3,now2).toMillis();
        System.out.println(millis1);*/
        //上面使用多线程打印的反而比没有使用的快得多
        /**int i=0;
        QueryWrapper<Password> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.lambda().eq(Password::getPassword,"ebe5dcac");
        Instant now = Instant.now();

        while ( i<100){

            Thread thread = new Thread(()->{

                passwordMapper.selectList();
            });
            thread.start();
            Thread thread1 = new Thread(()->{
                passwordMapper.selectList();
            });
            thread1.start();
            i++;

        }
        Instant now1 = Instant.now();
        long millis = Duration.between(now, now1).toMillis();
        System.out.println(millis);
        Instant now3 = Instant.now();
        int a=0;
        while ( a<100) {
            passwordMapper.selectList();
            passwordMapper.selectList();
            a++;
        }
        Instant now2 = Instant.now();
        long millis1 = Duration.between(now3,now2).toMillis();
        System.out.println(millis1);**/
        //在数据库查询上面，多线程查询的数据比单线程要快的多，i/o操作大部分都花在等待响应上面，单线程是a任务发送请求等待响应完成后b任务才能去发送请求等待响应，多线程b任务可以在a任务等待响应的时间发送请求，这样就避免排队浪费时间

        
    }

    @Test
    public  void  ThreadPool(){

        //创建缓存线程池 //核心线程数为0，最大线程数无限，等待队列数为0，非核心线程存活时间为60秒 //适合短生命周期任务
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            int i=0;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程"+i++);
            }
        });
        for(int i=0;i<20;i++){
            executorService.submit(new MyRunable(i));
        }
    }

    @Test
    public  void MyCallTest(){
        //创建固定大小线程池 //核心线程数为和最大线程数一致，等待队列无限大，存活时间为0    //适用于长期运行的服务，如Web服务器或消息处理系统，这些服务需稳定的性能和响应时间
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i=0;i<20;i++){
            Future<Integer> submit = executorService1.submit(new MyCall(i, i++));

            try {
                boolean cancel = submit.cancel(true);
                Integer integer = submit.get(10, TimeUnit.SECONDS);
                System.out.println(integer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void  ms(){

    }

    //递归遍历树结构
    @Test
    public void tree(){

        List<tree> trees = new ArrayList<>();
        trees.add(new tree("1","0"));
        trees.add(new tree("2","1"));
        trees.add(new tree("3","2"));
        trees.add(new tree("4","2"));
        tree tree = new tree("1", "0");
        tree.setChildreds(getTree(trees,"0"));
        String string = JSONObject.toJSON(tree).toString();
        System.out.println(string);

    }
    public  List<tree> getTree(List<tree> trees,String guid){
        List<tree> collect = trees.stream().filter(e -> e.getFaguid() == guid).collect(Collectors.toList());
        if(collect.size()==0){
            return null;
        }else {
            collect.forEach(x->{
                x.setChildreds(getTree(trees,x.guid));
            });
            return collect;
        }

    }




}

class MyRunable implements  Runnable{
    int i;
    public MyRunable(int i) {
        this.i = i;
    }

    public MyRunable() {
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "执行任务"+i);
    }
}

class MyCall implements Callable<Integer> {
    private int a;
    private int b;
    //通过构造方法传递两个参数

    public MyCall(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"准备开始计算...");
        Thread.sleep(2000);
        System.out.println(name+"计算完成...");
        return a*b;
    }
}
@Data
class tree{
    public  String guid;
    public  String faguid;


    public List<tree> childreds=new ArrayList<>();

    public tree(String guid, String faguid) {
        this.guid = guid;
        this.faguid = faguid;
    }


}
