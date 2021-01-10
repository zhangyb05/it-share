package it.share.practice.run;

import it.share.practice.product.OneWayProduct;

/**
 * @author ：zhangyabo872
 * @description：TODO
 * @date ：2020/9/19 11:38
 */
public class RunProducerTest {
    public static void main(String[] args) {
      sendOneWayProduct();
    }

    private static void sendOneWayProduct(){
        OneWayProduct product = new OneWayProduct();
        try {
            product.sendOneWay("Hello word");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
