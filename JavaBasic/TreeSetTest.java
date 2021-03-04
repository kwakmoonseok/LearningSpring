package JavaBasic;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("ȫ�浿");
        treeSet.add("�̼���");
        treeSet.add("������");

        for (String str : treeSet) { //String Ŭ������ comparable �Լ��� Ȱ���� ��
            System.out.println(str);
        }

    }
}
