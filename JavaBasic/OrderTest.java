package JavaBasic;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();

        order.orderNum = 1;
        order.id = "kd134v";
        order.date = "2020/12/22";
        order.address = "����";

        System.out.println(order.orderNum + order.id + order.date + order.address);
    }


}
