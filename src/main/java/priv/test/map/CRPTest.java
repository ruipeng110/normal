package priv.test.map;

import java.util.Random;

/**
 * <B>说       明</B>:
 *
 * @author 作  者  名：陈芮芃<br/>
 *         E-mail ：ruipeng110@126.com
 * @version 版 本 号：V1.0.<br/>
 *          创建时间：2017/9/13 0013 14:41
 */
public class CRPTest {

    public static void main(String[] args) {
        CRPTreeMap<Integer, Integer> map = new CRPTreeMap<>();
        for (int i = 0; i < 1000; i++) {
            int key = new Random().nextInt(10000);
            int value = new Random().nextInt(10000);
            map.put(key, value);
            if ((map.size() - i) != 1) {
                map.size();
                throw new RuntimeException();
            }
            if (!(new Integer(value).equals(map.get(key)))) {
                System.out.println(value + " " + map.get(key));
                throw new RuntimeException();
            }
            System.out.println(map.get(key));
        }
    }

}
