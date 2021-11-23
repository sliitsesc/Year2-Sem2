public class DSATreeNode
{
    private String key;
    private Object value;
    private DSATreeNode leftChild;
    private DSATreeNode rightChild;

    public DSATreeNode(String inKey, Object inValue)
    {
        key = inKey;
        value = inValue;
    }

    public String getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public DSATreeNode getLeft()
    {
        return leftChild;
    }

    public DSATreeNode getRight()
    {
        return getRight;
    }

    public void setLeft(DSATreeNode inLeftChild)
    {
        leftChild = inLeftChild;
    }

    public void setRight(DSATreeNode inRightChild)
    {
        rightChild = inRightChild;
    }
}