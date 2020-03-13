import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import org.omg.CORBA.portable.OutputStream;




public class PostJson {
	
	public static void main(String[] args) {
		PostJson.Post_JSON();
	}
	
	
	public static void Post_JSON() {
	  String query_url = "https://jsonplaceholder.typicode.com/todos/1";
      String json = "{ \"method\" : \"guru.test\", \"params\" : [ \"jinu awad\" ], \"id\" : 123 }";
      try {
      URL url = new URL(query_url);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setConnectTimeout(5000);
      conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      conn.setDoOutput(true);
     // conn.setDoInput(true);
      conn.setRequestMethod("GET");
     // OutputStream os = (OutputStream) conn.getOutputStream();
   //   os.write(json.getBytes("UTF-8"));
   //   os.close(); 
      // read the response
      InputStream in = new BufferedInputStream(conn.getInputStream());
      String result = IOUtils.toString(in, "UTF-8");
      System.out.println(result);


      
      System.out.println("CONVERTENDO STRING TO JSON");
      JSONObject myResponse = new JSONObject(result);
      



      System.out.println(result);
      System.out.println("NUMERO DETECTADO: "+ myResponse.get("userId"));
      PostJson.verificarNumeroPrimo(myResponse.get("userId").toString());
      
//      System.out.println("jsonrpc- "+myResponse.getString("jsonrpc"));
//      System.out.println("id- "+myResponse.getInt("id"));
//      System.out.println("result- "+myResponse.getString("result"));
      
      
      in.close();
      conn.disconnect();
      } catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void verificarNumeroPrimo(String num) {
		int valor = Integer.parseInt(num);
		if(valor %2 ==0) {
			
			System.out.println("O NÚMERO "+valor+" É PRIMO");
		}else {
			System.out.println("O NÚMERO "+valor+" NÃO É PRIMO");
		}
	}
}
