package Entities;

/**
 * Created by luismoreira on 12/11/16.
 */
public class EventTypeEntity {
    protected int id;
    protected String name;

    public EventTypeEntity(int _id, String _name)
    {
        this.id = _id;
        this.name = _name;
    }

    public int GetId()
    {
        return this.id;
    }

    public void SetId(int value)
    {
        this.id = value;
    }

    public String GetName()
    {
        return this.name;
    }

    public void SetName(String value)
    {
        this.name = value;
    }
}