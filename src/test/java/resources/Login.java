package resources;

import lombok.Builder;
import lombok.Getter;

import static lombok.Builder.Default;

@Builder(toBuilder = true)
@Getter
public class Login {
    @Default
    private String login="automation@keepitqa.com";
    @Default
    private String password="E#*b2wGIbFHz";

}
