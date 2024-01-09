package ejercicio02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class ejercicio02 {
	public static class Cuenta {
        private String id;
        private String contrasena;
        private double saldo;

        public Cuenta(String id, String contrasena, double saldoInicial) {
            this.id = id;
            this.contrasena = contrasena;
            this.saldo = saldoInicial;
        }

        public boolean verificarContrasena(String contrasena) {
            return this.contrasena.equals(contrasena);
        }

        public void depositar(double cantidad) {
            saldo += cantidad;
        }

        public boolean retirar(double cantidad) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
                return true;
            } else {
                return false;
            }
        }

        public double getSaldo() {
            return saldo;
        }
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Con el Map y Hash map se hace un mapa con el que se guardan valores a ellos asociados
        Map<String, Cuenta> cuentas = new HashMap<>();
        cuentas.put("usuario1", new Cuenta("usuario1", "clave123", 1000));
        cuentas.put("usuario2", new Cuenta("usuario2", "messi10", 500));
        String usuarioinicial = null;
        double cantidad = 0;
        boolean continuar=true;
        while(continuar) {
        	if(usuarioinicial==null) {
        		System.out.println("Por favor seleccione una opcion 1-Crear Cuenta 2-Inicio Sesion 3-Salir");
        		int opcion= scanner.nextInt();
        		switch(opcion) {
        			case 1:
        				System.out.println("Ingrese un nuevo ID de cuenta: ");
        				scanner.nextLine();
        				String nuevoId = scanner.nextLine();

        				if (cuentas.containsKey(nuevoId)) {
        				    System.out.println("El ID de cuenta ya está en uso. Operación cancelada.");
        				    return;
        				} else {
        				    System.out.println("Ingrese una nueva contraseña: ");
        				    String nuevaContrasena = scanner.nextLine();

                                
                                double saldoInicial = 0;
                                

                                cuentas.put(nuevoId, new Cuenta(nuevoId, nuevaContrasena, saldoInicial));
                                System.out.println("Cuenta creada con éxito. Ahora puede iniciar sesión.");
                            }
                            break;
        			case 2:
        				System.out.println("Ingrese su ID de cuenta: ");
        				scanner.nextLine();
        		        String idCuenta = scanner.nextLine();
        		        System.out.println("Ingrese su contraseña: ");
        		        String contrasena = scanner.nextLine();

        		        if (cuentas.containsKey(idCuenta) && cuentas.get(idCuenta).verificarContrasena(contrasena)) {
        		        	boolean sesionActiva = true;
        		        	while(sesionActiva) {
        		        	System.out.println("Seleccione una opcion :");
        		        	System.out.println("1 Ingresar");
        		        	System.out.println("2 Retirar");
        		        	System.out.println("3 Consultar Saldo");
        		        	System.out.println("4 Cerrar sesion");
        		        	System.out.println("5 Salir");
        		        	
        		        	opcion = scanner.nextInt();
        		        	switch(opcion) {
        		        	case 1:
        		        		 System.out.print("Ingrese la cantidad a depositar: ");
        		        	        cantidad = scanner.nextDouble();
        		        	        
        		        	        cuentas.get(idCuenta).depositar(cantidad);
        		        	        System.out.println("Depósitando... ");
        		        	        System.out.println("Depósito exitoso");
        		        	        System.out.println("Nuevo saldo: " + cuentas.get(idCuenta).getSaldo());
        		        	        break;
        		        	case 2:   
        		        			System.out.print("¿Cuanto dinero desea retira");
        		        				cantidad = scanner.nextDouble();
        		                
        		        			if (cuentas.get(idCuenta).retirar(cantidad)) {
        		        				System.out.println("Retirando...");
        		                    	System.out.println("Retiro exitoso");
        		                    	System.out.println("Saldo: " + cuentas.get(idCuenta).getSaldo());
        		        			} else {
        		        				System.out.println("Saldo insuficiente. Operación cancelada.");
        		        			}
        		        			break;
        		        	case 3:
        		        		System.out.println("Saldo actual es: " + cuentas.get(idCuenta).getSaldo());
        		        		break;
        		        	case 4:
        		        		System.out.println("Cierre de sesión exitoso para la cuenta: " + idCuenta);
        	                    sesionActiva=false;
        	                    break;
        		        	case 5:
        	                    System.out.println("programa finalizado");
        	                    
        	                   continuar=false;
        	                    break;
        	                default:
        	                    System.out.println("Opción no válida. Inténtelo de nuevo.");
        		        	}
        		        	}
        		        } else {
        		            System.out.println("Credenciales incorrectas. Operación cancelada.");
        		        }
        		        break;
        			case 3:
        				System.out.println("Programa  finalizado");
                        continuar= false;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
        				
        		}
        		
        		
        	}
        }
	scanner.close();
	}
	}
	


