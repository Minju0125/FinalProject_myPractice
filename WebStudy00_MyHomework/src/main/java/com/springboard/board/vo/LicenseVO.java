package com.springboard.board.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "licCode")
public class LicenseVO implements Serializable {
   @NotBlank
   private String licCode;
   @NotBlank
   private String licName;
   
   //has many 관계(1:N)
   private List<LicAlbaVO> licAlbaList;
}