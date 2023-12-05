


package com.example.demo;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.tableRepository.tableRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component

public class Scheduler {

	private final tableRepository tableRespository ;
	public Scheduler(tableRepository tableRespository){
		this.tableRespository = tableRespository;
	  
	}
	@Scheduled(fixedRate = 600000) public void scheduleTask()
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm:ss.SSS");

		String strDate = dateFormat.format(new Date());
		String uri="https://api.coindesk.com/v1/bpi/currentprice.json";
		RestTemplate restTemplate=new RestTemplate();
		String result=restTemplate.getForObject(uri,String.class);
	    try {
          
	    	EntityClass entity=new EntityClass();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(result);


            JsonNode usdNode = jsonNode.path("bpi").path("USD").path("rate");
            JsonNode gbpNode = jsonNode.path("bpi").path("GBP").path("rate");
            JsonNode eurNode = jsonNode.path("bpi").path("EUR").path("rate");
            JsonNode time = jsonNode.path("time").path("updatedISO");
            
            
            String cleanedStringEur =  eurNode.asText().replace(",", "");
            String cleanedStringUsd =  usdNode.asText().replace(",", "");
            String cleanedStringGbp =  gbpNode.asText().replace(",", "");
            entity.setEur(Double.parseDouble(cleanedStringEur));
            entity.setGbp(Double.parseDouble(cleanedStringGbp));
            entity.setUsd(Double.parseDouble(cleanedStringUsd));
                
              
              
            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
            
          
             
                LocalDateTime today= LocalDateTime.parse(time.asText(), formatter);
         
            entity.setTimestamp(today);
            tableRespository.save(entity);

           
        } catch (Exception e) {
            e.printStackTrace();
        }

	
	}
}
