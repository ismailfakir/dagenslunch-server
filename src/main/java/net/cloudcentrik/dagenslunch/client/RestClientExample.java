package net.cloudcentrik.dagenslunch.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import net.cloudcentrik.dagenslunch.utils.AuthenticationUtils;

public class RestClientExample {
	
	private static final long SECONDS_IN_MILLISECOND = 1000L;
    public static void main(String[] args) {
    	String token = null;

        try {

           
            String apiSecret="987654321";
            String apiKey="user";

            final long nowSec = System.currentTimeMillis() / SECONDS_IN_MILLISECOND;
            final String toHash = apiKey + apiSecret + (nowSec-60);
            
			try {
				token = AuthenticationUtils.hash256(toHash);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(token);


            URL url = new URL("http://localhost:8989/people?apiKey="+apiKey+"&token="+token);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
