import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    List<Actor> actorList = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
    System.out.println(actor.getName() + " заходит в магазин");
    takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor : actors){
            System.out.println(actor.getName() + " вышел из магазина");
            actorList.remove(actor);
        }
    }

    @Override
    public void update() {
    takeOrders();
    giveOrders();
    releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        actorList.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : actorList){
            if (!actor.isMakeOrder()){
                System.out.println(actor.getName() + " сделал заказ");
                actor.setMakeOrder(true);
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : actorList){
            if (!actor.isTakeOrder() && actor.isMakeOrder){
                System.out.println(actor.getName() + " получил заказ");
                actor.setTakeOrder(true);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseFromQueue = new ArrayList<>();
        for (Actor actor : actorList)
            if (actor.isTakeOrder){
                System.out.println(actor.getName() + " вышел из очереди");
                releaseFromQueue.add(actor);
            }
        releaseFromMarket(releaseFromQueue);
    }
    
}
