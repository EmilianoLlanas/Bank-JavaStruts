package com.model;

public class Movimiento {
	int idCuentaMovimiento;
	String tipo;
	int monto;
	
	public int getIdCuentaMovimiento() {
		return idCuentaMovimiento;
	}
	public void setIdCuentaMovimiento(int idCuentaMovimiento) {
		this.idCuentaMovimiento = idCuentaMovimiento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}

}
