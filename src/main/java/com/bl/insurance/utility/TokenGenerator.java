package com.bl.insurance.utility;


import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import com.bl.insurance.dto.DecodedToken;

@Component
public class TokenGenerator {
	public final String SECRET_TOKEN = "masterx1998";

    public String createToken(Long id, String role) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_TOKEN);
            String token = JWT.create().withClaim("userId", id).withClaim("roleId", role).sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DecodedToken decodeToken(String token) {

        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(SECRET_TOKEN));
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        }
        JWTVerifier jwtverifier = verification.build();
        // to decode token
        DecodedJWT decodedjwt = jwtverifier.verify(token);
        
        return new DecodedToken(decodedjwt.getClaim("userId").asLong(), decodedjwt.getClaim("roleId").asString());
    }

}
