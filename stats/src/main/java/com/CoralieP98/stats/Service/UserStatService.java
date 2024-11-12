package com.CoralieP98.stats.Service;

import com.CoralieP98.stats.Repository.UserStatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserStatService {

    private final UserStatRepository userStatRepository;

    public UserStatService(UserStatRepository userStatRepository) {
        this.userStatRepository = userStatRepository;
    }

    public String convertListMapToJson(List<Map<String, Object>> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String statWithData(int id, int sessionId){
        List<Map<String, Object>> data = userStatRepository.callSPGraphTechnic(id, sessionId);
        return convertListMapToJson(data);
    }
}
