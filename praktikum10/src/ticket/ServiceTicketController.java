package ticket;

/**
 * Created by Jaanus on 23.11.16.
 */
public class ServiceTicketController {
    void startServiceSystem() throws InterruptedException {
        TicketStorage storage = new TicketStorage();

        ServiceTicketGenerator gen1 = new ServiceTicketGenerator(11, storage);
        ServiceTicketGenerator gen2 = new ServiceTicketGenerator(12, storage);

        ServiceHandler handler1 = new ServiceHandler("Handler 1", storage);
        ServiceHandler handler2 = new ServiceHandler("Handler 2", storage);
        ServiceHandler handler3 = new ServiceHandler("Handler 3", storage);
        ServiceHandler handler4 = new ServiceHandler("Handler 4", storage);

        Thread genThread1 = new Thread(gen1);
        Thread genThread2 = new Thread(gen2);

        Thread handlerThread1 = new Thread(handler1);
        Thread handlerThread2 = new Thread(handler2);
        Thread handlerThread3 = new Thread(handler3);
        Thread handlerThread4 = new Thread(handler4);

        genThread1.start();
        genThread2.start();

        handlerThread1.start();
        handlerThread2.start();
        handlerThread3.start();
        handlerThread4.start();

        Thread.sleep(8000);

        genThread1.interrupt();
        genThread2.interrupt();
        handlerThread1.interrupt();
        handlerThread2.interrupt();
        handlerThread3.interrupt();
        handlerThread4.interrupt();
    }

    public static void main(String[] args) {
        try {
            new ServiceTicketController().startServiceSystem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
