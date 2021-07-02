package vn.co.vis.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.co.vis.web.exception.ResourceNotFoundException;

import java.util.Optional;

/**
 * Common attribute or method for controller
 * @author Giang Thanh Quang
 * @since 10/15/2020
 */
public abstract class AbstractController<S> {
    @Autowired
    protected S service;

    /**
     * @param response Optional of response object
     * @param <T>      Class type
     * @return ResponseEntity
     */
    protected <T> ResponseEntity<T> response(Optional<T> response) {
        return new ResponseEntity<T>(response.orElseThrow(() -> {
            throw new ResourceNotFoundException();
        }), HttpStatus.OK);
    }
}
