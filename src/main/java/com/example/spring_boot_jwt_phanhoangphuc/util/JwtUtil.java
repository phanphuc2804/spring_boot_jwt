package com.example.spring_boot_jwt_phanhoangphuc.util;

import com.example.spring_boot_jwt_phanhoangphuc.authen.UserPrincipal;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;


@Component
public class JwtUtil {
    private static Logger logger= LoggerFactory.getLogger(JwtUtil.class);
    private static final String USER= "Phuc";
    private static final String SECRET= "what's up Phuc-sama the secret length must be at least 256 bits" + "please no reveal!";

    public String generateToken(UserPrincipal user) {
        String token = null;
        try {
            JWTClaimsSet.Builder builder= new JWTClaimsSet.Builder();
            builder.claim(USER, user);
            builder.expirationTime(generateExpirationDate());
            JWTClaimsSet claimsSet= builder.build();

            SignedJWT signedJWT= new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            JWSSigner signer= new MACSigner(SECRET.getBytes());
            signedJWT.sign(signer);

            token= signedJWT.serialize();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return token;
    }
    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + 864000000);
    }
}
