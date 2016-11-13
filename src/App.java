import Entities.EventTypeEntity;

import java.io.*;
import java.util.ArrayList;
import java.sql.*;


public class App {
    public static void main (String [] args)
    {
        System.out.println("Begin execution!");

        EventType eventType = new EventType();

        try{
            OutputData();
            eventType.Add(new EventTypeEntity(5, "Surf"));
            OutputData();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("End execution!");
    }

    protected static void OutputData() throws  IOException
    {
        try{
            EventType eventType = new EventType();
            ArrayList<EventTypeEntity> data = eventType.GetAll();
            for (EventTypeEntity object: data) {
                System.out.println(object.GetName() + "(" + object.GetId() + ")");
            }
        } catch (IOException ex){
            throw ex;
        }
    }
}
