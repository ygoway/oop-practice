package com.ygoway.oppPractice.service.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Object data) {
        StringBuilder message = new StringBuilder();
        message.append(data.toString()).append(" not found");
        System.out.println(message);
    }
}
