import java.io.*;

public class BinarySearchTree implements Serializable
{
    private class DSATreeNode implements Serializable
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
            return rightChild;
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

    private DSATreeNode m_root;

    public BinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        Object returnElement = null;
        try
        {
            returnElement = findRec(key, m_root);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
        }
        return returnElement;
    }

    private Object findRec(String key, DSATreeNode currNode) throws NoSuchElementException
    {
        Object value = null;

        if (currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        } else if (key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        } else if (key.compareTo(currNode.getKey()) < 0 )
        {
            value = findRec(key, currNode.getLeft());
        } else
        {
            value = findRec(key, currNode.getRight());
        }
        return value;
    }

    public void insert(String key, Object value)
    {
        m_root = insertRec(key, value,  m_root);
    }

    private DSATreeNode insertRec(String key, Object value, DSATreeNode currNode)
    {
        if ( currNode == null)
        {
            DSATreeNode newNode = new DSATreeNode(key, value);
            currNode = newNode;
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, value, currNode.getLeft()));
        }
        else if (key.compareTo(currNode.getKey()) > 0)
        {
            currNode.setRight(insertRec(key, value, currNode.getRight()));
        }
        return currNode;
    }

    public void delete(String key)
    {
        m_root = deleteRec(key, m_root);
    }

    private DSATreeNode deleteRec(String key, DSATreeNode currNode)
    {
        DSATreeNode updateNode = currNode;
        if (key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(key, currNode);
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else if (key.compareTo(currNode.getKey()) > 0)
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }
        currNode = updateNode;
        return currNode;
    }

    private DSATreeNode deleteNode(String key, DSATreeNode delNode)
    {
        DSATreeNode updateNode = null;
        DSATreeNode currNode = delNode;

        if (delNode.getLeft() == null && delNode.getRight() == null)
        {
            delNode = null;
        }
        else if (delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft();
        } 
        else if (delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode);
            if (updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    private DSATreeNode promoteSuccessor(DSATreeNode currNode)
    {
        DSATreeNode successor = currNode;

        if (currNode.getLeft() == null)
        {
            successor = currNode;
        }

        if (currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if (successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }

    public void display()
    {
        System.out.println("----------Displaying inorder--------------");
        displayinOrder(m_root);
        System.out.println("-----------Displaying preorder------------");
        displaypreOrder(m_root);
        System.out.println("-----------Displaying postorder-----------");
        displaypostOrder(m_root);
    }

    private void displayinOrder(DSATreeNode currNode)
    {
        if (currNode != null)
        {
            displayinOrder(currNode.getLeft());
            System.out.print(currNode.getKey());
            System.out.print(" : ");
            System.out.println(currNode.getValue());
            displayinOrder(currNode.getRight());
        }
    }

    private void displaypreOrder(DSATreeNode currNode)
    {
        if (currNode != null)
        {
            System.out.print(currNode.getKey());
            System.out.print(" : ");
            System.out.println(currNode.getValue());
            displaypreOrder(currNode.getLeft());
            displaypreOrder(currNode.getRight());
        }
    }

    private void displaypostOrder(DSATreeNode currNode)
    {
        if (currNode != null)
        {
            displaypostOrder(currNode.getLeft());
            displaypostOrder(currNode.getRight());
            System.out.print(currNode.getKey());
            System.out.print(" : ");
            System.out.println(currNode.getValue());
        }
    }

    public int height()
    {
        return heightRec(m_root);
    }

    private int heightRec(DSATreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;

        if (currNode == null)
        {
            htSoFar = 0;
        }
        else
        {
            iLeftHt = heightRec(currNode.getLeft());
            iRightHt = heightRec(currNode.getRight());

            if (iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            }
            else
            {
                htSoFar = iRightHt + 1;
            }
        }
        return htSoFar;
    }
    public String minIter()
    {
        String minKey = minIter(m_root);
        return minKey;
    }

    private String minIter(DSATreeNode currNode)
    {
        String minKey;
        while (currNode.getLeft() != null)
        {
            currNode = currNode.getLeft();
        }
        minKey = currNode.getKey();
        return minKey;
    }

    public String maxIter()
    {
        String maxKey = maxIter(m_root);
        return maxKey;
    }

    private String maxIter(DSATreeNode currNode)
    {
        String maxKey;
        while (currNode.getRight() != null)
        {
            currNode = currNode.getRight();
        }
        maxKey = currNode.getKey();
        return maxKey;
    }

    public void balancedMark()
    {
        balancedMark(m_root);
    }

    private void balancedMark(DSATreeNode currNode)
    {
        int leftHeight = heightRec(currNode.getLeft());
        int rightHeight = heightRec(currNode.getRight());

        System.out.print("The height balance is : ");
        System.out.print(leftHeight / rightHeight * 100);
        System.out.println("%");
    }

}