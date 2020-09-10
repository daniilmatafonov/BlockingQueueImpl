import com.queue.Consumer;
import com.queue.ImplBlockingQueue;
import com.queue.Producer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BlockingQueueTest {

    private Producer producer;
    private Consumer consumer;
    private ImplBlockingQueue queue;

    @BeforeEach
    public void setUp(){
        queue = new ImplBlockingQueue();
        producer = new Producer(queue);
        consumer = new Consumer(queue);
        producer.setName("producer");
        consumer.setName("consumer");
    }

    @Test
    public void handleQueueMessages(){
        producer.start();
        consumer.start();
    }
}
