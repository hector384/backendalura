package com.project.alura.infra.security;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String GenerarToken(){
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;
    }
}
