
import java.awt.Color;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Procesar extends javax.swing.JFrame {

    int listaProcesosBloqueados[];//Se utiliza para agregar los procesos que se bloquean por E/S
    int Contador;//Contador del total de procesos que se van ingresando
    int NProceso;//Carga el número de procesos ejecutándose
    int Rafaga = 0;//Carga la ráfaga en ejecución
    int Quantum = 0;//Carga el quantum en ejecución
    int ResiduoRafaga = 0;//Carga el residuo en ejecución
    int TiempoProceso = 0;//Carga el tiempo que se dura procesando
    int ValorBarra;//Carga el progreso de la Barra
    int CantidadProcesos;//Número de procesos terminados
    boolean bloquear = true;//Estado de los procesos 
    boolean desbloquear = false;//Estado de los procesos 
    int procesosAEjecutarse;
    long tiempoInicio;
    long tiempoBase;
    long tiempoFin;
    static int LargoTotalTabla;//Valor Total de los tiempos para dibujar tablas
    static int CantProcesos;//Cantidad de Procesos
    Random rnd = new Random();
    private ImageIcon imagen;
    private Icon icono;
    int estado = 1;

    public Procesar() {
        initComponents();
        tamanioBloqueadosES();
        this.setLocationRelativeTo(null);
        Color x = new Color(63, 51, 30);
        jTIngresos.setBackground(Color.CYAN);
        jTIngresos.setForeground(Color.blue);
        jTFinal.setBackground(Color.GREEN);
        jTFCapturaQuantum.grabFocus();
        setTitle("Sistemas Operativos Obligatorio");
        this.setLocationRelativeTo(this);
        this.pintarImagen(this.imagen3, ".\\src\\Imagen\\Imagen7.png");
        jBAgregar.setIcon(setIcono("/Imagen/Cargar procesos.png", jBAgregar));
        jBIniciar.setIcon(setIcono("/Imagen/Iniciar.png", jBIniciar));
        blockear.setIcon(setIcono("/Imagen/Bloquear.png", blockear));
        desbloc.setIcon(setIcono("/Imagen/Desbloquear.png", desbloc));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLCantidadProcesos = new javax.swing.JTextField();
        jLCantidadTiempo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPBEstado = new javax.swing.JProgressBar();
        imagen3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLPorcentajeProceso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLNumeroProceso = new javax.swing.JTextField();
        blockear = new javax.swing.JButton();
        desbloc = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTIngresos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jBIniciar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTFCapturaQuantum = new javax.swing.JTextField();
        jTFCapturaRafaga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTFinal = new javax.swing.JTable();
        imagen2 = new javax.swing.JLabel();
        bloc = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 730));
        setMinimumSize(new java.awt.Dimension(1280, 730));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CANTIDAD PROCESO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 141, 17));

        jLCantidadProcesos.setEditable(false);
        jLCantidadProcesos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLCantidadProcesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 118, -1));

        jLCantidadTiempo.setEditable(false);
        jLCantidadTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLCantidadTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 118, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIEMPO PROCESO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 141, 20));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 730));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 730));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 730));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPBEstado.setBackground(java.awt.SystemColor.GREEN);
        jPBEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPBEstado.setForeground(new java.awt.Color(255, 125, 0));
        jPBEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(243, 225, 255)));
        jPanel1.add(jPBEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 340, 21));

        imagen3.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        imagen3.setForeground(new java.awt.Color(255, 255, 255));
        imagen3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imagen3.setText("PLANIFICADOR DE PROCESOS");
        jPanel1.add(imagen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HISTORICO PROCESOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 450, 30));

        jLPorcentajeProceso.setEditable(false);
        jLPorcentajeProceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jLPorcentajeProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 53, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Proceso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, -1, -1));

        jLNumeroProceso.setEditable(false);
        jLNumeroProceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jLNumeroProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 41, -1));

        blockear.setForeground(new java.awt.Color(255, 255, 255));
        blockear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockearActionPerformed(evt);
            }
        });
        jPanel1.add(blockear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 130, 40));

        desbloc.setForeground(new java.awt.Color(255, 255, 255));
        desbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desblocActionPerformed(evt);
            }
        });
        jPanel1.add(desbloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 130, 40));

        jBAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 150, 40));

        jTIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Rafaga", "Quantum", "ResiduoRafaga", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTIngresos.setSelectionBackground(new java.awt.Color(102, 255, 102));
        jTIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTIngresosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTIngresos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 530, 190));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("        LISTA DE PROCESOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 265, 29));

        jBIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(jBIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 150, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1020, 300));

        jTFCapturaQuantum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTFCapturaQuantum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 79, -1));

        jTFCapturaRafaga.setEditable(false);
        jTFCapturaRafaga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTFCapturaRafaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 114, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantum");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 79, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rafaga");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 74, -1));

        jTFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Rafaga", "Quantum", "Tiempo Final"
            }
        ));
        jTFinal.setEnabled(false);
        jScrollPane4.setViewportView(jTFinal);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 410, 133));

        imagen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/FONDO.png"))); // NOI18N
        imagen2.setText("jLabel8");
        imagen2.setMaximumSize(new java.awt.Dimension(1280, 730));
        imagen2.setMinimumSize(new java.awt.Dimension(1280, 730));
        imagen2.setPreferredSize(new java.awt.Dimension(1280, 730));
        jPanel1.add(imagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 730));
        jPanel1.add(bloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 79, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void tamanioBloqueadosES() {
        String clavesInsertar[] = ManejadorArchivosGenerico.leerArchivo(".\\src\\Procesos.txt");
        int cantProcesosBloc = 0;
        for (String string : clavesInsertar) {
            String proceso[] = new String[2];
            proceso = string.split(",");
            if (proceso[1].contains("1")) {
                cantProcesosBloc++;
            }
        }
        listaProcesosBloqueados = new int[cantProcesosBloc];
    }

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        //Metodo que lee un archivo txt de procesos y los carga a la tabla donde van a ser posteriormente
        //ejecutados por el planificador
        if (jTFCapturaQuantum.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Quantum");
        } else {
            String clavesInsertar[] = ManejadorArchivosGenerico.leerArchivo(".\\src\\Procesos.txt");
            String proceso[] = new String[2];
            int numeroProcesos = 0;
            int cont = 0;
            String numeroProceso;
            String rafaga;
            for (String string : clavesInsertar) {
                numeroProcesos++;
                proceso = string.split(",");
                Procesos nuevoProceso = new Procesos(Integer.parseInt(proceso[0]), Integer.parseInt(proceso[1]));
                if (nuevoProceso.isBloqueoPorEntradaSalida()) {
                    listaProcesosBloqueados[cont] = numeroProcesos;
                    cont++;
                    System.out.println("bloqueado pors Entrada y salida el proceso " + numeroProcesos);
                }
                numeroProceso = String.valueOf(nuevoProceso.getNumeroProceso());
                rafaga = String.valueOf(nuevoProceso.getRafagaDeCpu());
                Ingresar(numeroProceso, rafaga);

            }
        }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        //Este metodo inicia el planificador y los dos hilos que ejecuta el sistema
        //un hilo para el planificador en si y otro hilo para el bloqueo de los procesos que 
        //se bloquean por entrada y salida
        tiempoBase = System.currentTimeMillis();
        new Thread(new Hilo()).start(); //Crea un nuevo hilo
        new Thread(new HiloTiempo()).start();
    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jTIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTIngresosMouseClicked
        //Este metodo captura el numero del proceso y lo guarda en JTxtfield para poder 
        //bloquearlo o desbloquearlo
        int row = jTIngresos.getSelectedRow();
        String id = String.valueOf(jTIngresos.getValueAt(row, 0));
        bloc.setText(id);
    }//GEN-LAST:event_jTIngresosMouseClicked

    private void blockearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockearActionPerformed
        //Con este boton bloqueamos el proceso de forma manueal, lo que seria 
        //Bloqueo por usuario
        int row = jTIngresos.getSelectedRow();
        if (Integer.parseInt(jTIngresos.getValueAt(row, 0).toString()) != 0) {
            String numeroProceso = bloc.getText();
            jTIngresos.setValueAt("Bloqueado", Integer.parseInt(numeroProceso) - 1, 4);
        }

    }//GEN-LAST:event_blockearActionPerformed

    private void desblocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desblocActionPerformed
        //Este boton desbloquea el proceso seleccionado de la tabla de procesos
        Dormir();
        String numeroProceso = bloc.getText();
        if (jTIngresos.getValueAt(Integer.parseInt(numeroProceso) - 1, 4) == "Bloqueado") {
            jTIngresos.setValueAt("Listo", Integer.parseInt(numeroProceso) - 1, 4);
        }
    }//GEN-LAST:event_desblocActionPerformed

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
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Procesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Procesar().setVisible(true);
            }
        });
    }

    private class HiloTiempo implements Runnable {

        //Este hilo lo que hace es bloquear y desbloquear los procesos que se bloquean por espera de 
        //entrada y salida. toma un tiempo y en funcion de las variables booleanas para los estados
        //de los procesos, los bloquea o desbloquea respectivamente
        @Override
        public void run() {
            while (true) {
                while (bloquear) {
                    tiempoInicio = System.currentTimeMillis();
                    tiempoFin = (int) (rnd.nextDouble() * 6500 + 3000);
                    if (tiempoInicio - tiempoBase >= tiempoFin) {
                        bloqueoEntradaSalida();
                    }
                }
                while (desbloquear) {
                    tiempoInicio = System.currentTimeMillis();
                    tiempoFin = (int) (rnd.nextDouble() * 6500 + 3000);
                    if (tiempoInicio - tiempoBase >= tiempoFin) {
                        desbloqueoEntradaSalida();
                    }
                }
            }
        }

    }

    private class Hilo implements Runnable { //Objeto de tipo Hilo con extension ejectubale

        @Override
        public void run() {
            //En las lineas subsiguientes se ejecuta el recorrido de la tabla de procesos y en funcion de el valor
            //del quantum, el residuo que le va quedando a cada proceso, va ejecutando proceso por proceso a no ser que 
            //esten bloqueados, hasta terminar la lista de procesos.
            int i = 0;
            Grafica grafica = new Grafica();
            while (estado != 0) {
                while (i < Contador) { //Recorrer las filas de la tabla procesos
                    Cargar(i);
                    if (ResiduoRafaga != 0 && ResiduoRafaga > Quantum && jTIngresos.getValueAt(i, 4) != "Bloqueado") { //Ejecutando Procesos
                        for (int c = 1; c <= Quantum; c++) {
                            if (jTIngresos.getValueAt(i, 4) != "Bloqueado") {

                                grafica.Dibujar(i, jPanel2, LargoTotalTabla, CantProcesos);
                                jTIngresos.setValueAt("Procesando", i, 4);
                                ResiduoRafaga--;
                                Barra(Rafaga, ResiduoRafaga);
                                Pintar();
                                jTIngresos.setValueAt(String.valueOf(ResiduoRafaga), i, 3);
                                TiempoProceso++;
                                Dormir();
                            }
                        }
                        jTIngresos.setValueAt("Espera", i, 4);
                        if (ResiduoRafaga == 0) {
                            jTIngresos.setValueAt("Terminado", i, 4);
                            Pintar();
                            Informe(i);
                            Borrar(i);
                            jPBEstado.setValue(0);
                        }
                    } else {
                        if (ResiduoRafaga > 0 && Quantum != 0 && jTIngresos.getValueAt(i, 4) != "Bloqueado") {
                            while (ResiduoRafaga > 0) {
                                if (jTIngresos.getValueAt(i, 4) != "Bloqueado") {

                                    grafica.Dibujar(i, jPanel2, LargoTotalTabla, CantProcesos);
                                    jTIngresos.setValueAt("Procesando", i, 4);
                                    ResiduoRafaga--;
                                    Barra(Rafaga, ResiduoRafaga);
                                    Pintar();
                                    jTIngresos.setValueAt(String.valueOf(ResiduoRafaga), i, 3);
                                    TiempoProceso++;
                                    Dormir();
                                }
                            }
                            jTIngresos.setValueAt("Espera", i, 4);
                            if (ResiduoRafaga == 0 && Quantum != 0) {
                                jTIngresos.setValueAt("Terminado", i, 4);
                                Pintar();
                                Informe(i);
                                Borrar(i);
                                jPBEstado.setValue(0);
                            }
                        } else {
                            if (ResiduoRafaga == 0 && Quantum != 0) {
                                jTIngresos.setValueAt("Terminado", i, 4);
                                Pintar();
                                Informe(i);
                                Borrar(i);
                                jPBEstado.setValue(0);
                            }
                        }
                    }
                    jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
                    jLPorcentajeProceso.setText(String.valueOf(""));
                    i++;
                }
                i = 0;
                jLNumeroProceso.setText(String.valueOf("")); //Borrar contenido
                jLPorcentajeProceso.setText(String.valueOf(""));
            }
        }
    }

    public void bloqueoEntradaSalida() {
        //Metodo que pone en estado de bloqueado a los procesos que se bloquean por espera de entrada/salida
        for (int listaProcesosBloqueado : listaProcesosBloqueados) {
            int raf = parseInt((String) (jTIngresos.getValueAt(listaProcesosBloqueado - 1, 3)));
            if (listaProcesosBloqueado != 0 && raf > 0) {
                jTIngresos.setValueAt("Bloqueado", listaProcesosBloqueado - 1, 4);
            }
        }
        tiempoBase = System.currentTimeMillis();
        bloquear = false;
        desbloquear = true;
    }

    public void desbloqueoEntradaSalida() {
        //Proceso inverso del metodo anterior, desbloquea los procesos que se encuentran bloqueados luego de pasado
        //el tiempo de espera
        for (int listaProcesosBloqueado : listaProcesosBloqueados) {
            int raf = parseInt((String) (jTIngresos.getValueAt(listaProcesosBloqueado - 1, 3)));
            if (listaProcesosBloqueado != 0 && raf > 0) {
                jTIngresos.setValueAt("Esperando", listaProcesosBloqueado - 1, 4);
            }
        }
        tiempoBase = System.currentTimeMillis();
        bloquear = true;
        desbloquear = false;

    }

    public void Dormir() {
        //Metodo que hace que el proceso de ejecucion de los procesos hace que podamos verlo 
        //o sea nos permite verlo
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Cargar(int i) { //Carga los valores de la Tabla
        //Este metodo pone valor a las variables que utilizan los procesos
        //Toma los valores de cada proceso que tiene la tabla y los guarda en la variable para 
        //que desdpues sean utilizadas en la ejecucion de los procesos.
        if (jTIngresos.getValueAt(i, 4) != "Bloqueado") {
            NProceso = (int) jTIngresos.getValueAt(i, 0);
            Rafaga = parseInt((String) (jTIngresos.getValueAt(i, 1)));
            Quantum = parseInt((String) (jTIngresos.getValueAt(i, 2)));
            ResiduoRafaga = parseInt((String) (jTIngresos.getValueAt(i, 3)));
            if (NProceso > 0 && jTIngresos.getValueAt(i, 4) != "Bloqueado") {
                jLNumeroProceso.setText(String.valueOf(NProceso));
            }
        }
    }

    public void Ingresar(String numeroProceso, String rafaga) {
        //Ingresa los procesos a la tabla de procesos a ejecutarse
        DefaultTableModel modelo = (DefaultTableModel) jTIngresos.getModel();
        Contador++;
        Object[] miTabla = new Object[5];
        miTabla[0] = Contador;
        miTabla[1] = rafaga;
        LargoTotalTabla += Integer.parseInt(rafaga);
        CantProcesos++;
        miTabla[2] = jTFCapturaQuantum.getText();
        miTabla[3] = rafaga;
        miTabla[4] = "Listo";
        modelo.addRow(miTabla);
        jTIngresos.setModel(modelo);
    }

    public void Informe(int c) {
        //Una vez terminado cada proceso de ejecutarse, se ingresa a la tabla de informe llenandose asi 
        //esta tabla hasta que se completen con la totalidad de los procesos ejecutados
        DefaultTableModel modelo2 = (DefaultTableModel) jTFinal.getModel();
        Object[] miTabla = new Object[5];
        miTabla[0] = c + 1;
        miTabla[1] = Rafaga;
        miTabla[2] = Quantum;
        miTabla[3] = TiempoProceso + " Segundos";
        miTabla[4] = "Terminado";
        modelo2.addRow(miTabla);
        jTFinal.setModel(modelo2);
        CantidadProcesos++;
        jLCantidadProcesos.setText(String.valueOf(CantidadProcesos + " Terminados"));
        jLCantidadTiempo.setText(String.valueOf(TiempoProceso + " Segundos"));
    }

    public void Borrar(int c) {
        //Elimina los registros de la tabla procesos una vez terminado de ejecutarse por completo
        jTIngresos.setValueAt(0, c, 0);
        jTIngresos.setValueAt("0", c, 1);
        jTIngresos.setValueAt("0", c, 2);
        jTIngresos.setValueAt("0", c, 3);
        jTIngresos.setValueAt("******", c, 4);
    }

    public void Barra(int rafaga, int residuo) {
        //Calcula porcentaje de la barra y su progreso
        int valor = 100 / rafaga;
        int porcentaje = 100 - (valor * residuo);
        ValorBarra = porcentaje;
        jLPorcentajeProceso.setText(String.valueOf(ValorBarra + "%"));
    }

    public void Pintar() {
        //Setea el valor de la barra acorde al porcentaje de ejecucion de cada proceso
        
        jPBEstado.setValue(ValorBarra);
        jPBEstado.repaint();
        Color barra = new Color(125,255,120);
        jPBEstado.setBackground(barra);
    }

    private void pintarImagen(JLabel lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_AREA_AVERAGING));
        lbl.setIcon(this.icono);
        this.repaint();
    }

    public Icon setIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

        return icono;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bloc;
    private javax.swing.JButton blockear;
    private javax.swing.JButton desbloc;
    private javax.swing.JLabel imagen2;
    private javax.swing.JLabel imagen3;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBIniciar;
    private javax.swing.JTextField jLCantidadProcesos;
    private javax.swing.JTextField jLCantidadTiempo;
    private javax.swing.JTextField jLNumeroProceso;
    private javax.swing.JTextField jLPorcentajeProceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jPBEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFCapturaQuantum;
    private javax.swing.JTextField jTFCapturaRafaga;
    private javax.swing.JTable jTFinal;
    private javax.swing.JTable jTIngresos;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
