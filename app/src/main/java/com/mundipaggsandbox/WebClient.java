package com.mundipaggsandbox;

import com.mundipaggsandbox.model.Merchant;
import com.mundipaggsandbox.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by guilherme on 29/10/16.
 */
public class WebClient {

    private int responseCode ;

    public String postLogin(String json){

        try {
            URL url = new URL("https://api-dashboard.mundipagg.com/users/accesstokens");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");

            con.setDoOutput(true);

            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print(json);
            responseCode = con.getResponseCode();
            Scanner scanner ;
            if (responseCode == 200 || responseCode == 201)
                scanner = new Scanner(con.getInputStream());
            else
                scanner = new Scanner(con.getErrorStream());


            String response = "";
            while (scanner.hasNext()){
                response += " "+scanner.next();
            }

            return response;

        }catch (FileNotFoundException e){
             e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public String getListMerchant(User user,String term){
        try {

            String param = "";
            if (term != null)
                    param = "&merchant="+term;

            URL url = new URL("https://api-dashboard.mundipagg.com/"+user.getCustomerKey()+"/merchants?sortField=Name&sortMode=ASC"+param);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Authorization", user.getTokenType()+" "+user.getAccessToken());
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("IsSandboxEnabled", "true");


            responseCode = con.getResponseCode();
            Scanner scanner ;
            if (responseCode == 200 || responseCode == 201)
                scanner = new Scanner(con.getInputStream());
            else
                scanner = new Scanner(con.getErrorStream());

            String response = scanner.next().toString();
            while (scanner.hasNext()){
                response += " "+scanner.next().toString();
            }

            return response;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String postPayment(String json,User user,Merchant merchant) {
        String response;

        try {
            String strUrl = "https://api-dashboard.mundipagg.com/"+user.getCustomerKey()+"/sales";
            URL url = new URL(strUrl);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", user.getTokenType()+" "+user.getAccessToken());
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("IsSandboxEnabled", "true");
            con.setRequestProperty("MerchantKey", merchant.getMerchantKey());

            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());
            ps.print(json);
            responseCode = con.getResponseCode();
            Scanner scanner;
            if (responseCode == 200 || responseCode == 201)
                scanner = new Scanner(con.getInputStream());
            else
                scanner = new Scanner(con.getErrorStream());


            response = scanner.next().toString();
            while (scanner.hasNext()){
                response += " "+scanner.next();
            }
            return response;


        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    public int getResponseCode(){
        return responseCode;
    }

}
