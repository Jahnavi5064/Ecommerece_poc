package com.demo.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
public JSONObject productsResponse(String status,String message, String accessToken)
{



JSONObject obj=new JSONObject();
obj.put("status",status);
obj.put("message",message);
obj.put("accessToken",accessToken);
return obj;
}

}

	