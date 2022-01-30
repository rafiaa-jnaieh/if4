package ServerProxy;
import SI3.SI3_RMI_Server.service.TransportInterface;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;
/**
 * @author Rafiaa
 */
public class Interface extends javax.swing.JFrame {
    public Interface() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Facture = new javax.swing.JButton();
        Recette_Glb = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        code_c = new javax.swing.JTextField();
        Nom_c = new javax.swing.JTextField();
        Montant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NumSys = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        Facture.setText("Facture");
        Facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FactureActionPerformed(evt);
            }
        });

        Recette_Glb.setText("Recette_Glb");
        Recette_Glb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recette_GlbActionPerformed(evt);
            }
        });

        jLabel1.setText("Code_c");

        jLabel2.setText("Nom_c");

        jLabel3.setText("Montant");

        jLabel4.setText("System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Montant, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(Nom_c)
                            .addComponent(code_c)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NumSys))
                            .addComponent(Facture))
                        .addGap(57, 57, 57)
                        .addComponent(Recette_Glb)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(code_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nom_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Montant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NumSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Facture)
                    .addComponent(Recette_Glb))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FactureActionPerformed
        try { 
            //------------ reçoie code client -----------------------------
            String codeClient=code_c.getText();
            int code=Integer.parseInt(codeClient);
            //------------ reçoie num System -----------------------------
            String system=NumSys.getText();
            int Nsys=Integer.parseInt(system);
            switch (Nsys) {
                //--------------------------- System d'information 1 ---------------------------
                case 1 : 
                    DatagramSocket socket_SI = new DatagramSocket();
                    InetAddress IPAddress = InetAddress.getByName("localhost");
                    // ---------envoyer le code client
                    byte[] sendData = new byte[1024];
                    sendData = codeClient.getBytes();
                    DatagramPacket sentPacket = new DatagramPacket(sendData,sendData.length,IPAddress,8532);
                    socket_SI.send(sentPacket);
                    // --------reçevoir le  client
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket_SI.receive(receivePacket);
                    // ---------- affichage
                    String client1 = new String(receivePacket.getData());
                    String[] companies1 = client1.split("\\s+");
                    String nom1 = companies1[1].trim();
                    String montant1 = companies1[2].trim();
                     Nom_c.setText(nom1);
                     Montant.setText(montant1);
                    socket_SI.close();
                    break;
                    //--------------------------- System d'information 2 ---------------------------
                    case 2 : 
                    Socket socket_SII = new Socket("localhost", 9090);
                    //---------envoie code client 
                    PrintWriter send = new PrintWriter(socket_SII.getOutputStream(), true);
                    send.println(code);
                    //------------ reçoie le client 
                    BufferedReader receive = new BufferedReader(new InputStreamReader(socket_SII.getInputStream()));
                    String client_SII = receive.readLine();
                    //------------  affichage
                    String[] companies2 = client_SII.split("\\s+");
                    String nom2 = companies2[1].trim();
                    String montant2 = companies2[2].trim();
                     Nom_c.setText(nom2);
                     Montant.setText(montant2);
                    socket_SII.close();
                    break;
                    //--------------------------- System d'information 3 ---------------------------
                    case 3: 
                    try {
                    Registry reg = LocateRegistry.getRegistry("localhost",1099); 
                    TransportInterface stub = (TransportInterface) reg.lookup("vehicule");
                    String client3 = stub.getInformation(code);
                    //simple affichage 
                    String[] companies3 = client3.split("\\s+");
                    String nom3 = companies3[1].trim();
                    String montant3 = companies3[2].trim();
                     Nom_c.setText(nom3);
                     Montant.setText(montant3);
                    break;
              } catch (Exception e) { e.printStackTrace(); }
            } 
           }catch (Exception e) { e.printStackTrace(); }    
    }//GEN-LAST:event_FactureActionPerformed

    private void Recette_GlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recette_GlbActionPerformed

            try { 
                    String name="null";
                    int somme=0;
                    String codeClient=code_c.getText();
                    int code=Integer.parseInt(codeClient);
            //--------------------------- System d'information 1 ---------------------------
                    DatagramSocket socket_SI = new DatagramSocket();
                    InetAddress IPAddress = InetAddress.getByName("localhost");
                    // --------envoyer le code client
                    byte[] sendData = new byte[1024];
                    sendData = codeClient.getBytes();
                    DatagramPacket sentPacket = new DatagramPacket(sendData,sendData.length,IPAddress,8532);
                    socket_SI.send(sentPacket);
                    // ---------reçevoir le code client
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket_SI.receive(receivePacket);
                    String client1 = new String(receivePacket.getData());
                    String[] companies1 = client1.split("\\s+");
                    String nom1 = companies1[1].trim();
                    String montant1 = companies1[2].trim();
                    if(!nom1.equals("null"))
                    { name=nom1;}
                    somme = Integer.parseInt(montant1);
                    socket_SI.close(); 
            //--------------------------- System d'information 2 ---------------------------
                    Socket socket_SII = new Socket("localhost", 9090);
                    //-------envoie code client 
                    PrintWriter send = new PrintWriter(socket_SII.getOutputStream(), true);
                    send.println(code);
                    //------------ reçoie le client
                    BufferedReader receive = new BufferedReader(new InputStreamReader(socket_SII.getInputStream()));
                    String client_SII = receive.readLine();
                    String[] companies2 = client_SII.split("\\s+");
                    String nom2 = companies2[1].trim();
                    String montant2 = companies2[2].trim();
                     if(!nom2.equals("null"))
                    { name=nom2;}
                    somme += Integer.parseInt(montant2);
                    socket_SII.close();
            //--------------------------- System d'information 3 ---------------------------
                Registry reg = LocateRegistry.getRegistry("localhost",1099); 
                TransportInterface stub = (TransportInterface) reg.lookup("vehicule");
                String client3 = stub.getInformation(code);
                    String[] companies3 = client3.split("\\s+");
                    String nom3 = companies3[1].trim();
                    String montant3 = companies3[2].trim();
                     if(!nom3.equals("null"))
                    { name=nom3;}
                    somme += Integer.parseInt(montant3);
                    String recette = String.valueOf(somme);
                    //--------- affichage
                     Nom_c.setText(name);
                     Montant.setText(recette);
              } catch (Exception e) { e.printStackTrace(); }    
    }//GEN-LAST:event_Recette_GlbActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Facture;
    private javax.swing.JTextField Montant;
    private javax.swing.JTextField Nom_c;
    private javax.swing.JTextField NumSys;
    private javax.swing.JButton Recette_Glb;
    private javax.swing.JTextField code_c;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
