package com.example.app.restapp.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.ws.rs.NameBinding;

/**
 * UserAuth
 *
 * @author shimiz
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAuth {}