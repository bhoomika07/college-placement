/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mac
 */
public class search_company extends javax.swing.JFrame {

    /**
     * Creates new form search_company
     */
    public search_company() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_id = new javax.swing.JLabel();
        cgpa_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        com_table = new javax.swing.JTable();
        search = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_id.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        search_id.setForeground(new java.awt.Color(255, 255, 255));
        search_id.setText("ENTER YOUR CGPA");
        getContentPane().add(search_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));

        cgpa_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgpa_searchActionPerformed(evt);
            }
        });
        getContentPane().add(cgpa_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 170, 40));

        com_table.setBackground(new java.awt.Color(149, 187, 213));
        com_table.setBorder(new javax.swing.border.MatteBorder(null));
        com_table.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        com_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COMPANY", "SEATS", "CGPA REQUIRED"
            }
        ));
        jScrollPane1.setViewportView(com_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 540, 350));

        search.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        search.setForeground(new java.awt.Color(0, 51, 255));
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 140, 40));

        back.setIcon(new javax.swing.ImageIcon("/Users/mac/Desktop/img/college copy.jpg")); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cgpa_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgpa_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cgpa_searchActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/campus?user=root&password=Cutesss@07");
            String q,cname,seats,per,c;
            per=cgpa_search.getText();
            q="select * from company where CGPA="+per;
            Statement st=con.prepareStatement(q,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery(q);
            DefaultTableModel df=(DefaultTableModel)com_table.getModel();
            df.setRowCount(0);
            while(rs.next())
            {
                cname=rs.getString("COMPANYNAME");
                seats=rs.getString("NUM_SEATS");
                c=rs.getString("CGPA");
                String data[]={cname,seats,c};
                df.addRow(data);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Connection error");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(search_company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search_company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search_company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search_company.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_company().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JTextField cgpa_search;
    private javax.swing.JTable com_table;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    private javax.swing.JLabel search_id;
    // End of variables declaration//GEN-END:variables
}
