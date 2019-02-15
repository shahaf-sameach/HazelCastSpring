package com.example.hazelcastcach;

import lombok.Data;

@Data
public class DbEntry {

    private String key;
    private String value;
}
