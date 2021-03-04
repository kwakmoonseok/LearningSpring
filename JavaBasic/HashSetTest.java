package JavaBasic;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("������");
        set.add("�̼���");
        set.add("������");
        set.add("�̼���");

        System.out.println(set); //�ߺ��� ������ ���� ������ ����

        Iterator<String> ir = set.iterator(); //��ȸ�� iterator �ڷ��� ���

        while (ir.hasNext()) {
            String str = ir.next();
            System.out.println(str);
        }
    }
}
