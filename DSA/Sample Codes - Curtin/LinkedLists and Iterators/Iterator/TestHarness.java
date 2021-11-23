import java.util.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        Object c;
        DSALinkedList llist = new DSALinkedList();

        llist.insertFirst("Third Element");
        llist.insertFirst("Second Element");
        llist.insertLast("Fourth Element");
        llist.insertLast("Fifth Element");
        llist.insertFirst("First Element");

        Iterator itList = llist.iterator();

        while(itList.hasNext())
        {
            c = itList.next(); //ask why we need to cast it?
            System.out.println(c);
        }
    }
}
