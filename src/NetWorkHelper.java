package cn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NetWorkHelper {
	
	public String getHttpsResponsePostBody(String hsUrl,String requestMethod,String body) {
        URL url;
        InputStream is = null;
        String resultData = "";
        try {
            url = new URL(hsUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            TrustManager[] tm = {xtm};
 
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tm, null);
 
            con.setSSLSocketFactory(ctx.getSocketFactory());
            con.setHostnameVerifier(new HostnameVerifier() {
                //@Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
 
            con.setDoInput(true); //允许输入流，即允许下载
 
            //在android中必须将此项设置为false
            con.setDoOutput(true); //允许输出流，即允许上传
            con.setUseCaches(false); //不使用缓冲
            if(null!=requestMethod && !requestMethod.equals("")) {
                con.setRequestMethod(requestMethod); //使用指定的方式
            }
            else{
                con.setRequestMethod("GET"); //使用get请求
            }
            
            con.setRequestProperty("Content-Type","application/json");  
            
            DataOutputStream out = new DataOutputStream(con.getOutputStream());   
            String content = body;   
            byte[] outputInBytes = content.getBytes("UTF-8");
            out.write(outputInBytes);   
            out.flush();   
            out.close();   
            
            is = con.getInputStream();   //获取输入流，此时才真正建立链接
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = bufferReader.readLine()) != null) {
                resultData += inputLine + "\n";
            }
            System.out.println(resultData);
 
            
            Certificate[] certs = con.getServerCertificates();
 
            int certNum = 1;
 
            for (Certificate cert : certs) {
                X509Certificate xcert = (X509Certificate) cert;
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }
 
	
	public String getHttpsResponse(String hsUrl,String requestMethod) {
        URL url;
        InputStream is = null;
        String resultData = "";
        try {
            url = new URL(hsUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            TrustManager[] tm = {xtm};
 
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(null, tm, null);
 
            con.setSSLSocketFactory(ctx.getSocketFactory());
            con.setHostnameVerifier(new HostnameVerifier() {
                //@Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
 
            con.setDoInput(true); //允许输入流，即允许下载
 
            //在android中必须将此项设置为false
            con.setDoOutput(false); //允许输出流，即允许上传
            con.setUseCaches(false); //不使用缓冲
            if(null!=requestMethod && !requestMethod.equals("")) {
                con.setRequestMethod(requestMethod); //使用指定的方式
            }
            else{
                con.setRequestMethod("GET"); //使用get请求
            }
            
            is = con.getInputStream();   //获取输入流，此时才真正建立链接
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = bufferReader.readLine()) != null) {
                resultData += inputLine + "\n";
            }
            System.out.println(resultData);
 
            
            Certificate[] certs = con.getServerCertificates();
 
            int certNum = 1;
 
            for (Certificate cert : certs) {
                X509Certificate xcert = (X509Certificate) cert;
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }
 
	X509TrustManager xtm = new X509TrustManager() {
       // @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
 
        //@Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub
 
        }
 
       // @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                throws CertificateException {
            // TODO Auto-generated method stub
 
        }
    };
}
