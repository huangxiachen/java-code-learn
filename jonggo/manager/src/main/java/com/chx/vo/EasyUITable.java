package com.chx.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class EasyUITable {

    private Integer total;
    private List<?> rows;

    public EasyUITable() {
    }

    public EasyUITable(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
