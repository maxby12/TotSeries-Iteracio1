/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author mat.aules
 */
public class FrmRegistre extends javax.swing.JDialog {
    
    private boolean _canviUser, _canviPas, _canviNom, _canviNac, _canviDia, _canviMes, _canviAny;

    /**
     * Creates new form FrmRegistre
     */
    public FrmRegistre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this._canviUser = false;
        this._canviPas = false;
        this._canviNom = false;
        this._canviNac = false;
        this._canviDia = false;
        this._canviMes = false;
        this._canviAny = false;
        initComponents();
        
        PlainDocument doc1 = (PlainDocument) txtDia.getDocument();
        doc1.setDocumentFilter(new MyIntFilter());
        PlainDocument doc2 = (PlainDocument) txtMes.getDocument();
        doc2.setDocumentFilter(new MyIntFilter());
        PlainDocument doc3 = (PlainDocument) txtAny.getDocument();
        doc3.setDocumentFilter(new MyIntFilter());
        
        txtUser.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviUser = !txtUser.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviUser = !txtUser.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviUser = !txtUser.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        
        txtPas.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviPas = !txtPas.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviPas = !txtPas.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviPas = !txtPas.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        
        txtNom.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviNom = !txtNom.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviNom = !txtNom.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviNom = !txtNom.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        txtNac.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviNac = !txtNac.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviNac = !txtNac.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviNac = !txtNac.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        txtAny.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviAny = !txtAny.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviAny = !txtAny.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviAny = !txtAny.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        txtMes.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviMes = !txtMes.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviMes = !txtMes.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviMes = !txtMes.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
        
        txtDia.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent de) {
                _canviDia = !txtDia.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                _canviDia = !txtDia.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
            // implement the methods

            @Override
            public void insertUpdate(DocumentEvent de) {
                _canviDia = !txtDia.getText().equals("");
                btnOk.setEnabled(_canviUser && _canviPas && _canviNom && _canviNac && _canviDia && _canviMes && _canviAny);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        txtPas = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtNac = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAny = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Data de naixament");

        btnOk.setText("Registrar-se");
        btnOk.setEnabled(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCan.setText("Cancel·lar");
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom d'Usuari");

        jLabel3.setText("Password");

        jLabel4.setText("Nom");

        jLabel5.setText("Nacionalitat");

        jLabel6.setText("Dia");

        jLabel7.setText("Més");

        jLabel8.setText("Any");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(txtNom, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNac, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAny, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtDia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                                .addComponent(txtMes, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnOk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCan)
                    .addComponent(btnOk))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnOkActionPerformed

  public String[] showDialog(){
      String [] s = new String[7];
      this.setVisible(false);
      this.dispose();
      return s;
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCan;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAny;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNac;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPas;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}




class MyIntFilter extends DocumentFilter {
   @Override
   public void insertString(FilterBypass fb, int offset, String string,
         AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }

   private boolean test(String text) {
      if (text.equals("")) return true;
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   @Override
   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (test(sb.toString())) {
         super.replace(fb, offset, length, text, attrs);
      } else {
         // warn the user and don't allow the insert
      }

   }

   @Override
   public void remove(FilterBypass fb, int offset, int length)
         throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset, offset + length);
      
      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      } else {
         // warn the user and don't allow the insert
      }

   }
}