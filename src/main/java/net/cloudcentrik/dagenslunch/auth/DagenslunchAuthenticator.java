package net.cloudcentrik.dagenslunch.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface DagenslunchAuthenticator {

}

//https://automationrhapsody.com/implement-secure-api-authentication-http-dropwizard/

//client send credientials in quesry OR header param AS 'apiKey' AND 'token'
//Token consists of: API key + Secret key + Current time in seconds, 
//which then gets hashed with SHA-256 algorithm preferably
/*
 * API authentication mechanism

Suggested authentication mechanism consists of following steps:

    Secret key that is known only by API consumer and API provider is needed along with API key.
    Secret key is used to one way hash a token which is send to server along with API key in the API call.
    Token consists of: API key + Secret key + Current time in seconds, which then gets hashed with SHA-256 algorithm preferably.
    Server recreates all the tokens locally for every second for some time in the future, preferably not too long – 30~120 seconds.
    Server recreates all the tokens for 30~120 seconds in the past, to take into account the time needed for request to reach the server.
    Server compares each of the tokens with received one.
    If there is match consumer is authenticated and response is returned.

 */
