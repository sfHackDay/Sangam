package com.data.sangam.contacts.bean;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public class OAuthInfo {
	
	public OAuthInfo(String provider,OAuthService service,Token requestToken){
		this.provider=provider;
		this.requestToken=requestToken;
		this.service=service;
	}
	
	private String provider;
	
	private OAuthService service;
	
	private Token requestToken;

	public OAuthService getService() {
		return service;
	}

	public void setService(OAuthService service) {
		this.service = service;
	}

	public Token getRequestToken() {
		return requestToken;
	}

	public void setRequestToken(Token requestToken) {
		this.requestToken = requestToken;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	


}
