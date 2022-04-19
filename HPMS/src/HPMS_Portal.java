import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HPMS_Portal {
	
	public static HttpRequest Getter() {
		HttpURLConnection connection;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request   = HttpRequest.newBuilder().uri(URI.create("http://happypets-1867210382.us-east-1.elb.amazonaws.com/api/patients")).build();
		client.sendAsync(request,HttpResponse.BodyHandlers.ofString())//tell server to recieve response as a string 
        .thenApply(HttpResponse::body) // returns response gofuture data type used for aysnchronous programming
        .thenAccept(System.out::println)// once we receive the response we want to apply the ::body method to previous results
                                        //:: means it's a lamda , once that is done we use this body to print out, using printline method
        .join();
		return request;
	}
	
	public static void runPP() {
		
	}
	
	public static void main(String[]Args) {
		System.out.println(Getter());
		
		
	}
	
	
	

	

}
