package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cita;
import com.model.Cuenta;
import com.model.Movimiento;
import com.opensymphony.xwork2.ActionSupport;

public class DepositoAction  extends ActionSupport implements SessionAware {
	
	private int noCuenta;
	private int monto;
	private String usuario;
	private String password;
	private boolean sum;
	private Movimiento movimiento;
	

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
		
		HashMap <Integer,Movimiento> movimientoss = (HashMap<Integer, Movimiento>) session.get("listaMovimientos");
		
		if(movimientoss==null)
		{
			movimientoss= new HashMap<Integer, Movimiento>();
			
			session.put("listaMovimientos", movimientoss);
		}
		
		
		if(!("scott".equals(usuario) && "navy".equals(password))) {
			super.addActionMessage("Datos invalidos");
			return "input";
		}
		
		if(!cuentas.containsKey(noCuenta)) {
			super.addActionMessage("No existe una cuenta con ese numero");
			return "input";
		}
		Cuenta cuenta= cuentas.get(noCuenta);
		
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
		
		
	
		movimiento= new Movimiento();
		if(sum==true) {
			cuenta.setMontoInicial(cuenta.getMontoInicial()+monto);
			
			cuentas.put(noCuenta, cuenta);
			movimiento.setIdCuentaMovimiento(noCuenta);
			movimiento.setMonto(monto);
			movimiento.setTipo("Deposito");
			
			
			
			movimientoss.put(idMovi, movimiento);
			super.addActionMessage("Deposito exitoso");
		}
		else {
			if(cuenta.getMontoInicial()>=monto) {
				cuenta.setMontoInicial(cuenta.getMontoInicial()-monto);
				
				
				movimiento.setIdCuentaMovimiento(noCuenta);
				movimiento.setMonto(monto*-1);
				movimiento.setTipo("Retiro");
				
				
				movimientoss.put(idMovi, movimiento);
				
				cuentas.put(noCuenta, cuenta);
				super.addActionMessage("Retiro exitoso");
			}else {
				super.addActionMessage("Fondos insuficientes para este retiro");
				return "input";
			}
			
		}
		
		session.put("listaMovimientos", movimientoss);
		return "success";
	}



	
}
