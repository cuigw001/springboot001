package com.example.ws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IT_DATA implements Serializable {
    private String MATNR;
    private String WERKS;
    private String QUOTA_GROUP;
    private String LIFNR;
    private String EKGRP;
    private String QUOTA;
    private Integer CACU_TYPE;
    private String DATUA;
    private String DATUB;
    private String BLOCK_INDICATION_VD;
}
