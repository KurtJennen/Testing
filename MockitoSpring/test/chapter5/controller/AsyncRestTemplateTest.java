package chapter5.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRequestCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.ResponseExtractor;

public class AsyncRestTemplateTest {
	
	@Test
	public void exchange() {
		AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
		
		String url = "http://localhost:8080/MockitoSpring/hello/all/";
		HttpMethod method = HttpMethod.GET;
		Class<String> responseType = String.class;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		HttpEntity<String> requestEntity = new HttpEntity<String>("params", headers);
		
		ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.exchange(url, method, requestEntity, responseType);
		
		try {
			ResponseEntity<String> entity = future.get();
			System.out.println(entity.getBody());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void execute() {
		AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
		
		String url = "http://localhost:8080/MockitoSpring/hello/reader";
		HttpMethod method = HttpMethod.GET;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		
		AsyncRequestCallback requestCallback = new AsyncRequestCallback() {
			
			@Override
			public void doWithRequest(AsyncClientHttpRequest request) throws IOException {
				System.out.println(request.getURI());
			}
		};
		
		ResponseExtractor<String> responseExtractor = new ResponseExtractor<String>() {
			
			@Override
			public String extractData(ClientHttpResponse response) throws IOException {
				return response.getStatusText();
			}
		};
		
		Map<String,String> urlVariable = new HashMap<String, String>();
		
		ListenableFuture<String> future = asyncRestTemplate.execute(url, method, requestCallback, responseExtractor, urlVariable);
		
		try {
			String result = future.get();
			System.out.println("Status = " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
