package com.example.app.restapp.filter;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * AuthRequestFilter
 *
 * @author shimiz
 */
@UserAuth
@Provider
public class UserAuthRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        List<String> userTokens = requestContext.getHeaders().get("X-RestApp-User-Token");
        if (userTokens == null) {
            throw new WebApplicationException("AuthError", Response.Status.UNAUTHORIZED);
        }

        // TODO 本来はユーザ情報を検索して、トークンが正しいかチェックする
        if(!userTokens.get(0).equals("abc")){
            throw new WebApplicationException("AuthError", Response.Status.UNAUTHORIZED);
        }

    }

}