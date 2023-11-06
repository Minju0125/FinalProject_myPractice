package com.springboard.board.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "grCode")
public class GradeVO implements Serializable{
   @NotBlank
   private String grCode;
   @NotBlank
   private String grName;
   
   //has many 관계(1:N)
   private List<AlbaVO> albaList;
}