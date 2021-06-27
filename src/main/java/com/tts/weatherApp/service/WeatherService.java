package com.tts.weatherApp.service;

import com.tts.weatherApp.model.Response;
import com.tts.weatherApp.model.ZipCode;
import com.tts.weatherApp.repository.ZipCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;

// injects dependencies
@Autowired
public ZipCodeRepo zipCodeRepo;

private static List<ZipCode> zipCodes;

    public Response getForecast(String zipCode){
        String url = "http://api.openweathermap.org/data/2.5/weather?zip="+
                zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        ZipCode newZip = new ZipCode(zipCode);
        addZip(newZip);

        return restTemplate.getForObject(url, Response.class);
    }

    private void addZip(ZipCode zipCode) {
        zipCodeRepo.save(zipCode);
    }

    private List<ZipCode> getRecentZips(){
        zipCodes = zipCodeRepo.selectTenRecent();
        return zipCodes;
    }

}
