package util;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.*;

public class json_builder
{
    public static ServerSocket servSoc;
    public static Socket sendingSoc;
    public static Socket clientSoc;
    public static PrintWriter out;
    public static BufferedReader in;

    public void init_json_builder() throws IOException
    {
        json_builder.servSoc = new ServerSocket(200);
        json_builder.sendingSoc = new Socket("127.0.0.1", 100);
        json_builder.clientSoc = json_builder.servSoc.accept();
        json_builder.out = new PrintWriter(json_builder.sendingSoc.getOutputStream(), true); 
        json_builder.in = new BufferedReader(new InputStreamReader(json_builder.clientSoc.getInputStream()));
    }

    public void send_json_data(int quantity, int liquid_one, int liquid_two, int liquid_three, int liquid_four)
    {
        json recipe = new json(quantity, liquid_one, liquid_two, liquid_three, liquid_four);
        Gson gson = new GsonBuilder().setVersion(1.0).create();
        String jsonOut = gson.toJson(recipe);

        json_builder.out.println(jsonOut);
    }

    public void recv_json_data() throws IOException
    {
        String msg = json_builder.in.readLine();
        System.out.println(msg);
        // json recipe = new json();
    }

    class json
    {
        int quantity;
        int liquid_one;
        int liquid_two;
        int liquid_three;
        int liquid_four;

        public json(int quantity, int liquid_one, int liquid_two, int liquid_three, int liquid_four)
        {
            this.quantity = quantity;
            this.liquid_one = liquid_one;
            this.liquid_two = liquid_two;
            this.liquid_three = liquid_three;
            this.liquid_four = liquid_four;
        }
    }
}