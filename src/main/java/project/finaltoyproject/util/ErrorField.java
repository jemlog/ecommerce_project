package project.finaltoyproject.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorField {

    private String code;
    private String message;
}
