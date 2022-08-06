package classes.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Request extends AccountInfo {
    public String field;
}
