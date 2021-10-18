package vvat.credorax.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import vvat.credorax.data.Error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public final boolean approved;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public final Map<String, String> errors;

    public Result(List<Error> errors) {
        if (errors == null || errors.size() == 0) {
            approved = true;
            this.errors = null;
        } else {
            approved = false;
            this.errors = new HashMap<>();
            errors.forEach(error -> this.errors.put(error.getKey(), error.getDescription()));
        }
    }
}
