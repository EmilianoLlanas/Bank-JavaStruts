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
	private HashMap <Integer,Movimiento> movList;
	
	
	
	
	public HashMap<Integer, Movimiento> getMovList() {
		return movList;
	}

	public void setMovList(HashMap<Integer, Movimiento> movList) {
		this.movList = movList;
	}

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
	
		
		movList = (HashMap<Integer, Movimiento>) session.get("listaPorCuentaMovimientos");
		
		if(movList==null)
		{
			movList= new HashMap<Integer, Movimiento>();
			
			session.put("listaPorCuentaMovimientos", movList);
		}
		
		
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
		
		
		movList.clear();
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
				movList.put(idMov, movimiento);
				idMov++;
			}
			
		}
		
		if(movList.size()==0)
		{
			System.out.println("la lista de movimientos esta vacia");
		}
		else
		{
			System.out.println("hay "+movList.size()+" "+"movimientos");
		}
		
		super.addActionMessage("nos vamos a consultar movimientos pa");
		session.put("listaPorCuentaMovimientos", movList);
		return "success";
	}


}
