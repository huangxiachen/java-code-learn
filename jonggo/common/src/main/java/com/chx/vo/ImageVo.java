package com.chx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageVo {

    private Integer error;
    private String url;
    private Integer width;
    private Integer height;


}
