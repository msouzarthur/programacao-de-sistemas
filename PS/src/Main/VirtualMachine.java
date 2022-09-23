package Main;

import Instructions.*;
import Registers.*;
import static Main.Memory.*;
import java.util.List;

/*
 * @author arthur souza
 * @author hector fernandes
 * @author rafael grimmler
 * @author willian do espirito santo
 * @author matheus cardoso
 * @author leonardo marotta
 * @author lucas dias
 */

public class VirtualMachine extends javax.swing.JFrame {

    public VirtualMachine() {
        //MONTADOR: opcode -> binário
        initComponents();
        setInitValues();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        btnRun = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnDebug = new javax.swing.JButton();
        btnRunCicle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMemory = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        outCod = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        inCod = new javax.swing.JTextPane();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        accValue = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        pcValue = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        spValue = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        mopValue = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        reValue = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        riValue = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRun.setText("Executar");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        btnRun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRunKeyPressed(evt);
            }
        });

        btnHelp.setText("Ajuda");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnDebug.setText("Debug");

        btnRunCicle.setText("Executar Passo");

        tMemory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Address", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tMemory);

        jScrollPane2.setViewportView(outCod);

        jScrollPane3.setViewportView(inCod);

        label1.setText("Entrada de código");

        label2.setText("Saída de código");

        label3.setText("Memória");

        jLabel1.setText("Registradores");

        jScrollPane5.setAutoscrolls(true);
        jScrollPane5.setWheelScrollingEnabled(false);

        accValue.setColumns(20);
        accValue.setRows(1);
        accValue.setTabSize(1);
        accValue.setAutoscrolls(false);
        jScrollPane5.setViewportView(accValue);

        jScrollPane6.setAutoscrolls(true);
        jScrollPane6.setWheelScrollingEnabled(false);

        pcValue.setColumns(20);
        pcValue.setRows(1);
        pcValue.setTabSize(1);
        pcValue.setAutoscrolls(false);
        jScrollPane6.setViewportView(pcValue);

        jScrollPane7.setAutoscrolls(true);
        jScrollPane7.setWheelScrollingEnabled(false);

        spValue.setColumns(20);
        spValue.setRows(1);
        spValue.setTabSize(1);
        spValue.setAutoscrolls(false);
        jScrollPane7.setViewportView(spValue);

        jScrollPane8.setAutoscrolls(true);
        jScrollPane8.setWheelScrollingEnabled(false);

        mopValue.setColumns(20);
        mopValue.setRows(1);
        mopValue.setTabSize(1);
        mopValue.setAutoscrolls(false);
        jScrollPane8.setViewportView(mopValue);

        jScrollPane9.setAutoscrolls(true);
        jScrollPane9.setWheelScrollingEnabled(false);

        reValue.setColumns(20);
        reValue.setRows(1);
        reValue.setTabSize(1);
        reValue.setAutoscrolls(false);
        jScrollPane9.setViewportView(reValue);

        jScrollPane10.setAutoscrolls(true);
        jScrollPane10.setWheelScrollingEnabled(false);

        riValue.setColumns(20);
        riValue.setRows(1);
        riValue.setTabSize(1);
        riValue.setAutoscrolls(false);
        jScrollPane10.setViewportView(riValue);

        jLabel2.setText("ACC");

        jLabel3.setText("PC");

        jLabel4.setText("SP");

        jLabel5.setText("MOP");

        jLabel6.setText("RI");

        jLabel7.setText("RE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHelp)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addGap(0, 28, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRun)
                                .addGap(295, 295, 295))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRunCicle)
                                .addGap(282, 282, 282))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDebug)
                                .addGap(300, 300, 300))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHelp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label1)
                            .addComponent(label2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(btnRun)
                        .addGap(18, 18, 18)
                        .addComponent(btnRunCicle)
                        .addGap(18, 18, 18)
                        .addComponent(btnDebug)))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        //EXECUTAR A INSTRUÇÃO OLHANDO O ENDEREÇAMENTO
        //VER A FUNÇÃO DO REGISTRADOR RE
        reset();
        Instruction instruction;
        Integer position = 12;
        
        RE.setValue(position);
        PC.setValue(position);
        SP.setValue(2);
        MOP.setValue(0);

        Integer opd1 = null, opd2 = null;
        String[] cod = inCod.getText().split("\n");;
        
        readContent(cod, position);

        do {
            attScreen();
            instruction = decodeInstruction(Memory.memoryGet(PC.getValue()));

            if(PC.getValue() != null)
                RI.setValue(Memory.memoryGet(PC.getValue()));
            PC.setValue(PC.getValue()+instruction.numberOpd()+1);
            
            if(instruction instanceof STOP || PC.getValue() == null){
                PC.setValue(null);
                break;
            }
            
            if(instruction.numberOpd() == 1)
                opd1 = Memory.memoryGet(PC.getValue()-1);
            else if(instruction.numberOpd() == 2)
                opd2 = Memory.memoryGet(PC.getValue()-2);
            
            instruction.runInstruction(outCod, opd1, opd2);
            attScreen();
        }while(Memory.memoryGet(PC.getValue())!= null);
    }//GEN-LAST:event_btnRunActionPerformed

    private void reset(){
        ACC.reset();
        MOP.reset();
        PC.reset();
        RE.reset();
        RI.reset();
        SP.reset();
        Memory.memoryReset();
        attScreen();
    }
    
    private void readContent(String[] cod, Integer position) {
        String[] aux = null;
        if(cod.length>0){
            for (String command : cod){
                aux = command.split(" ");
                for(String p : aux){
                    Memory.memorySet(position, Integer.parseInt(p.trim()));
                    position++;
                }
            }
        }
    }
                
    private Instruction decodeInstruction(Integer inCod) {
        Instruction instruction = null;
        Integer opcode = inCod;
        if(inCod>16){
            if(inCod-32<=15 && inCod-32>=0){
                opcode = inCod-32;
                inCod = 32;
            }
            if(inCod-64<=15 && inCod-64>=0){
                opcode = inCod-64;
                inCod = 64;
            }
            if(inCod-128<=15 && inCod-128>=0){
                opcode = inCod-128;
                inCod = 128;
            }
        }
        if(opcode!=null){
            switch(opcode){
            case 0: //BR: PC <- opd1
                instruction = new BR();
                break;
            case 1: //BRPOS: PC <- opd1, se ACC > 0
                instruction = new BRPOS();
                break;
            case 2: //ADD: ACC <- ACC + opd1
                instruction = new ADD();
                break;
            case 3: //LOAD: ACC <- opd1
                instruction = new LOAD();
                break;
            case 4: //BRZERO: PC <- opd1, se ACC = 0
                instruction = new BRZERO();
                break;
            case 5: //BRNEG: PC <- opd1, se ACC < 0
                instruction = new BRNEG();
                break;
            case 6: //SUB: ACC <- ACC - opd1
                instruction = new SUB();
                break;
            case 7: //STORE: opd1 <- ACC
                instruction = new STORE();
                break;
            case 8: //WRITE: output <- opd1
                instruction = new WRITE();
                break;
            case 9: //RET: PC <- [SP]
                instruction = new RET();
                break;
            case 10: //DIV: ACC <- ACC / opd1
                instruction = new DIV();
                break;
            case 11: //STOP: fim do programa
                instruction = new STOP();
                break;
            case 12: //READ: opd1 <- input stream
                instruction = new READ();
                break;
            case 13: //COPY: opd1 <- opd2
                instruction = new COPY();
                break;
            case 14: //MULT: ACC <- ACC * opd1
                instruction = new MULT();
                break;
            case 15: //CALL: [SP] <- PC; PC <- opd1
                instruction = new CALL();
                break;
            default:
                System.out.println("ERRO DE OPCODE");
            }
            if(inCod==32){
                System.out.println("primeiro operando indireto");
                //instruction.setEndType(Instruction.D);
                //primeiro operando indireto
            }
            if(inCod==64){
                System.out.println("segundo operando indireto");
                //segundo operando indireto
            }
            if(inCod==128){
                System.out.println("endereçamento imediato");
                //imediato
            }
        }
        return instruction;        
    }

    public void attScreen(){
        String bin;
        for(int i=0;i<100;i++){
            if(Memory.memoryGet(i)!=null){
                bin = CompleteBinary.toBin(Memory.memoryGet(i));
                tMemory.setValueAt(bin, i, 1);
            }
            else
                tMemory.setValueAt(Memory.memoryGet(i), i, 1);
        }
        accValue.setText(ACC.getText());
        pcValue.setText(PC.getText());
        spValue.setText(SP.getText());
        mopValue.setText(MOP.getText());
        riValue.setText(RI.getText());
        reValue.setText(RE.getText());
    }
    
    public void outMessage(String message){
        outCod.setText(message);
    }
    
    public void setInitValues(){
        memoryInit();
        List<Integer> memory = Memory.memoryGetAll();
        for(int i=0;i<memory.size();i++){
            tMemory.setValueAt(i, i, 0);
            tMemory.setValueAt(memory.get(i), i, 1);
        }
    }
    
    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // abrir pop up com infos das instruções
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnRunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRunKeyPressed

    }//GEN-LAST:event_btnRunKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirtualMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea accValue;
    private javax.swing.JButton btnDebug;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnRunCicle;
    private javax.swing.JTextPane inCod;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JTextArea mopValue;
    private javax.swing.JTextPane outCod;
    private javax.swing.JTextArea pcValue;
    private javax.swing.JTextArea reValue;
    private javax.swing.JTextArea riValue;
    private javax.swing.JTextArea spValue;
    private javax.swing.JTable tMemory;
    // End of variables declaration//GEN-END:variables
}
