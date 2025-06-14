package kr.or.ddit.case07.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculateVO {
	@Min(0)
	private int op1;
	@Min(0)
	private int op2;
	private int result;
}
