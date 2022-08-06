package classes.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.HeaderParam;

@RegisterForReflection
public class AccountInfo {
    public String accountId;
}
