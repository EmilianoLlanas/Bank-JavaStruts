package com.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.model.Cuenta;
import com.model.Movimiento;
import com.opensymphony.xwork2.ActionSupport;

public class ConsultarMovimientosAction  extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private Cuenta cuenta;
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	private Movimiento movimiento;
	
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
		
		HashMap <Integer,Movimiento> listaMovimientos = (HashMap<Integer, Movimiento>) session.get("listaPorCuentaMovimientos");
		
		if(listaMovimientos==null)
		{
			listaMovimientos= new HashMap<Integer, Movimiento>();
			
			session.put("listaPorCuentaMovimientos", listaMovimientos);
		}
		
		movimiento= new Movimiento();
		int idMov=1;
		for(int i=1; i<=movimientoss.size();i++)
		{
			
			movimiento=movimientoss.get(i);
			
			if(cuenta.getNumCuenta()==(movimiento.getIdCuentaMovimiento()))
			{
			
				System.out.println("movimiento: "+i);
				System.out.println(movimiento.getIdCuentaMovimiento());
				System.out.println(movimiento.getMonto());
				System.out.println(movimiento.getTipo());
				listaMovimientos.put(idMov, movimiento);
				idMov++;
			}
			
		}
		
		super.addActionMessage("nos vamos a consultar movimientos pa");
		
		return "success";
	}


}
