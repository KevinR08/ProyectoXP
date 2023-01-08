/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoestructurasdedatos;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;

/**
 *
 * @author santiago
 */
public class Interfaz extends javax.swing.JFrame {

    Empleado empleado = new Empleado();
    NodoEmpleadoLista nuevoNodo = new NodoEmpleadoLista();
    ListaDEnlazada lista = new ListaDEnlazada();
    TablaHashEnlazadaEmpleados tabla = new TablaHashEnlazadaEmpleados();
    ArregloEmpleados Sucursal1 = new ArregloEmpleados(1);
    ArregloEmpleados Sucursal2 = new ArregloEmpleados(2);
    ArregloEmpleados Sucursal3 = new ArregloEmpleados(3);
    ArregloEmpleados Sucursal4 = new ArregloEmpleados(4);
    String sucursal;

    /*
    String sucursal = "";

    TablaHashEnlazadaEmpleados tabla = new TablaHashEnlazadaEmpleados();

    ArregloEmpleados sucursal1 = new ArregloEmpleados(1);
    ArregloEmpleados sucursal2 = new ArregloEmpleados(2);
    ArregloEmpleados sucursal3 = new ArregloEmpleados(3);
    ArregloEmpleados sucursal4 = new ArregloEmpleados(4);
     */
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("registroEmpleados2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String dato = tokens.nextToken();
                Empleado nuevoEmpleado = new Empleado();
                nuevoEmpleado.setCodigo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setNombres(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setApellidos(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setCargo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setUltimaSucursal(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setDireccion(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setCorreo(dato);
                dato = tokens.nextToken();
                nuevoEmpleado.setNumTelf(dato);

                lista.insertarOrdenado(nuevoEmpleado);

                if (nuevoEmpleado.getCargo().equals("Vendedor")) {

                    tabla.inicializar(nuevoEmpleado.getCodigo(), nuevoEmpleado.getUltimaSucursal());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        // Llenar los arreglos de las sucursales

        // SUCURSAL 1
        File archivo1 = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        try {
            archivo1 = new File("codigosEmpleadosSucursal1.txt");
            fr1 = new FileReader(archivo1);
            br1 = new BufferedReader(fr1);
            String codigo1;
            while ((codigo1 = br1.readLine()) != null) {
                Sucursal1.insertarCodigo(codigo1);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (null != fr1) {
                    fr1.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // SUCURSAL 2
        File archivo2 = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;
        try {
            archivo2 = new File("codigosEmpleadosSucursal2.txt");
            fr2 = new FileReader(archivo2);
            br2 = new BufferedReader(fr2);
            String codigo2;
            while ((codigo2 = br2.readLine()) != null) {
                Sucursal2.insertarCodigo(codigo2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (null != fr2) {
                    fr2.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // SUCURSAL 3
        File archivo3 = null;
        FileReader fr3 = null;
        BufferedReader br3 = null;
        try {
            archivo3 = new File("codigosEmpleadosSucursal3.txt");
            fr3 = new FileReader(archivo3);
            br3 = new BufferedReader(fr3);
            String codigo3;
            while ((codigo3 = br3.readLine()) != null) {
                Sucursal3.insertarCodigo(codigo3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        } finally {
            try {
                if (null != fr3) {
                    fr3.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // SUCURSAL 4
        File archivo4 = null;
        FileReader fr4 = null;
        BufferedReader br4 = null;
        try {
            archivo4 = new File("codigosEmpleadosSucursal4.txt");
            fr4 = new FileReader(archivo4);
            br4 = new BufferedReader(fr4);
            String codigo4;
            while ((codigo4 = br4.readLine()) != null) {
                Sucursal4.insertarCodigo(codigo4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        } finally {
            try {
                if (null != fr4) {
                    fr4.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNumTelf = new javax.swing.JTextField();
        btnInsertarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEmpleado = new javax.swing.JTextArea();
        cmbCargo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaNuevoEmpleado = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAntes = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDespués = new javax.swing.JTextArea();
        btnRotar = new javax.swing.JButton();
        btnMostrarTablaHashPrevia = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxSucursales = new javax.swing.JComboBox<>();
        btnMostrarEmpleados = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaMostrarEmpleados = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombres.setText("Nombre");

        lblApellidos.setText("Apellido");

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
        });

        jLabel1.setText("Correo electrónico");

        jLabel2.setText("Dirección");

        jLabel3.setText("Número de teléfeno");

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
        });

        txtNumTelf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumTelfKeyPressed(evt);
            }
        });

        btnInsertarEmpleado.setText("Registrar");
        btnInsertarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarEmpleadoActionPerformed(evt);
            }
        });

        txaEmpleado.setColumns(20);
        txaEmpleado.setRows(5);
        jScrollPane1.setViewportView(txaEmpleado);

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Contador", "Encargado de Bodega" }));

        jLabel6.setText("Cargo");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel7.setText("Lista Completa de Empleados");

        txaNuevoEmpleado.setColumns(20);
        txaNuevoEmpleado.setRows(5);
        jScrollPane5.setViewportView(txaNuevoEmpleado);

        jLabel8.setText("Nuevo Empleado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumTelf))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtApellidos)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertarEmpleado))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel7)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidos)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnInsertarEmpleado))
                        .addGap(11, 11, 11))))
        );

        jTabbedPane1.addTab("Registro Empleado", jPanel1);

        jLabel4.setText("Lista previa a la rotación");

        txaAntes.setColumns(20);
        txaAntes.setRows(5);
        jScrollPane2.setViewportView(txaAntes);

        jLabel5.setText("Lista después de la rotación");

        txaDespués.setColumns(20);
        txaDespués.setRows(5);
        jScrollPane3.setViewportView(txaDespués);

        btnRotar.setText("Rotar");
        btnRotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotarActionPerformed(evt);
            }
        });

        btnMostrarTablaHashPrevia.setText("Mostrar Lista Previa");
        btnMostrarTablaHashPrevia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTablaHashPreviaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnMostrarTablaHashPrevia)
                .addGap(36, 36, 36)
                .addComponent(btnRotar)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRotar)
                    .addComponent(btnMostrarTablaHashPrevia))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rotar Empleados", jPanel2);

        cbxSucursales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal 1", "Sucursal 2", "Sucursal 3", "Sucursal 4" }));
        cbxSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSucursalesActionPerformed(evt);
            }
        });

        btnMostrarEmpleados.setText("Mostrar Empleados");
        btnMostrarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarEmpleadosActionPerformed(evt);
            }
        });

        txaMostrarEmpleados.setColumns(20);
        txaMostrarEmpleados.setRows(5);
        jScrollPane4.setViewportView(txaMostrarEmpleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbxSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarEmpleados)
                        .addGap(0, 338, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarEmpleados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar", jPanel3);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("File");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnInsertarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarEmpleadoActionPerformed
        if (txtNombres.getText().equals("") || 
                txtApellidos.getText().equals("") ||
                txtDireccion.getText().equals("") ||
                txtCorreo.getText().equals("") ||
                txtNumTelf.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null, "Para registrar un empleado debe llenar TODOS los campos");
            txtNombres.requestFocus();

        } else {

            String cargo = String.valueOf(cmbCargo.getSelectedItem());
            String codigo = "";
            switch (cargo) {
                case "Vendedor":
                    codigo += "VD";
                    codigo += "-";
                    codigo += empleado.generarDigitos();
                    NodoEmpleadoLista nodoEmpleado = new NodoEmpleadoLista();
                    while (nodoEmpleado.adelante != null && codigo.equals(empleado.getCodigo())) {
                        codigo = "VD";
                        codigo += "-";
                        codigo += empleado.generarDigitos();
                        nodoEmpleado = nodoEmpleado.adelante;
                    }
                    break;
                case "Contador":
                    codigo += "CT";
                    codigo += "-";
                    codigo += empleado.generarDigitos();
                    while (nuevoNodo.adelante != null && codigo.equals(empleado.getCodigo())) {
                        codigo = "CT";
                        codigo += "-";
                        codigo += empleado.generarDigitos();
                        nuevoNodo = nuevoNodo.adelante;
                    }
                    break;
                case "Encargado de Bodega":
                    codigo += "EB";
                    codigo += "-";
                    codigo += empleado.generarDigitos();
                    while (nuevoNodo.adelante != null && codigo.equals(empleado.getCodigo())) {
                        codigo = "EB";
                        codigo += "-";
                        codigo += empleado.generarDigitos();
                        nuevoNodo = nuevoNodo.adelante;
                    }
                    break;
            }
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            String direccion = txtDireccion.getText();
            String correo = txtCorreo.getText();
            String telefono = txtNumTelf.getText();

            int numCodigo = Integer.parseInt(codigo.substring(3, 7));
            int numC = numCodigo % 4;
            String ultimaSucursal = String.valueOf(numC);

            Empleado nuevoEmpleado = new Empleado(codigo, nombres, apellidos, cargo, ultimaSucursal, direccion, correo, telefono);
            lista.insertarOrdenado(nuevoEmpleado);
            tabla.inicializar(codigo, ultimaSucursal);
            this.txaNuevoEmpleado.setText(nuevoEmpleado.toString());
            this.txaEmpleado.setText(lista.mostrar());

            lista.actualizaFichero();

        }

    }//GEN-LAST:event_btnInsertarEmpleadoActionPerformed

    private void btnRotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotarActionPerformed
        // TODO add your handling code here:
        TablaHashEnlazadaEmpleados tabla2 = new TablaHashEnlazadaEmpleados();

        Empleado empleadoAux = new Empleado();
        NodoEmpleadoLista actual = lista.getCabecera();
        int k = 0;
        while (k == 0) {
            if (actual.getAdelante() != null) {
                empleadoAux = actual.getInfo();
                if (empleadoAux.getCargo().equals("Vendedor")) {
                    String auxS = empleadoAux.getUltimaSucursal();
                    int auxN = Integer.parseInt(auxS);
                    auxN += 1;
                    auxN = auxN % 4;

                    tabla2.insertarEmpleadoTabla(empleadoAux.getCodigo(), String.valueOf(auxN));

                    empleadoAux.setUltimaSucursal(String.valueOf(auxN));
                    actual.setInfo(empleadoAux);
                }
                actual = actual.getAdelante();
            } else {
                empleadoAux = actual.getInfo();
                if (empleadoAux.getCargo().equals("Vendedor")) {
                    String auxS = empleadoAux.getUltimaSucursal();
                    int auxN = Integer.parseInt(auxS);
                    auxN += 1;
                    auxN = auxN % 4;

                    tabla2.insertarEmpleadoTabla(empleadoAux.getCodigo(), String.valueOf(auxN));

                    empleadoAux.setUltimaSucursal(String.valueOf(auxN));
                    actual.setInfo(empleadoAux);
                }
                actual = actual.getAdelante();
                k = 1;
            }

        }
        tabla = tabla2;
        this.txaDespués.setText(tabla.mostrarEstructura());
        btnMostrarTablaHashPrevia.setEnabled(false);

        // Sobrescribir los archivos del código de los empleados
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0: // SUCURSAL 1
                    File archivo1 = null;
                    FileWriter fw1 = null;
                    PrintWriter pw1 = null;
                    try {
                        archivo1 = new File("codigosEmpleadosSucursal1.txt");
                        fw1 = new FileWriter(archivo1);
                        pw1 = new PrintWriter(fw1);
                        NodoEmpleado nodoActual = tabla2.getNodoEmpleado(0);
                        String nuevoCodigo;
                        int j = 0;
                        while (j == 0) {
                            if (nodoActual.enlace != null) {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw1.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                            } else {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw1.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                                j = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fw1 != null) {
                                fw1.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1: // SUCURSAL 2
                    File archivo2 = null;
                    FileWriter fw2 = null;
                    PrintWriter pw2 = null;
                    try {
                        archivo2 = new File("codigosEmpleadosSucursal2.txt");
                        fw2 = new FileWriter(archivo2);
                        pw2 = new PrintWriter(fw2);
                        NodoEmpleado nodoActual = tabla2.getNodoEmpleado(1);
                        String nuevoCodigo;
                        int j = 0;
                        while (j == 0) {
                            if (nodoActual.enlace != null) {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw2.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                            } else {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw2.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                                j = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fw2 != null) {
                                fw2.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2: // SUCURSAL 3
                    File archivo3 = null;
                    FileWriter fw3 = null;
                    PrintWriter pw3 = null;
                    try {
                        archivo3 = new File("codigosEmpleadosSucursal3.txt");
                        fw3 = new FileWriter(archivo3);
                        pw3 = new PrintWriter(fw3);
                        NodoEmpleado nodoActual = tabla2.getNodoEmpleado(2);
                        String nuevoCodigo;
                        int j = 0;
                        while (j == 0) {
                            if (nodoActual.enlace != null) {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw3.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                            } else {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw3.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                                j = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fw3 != null) {
                                fw3.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3: // SUCURSAL 4
                    File archivo4 = null;
                    FileWriter fw4 = null;
                    PrintWriter pw4 = null;
                    try {
                        archivo4 = new File("codigosEmpleadosSucursal4.txt");
                        fw4 = new FileWriter(archivo4);
                        pw4 = new PrintWriter(fw4);
                        NodoEmpleado nodoActual = tabla2.getNodoEmpleado(3);
                        String nuevoCodigo;
                        int j = 0;
                        while (j == 0) {
                            if (nodoActual.enlace != null) {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw4.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                            } else {
                                nuevoCodigo = nodoActual.getCodigo();
                                pw4.println(nuevoCodigo);
                                nodoActual = nodoActual.enlace;
                                j = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fw4 != null) {
                                fw4.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Algo salió mal xD");
            }

        }
        Sucursal1.vaciarArreglo();
        Sucursal2.vaciarArreglo();
        Sucursal3.vaciarArreglo();
        Sucursal4.vaciarArreglo();

        // Cambiar el archivo del registro de los empleados
        lista.actualizaFichero();


    }//GEN-LAST:event_btnRotarActionPerformed

    private void cbxSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSucursalesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxSucursalesActionPerformed

    private void btnMostrarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEmpleadosActionPerformed
        // TODO add your handling code here:
        sucursal = String.valueOf(cbxSucursales.getSelectedItem());
        txaMostrarEmpleados.setText("");
        String texto = "";
        switch (sucursal) {
            case "Sucursal 1":
                if (!Sucursal1.estaVacio()) {
                    texto += Sucursal1.mostrarEstructura(lista);
                    txaMostrarEmpleados.setText(texto);
                } else {
                    File archivo1 = null;
                    FileReader fr1 = null;
                    BufferedReader br1 = null;
                    try {
                        archivo1 = new File("codigosEmpleadosSucursal1.txt");
                        fr1 = new FileReader(archivo1);
                        br1 = new BufferedReader(fr1);
                        String codigo1;
                        while ((codigo1 = br1.readLine()) != null) {
                            Sucursal1.insertarCodigo(codigo1);
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            if (null != fr1) {
                                fr1.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    txaMostrarEmpleados.setText(Sucursal1.mostrarEstructura(lista));
                }
                break;
            case "Sucursal 2":
                if (!Sucursal2.estaVacio()) {
                    txaMostrarEmpleados.setText(Sucursal2.mostrarEstructura(lista));
                } else {
                    File archivo2 = null;
                    FileReader fr2 = null;
                    BufferedReader br2 = null;
                    try {
                        archivo2 = new File("codigosEmpleadosSucursal2.txt");
                        fr2 = new FileReader(archivo2);
                        br2 = new BufferedReader(fr2);
                        String codigo2;
                        while ((codigo2 = br2.readLine()) != null) {
                            Sucursal2.insertarCodigo(codigo2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        try {
                            if (null != fr2) {
                                fr2.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    txaMostrarEmpleados.setText(Sucursal2.mostrarEstructura(lista));
                }
                break;
            case "Sucursal 3":
                if (!Sucursal3.estaVacio()) {
                    txaMostrarEmpleados.setText(Sucursal3.mostrarEstructura(lista));
                } else {
                    File archivo3 = null;
                    FileReader fr3 = null;
                    BufferedReader br3 = null;
                    try {
                        archivo3 = new File("codigosEmpleadosSucursal3.txt");
                        fr3 = new FileReader(archivo3);
                        br3 = new BufferedReader(fr3);
                        String codigo3;
                        while ((codigo3 = br3.readLine()) != null) {
                            Sucursal3.insertarCodigo(codigo3);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    } finally {
                        try {
                            if (null != fr3) {
                                fr3.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    txaMostrarEmpleados.setText(Sucursal3.mostrarEstructura(lista));
                }
                break;
            case "Sucursal 4":
                if (!Sucursal4.estaVacio()) {
                    txaMostrarEmpleados.setText(Sucursal4.mostrarEstructura(lista));
                } else {
                    File archivo4 = null;
                    FileReader fr4 = null;
                    BufferedReader br4 = null;
                    try {
                        archivo4 = new File("codigosEmpleadosSucursal4.txt");
                        fr4 = new FileReader(archivo4);
                        br4 = new BufferedReader(fr4);
                        String codigo4;
                        while ((codigo4 = br4.readLine()) != null) {
                            Sucursal4.insertarCodigo(codigo4);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    } finally {
                        try {
                            if (null != fr4) {
                                fr4.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    txaMostrarEmpleados.setText(Sucursal4.mostrarEstructura(lista));
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Algo salió mal");
                break;
        }


    }//GEN-LAST:event_btnMostrarEmpleadosActionPerformed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Empleado emp = new Empleado();
            String correo = txtCorreo.getText();
            if (!emp.esCorreoValido(correo)) {
                JOptionPane.showMessageDialog(null, "Correo inválido, vuelva a ingresarlo");
                txtCorreo.setText("");
                txtCorreo.requestFocus();
            } else {
                txtNumTelf.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void txtNumTelfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumTelfKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Empleado emp = new Empleado();
            String numTelf = txtNumTelf.getText();
            if (!emp.esTelefonoValido(numTelf)) {
                JOptionPane.showMessageDialog(null, "Número de teléfono inválido, vuelva a ingresarlo");
                txtNumTelf.setText("");
                txtNumTelf.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNumTelfKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed

        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Empleado emp = new Empleado();
            String nombre = txtNombres.getText();
            if (!emp.esNombreValido(nombre)) {
                JOptionPane.showMessageDialog(null, "Su nombre no puede contener números ni caracteres especiales");
                txtNombres.setText("");
                txtNombres.requestFocus();
            } else {
                txtApellidos.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Empleado emp = new Empleado();
            String apellido = txtApellidos.getText();
            if (!emp.esApellidoValido(apellido)) {
                JOptionPane.showMessageDialog(null, "Su apellido no puede contener números ni caracteres especiales");
                txtApellidos.setText("");
                txtApellidos.requestFocus();
            } else {
                cmbCargo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Empleado emp = new Empleado();
            String direccion = txtDireccion.getText();
            if (!emp.esApellidoValido(direccion)) {
                JOptionPane.showMessageDialog(null, "Su direccion no puede contener números ni caracteres especiales");
                txtDireccion.setText("");
                txtDireccion.requestFocus();
            } else {
                txtCorreo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.txtNombres.setText("");
        this.txtApellidos.setText("");
        this.txtDireccion.setText("");
        this.txtNumTelf.setText("");
        this.txtCorreo.setText("");
        this.txaEmpleado.setText("");
        this.txaNuevoEmpleado.setText("");
        this.txtNombres.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnMostrarTablaHashPreviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTablaHashPreviaActionPerformed
        // TODO add your handling code here:
        txaAntes.setText(tabla.mostrarEstructura());

    }//GEN-LAST:event_btnMostrarTablaHashPreviaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertarEmpleado;
    private javax.swing.JButton btnMostrarEmpleados;
    private javax.swing.JButton btnMostrarTablaHashPrevia;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRotar;
    private javax.swing.JComboBox<String> cbxSucursales;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTextArea txaAntes;
    private javax.swing.JTextArea txaDespués;
    private javax.swing.JTextArea txaEmpleado;
    private javax.swing.JTextArea txaMostrarEmpleados;
    private javax.swing.JTextArea txaNuevoEmpleado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumTelf;
    // End of variables declaration//GEN-END:variables
}
