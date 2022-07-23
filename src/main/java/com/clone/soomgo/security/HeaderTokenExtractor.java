package com.clone.soomgo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

//@Slf4j
//@Component
//public class HeaderTokenExtractor {
//
//    public final String HEADER_PREFIX = "Bearer";
//
//    public String extract(String header, HttpServletRequest request){
//        if(header == null || header.equals("") || header.length()<HEADER_PREFIX.length()){
//            log.info("error request {} ",request.getRequestURI());
//              throw new NoSuchElementException("올바른 JWT 정보가 아닙니다.");
//
//        }
//    }
//}
