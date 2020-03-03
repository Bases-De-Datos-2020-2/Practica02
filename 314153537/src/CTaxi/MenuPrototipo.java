package CTaxi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase para manejar un menu prototipo
 *
 * @author wozr
 * @version 0.1
 */
public class MenuPrototipo {

    /**
     * Despliegue de un menu de opciones Capturar Consultar editar Eliminar
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ATUCU");
        System.out.println("Elige una opcion:");
        System.out.println("(A) Capturar informacion\n"
                + "(B) Consultar informacion\n"
                + "(C) Editar informacion\n"
                + "(D) Eliminar informacion\n"
                + "(E) Salir");

        boolean entras = false;
        while (!entras) {
            String op = sc.nextLine();
            String opt = op.toUpperCase();
            switch (opt) {
                case "A":
                    capturarInfo();
                    entras = !entras;
                    break;
                case "B":
                    consultarInfo();
                    entras = !entras;
                    break;
                case "C":
                    editarInfo();
                    entras = !entras;
                    break;
                case "D":
                    eliminarInfo();
                    entras = !entras;
                    break;
                case "E"://salir
                    entras = !entras;
                    break;
                default://volver a intentar
                    System.out.println("Vuleve a intentar");

                    break;
            }

        }
    }

    /**
     * Menu para capturar info
     */
    private void capturarInfo() {
        System.out.println("Selecciona una entidad:");
        System.out.println("(A) Dueño\n"
                + "(B) Chofer\n"
                + "(C) Taxi\n"
                + "(D) Regresar al menu pricipal");
        Scanner sc = new Scanner(System.in);

        //este patron se preste a que lo encapsule
        boolean entras = false;
        while (!entras) {
            String op = sc.nextLine();
            String opt = op.toUpperCase();
            switch (opt) {
                case "A":
                    capturaDueños();
                    entras = !entras;
                    break;
                case "B":
                    capturaChoferes();
                    entras = !entras;
                    break;
                case "C":
                    capturaTaxis();
                    entras = !entras;
                    break;
                case "D":
                    menu();
                    entras = !entras;
                    break;
                default://volver a intentar
                    System.out.println("Vuleve a intentar");

                    break;
            }
        }
    }

    /**
     * Crea dueños y los guarda para capturarlos en .csv
     * ojo por la fuerza bruta que no se te olviden los anteriores
     */
    private void capturaDueños() {
        DueñosCSV dcsv = new DueñosCSV();
        ArrayList<Dueño> dueños = dcsv.importarDueñosCSV();

        //ya lo se va a pedir que lo cambie
        System.out.println("La fecha de ingreso sera el dia de hoy");
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos dueños capturaras?");
        int n = sc.nextInt();
        
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre del dueño " + (i + 1) + ":");
            String nombre = sc.nextLine();

            System.out.println("Domicilio:");
            String domin = sc.nextLine();

            System.out.println("Numero de licencia:");
            String numLice = sc.nextLine();

            Date today = new Date();

            System.out.println("email:");
            String email = sc.nextLine();

            System.out.println("Telefono:");
            String tel = sc.nextLine();

            System.out.println("RFC:");
            String rfc = sc.nextLine();

            Dueño d = new Dueño(nombre, domin, numLice, today, email, tel, rfc);

            dueños.add(d);
        }

        //capturado
        
