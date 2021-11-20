class DSAHeapEntry
{
    Integer priority;
    Object value = null;

    public DSAHeapEntry(Integer inPriority, Object inValue)
    {
        priority = inPriority;
        value = inValue;
    }

    public DSAHeapEntry(Integer inPriority)
    {
        priority = inPriority;
    }

    public void setPriority(Integer inPriority)
    {
        priority = inPriority;
    }

    public void setValue(Object inValue)
    {
        value = inValue;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public Object getValue()
    {
        return value;
    }
}