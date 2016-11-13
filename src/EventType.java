import Entities.EventTypeEntity;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;
import java.sql.*;

/**
 * Created by luismoreira on 12/11/16.
 */
public class EventType extends Db {

    private static final String FilePath = "/Users/luismoreira/Java_project/event_types.csv";

    public ArrayList<EventTypeEntity> GetAll() throws IOException {
        ArrayList<EventTypeEntity> data = new ArrayList<EventTypeEntity>();

        try{
            this.CreateConnection();

            //here sonoo is database name, root is username and password
            Statement stmt = this._conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from event_type");
            while(rs.next())
            {
                data.add(new EventTypeEntity(rs.getInt(1), rs.getString(2)));
            }
            this.CloseConnection();
        }
        catch(Exception e){ System.out.println(e);}

        return data;
    }

    public void Add(EventTypeEntity entity) throws IOException, SQLException {
        /*String filename= "MyFile.txt";
        FileWriter fw = new FileWriter(FilePath,true); //the true will append the new data
        fw.write(String.format("%s,%s\n", entity.GetId(), entity.GetName()));//appends the string to the file
        fw.close();*/
        try{
            this.CreateConnection();

            String query = " insert into event_type (id, name)"
                    + " values (?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = this._conn.prepareStatement(query);
            preparedStmt.setString (1, String.format("%s", entity.GetId()));
            preparedStmt.setString (2, entity.GetName());

            // execute the preparedstatement
            preparedStmt.execute();

            this.CloseConnection();

        }
        catch (SQLException ex) { throw ex; }
        catch (Exception ex) { throw ex; }
    }

    public void Remove(int id) throws IOException
    {
        ArrayList<EventTypeEntity> data = this.GetAll();
        data.removeIf(e -> e.GetId() == id);

        String filename= "MyFile.txt";
        FileWriter fw = new FileWriter(FilePath,false); //the true will append the new data
        String writeData = "";
        for (EventTypeEntity entityData : data)
        {
            writeData += String.format("%s,%s\n", entityData.GetId(), entityData.GetName());
        }
        fw.write(writeData);//appends the string to the file
        fw.close();
    }

    /*File f = new File(FilePath);

        FileReader fr = new FileReader("/Users/luismoreira/Java_project/event_types.csv");
        BufferedReader br = new BufferedReader(fr);
        String stringRead = br.readLine();

        while( stringRead != null )
        {
            StringTokenizer st = new StringTokenizer(stringRead, ",");
            String idStr = st.nextToken( );
            String name = st.nextToken( );

            EventTypeEntity temp = new EventTypeEntity(Integer.parseInt(idStr), name);
            data.add(temp);

            // read the next line
            stringRead = br.readLine();
        }

        br.close( );*/
}
