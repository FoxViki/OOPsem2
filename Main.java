public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Саша");
        Human human2 = new Human("Костя");
        Human human3 = new Human("Леша");
        Human human4 = new Human("Женя");
        Human human5 = new Human("Марта");
        Market market = new Market();
        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);
        market.acceptToMarket(human4);
        market.acceptToMarket(human5);
        market.update();
    }
}
