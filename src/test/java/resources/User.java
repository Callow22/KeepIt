package resources;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class User {
    private Boolean enabled;
    private ZonedDateTime created;
    private String product;
    private String parent;
    private Boolean subscribed;
}
