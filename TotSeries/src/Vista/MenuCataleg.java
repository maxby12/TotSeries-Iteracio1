package Vista;

import Controlador.TotSeries;
import Model.TotSeriesDades;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raül
 */
public class MenuCataleg extends javax.swing.JDialog implements SeriesObserver {
    
    private TotSeries _ctrl;
    private TotSeriesDades _model;
    private String _user;
    private int numS;
    private int numT;
    private int numCap;
    private boolean admin;
    
    /**
     * Creates new form MenuCataleg
     */
    public MenuCataleg(java.awt.Frame parent, boolean modal, TotSeries ctrl, TotSeriesDades model, String us) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this._ctrl = ctrl;
        this._model = model;
        this._user = us;
        _model.registerSeriesObserver((SeriesObserver) this);
        ArrayList<String> series = _model.mostrarSeries();
        this.lstCataleg.setModel(new ItemListModel(series));
        this.admin = _ctrl.isAdmin(_user);
        this.btnView.setEnabled(!admin && !_user.equals(""));
        this.btnRate.setEnabled(false);
    }
    
    @Override
    public void updateSeries() {
        this.lstCataleg.setModel(new ItemListModel(_model.mostrarSeries()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCataleg = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTemp = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVistos = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstCap = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        descrSerie = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        nomSerie = new javax.swing.JTextArea();
        directorSerie = new javax.swing.JScrollPane();
        dirSerie = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        actorsSerie = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        nomCapitol = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        idiomaCap = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        duracioCap = new javax.swing.JTextArea();
        directorSerie1 = new javax.swing.JScrollPane();
        notaCap = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        descCap = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstValorats = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        btnRate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catàleg");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Séries");

        jLabel2.setText("Temporades");

        jLabel3.setText("Top Vistos");

        lstCataleg.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCataleg.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCatalegValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCataleg);

        lstTemp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTemp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTempValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstTemp);

        lstVistos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstVistos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("TOT SERIES");

        lstCap.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstCap.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCapValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstCap);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informació Série"));

        jLabel7.setText("Descripció:");

        jLabel8.setText("Director:");

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descrSerie.setEditable(false);
        descrSerie.setColumns(20);
        descrSerie.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        descrSerie.setLineWrap(true);
        descrSerie.setRows(5);
        descrSerie.setWrapStyleWord(true);
        descrSerie.setFocusable(false);
        jScrollPane7.setViewportView(descrSerie);

        jLabel9.setText("Série:");

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        nomSerie.setEditable(false);
        nomSerie.setColumns(20);
        nomSerie.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        nomSerie.setLineWrap(true);
        nomSerie.setRows(5);
        nomSerie.setWrapStyleWord(true);
        nomSerie.setFocusable(false);
        jScrollPane6.setViewportView(nomSerie);

        directorSerie.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        directorSerie.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        dirSerie.setColumns(20);
        dirSerie.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        dirSerie.setLineWrap(true);
        dirSerie.setRows(5);
        dirSerie.setWrapStyleWord(true);
        dirSerie.setFocusable(false);
        directorSerie.setViewportView(dirSerie);

        jLabel10.setText("Actors:");

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        actorsSerie.setEditable(false);
        actorsSerie.setColumns(20);
        actorsSerie.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        actorsSerie.setLineWrap(true);
        actorsSerie.setRows(5);
        actorsSerie.setWrapStyleWord(true);
        actorsSerie.setFocusable(false);
        jScrollPane12.setViewportView(actorsSerie);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6)
                    .addComponent(directorSerie)
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directorSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informació Capítol"));

        jLabel11.setText("Nom:");

        jLabel12.setText("Duració:");

        jLabel13.setText("Idioma:");

        jLabel15.setText("Nota:");

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        nomCapitol.setEditable(false);
        nomCapitol.setColumns(20);
        nomCapitol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        nomCapitol.setRows(5);
        nomCapitol.setFocusable(false);
        jScrollPane8.setViewportView(nomCapitol);

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        idiomaCap.setEditable(false);
        idiomaCap.setColumns(20);
        idiomaCap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        idiomaCap.setRows(5);
        idiomaCap.setFocusable(false);
        jScrollPane10.setViewportView(idiomaCap);

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        duracioCap.setEditable(false);
        duracioCap.setColumns(20);
        duracioCap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        duracioCap.setRows(5);
        duracioCap.setFocusable(false);
        jScrollPane11.setViewportView(duracioCap);

        directorSerie1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        directorSerie1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        notaCap.setEditable(false);
        notaCap.setColumns(20);
        notaCap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        notaCap.setRows(5);
        notaCap.setFocusable(false);
        directorSerie1.setViewportView(notaCap);

        jLabel14.setText("Descripció:");

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descCap.setEditable(false);
        descCap.setColumns(20);
        descCap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        descCap.setLineWrap(true);
        descCap.setRows(5);
        descCap.setWrapStyleWord(true);
        descCap.setFocusable(false);
        jScrollPane13.setViewportView(descCap);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directorSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(directorSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane13))
                .addContainerGap())
        );

        lstValorats.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(lstValorats);

        jLabel6.setText("Top Valorats");

        jLabel5.setText("Capítols");

        btnView.setText("Visualitzar");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnRate.setText("Valorar");
        btnRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1)
                                .addGap(139, 139, 139)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabel5)))))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRate)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(380, 380, 380))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnView)
                            .addComponent(btnRate))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstCatalegValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCatalegValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            int i = this.lstCataleg.getSelectedIndex();
            if (i>=0) {
                this.notaCap.setText("");
                this.nomCapitol.setText("");
                this.duracioCap.setText("");
                this.idiomaCap.setText("");
                this.descCap.setText("");
                this.lstCap.setModel(new ItemListModel());
                String serie = (String)this.lstCataleg.getModel().getElementAt(i);
                ArrayList<String> infoSerie = _model.infoSerie(i);
                this.nomSerie.setText(serie);
                this.descrSerie.setText(infoSerie.get(0));
                this.dirSerie.setText(infoSerie.get(1));
                this.actorsSerie.setText(infoSerie.get(2));
                int n = _model.getNumTemp(i);
                numS = i;
                if (n>0) {
                    ArrayList<String> temp = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        temp.add("Temporada "+ (j+1) );
                    }
                    this.lstTemp.setModel(new ItemListModel(temp));
                }
            }
        }
    }//GEN-LAST:event_lstCatalegValueChanged

    private void lstTempValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTempValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            int i = this.lstTemp.getSelectedIndex();
            if (i>=0) {
                numT = i;
                this.lstCap.setModel(new ItemListModel(_model.mostrarTemporada(1000*numT+numS)));
                this.notaCap.setText("");
                this.nomCapitol.setText("");
                this.duracioCap.setText("");
                this.idiomaCap.setText("");
                this.descCap.setText("");
            }
        }
    }//GEN-LAST:event_lstTempValueChanged

    private void lstCapValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCapValueChanged
        // TODO add your handling code here:
        if (!evt.getValueIsAdjusting()) {
            int i = this.lstCap.getSelectedIndex();
            if (i>=0) {
                numCap = i;
                ArrayList<String> infoCap = _model.infoCapitol(i);
                this.notaCap.setText(infoCap.get(0));
                this.nomCapitol.setText(infoCap.get(1));
                this.duracioCap.setText(infoCap.get(2));
                this.idiomaCap.setText(infoCap.get(3));
                this.descCap.setText(infoCap.get(4));
                if (admin) btnRate.setEnabled(true);
            }
        }
    }//GEN-LAST:event_lstCapValueChanged

    private void btnRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnViewActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea actorsSerie;
    private javax.swing.JButton btnRate;
    private javax.swing.JButton btnView;
    private javax.swing.JTextArea descCap;
    private javax.swing.JTextArea descrSerie;
    private javax.swing.JTextArea dirSerie;
    private javax.swing.JScrollPane directorSerie;
    private javax.swing.JScrollPane directorSerie1;
    private javax.swing.JTextArea duracioCap;
    private javax.swing.JTextArea idiomaCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList lstCap;
    private javax.swing.JList lstCataleg;
    private javax.swing.JList lstTemp;
    private javax.swing.JList lstValorats;
    private javax.swing.JList lstVistos;
    private javax.swing.JTextArea nomCapitol;
    private javax.swing.JTextArea nomSerie;
    private javax.swing.JTextArea notaCap;
    // End of variables declaration//GEN-END:variables
}




class ItemListModel extends AbstractListModel {
    
    private ArrayList<String> list = new ArrayList<String>();
    
    public ItemListModel () {
        super();
    }
    
    public ItemListModel (ArrayList<String> series) {
        super();
        this.list = series;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }
    
    public void add(String o) {
        list.add(o);
    }
    
    public void remove(int index) {
        list.remove(index);
    }
    
}
