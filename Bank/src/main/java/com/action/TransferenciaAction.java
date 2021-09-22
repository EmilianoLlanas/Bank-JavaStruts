package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cuenta;
import com.opensymphony.xwork2.ActionSupport;

public class TransferenciaAction extends ActionSupport implements SessionAware
{
	private int nocuentaOrigen;
	private int monto;
	private int nocuentaDestino;
	private String usuario;
	private String password;
	
	
	public int getNocuentaOrigen() {
		return nocuentaOrigen;
	}

	public void setNocuentaOrigen(int nocuentaOrigen) {
		this.nocuentaOrigen = nocuentaOrigen;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getNocuentaDestino() {
		return nocuentaDestino;
	}

	public void setNocuentaDestino(int nocuentaDestino) {
		this.nocuentaDestino = nocuentaDestino;
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

	public String init() 
	{
		return "success";
	}

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public String execute()
	{
		HashMap <Integer,Cuenta> cuentas = (HashMap<Integer, Cuenta>) session.get("listaCuentas");
		
		
		if(!("scott".equals(usuario) && "navy".equals(password))) 
		{
			super.addActionMessage("Datos invalidos");
			return "input";
		}
		
		if(!cuentas.containsKey(nocuentaOrigen)) 
		{
			super.addActionMessage("La cuenta Origen no existe");
			return "input";
		}
		
		if(!cuentas.containsKey(nocuentaDestino)) 
		{
			super.addActionMessage("La cuenta Destino no existe");
			return "input";
		}
		
		Cuenta cuentaOrigen= cuentas.get(nocuentaOrigen);
		Cuenta cuentaDestino= cuentas.get(nocuentaDestino);
		
		if(cuentaOrigen.getMontoInicial()>=monto) 
		{
			cuentaOrigen.setMontoInicial(cuentaOrigen.getMontoInicial()-monto);
			cuentaDestino.setMontoInicial(cuentaDestino.getMontoInicial()+monto);
			System.out.println(cuentaOrigen.getMontoInicial());
			System.out.println(cuentaDestino.getMontoInicial());
			cuentas.put(nocuentaOrigen, cuentaOrigen);
			cuentas.put(nocuentaDestino, cuentaDestino);
			super.addActionMessage("Transferencia exitosa");
		}
		else
		{
			super.addActionMessage("Fondos insuficientes para este movimiento");
			return "input";
		}
		
		return "success";
	}
}