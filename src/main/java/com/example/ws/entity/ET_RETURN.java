package com.example.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ET_RETURN implements Serializable {
    private String MSGID;
    private String MSGTY;
    private Integer MSGNO;
    private String MSGV1;
    private String MSGV2;
    private String MSGV3;
    private String MSGV4;
    private String LINENO;
}
