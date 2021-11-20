import java.io.*;

class TestHarness
{
    public static void main(String[] args)
    {
        DSAHashTable newHashTable = new DSAHashTable(6);

        newHashTable.put("A", 12);
        System.out.println(newHashTable.get("A").getValue() + 1);
        newHashTable.put("B", 13);
        newHashTable.remove("A");
        System.out.println(newHashTable.get("B").getValue() + 1);
        System.out.println(newHashTable.get("A").getValue());
    }
}