package com.example.hazelcastcach;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class DbEntry {

    private String key;
    private String value;

    public boolean isInvalid() {
        return StringUtils.isEmpty(key) || StringUtils.isEmpty(value);
    }
}
