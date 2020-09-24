package com.orznewbie.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private static final String SECRET_CODE = "whatisthehell?";

    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 生成token
     * @param id
     * @param role
     * @return
     */
    public static String generateToken(String id, Integer role) {
        try {
            Date expdate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET_CODE);
            // 头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            return JWT.create()
                    .withHeader(header)
                    .withClaim("id", id)
                    .withClaim("role", role)
                    .withExpiresAt(expdate)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_CODE);
            JWTVerifier verifier = JWT.require(algorithm).build();
            // 未验证通过会抛出异常
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token中获取key字段信息
     * @param
     * @return
     */
    public static String getClaim(String token, String key){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e){
            e.printStackTrace();
        }
        return null;
    }
}