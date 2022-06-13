
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Procesar extends javax.swing.JFrame {

    int listaProcesosBloqueados[];
    int listaProcesosPrioridad[];
    int Contador;//Contador del total de procesos que se van ingresando
    int contadorProcesosPrioridad;
    int NProceso;//Carga el número de procesos ejecutándose
    int Rafaga = 0;//Carga la ráfaga en ejecución
    int Quantum = 0;//Carga el quantum en ejecución
    int ResiduoRafaga = 0;//Carga el residuo en ejecución
    int TiempoProceso = 0;//Carga el tiempo que se dura procesando
    int ValorBarra;//Carga el progreso de la Barra
    int CantidadProcesos;//Número de procesos terminados
    boolean bloquear = true;
    boolean desbloquear = false;
    int procesosAEjecutarse;
    long tiempoInicio;
    long tiempoBase;
    long tiempoFin;
    static int LargoTotalTabla;//Valor Total de los tiempos para dibujar tablas
    static int CantProcesos;//Cantidad de Procesos
    Random rnd = new Random();


    public Procesar() {
        initComponents();
        redimensionar();
        tamanioBloqueadosES();
        this.setLocationRelativeTo(null);
        jTIngresos.setBackground(Color.CYAN);
        jTIngresos.setForeground(Color.blue);
        jTFinal.setBackground(Color.GREEN);
        jTFCapturaQuantum.grabFocus();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTIngresos = new javax.swing.JTable();
        jTFCapturaQuantum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTFCapturaRafaga = new javax.swing.JTextField();
        jBIniciar = new javax.swing.JButton();
        block = new javax.swing.JTextField();
        blockear = new javax.swing.JButton();
        blockear1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLCantidadProcesos = new javax.swing.JTextField();
        jLCantidadTiempo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTFinal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPBEstado = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLPorcentajeProceso = new javax.swing.JTextField();
        jLNumeroProceso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SetPrioridad = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 1020, 310));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantum");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 79, -1));

        jBAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jBAgregar.setText("Cargar Procesos");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 52, -1, 20));

        jTIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Prioridad", "Rafaga", "Quantum", "ResiduoRafaga", "Estado"
            }
        ));
        jTIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTIngresosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTIngresos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 490, 190));

        jTFCapturaQuantum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFCapturaQuantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCapturaQuantumActionPerformed(evt);
            }
        });
        getContentPane().add(jTFCapturaQuantum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 79, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rafaga");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 74, -1));

        jTFCapturaRafaga.setEditable(false);
        jTFCapturaRafaga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTFCapturaRafaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCapturaRafagaActionPerformed(evt);
            }
        });
        getContentPane().add(jTFCapturaRafaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 114, -1));

        jBIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jBIniciar.setText("Iniciar");
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jBIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 115, -1));
        getContentPane().add(block, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 79, -1));

        blockear.setForeground(new java.awt.Color(255, 255, 255));
        blockear.setText("Bloquear");
        blockear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockearActionPerformed(evt);
            }
        });
        getContentPane().add(blockear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 100, -1));

        blockear1.setForeground(new java.awt.Color(255, 255, 255));
        blockear1.setText("Desbloquear");
        blockear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockear1ActionPerformed(evt);
            }
        });
        getContentPane().add(blockear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CANTIDAD PROCESO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 141, 17));

        jLCantidadProcesos.setEditable(false);
        jLCantidadProcesos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCantidadProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLCantidadProcesosActionPerformed(evt);
            }
        });
        getContentPane().add(jLCantidadProcesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 118, -1));

        jLCantidadTiempo.setEditable(false);
        jLCantidadTiempo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCantidadTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLCantidadTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(jLCantidadTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 118, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIEMPO PROCESO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 141, 20));

        jTFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Proceso", "Rafaga", "Quantum", "Tiempo Final"
            }
        ));
        jTFinal.setEnabled(false);
        jScrollPane4.setViewportView(jTFinal);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, 133));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPBEstado.setBackground(java.awt.SystemColor.textHighlight);
        jPBEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPBEstado.setForeground(new java.awt.Color(0, 51, 255));
        jPBEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jPanel1.add(jPBEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 360, 21));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PLANIFICADOR DE PROCESOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, 413, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HISTORICO PROCESOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 450, 30));

        jLPorcentajeProceso.setEditable(false);
        jLPorcentajeProceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPorcentajeProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLPorcentajeProcesoActionPerformed(evt);
            }
        });
        jPanel1.add(jLPorcentajeProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 53, -1));

        jLNumeroProceso.setEditable(false);
        jLNumeroProceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNumeroProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLNumeroProcesoActionPerformed(evt);
            }
        });
        jPanel1.add(jLNumeroProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 41, -1));

        jLabel7.setText("Proceso");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        SetPrioridad.setText("Set Prioridad");
        SetPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetPrioridadActionPerformed(evt);
            }
        });
        jPanel1.add(SetPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/red puntos.png"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 720));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("        LISTA DE PROCESOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 265, 29));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void tamanioBloqueadosES() {
        String clavesInsertar[] = ManejadorArchivosGenerico.leerArchivo(".\\src\\Procesos.txt");
        int cantProcesosBloc = 0;
        int contProcesosprior=0;
        for (String string : clavesInsertar) {
            String proceso[] = new String[2];
            proceso = string.split(",");
            if (proceso[1].contains("1")) {
                cantProcesosBloc++;
            }
            contProcesosprior++;
        }
        listaProcesosBloqueados = new int[cantProcesosBloc];
        listaProcesosPrioridad = new int[contProcesosprior];
    }
    public void redimensionar(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();        
        this.setSize( screenSize.width, screenSize.height);
        
    }
    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
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

    private void jTFCapturaRafagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCapturaRafagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCapturaRafagaActionPerformed

    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        tiempoBase = System.currentTimeMillis();
        new Thread(new Hilo()).start(); //Crea un nuevo hilo
        new Thread(new HiloTiempo()).start();
        Iniciar();
    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jTFCapturaQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCapturaQuantumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCapturaQuantumActionPerformed

    private void jLCantidadProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLCantidadProcesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLCantidadProcesosActionPerformed

    private void jLCantidadTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLCantidadTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLCantidadTiempoActionPerformed

    private void jLNumeroProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLNumeroProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLNumeroProcesoActionPerformed

    private void jLPorcentajeProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLPorcentajeProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLPorcentajeProcesoActionPerformed

    private void jTIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTIngresosMouseClicked
