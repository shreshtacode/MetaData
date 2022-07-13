package com.example.demo.service;

import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MetaDataService {
	
	@Autowired
	RestTemplate template;
	
	
	public Object getMetadata() {
		HttpHeaders headers = new HttpHeaders() {{
			String auth = "lowkeylobos-open-video" + ":" + "shreshta-kota";
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         set( "Authorization", authHeader );
	      }};
		
		
		HttpEntity<String> entity = new HttpEntity<>( headers);
		ResponseEntity<Object> resp = template.exchange("https://7ir47r3nq5.execute-api.us-east-2.amazonaws.com/metadata",HttpMethod.GET,entity, Object.class);
		
		return resp.getBody();
	}
	
	public Object getMetadataWithId(String id) {
		HttpHeaders headers = new HttpHeaders() {{
			String auth = "lowkeylobos-open-video" + ":" + "shreshta-kota";
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         set( "Authorization", authHeader );
	      }};
		
		
		HttpEntity<String> entity = new HttpEntity<>( headers);
		ResponseEntity<Object> resp = template.exchange("https://7ir47r3nq5.execute-api.us-east-2.amazonaws.com/metadata/"+id,HttpMethod.GET,entity, Object.class);
		
		return resp.getBody();
	}
	public Object postMetadata(Object data) {
		HttpHeaders headers = new HttpHeaders() {{
			String auth = "lowkeylobos-open-video" + ":" + "shreshta-kota";
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         set( "Authorization", authHeader );
	      }};
		
		
		HttpEntity<Object> entity = new HttpEntity<>(data, headers);
		ResponseEntity<String> resp = template.exchange("https://7ir47r3nq5.execute-api.us-east-2.amazonaws.com/metadata",HttpMethod.POST,entity, String.class);
		
		return resp.getBody();
	}
	public Object deleteMetadataWithId(String id) {
		HttpHeaders headers = new HttpHeaders() {{
			String auth = "lowkeylobos-open-video" + ":" + "shreshta-kota";
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         set( "Authorization", authHeader );
	      }};
		
		
		HttpEntity<String> entity = new HttpEntity<>( headers);
		ResponseEntity<Object> resp = template.exchange("https://7ir47r3nq5.execute-api.us-east-2.amazonaws.com/metadata/"+id,HttpMethod.DELETE,entity, Object.class);
		
		return resp.getBody();
	}

}
