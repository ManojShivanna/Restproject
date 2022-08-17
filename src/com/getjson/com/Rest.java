package com.getjson.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Rest {
 public static void main(String[] args) throws IOException {
	 URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
	 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	 conn.setRequestMethod("GET");
	 BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	 String inputLine ;
	 
	StringBuffer response = new StringBuffer();
	while((inputLine = reader.readLine())!=null) {
		response.append(inputLine);
	}reader.close();
	 //System.out.println(response);
	 
	JSONObject arr = new JSONObject(response.toString());
	JSONArray list = arr.getJSONArray("list");
	
	//System.out.println(list);
	while(true) {
		int choice;
		System.out.println("1.GET temparture\n"+"2.GET Wind\n"+"3.GET pressure\n"+"0.Exit\n"+"Enter the choice\n\n");
		Scanner b = new Scanner(System.in);
		choice = b.nextInt();
		if(choice==0) {
			break;
		}
		if(choice ==1) {
			String date;
			System.out.println("Enter the date:"+"\t\t\t\t"+"Ex : 2019-03-27");
			Scanner c = new Scanner(System.in);
			date = c.nextLine();
			for(int i=0;i<list.length();i++) {
				JSONObject arr1 = list.getJSONObject(i);
				JSONObject main = arr1.getJSONObject("main");
				String dt = arr1.get("dt_txt").toString();
				//System.out.println(dt);
				String [] dt1 = dt.split(" ");
				String [] dt2 = dt1[0].split("-");
				String dt3 = dt2[2];
				String [] date1 = date.split(" ");
				String [] date2 = date1[0].split("-");
				//System.out.println(date1[0]);
				String date3 = date2[2];
				int k = Integer.parseInt(date3);
				int j = Integer.parseInt(dt3);
				//System.out.println(date3);
				//System.out.println(dt3);
				if(k==j) {
					String temp = main.get("temp").toString();
					System.out.println("\t\t*******\t temperture :"+temp+"\tdate :"+dt+"\t********\n\n");
				}
				
			}
			
		}
		if(choice==2) { 
			String date;
			System.out.println("Enter the date:\t\t\t\t"+"Ex : 2019-03-27");
			Scanner c = new Scanner(System.in);
			date = c.nextLine();
			for(int i=0;i<list.length();i++) {
				JSONObject arr1 = list.getJSONObject(i);
				JSONObject main = arr1.getJSONObject("main");
				String dt = arr1.get("dt_txt").toString();
				//System.out.println(dt);
				String [] dt1 = dt.split(" ");
				String [] dt2 = dt1[0].split("-");
				String dt3 = dt2[2];
				String [] date1 = date.split(" ");
				String [] date2 = date1[0].split("-");
				//System.out.println(date1[0]);
				String date3 = date2[2];
				int k = Integer.parseInt(date3);
				int j = Integer.parseInt(dt3);
				//System.out.println(date3);
				//System.out.println(dt3);
				if(k==j) {
				JSONObject wind = arr1.getJSONObject("wind");
				String speed = wind.get("speed").toString();
				System.out.println("\t\t*******\t wind speed\t"+speed+"date :"+dt+"\t\t********\t\tn");
				}
		}
			}
		if(choice==3) {
			String date;
			System.out.println("Enter the date:\t\t\t\t"+"Ex : 2019-03-27");
			Scanner c = new Scanner(System.in);
			date = c.nextLine();
			for(int i=0;i<list.length();i++) {
				JSONObject arr1 = list.getJSONObject(i);
				JSONObject main = arr1.getJSONObject("main");
				String dt = arr1.get("dt_txt").toString();
				//System.out.println(dt);
				String [] dt1 = dt.split(" ");
				String [] dt2 = dt1[0].split("-");
				String dt3 = dt2[2];
				String [] date1 = date.split(" ");
				String [] date2 = date1[0].split("-");
				//System.out.println(date1[0]);
				String date3 = date2[2];
				int k = Integer.parseInt(date3);
				int j = Integer.parseInt(dt3);
				//System.out.println(date3);
				//System.out.println(dt3);
				if(k==j) {
			String pressure = main.get("pressure").toString();
			System.out.print(pressure);
			System.out.println("\t\t*******\t wind speed\t"+pressure+"date :"+dt+"\t\t********\t\t\n");
				}
			}
			
		}
		if(choice<0||choice>3) {
			System.out.println("enter the worng data");
		}
	}
	 
	 
	 
 }

}
