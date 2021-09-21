package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cuenta;
import com.opensymphony.xwork2.ActionSupport;

public class DepositoAction  extends ActionSupport implements SessionAware {
	
	private int noCuenta;
	private int monto;
	private String usuario;
	private String password;
	private boolean sum;
	
	public int getNoCuenta() {
		return noCuenta;
	}


	public void setNoCuenta(int noCuenta) {
		this.noCuenta = noCuenta;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
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

	
	public boolean isSum() {
		return sum;
	}


	public void setSum(boolean sum) {
		this.sum = sum;
	}

	private Map<String, Object> session;
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	
	public String init() {
		
		return "success";
	}

	public String execute() {
		HashMap <Integer,Cuenta> cuentas = (HashMap<Integer, Cuenta>) session.get("listaCuentas");
		
		
		if(!("scott".equals(usuario) && "navy".equals(password))) {
			super.addActionMessage("Datos invalidos");
			return "input";
		}
		
		if(!cuentas.containsKey(noCuenta)) {
			super.addActionMessage("No existe una cuenta con ese numero");
			return "input";
		}
		Cuenta cuenta= cuentas.get(noCuenta);
		
		if(sum==true) {
			cuenta.setMontoInicial(cuenta.getMontoInicial()+monto);
			System.out.println(cuenta.getMontoInicial());
			cuentas.put(noCuenta, cuenta);
			super.addActionMessage("Deposito exitoso");
		}
		else {
			if(cuenta.getMontoInicial()>=monto) {
				cuenta.setMontoInicial(cuenta.getMontoInicial()-monto);
				System.out.println(cuenta.getMontoInicial());
				cuentas.put(noCuenta, cuenta);
				super.addActionMessage("Retiro exitoso");
			}else {
				super.addActionMessage("Fondos insuficientes para este retiro");
				return "input";
			}
			
		}
		
		
		return "success";
	}
	
}
