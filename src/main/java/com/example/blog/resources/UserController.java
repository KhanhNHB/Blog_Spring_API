package com.example.blog.resources;

import com.example.blog.commons.auth.UserAuthJwt;
import com.example.blog.domain.User;
import com.example.blog.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> userMap) {
        String id = (String) userMap.get("id");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(id, password);

        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        Map<String, String> map = new HashMap<>();

        map.put("message", "Registed successfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String jws = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, UserAuthJwt.CLIENT_SECRET_SIGNATURE)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + UserAuthJwt.expirationTime))
                .claim("id", user.getId())
                .compact();

        Map<String, String> map = new HashMap<String, String>();
        map.put("token", jws);

        return map;
    }
}