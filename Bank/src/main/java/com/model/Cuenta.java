package com.model;

public class Cuenta {
	private String usuario;
	private String password;
	private String rePassword;
	private int montoInicial;
	private String telefono;
	private int numCuenta;
	private int montoInit;
	
	public int getMontoInit() {
		return montoInit;
	}

	public void setMontoInit(int montoInit) {
		this.montoInit = montoInit;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}



	public int getMontoInicial() {
		return montoInicial;
	}

	public void setMontoInicial(int montoInicial) {

		this.montoInicial = montoInicial;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
}
