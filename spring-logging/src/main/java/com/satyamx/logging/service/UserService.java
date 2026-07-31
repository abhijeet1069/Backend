package com.satyamx.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String getUser(int id){
        logger.debug("Searching for user {}",id);
        if(id <= 0){
            logger.warn("Invalid user id {}",id);
            return "Invalid User";
        }
        try{
            //simulate DB call
            logger.info("User {} found",id);
            return "John Doe";
        }
        catch(Exception e){
            logger.error("Unable to fetch user {}",id,e);
            return "Error";
        }
    }
}
