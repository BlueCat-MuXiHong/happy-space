package com.bookServer.facade.userModule.entity;

import lombok.Data;
 
@Data
public class RoleTransferItemVO {
    private Long key;
    private String label;
    private boolean disabled;
}