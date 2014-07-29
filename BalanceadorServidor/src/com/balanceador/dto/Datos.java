package com.balanceador.dto;

import java.math.BigDecimal;

public class Datos {
    private BigDecimal memoriaOciosa;
    private BigDecimal procesamientoOcioso;
    
	public BigDecimal getMemoriaOciosa() {
		return memoriaOciosa;
	}
	public void setMemoriaOciosa(BigDecimal memoriaOciosa) {
		this.memoriaOciosa = memoriaOciosa;
	}
	public BigDecimal getProcesamientoOcioso() {
		return procesamientoOcioso;
	}
	public void setProcesamientoOcioso(BigDecimal procesamientoOcioso) {
		this.procesamientoOcioso = procesamientoOcioso;
	}
    
    
}