        dcsv.exportarDueñosCSV(dueños);
        System.out.println("Dueños agregados");
    }

    /**
     * Lo mismo pero para choferes
     */
    private void capturaChoferes() {
        ChoferesCSV ccsv = new ChoferesCSV();
        ArrayList<Chofer> choferes = ccsv.importarChoferesCSV();

        //ya lo se va a pedir que lo cambie
        System.out.println("La fecha de ingreso sera el dia de hoy");
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos choferres capturaras?");
        int n = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre del chofer " + (i + 1) + ":");
            String nombre = sc.nextLine();

            System.out.println("Domicilio:");
            String domin = sc.nextLine();

            System.out.println("Numero de licencia:");
            String numLice = sc.nextLine();

            Date today = new Date();

            System.out.println("email:");
            String email = sc.nextLine();

            System.out.println("Telefono:");
            String tel = sc.nextLine();

            Chofer c = new Chofer(nombre, domin, numLice, today, email, tel);

            choferes.add(c);
        }

        //capturado
        
        ccsv.exportarChoferesCSV(choferes);
        System.out.println("Choferes agregados");
    }

    /**
     * Captura de taxis
     */
    private void capturaTaxis() {
        TaxisCSV tcsv = new TaxisCSV();
        ArrayList<Taxi> taxis = tcsv.importarTaxisCSV();

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos taxis capturaras?");
        int n = sc.nextInt();

        sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre del modelo " + (i + 1) + " del taxi:");
            String modelo = sc.nextLine();

            System.out.println("Nombre de la marca del taxi:");
            String marca = sc.nextLine();

            System.out.println("Año del vehiculo " + (i + 1) + ":");
            int añoVe = sc.nextInt();

            System.out.println("Numero de cilindros:");
            int numCi = sc.nextInt();

            System.out.println("Numero de puertas:");
            int numP = sc.nextInt();

            System.out.println("¿Tiene llanta de refraccion [Y/N]");
            String res = sc.nextLine();
            res = res.toUpperCase();
            boolean refraccion = ("Y".equals(res));//esta simple ya casi es la 1 a.m

            System.out.println("Nombre de su chofer:");
            String nomChofer = sc.nextLine();

            Taxi t = new Taxi(modelo, marca, añoVe, numCi, numP,
                    refraccion, new Dueño(nomChofer));

            taxis.add(t);
        }

        //capturado
        
        tcsv.exportarTaxisCSV(taxis);
        System.out.println("Taxis agregados");
    }

    /**
     * Consulta en general de todo ALV
     */
    private void consultarInfo() {
        ChoferesCSV ccsv = new ChoferesCSV();
        DueñosCSV dcsv = new DueñosCSV();
        TaxisCSV tcsv = new TaxisCSV();

        //despliegues
        ArrayList choferes = ccsv.importarChoferesCSV();
        ccsv.desplegarListaChofer(choferes);

        ArrayList dueños = dcsv.importarDueñosCSV();
        dcsv.desplegarListaDueños(dueños);

        ArrayList taxis = tcsv.importarTaxisCSV();
        tcsv.desplegarListaTaxis(taxis);
    }

    /**
     * Menu para especificar que entidad editar
     */
    private void editarInfo() {
        System.out.println("Selecciona una entidad:");
        System.out.println("(A) Dueño\n"
                + "(B) Chofer\n"
                + "(C) Taxi\n"
                + "(D) Regresar al menu pricipal");
        Scanner sc = new Scanner(System.in);

        //este patron se preste a que lo encapsule
        boolean entras = false;
        while (!entras) {
            String op = sc.nextLine();
            String opt = op.toUpperCase();
            switch (opt) {
                case "A":
                    editarDueños();
                    entras = !entras;
                    break;
                case "B":
                    editarChoferes();
                    entras = !entras;
                    break;
                case "C":
                    editarTaxis();
                    entras = !entras;
                    break;
                case "D":
                    menu();
                    entras = !entras;
                    break;
                default://volver a intentar
                    System.out.println("Vuleve a intentar");
                    break;
            }
        }
    }

    /**
     * Editar los Dueños
     */
    private void editarDueños() {
        DueñosCSV dcsv = new DueñosCSV();
        ArrayList<Dueño> dueños = dcsv.importarDueñosCSV();

        //despliegue
        int i = 1;
        for (Dueño dueño : dueños) {
            System.out.println("Dueño " + (i++) + ":");
            System.out.println(dueño);
        }

        //de a uno por uno en esta version
        System.out.println("Seleciona el numero del Dueño que quieres modificar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;

        //todo directo
        System.out.println("Se modificara:");
        System.out.println(dueños.get(x));
        sc.nextLine();
        //todo junto en esta version, ya estoy hasta la madre, no hay mucho 
        //detalles en un prototipo super apurado
        System.out.println("Nombre:");
        String name = sc.nextLine();
        dueños.get(x).setNombre(name);

        System.out.println("Domicilio");
        String dom = sc.nextLine();
        dueños.get(x).setDomicilio(dom);

        System.out.println("Numero de licencia");
        String numL = sc.nextLine();
        dueños.get(x).setLicenciaDeConducir(numL);

        //no hay modificacion de fecha
        System.out.println("Email");
        String em = sc.nextLine();
        dueños.get(x).setEmail(em);

        System.out.println("Telefono");
        String tel = sc.nextLine();
        dueños.get(x).setTelefono(tel);

        System.out.println("RFC");
        String rfc = sc.nextLine();
        dueños.get(x).setRFC(rfc);

        dcsv.exportarDueñosCSV(dueños);
        
        System.out.println("Dueño editado");

    }//end edidChofers

    /**
     * Lo mismo para chofers
     */
    private void editarChoferes() {
        ChoferesCSV ccsv = new ChoferesCSV();
        ArrayList<Chofer> choferes = ccsv.importarChoferesCSV();

        //despliegue
        int i = 1;
        for (Chofer chofer : choferes) {
            System.out.println("Chofer " + (i++) + ":");
            System.out.println(chofer);
        }

        //de a uno por uno en esta version
        System.out.println("Seleciona el numero del chofer que quieres modificar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;

        //todo directo
        System.out.println("Se modificara:");
        System.out.println(choferes.get(x));
        sc.nextLine();

        System.out.println("Nombre:");
        String name = sc.nextLine();
        choferes.get(x).setNombre(name);

        System.out.println("Domicilio");
        String dom = sc.nextLine();
        choferes.get(x).setDomicilio(dom);

        System.out.println("Numero de licencia");
        String numL = sc.nextLine();
        choferes.get(x).setLicenciaDeConducir(numL);

        //no hay modificacion de fecha
        System.out.println("Email");
        String em = sc.nextLine();
        choferes.get(x).setEmail(em);

        System.out.println("Telefono");
        String tel = sc.nextLine();
        choferes.get(x).setTelefono(tel);

        //actualizar los archivos
        ccsv.exportarChoferesCSV(choferes);
        
        System.out.println("Chofer editado");
    }

    /**
     * Ya tu sabe los taxis
     */
    private void editarTaxis() {
        TaxisCSV tcsv = new TaxisCSV();
        ArrayList<Taxi> taxis = tcsv.importarTaxisCSV();

        //despliegue
        int i = 1;
        for (Taxi taxi : taxis) {
            System.out.println("Taxi " + (i++) + ":");
            System.out.println(taxi);
        }

        //de a uno por uno en esta version
        System.out.println("Seleciona el numero del taxi que quieres modificar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;//cosas de indices

        //todo directo
        System.out.println("Se modificara");
        System.out.println(taxis.get(x));
        sc.nextLine();

        System.out.println("Modelo:");
        String model = sc.nextLine();
        taxis.get(x).setModelo(model);

        System.out.println("Marca");
        String mar = sc.nextLine();
        taxis.get(x).setMarca(mar);

        System.out.println("Año del vehiculo");
        int aVehiculo = sc.nextInt();
        taxis.get(x).setAñoVehicuo(aVehiculo);

        //no hay modificacion de fecha
        System.out.println("Numero de cilindros");
        int numCil = sc.nextInt();
        taxis.get(x).setNumCilindros(numCil);

        System.out.println("Numero de puertas");
        int numP = sc.nextInt();
        taxis.get(x).setNumPuertas(numP);

        System.out.println("¿Tiene llanta de refraccion? [Y/N]");
        String res = sc.nextLine();
        res = res.toUpperCase();
        boolean refraccion = (res.equals("Y"));
        taxis.get(x).setLlantaRefaccion(refraccion);

        //la fuerza fruta que no se te olvide a los csv
        tcsv.exportarTaxisCSV(taxis);
        
        System.out.println("Taxi editado");
    }

    /**
     * Menu para la eliminacion de las entidades
     */
    private void eliminarInfo() {
        System.out.println("Selecciona una entidad:");
        System.out.println("(A) Dueño\n"
                + "(B) Chofer\n"
                + "(C) Taxi\n"
                + "(D) Regresar al menu pricipal");
        Scanner sc = new Scanner(System.in);

        //este patron se preste a que lo encapsule
        boolean entras = false;
        while (!entras) {
            String op = sc.nextLine();
            String opt = op.toUpperCase();
            switch (opt) {
                case "A":
                    eliminarDueños();
                    entras = !entras;
                    break;
                case "B":
                    eliminarChoferes();
                    entras = !entras;
                    break;
                case "C":
                    eliminarTaxis();
                    entras = !entras;
                    break;
                case "D":
                    menu();
                    entras = !entras;
                    break;
                default://volver a intentar
                    System.out.println("Vuleve a intentar");
                    break;
            }
        }
    }

    /**
     * Selecciona un dueño y lo elimina
     */
    private void eliminarDueños() {
        DueñosCSV dcsv = new DueñosCSV();
        ArrayList<Dueño> dueños = dcsv.importarDueñosCSV();

        int i = 1;
        for (Dueño dueño : dueños) {
            System.out.println("Dueño " + (i++) + ":");
            System.out.println(dueño);
        }

        System.out.println("Selecciona el numero del dueño a eliminar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;

        dueños.remove(x);
        System.out.println("Dueño eliminado");
        //y actualizar los csv
        dcsv.exportarDueñosCSV(dueños);
    }

    /**
     * Eliminar choferes
     */
    private void eliminarChoferes() {

        ChoferesCSV ccsv = new ChoferesCSV();
        ArrayList<Chofer> choferes = ccsv.importarChoferesCSV();

        int i = 1;
        for (Chofer dueño : choferes) {
            System.out.println("Chofer " + (i++) + ":");
            System.out.println(dueño);
        }

        System.out.println("Selecciona el numero del chofer a eliminar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;

        choferes.remove(x);
        System.out.println("Chofer eliminado");

        ccsv.exportarChoferesCSV(choferes);
    }

    /**
     * Eliminar taxis
     */
    private void eliminarTaxis() {
        TaxisCSV tcsv = new TaxisCSV();
        ArrayList<Taxi> taxis = tcsv.importarTaxisCSV();

        int i = 1;
        for (Taxi taxi : taxis) {
            System.out.println("Taxi " + (i++) + ":");
            System.out.println(taxi);
        }

        System.out.println("Selecciona el numero del taxi a eliminar");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        x = x - 1;

        taxis.remove(x);
        System.out.println("Taxi eliminado");

        tcsv.exportarTaxisCSV(taxis);
    }

}