//        Dormir();
        int row = jTIngresos.getSelectedRow();
        System.out.println(row);
        String id = String.valueOf(jTIngresos.getValueAt(row, 0));
        block.setText(id);
    }//GEN-LAST:event_jTIngresosMouseClicked

    private void blockearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockearActionPerformed
        Dormir();
        String numeroProceso = block.getText();
        jTIngresos.setValueAt("Bloqueado", Integer.parseInt(numeroProceso) - 1, 4);
        
        
     
        
    }//GEN-LAST:event_blockearActionPerformed

    private void blockear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockear1ActionPerformed
        Dormir();
        String numeroProceso = block.getText();
        if (jTIngresos.getValueAt(Integer.parseInt(numeroProceso) - 1, 4) == "Bloqueado") {
            jTIngresos.setValueAt("Listo", Integer.parseInt(numeroProceso) - 1, 4);
        }
    }//GEN-LAST:event_blockear1ActionPerformed

    private void SetPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetPrioridadActionPerformed
    //    String prioridadPrevia = block.getText();
    //    String proximaPrioridad = JOptionPane.showInputDialog("Coloque una prioridad al proceso, maximo "+
     //           listaProcesosPrioridad.length);
     //   jTIngresos.setValueAt(proximaPrioridad, Integer.parseInt(prioridadPrevia)-1, 1);
     //   jTIngresos.setValueAt(prioridadPrevia, Integer.parseInt(proximaPrioridad)-1, 1);
        
    }//GEN-LAST:event_SetPrioridadActionPerformed

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

        @Override
        public void run() {
            while (true) {
                while (bloquear) {
                    tiempoInicio = System.currentTimeMillis();                   
                    tiempoFin = (int)(rnd.nextDouble() * 6500 + 3000);                   
                    if (tiempoInicio - tiempoBase >= tiempoFin) {                       
                        bloqueoEntradaSalida();
                    }
                }              
                while (desbloquear) {                    
                    tiempoInicio = System.currentTimeMillis();
                    tiempoFin = (int)(rnd.nextDouble() * 6500 + 3000);                   
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
            int estado = 1; //Estado de while que indica si se puede seguir o no
            int i = 0; // contador de while
            Grafica grafica = new Grafica();
            
            while (estado != 0) {
                while (i < Contador) { //Recorrer las filas
                    Cargar(i);
                    if (ResiduoRafaga != 0 && ResiduoRafaga > Quantum && jTIngresos.getValueAt(i, 4) != "Bloqueado") { //Ejecutando Procesos
                        for (int c = 1; c <= Quantum; c++) {
                            if(jTIngresos.getValueAt(i, 4)!= "Bloqueado"){
                                                       
                            grafica.Dibujar(i, jPanel2,LargoTotalTabla, CantProcesos);
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
                                if(jTIngresos.getValueAt(i, 4) != "Bloqueado"){
                                 
                               
                                grafica.Dibujar(i, jPanel2,LargoTotalTabla, CantProcesos );
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
                            if (ResiduoRafaga == 0 && Quantum != 0 && jTIngresos.getValueAt(i, 4) != "Bloqueado") {
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
        
        for (int listaProcesosBloqueado : listaProcesosBloqueados) {
           int raf = parseInt((String) (jTIngresos.getValueAt(listaProcesosBloqueado - 1, 3)));          
            if(listaProcesosBloqueado!=0 && raf>0){
                 jTIngresos.setValueAt("Bloqueado", listaProcesosBloqueado - 1, 4);
            }
           
        }
        tiempoBase = System.currentTimeMillis();
        bloquear = false;       
        desbloquear = true;


    }

    public void desbloqueoEntradaSalida() {
        for (int listaProcesosBloqueado : listaProcesosBloqueados) {
            int raf = parseInt((String) (jTIngresos.getValueAt(listaProcesosBloqueado - 1, 3)));
            if(listaProcesosBloqueado!=0&& raf>0){
            jTIngresos.setValueAt("Listo", listaProcesosBloqueado - 1, 4);
            }
        }
        tiempoBase = System.currentTimeMillis();
        bloquear = true;
        desbloquear = false;


    }

    public void Dormir() {
        try {
            Thread.sleep(100); //Dormir sistema
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public void Cargar(int i) { //Carga los valores de la Tabla

        if(jTIngresos.getValueAt(i, 4) != "Bloqueado"){
         
        NProceso = (int) jTIngresos.getValueAt(i, 0);
        Rafaga = parseInt((String) (jTIngresos.getValueAt(i, 1)));
        Quantum = parseInt((String) (jTIngresos.getValueAt(i, 2)));
        ResiduoRafaga = parseInt((String) (jTIngresos.getValueAt(i, 3)));
        if (NProceso > 0 && jTIngresos.getValueAt(i, 4) != "Bloqueado") {
            jLNumeroProceso.setText(String.valueOf(NProceso));
        }
         }

    }

    public void Ingresar(String numeroProceso, String rafaga) { //Ingresar proceso a la tabla

        DefaultTableModel modelo = (DefaultTableModel) jTIngresos.getModel();
        Contador++;        
        Object[] miTabla = new Object[6];
        miTabla[0] = Contador;
        miTabla[1] = Contador;
        miTabla[2] = rafaga;
        LargoTotalTabla += Integer.parseInt(rafaga);
        CantProcesos++;
        miTabla[3] = jTFCapturaQuantum.getText();
        miTabla[4] = rafaga;
        miTabla[5] = "Listo";
        modelo.addRow(miTabla);
        jTIngresos.setModel(modelo);
        

    }

    public void Informe(int c) {
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

    public void Borrar(int c) { //Elimina los registros de la tabla procesos
        jTIngresos.setValueAt(0, c, 0);
        jTIngresos.setValueAt("0", c, 1);
        jTIngresos.setValueAt("0", c, 2);
        jTIngresos.setValueAt("0", c, 3);
        jTIngresos.setValueAt("******", c, 4);
        
    }
        

    public void Barra(int rafaga, int residuo) { //Calcula porcentaje de la barra y su progreso
        int Rafaga = rafaga;
        int valor = 100 / rafaga;
        int porcentaje = 100 - (valor * residuo);
        ValorBarra = porcentaje;
        jLPorcentajeProceso.setText(String.valueOf(ValorBarra + "%"));
    }

    public void Pintar() {
        jPBEstado.setValue(ValorBarra);
        jPBEstado.repaint();
    }

    public void Iniciar() { //Inicia la secuencia de procesos
        /*  jLabel2.setVisible(false);
        jLabel1.setVisible(false);
        jTFCapturaRafaga.setVisible(false);
        jTFCapturaQuantum.setVisible(false);
        jBAgregar.setVisible(false);
        jBIniciar.setVisible(false);*/
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SetPrioridad;
    private javax.swing.JTextField block;
    private javax.swing.JButton blockear;
    private javax.swing.JButton blockear1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
