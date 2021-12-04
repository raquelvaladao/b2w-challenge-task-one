package com.b2w.challenge.task1.controller.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseController<T> {

        protected ResponseEntity<T> answerCreatedItem() {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        protected ResponseEntity<T> answerCreatedItemWithURI(T object, UriComponentsBuilder uriBuilder, String path,
                                                             String code) {
            URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
            return ResponseEntity.created(uri).body(object);
        }

        protected ResponseEntity<T> answerNotFoundItem() {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        protected ResponseEntity<T> answerSuccess() {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        protected ResponseEntity<T> answerSuccessWithItem(T object) {
            return ResponseEntity.status(HttpStatus.OK).body(object);
        }

        protected ResponseEntity<List<T>> answerEmptyList() {
            List<T> emptyList = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.OK).body(emptyList);
        }

        protected ResponseEntity<List<T>> answerListOfItems(List<T> items) {
            return ResponseEntity.status(HttpStatus.OK).body(items);
        }

        protected ResponseEntity<T> answerBadRequestCall() {
            return ResponseEntity.badRequest().build();
        }

    protected ResponseEntity<T> answerUnauthorizedCall() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

        protected ResponseEntity<Page<T>> answerPaginatedListOfItems(Page<T> items) {
            return ResponseEntity.status(HttpStatus.OK).body(items);
        }

    }

