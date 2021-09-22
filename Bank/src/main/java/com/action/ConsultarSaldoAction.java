package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cuenta;
import com.opensymphony.xwork2.ActionSupport;

public class ConsultarSaldoAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private Cuenta cuenta;
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

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
		//HashMap <Integer,Movimiento> movimientos = (HashMap<Integer, Cuenta>) session.get("listaCuentas");
			if(!(cuentas.containsKey(cuenta.getNumCuenta())))
			{
				super.addActionMessage("El numero de cuenta: "+cuenta.getNumCuenta()+" "+"no existe");
				return "data";
			}
			
			if(!("navy".equals(cuenta.getPassword())))
			{
				super.addActionMessage("password incorrecto");
				return "data";
			}
			
			if(!("scott".equals(cuenta.getUsuario())))
			{
				super.addActionMessage("El usuario "+cuenta.getUsuario()+" "+ "no existe");
				return "data";
			}
		cuenta= cuentas.get(cuenta.getNumCuenta());
		
		
		session.put("prueba", cuenta);
		super.addActionMessage("Saldo de la cuenta con id: "+cuenta.getNumCuenta());
		return "success";
	}

	
}
