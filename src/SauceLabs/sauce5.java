//package SauceLabs;
//import org.apache.http.*;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.params.HttpParams;
//import org.apache.http.protocol.HttpContext;
//
//import java.io.*;
//
///**
// * Created by namrataojha on 7/20/16.
// */
//public class sauce5 {
//
//
//
//    private static String url = "http://localhost:12345/";
//
//    public static void main(String[] args) {
//        // Create an instance of HttpClient.
//        HttpClient client = new HttpClient() {
//            @Override
//            public HttpParams getParams() {
//                return null;
//            }
//
//            @Override
//            public ClientConnectionManager getConnectionManager() {
//                return null;
//            }
//
//            @Override
//            public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
//                return null;
//            }
//
//            @Override
//            public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
//                return null;
//            }
//        };
//
//        // Create a method instance.
//        GetMethod method = new GetMethod(url);
//
//        // Provide custom retry handler is necessary
//        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
//                new DefaultHttpMethodRetryHandler(3, false));
//
//        try {
//            // Execute the method.
//            int statusCode = client.executeMethod(method);
//
//            if (statusCode != HttpStatus.SC_OK) {
//                System.err.println("Method failed: " + method.getStatusLine());
//            }
//
//            // Read the response body.
//            byte[] responseBody = method.getResponseBody();
//
//            // Deal with the response.
//            // Use caution: ensure correct character encoding and is not binary data
//            System.out.println(new String(responseBody));
//
//        } catch (HttpException e) {
//            System.err.println("Fatal protocol violation: " + e.getMessage());
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("Fatal transport error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // Release the connection.
//            method.releaseConnection();
//        }
//    }
//}
