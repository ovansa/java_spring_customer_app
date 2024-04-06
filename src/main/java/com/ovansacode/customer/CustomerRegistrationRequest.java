package com.ovansacode.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age) {
}
