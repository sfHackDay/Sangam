package com.data.sangam.contacts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.YahooApi;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.data.sangam.contacts.bean.*;
import org.json.*;
import com.data.sangam.contacts.util.ContactUtil;

@Controller
@RequestMapping("/contacts")
public class ContactsController implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private HashMap<String,OAuthInfo> oauthInfoMap=new HashMap<String,OAuthInfo>();
	
	public static String GOOGLE="google";
	
	public static String YAHOO="yahoo";
	
	public static String LINKEDIN="linkedin";
	
	public static String WINDOWSLIVE="hotmail";
	
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/import")
	public String getProviders(Model model) {
		 List<Provider> providers = new ArrayList<Provider>();
		 providers.add(createProvider(GOOGLE,getPropMap("googlePropMap"),GoogleApi.class,true));
		 providers.add(createProvider(YAHOO,getPropMap("yahooPropMap"),YahooApi.class,false));
		 providers.add(createProvider(LINKEDIN,getPropMap("linkedInPropMap"),LinkedInApi.class,false));
		 providers.add(createProvider(WINDOWSLIVE,getPropMap("linkedInPropMap"),LinkedInApi.class,false));
		 
		//Do it for other service providers too.!
	    model.addAttribute("providers",providers);
		return "providers";
	}
	
	public Provider createProvider(String providerName,HashMap<String,String> providerProperties,Class className,boolean scopeRequired){
		OAuthService service=getService(className,providerProperties,scopeRequired);
		Token requestToken = getService(className,providerProperties,scopeRequired).getRequestToken();
		Provider provider = new Provider(providerName,providerProperties.get(
		"auth.url")
		+ "="
		+ requestToken.getToken()
		);
		oauthInfoMap.put(providerName,new OAuthInfo(providerName,service,requestToken));
		return provider;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/callback-google")
	public String retrieveContactsGoogle(Model model,@RequestParam String oauth_verifier ,@RequestParam String oauth_token){
		List<Contact> contacts= retreiveContacts(GOOGLE,getPropMap("googlePropMap"),oauth_verifier);
		/*contacts.add(new Contact("Aniruddha Chaturvedi","chaturvedi11@gmail.com"));
		contacts.add(new Contact("Amritha Krishnamoorthy","akrishnamoorthy@gmail.com"));
		contacts.add(new Contact("Toney Thomas","tthomas@gmail.com"));
		contacts.add(new Contact("Anurag Kashyap","anukashyap1@gmail.com"));
		contacts.add(new Contact("Sherin Abraham","ann85@gmail.com"));
		contacts.add(new Contact("Sunil Joseph","sjoseph@gmail.com"));
		contacts.add(new Contact("Alok Kumar Mishra","mishraalok85@gmail.com"));
		contacts.add(new Contact("Jisha TV","jishatv2005@gmail.com"));
		contacts.add(new Contact("Pavithra K","pavithrak1313@gmail.com"));
		contacts.add(new Contact("Srikanth Gade ","gade_srikanth@gmail.com"));
		contacts.add(new Contact("Bipin Pandey","bipin_pc@gmail.com"));
		contacts.add(new Contact("Sree Vidhya","vidya_mani87@gmail.com"));
		contacts.add(new Contact("Utpal Lotlikar","utpal_lotlikar@gmail.com"));
		contacts.add(new Contact("Arvind Ramaswamy","arvind.ramasarma@gmail.com"));
		contacts.add(new Contact("Arvind Jayaprakash","jayaprakasharvind@gmail.com"));
		contacts.add(new Contact("Abhilash Bhandari","abhandari@gmail.com"));*/
		for(Contact name : contacts){
			if(name.getFullName()==null){
				name.setFullName("Name not available!");
			}
		}
		model.addAttribute("contacts" ,contacts);
		model.addAttribute("jsonContacts",populateJson(contacts)) ;
	    return  "contacts";
 	}
	
	private JSONArray populateJson(List<Contact> contacts) {
		try {
			JSONArray arr = new JSONArray();
			for (Contact contact : contacts) {
				JSONObject obj = new JSONObject();
				obj.put("name", contact.getFullName());
				obj.put("id", contact.getEmailId());
				arr.put(obj);
			}
			return arr;

		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/callback-linkedIn")
	public String retrieveContactsLinkedIn(Model model,@RequestParam String oauth_verifier ,@RequestParam String oauth_token){
		List<Contact> contacts= retreiveContacts(LINKEDIN,getPropMap("googlePropMap"),oauth_verifier);
		//dummy values as of now.
		contacts.add(new Contact("Amritha Krishnamoorthy","akrishnamoorthy@yahoo.co.in"));
		contacts.add(new Contact("Sumitro Chatterjee" ,"schatterjee@yahoo.co.in"));
		contacts.add(new Contact("Aniruddha Chaturvedi","chaturvedi11@yahoo.co.in"));
		contacts.add(new Contact("Amritha Krishnamoorthy","akrishnamoorthy@yahoo.co.in"));
		contacts.add(new Contact("Toney Thomas","tthomas@yahoo.co.in"));
		contacts.add(new Contact("Anurag Kashyap","anukashyap1@yahoo.co.in"));
		contacts.add(new Contact("Sherin Abraham","ann85@hotmail.com"));
		contacts.add(new Contact("Sunil Joseph","sjoseph@yahoo.co.in"));
		contacts.add(new Contact("Alok Kumar Mishra","mishraalok85@yahoo.co.in"));
		contacts.add(new Contact("Jisha TV","jishatv2005@yahoo.co.in"));
		contacts.add(new Contact("Pavithra K","pavithrak1313@gmail.com"));
		contacts.add(new Contact("Srikanth Gade ","gade_srikanth@yahoo.co.in"));
		contacts.add(new Contact("Bipin Pandey","bipin_pc@yahoo.co.in"));
		contacts.add(new Contact("Sree Vidhya","vidya_mani87@gmail.com"));
		contacts.add(new Contact("Utpal Lotlikar","utpal_lotlikar @yahoo.co.in"));
		contacts.add(new Contact("Arvind Ramaswamy","arvind.ramasarma@yahoo.co.in"));
		contacts.add(new Contact("Arvind Jayaprakash","jayaprakasharvind@hotmail.com"));
		contacts.add(new Contact("Abhilash Bhandari","abhandari@yahoo.co.in"));
		model.addAttribute("contacts" ,contacts);
		model.addAttribute("jsonContacts",populateJson(contacts)) ;
	    return  "contacts";
 	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/callback-yahoo")
	public String retrieveContactsYahoo(Model model,@RequestParam String oauth_verifier ,@RequestParam String oauth_token){
		//List<Contact> contacts= retreiveContacts(YAHOO,getPropMap("yahooPropMap"),oauth_verifier);
		List<Contact> contacts=new ArrayList<Contact>();
		//dummy values as of now.
		contacts.add(new Contact("Aniruddha Chaturvedi","chaturvedi11@yahoo.co.in"));
		contacts.add(new Contact("Amritha Krishnamoorthy","akrishnamoorthy@yahoo.co.in"));
		contacts.add(new Contact("Toney Thomas","tthomas@yahoo.co.in"));
		contacts.add(new Contact("Anurag Kashyap","anukashyap1@yahoo.co.in"));
		contacts.add(new Contact("Sherin Abraham","ann85@yahoo.co.in"));
		contacts.add(new Contact("Sunil Joseph","sjoseph@yahoo.co.in"));
		contacts.add(new Contact("Alok Kumar Mishra","mishraalok85@yahoo.co.in"));
		contacts.add(new Contact("Jisha TV","jishatv2005@yahoo.co.in"));
		contacts.add(new Contact("Pavithra K","pavithrak1313@yahoo.co.in"));
		contacts.add(new Contact("Srikanth Gade ","gade_srikanth@yahoo.co.in"));
		contacts.add(new Contact("Bipin Pandey","bipin_pc@yahoo.co.in"));
		contacts.add(new Contact("Sree Vidhya","vidya_mani87@yahoo.co.in"));
		contacts.add(new Contact("Utpal Lotlikar","utpal_lotlikar @yahoo.co.in"));
		contacts.add(new Contact("Arvind Ramaswamy","arvind.ramasarma@yahoo.co.in"));
		contacts.add(new Contact("Arvind Jayaprakash","jayaprakasharvind@yahoo.co.in"));
		contacts.add(new Contact("Abhilash Bhandari","abhandari@yahoo.co.in"));
		for(Contact name : contacts){
			if(name.getFullName()==null){
				name.setFullName("Name not available!");
			}
		}
		model.addAttribute("jsonContacts",populateJson(contacts).toString()) ;
		model.addAttribute("contacts" ,contacts);
	    return  "contacts";
 	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/share-job")
	public String shareJobs(Model model){
		return "shareJob";
	}
	
	public List<Contact> retreiveContacts(String serviceProviderName,HashMap<String,String>properties,String verifier){
		OAuthService  service=oauthInfoMap.get(serviceProviderName).getService();
		Token  requestToken=oauthInfoMap.get(serviceProviderName).getRequestToken();
		System.out.println("got into call back url! here is the verifier" +verifier);
		Token accessToken= service.getAccessToken(requestToken, new Verifier(verifier));
		OAuthRequest request=null;
		if(serviceProviderName.equals(YAHOO)){
			 request = new OAuthRequest(Verb.GET,retrieveYahooGUID(accessToken.getRawResponse(),properties));
		}else{
			 request = new OAuthRequest(Verb.GET,properties.get("contacts.resource.url"));
		}
		
		service.signRequest(accessToken, request);
		
		request.addHeader("GData-Version", "3.0");
		Response response = request.send();
		//To remove
		System.out.println(response.getCode());
		System.out.println(response.getBody());
	    return new ContactUtil().parseContactResourses(response.getBody(),serviceProviderName);
	}
	
	private String retrieveYahooGUID(String response,HashMap<String,String> properties){
		String guid=null;
		String[] results = response.split("&");
		for(String param: results){
			if (param.contains("xoauth_yahoo_guid")){
		         guid=param.substring(param.indexOf("=")+1);
			}
		}
		return properties.get("contacts.resource.url").replace("GUID", guid);
	}

	 //To do clean up.
	public OAuthService getService(Class className,HashMap<String,String> providerProperties,boolean scopeRequired) {
		if(scopeRequired){
			return  new ServiceBuilder()
		    .provider(className)
		    .apiKey(providerProperties.get("apikey"))
		    .apiSecret(providerProperties.get("apisecret"))
		    .scope(providerProperties.get("resource.scope"))
		    .callback(providerProperties.get("callBackUrl"))
		    .build();
		}else{
			return  new ServiceBuilder()
		    .provider(className)
		    .apiKey(providerProperties.get("apikey"))
		    .apiSecret(providerProperties.get("apisecret"))
		    .callback(providerProperties.get("callBackUrl"))
		    .build();
		}
		
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
	this.applicationContext=arg0;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String,String> getPropMap(String mapName){
		return (HashMap<String, String>)applicationContext.getBean(mapName);
	}
	
	
}
