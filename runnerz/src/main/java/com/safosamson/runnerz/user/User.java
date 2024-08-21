package com.safosamson.runnerz.user;

public record User(
        Integer id,
        String name,
        String username,
        String email,
        String phone,
        String website,
        Address address,
        Company company) {
}
