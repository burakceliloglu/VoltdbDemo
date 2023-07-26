import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "http://localhost:32826/api/2.0/?Procedure=select";

        try{
            Client client = ClientFactory.createClient();
            client.createConnection("localhost", 32822);

            ClientResponse response = client.callProcedure("@AdHoc", "SELECT * FROM SUBSCRIBER");
            System.out.println(response.getResults()[0]);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
