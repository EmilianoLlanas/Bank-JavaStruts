package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cuenta;
import com.model.Movimiento;
import com.opensymphony.xwork2.ActionSupport;

public class TransferenciaAction extends ActionSupport implements SessionAware
{
	private int nocuentaOrigen;
	private int monto;
	private int nocuentaDestino;
	private String usuario;
	private String password;
	private Movimiento movimientoOrigen,movimientoDestino;
	
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
		HashMap <Integer,Movimiento> movimientoss = (HashMap<Integer, Movimiento>) session.get("listaMovimientos");
		
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
		
		int idMovi=movimientoss.size();
		if(idMovi==0)
		{
			idMovi=1;
		}
		else
		{
			while(movimientoss.containsKey(idMovi)) {
				idMovi++;
			}
		}
		
		movimientoOrigen= new Movimiento();
		movimientoDestino= new Movimiento();
		if(cuentaOrigen.getMontoInicial()>=monto) 
		{
			cuentaOrigen.setMontoInicial(cuentaOrigen.getMontoInicial()-monto);
			cuentaDestino.setMontoInicial(cuentaDestino.getMontoInicial()+monto);
			
			//origen
			movimientoOrigen.setIdCuentaMovimiento(cuentaOrigen.getNumCuenta());
			movimientoOrigen.setMonto(monto*-1);
			movimientoOrigen.setTipo("Transferencia");
			movimientoss.put(idMovi, movimientoOrigen);
			//destino
			movimientoDestino.setIdCuentaMovimiento(cuentaDestino.getNumCuenta());
			movimientoDestino.setMonto(monto);
			movimientoDestino.setTipo("Transferencia");
			movimientoss.put(idMovi+1, movimientoDestino);
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