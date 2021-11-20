class DSAHashEntry
{
    private String key;
    private Integer value;
    private Integer state;

    public DSAHashEntry()
    {
        key = "";
        value = null;
        state = 0;
    }

    public DSAHashEntry(String inKey, Integer inValue)
    {
        key = inKey;
        value = inValue;
    }

    public void setKey(String inKey)
    {
        key = inKey;
    }

    public String getKey()
    {
        return key;
    }

    public void setValue(Integer inValue)
    {
        value = inValue;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setState()
    {
        state = 1;
    }

    public void clearState()
    {
        state = null;
    }

    public Integer getState()
    {
        return state;
    }
}