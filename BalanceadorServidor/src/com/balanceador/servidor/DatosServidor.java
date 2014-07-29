/**
 * DatosServidor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.balanceador.servidor;

import java.math.BigDecimal;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class DatosServidor  implements java.io.Serializable {
    private BigDecimal memoriaOciosa;
    private BigDecimal memoriaTotal;
    private BigDecimal procesamientoOcioso;
	Sigar sigar = new Sigar();
    
	public BigDecimal getMemoriaOciosa() throws SigarException {
		Mem mem = sigar.getMem();
		return new BigDecimal(mem.getFree()/1024/1024);
	}

	public BigDecimal getMemoriaTotal() throws SigarException {
		Mem mem = sigar.getMem();
		return new BigDecimal(mem.getTotal()/1024/1024);
	}

	public BigDecimal getProcesamientoOcioso() throws SigarException {
		Sigar sigar = new Sigar();
		CpuPerc cpu = sigar.getCpuPerc();
		procesamientoOcioso =  BigDecimal.valueOf(cpu.getIdle()*100);	
		procesamientoOcioso=round(procesamientoOcioso, 2, true);
		return procesamientoOcioso;
	}

    public BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
        int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
        return d.setScale(scale, mode);
      }

    
    
}
