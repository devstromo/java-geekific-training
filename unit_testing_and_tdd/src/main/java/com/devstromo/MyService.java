package com.devstromo;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyService {
    private final MyRepository repository;
    private final OtherService otherService;

    public String getAsJsonString(UUID id) throws InvalidMyObjectException {
        MyObject object = repository.getById(id);
        return otherService.myObjectToJson(object);
    }
}
