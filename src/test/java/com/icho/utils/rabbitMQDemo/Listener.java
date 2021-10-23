package com.icho.utils.rabbitMQDemo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: icho
 * @Date: 2021/9/19 17:10
 * @Describe: RabbitMQ消费者
 */
@Component // 注册到sping容器中
@Resource
public class Listener {

    @RabbitListener( // 声明该方法是一个消费者方法
            bindings = @QueueBinding( // 指定绑定关系,可以为多个;值是QueueBinding的数组
                    value = @Queue(
                            value = "icho.queue",durable = "true"), // 该消费者关联的队列,值是@Queue,代表一个队列
                    exchange = @Exchange( // 队列锁绑定的交换机
                            value = "icho.exchange",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
                    key = {"#.#"} // 队列和交换机绑定的RoutingKey
            )
    )
    public void listen(String msg) {
        System.out.println("接收到消息 : " + msg);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test1() {

    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int Inputmonth = sc.nextInt();
        int i = 1, j = 0, month, x;
        for (month = 1; month < Inputmonth; month++) {
            x = i;
            i = i + j;
            j = x;
        }
        System.out.println("第" + month + "个月有"+2 * i + "只兔子");
    }*/

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
    }
}
