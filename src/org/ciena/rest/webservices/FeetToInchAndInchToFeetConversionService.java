package org.ciena.rest.webservices;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
 
@Path("ConversionService")
public class FeetToInchAndInchToFeetConversionService {
	
	 Object obj[] = 
 { "Test123", "identifier", "Type", "State", "100",
			"200", "cosPolicy", "CCMInterval", "L2CFT", "VLLI" };
	//List<Object[]> lst = new  ArrayList<Object[]>(){{add(sqlResult);}};
  		  
	
     @GET
     @Path("/InchToFeet/{i}")
      @Produces(MediaType.TEXT_XML)
      public String convertInchToFeet(@PathParam("i") int i) {
 
        int inch=i;
        double feet = 0;
        feet =(double) inch/12;
      
        return "<InchToFeetService>"
        + "<Inch>" + inch + "</Inch>"
          + "<Feet>" + feet + "</Feet>"
         + "</InchToFeetService>";
      }
 
      @Path("/FeetToInch/{f}")
      @GET
      @Produces(MediaType.TEXT_XML)
      public String convertFeetToInch(@PathParam("f") int f) {
       int inch=0;
          int feet = f;
          inch = 12*feet;
   
          return "<FeetToInchService>"
            + "<Feet>" + feet + "</Feet>"
            + "<Inch>" + inch + "</Inch>"
            + "</FeetToInchService>";
      }
      
      @Path("/hello")
      @GET
      @Produces(MediaType.TEXT_PLAIN)
      public String sayHello() {
    	  System.out.println(System.getProperty("java.version"));
    	  return "Hello, Welcome to Cienaa Corporation. This is a Jersey Test";
      }
      
      @Path("/helloJsonMapList")
      @GET
      @Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloJSonMapList() {
  	  Map<String,List<String>> map = new HashMap<String,List<String>>();
  	  map.put("serviceType",new ArrayList<String>(){{add("Type");}});
  	  map.put("custIdentifier",new ArrayList<String>(){{add("Type");}});
  	  map.put("EVCPrority",new ArrayList<String>(){
  		  {
  			  add("0");
  			  add("1");
  			  add("2");
  			  add("3");
  		  }
  		  });
  	  
		GenericEntity< Map<String,List<String>>> entity = new GenericEntity< Map<String,List<String>>>(
				map) {
		};
		Response response = Response.ok(entity).build();
		System.out.println(System.getProperty("java.version"));
		return response;
	}
      
      @Path("/helloJsonList")
      @GET
      @Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloJSonList() {		
		List<String> lst = new ArrayList<String>();

		lst.add("Json");
		lst.add("test");
		GenericEntity<List<String>> entity = new GenericEntity<List<String>>(
				lst) {
		};
		Response response = Response.ok(entity).build();
		System.out.println(System.getProperty("java.version"));
		return response;
	}
      @Path("/helloJsonMap")
      @GET
      @Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloJSonMap() {		
    	  Map<String,String> map = new HashMap<String,String>();
    	  map.put("CACLabel","Type");
    	  map.put("serviceType","Type");
    	  map.put("serviceType","Type");
    	  map.put("serviceType","Type");
    	  map.put("serviceType","Type");
    	  map.put("serviceType","Type");
		GenericEntity<Map<String,String>> entity = new GenericEntity<Map<String,String> >(
				map) {
		};
		Response response = Response.ok(entity).build();
		System.out.println(System.getProperty("java.version"));
		return response;
	}
      
      
      @Path("/helloJsonObject")
      @GET
      @Produces(MediaType.TEXT_PLAIN)
	public String sayHelloJSonObject() {	
    		JSONObject obj = new JSONObject();
    	//	String serviceType= (String)obj.get("serviceType");
    	  try {    	  
    		obj.put("serviceType", "Type");
    		obj.put("custIdentifier","identifier");
    		obj.put("MAXCIR", "500");
    		JSONArray list = new JSONArray();
    		list.put("0");
    		list.put("1");
    		list.put("2");
    		list.put("3");
    	 
    		obj.put("EvcPriority", list);
    	  } catch (JSONException e){
    		  
    	  }
    		return obj.toString();
	}
      
      @Path("/helloJsonObjectEvc")
      @GET
      @Produces(MediaType.TEXT_PLAIN)
	public String sayHelloJSonObjectEVC() {	
    	  long startTime = System.nanoTime();
    		JSONObject obj = new JSONObject();
    		
    	  try {    	  
      		obj.put("Ref",this.obj[0] ); 
    		obj.put("CustomerIdentifier",this.obj[1] );
    		obj.put("Type", this.obj[2] );
    		obj.put("State", this.obj[3] );
    		obj.put("CIR", this.obj[4] );
    		obj.put("EIR",this.obj[5] );
    		obj.put("CosPolicy",this.obj[6] );
    		obj.put("CCM Interval", this.obj[7]);
    		obj.put("L2 CFT", this.obj[8] );
    		obj.put("Vlli", this.obj[9] );
    		JSONArray list = new JSONArray();
    		list.put("0");
    		list.put("1");
    		list.put("2");
    		list.put("3");
    	 
    		obj.put("EvcPriority", list);
    	  } catch (JSONException e){
    		  
    	  }
    	  long endTime = System.nanoTime();
    	  long elapsedTime = endTime- startTime;
    	  return obj.toString() + "    Time Elapsed(nanoseconds) " + elapsedTime;
	}
      
      @Path("/helloJsonStrFormat")
      @GET
      @Produces(MediaType.TEXT_PLAIN)
      
      public String sayHelloJSonStrFormat() {
    	  long startTime = System.nanoTime();
    	  String sb=   	  
    	  
    	 // for(Object obj[]: lst){
    		  (String
    					.format("{\"Ref\":\"%s\",\"CustomerIdentifier\":\"%s\",\"Type\":\"%s\",\"State\":\"%s\",\"CIR\":\"%s\",\"EIR\":\"%s\",\"CosPolicy\":\"%s\",\"CCM Interval\":\"%s\",\"L2 CFT\":\"%s\",\"Vlli\":\"%s\"}",
    							obj[0], obj[1], obj[2], obj[3], obj[4], obj[5], obj[6],
    							obj[7], obj[8], obj[9]));
    	   //  }
    	  long endTime = System.nanoTime();
    	  long elapsedTime = endTime- startTime;
    	  
    	  return sb + "    Time Elapsed(nanoseconds) " + elapsedTime;
    	  }
      
  	@POST
  	@Path("/helloPost/{evcname}")
  	 @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
  	public String getHelloFormPost(@PathParam("evcname") String evcname, @QueryParam("evctype") String str,JSONObject nm) {
  		String userName = null;
  		JSONArray array = null;
  		try {
			 array =nm.getJSONArray("testarray");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		long id = 0;
		try {
			userName = (String)nm.getString("username");
			id = (long)nm.getLong("id");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  		return "Username sent: " + userName +" , ID: " + id + " Array" + array;
  	}
		
}
