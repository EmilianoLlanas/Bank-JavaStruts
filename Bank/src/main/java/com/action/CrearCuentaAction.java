package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import com.model.Cuenta;
import com.opensymphony.xwork2.ActionSupport;

public class CrearCuentaAction extends ActionSupport implements SessionAware{
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
		if(cuentas==null) {
			cuentas=new HashMap<Integer, Cuenta>();
			Cuenta cuentaOriginal = new Cuenta();
			cuentas.put(0,cuentaOriginal);
			session.put("listaCuentas", cuentas);
		}
		 
		if(!("scott".equals(cuenta.getUsuario()) && "navy".equals(cuenta.getPassword()))) {
			super.addActionMessage("Datos invalidos");
			return "input";
		}
		if(!(cuenta.getPassword().equals(cuenta.getRePassword()))) {
			super.addActionMessage("Las contraseñas no coinciden");
			return "input";
		}
		
		if(cuenta.getNumCuenta()==0) {
			
			int newIdCuenta=cuentas.size();
			
			while(cuentas.containsKey(newIdCuenta)) {
				newIdCuenta++;
			}
			cuenta.setNumCuenta(newIdCuenta);
		}
		cuentas.put(cuenta.getNumCuenta(), cuenta);
		super.addActionMessage("Alta de cuenta exitosa, No. de cuenta: "+cuenta.getNumCuenta());
		return "success";
		
			
		}


	

}
