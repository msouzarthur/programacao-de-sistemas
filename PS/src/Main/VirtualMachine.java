package Main;

import Instructions.*;
import Main.Instruction.EndType;
import Registers.*;
import static Main.Memory.*;
import java.io.File;
import java.util.List;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;

/*
 * @author arthur souza
 * @author hector fernandes
 * @author rafael grimmler
 * @author willian do espirito santo
 */
public class VirtualMachine extends javax.swing.JFrame {

    public VirtualMachine() {
        clear();
        initComponents();
        setInitValues();
        attScreen();
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
        Fundo = new javax.swing.JLabel();
        viewAjuda = new javax.swing.JLabel();

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
        setTitle("Virtual Machine");
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRun.setBackground(new java.awt.Color(102, 102, 102));
        btnRun.setForeground(new java.awt.Color(255, 255, 255));
        btnRun.setText("Executar");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        getContentPane().add(btnRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        btnHelp.setBackground(new java.awt.Color(102, 102, 102));
        btnHelp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setText("Ajuda");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 6, -1, -1));

        btnDebug.setBackground(new java.awt.Color(102, 102, 102));
        btnDebug.setForeground(new java.awt.Color(255, 255, 255));
        btnDebug.setText("Debug");
        btnDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebugActionPerformed(evt);
            }
        });
        getContentPane().add(btnDebug, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, -1, -1));

        btnRunCicle.setBackground(new java.awt.Color(102, 102, 102));
        btnRunCicle.setForeground(new java.awt.Color(255, 255, 255));
        btnRunCicle.setText("Executar Visual");
        btnRunCicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunCicleActionPerformed(evt);
            }
        });
        getContentPane().add(btnRunCicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 130, -1));

        tMemory.setBackground(new java.awt.Color(102, 102, 102));
        tMemory.setForeground(new java.awt.Color(255, 255, 255));
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
        ));
        jScrollPane1.setViewportView(tMemory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 313, 630));

        outCod.setBackground(new java.awt.Color(102, 102, 102));
        outCod.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(outCod);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 215, 298, 245));

        inCod.setBackground(new java.awt.Color(102, 102, 102));
        inCod.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(inCod);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 215, 298, 245));

        label1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Entrada de código");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, -1, -1));

        label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Saída de código");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, -1, -1));

        label3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Memória");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registradores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jScrollPane5.setAutoscrolls(true);
        jScrollPane5.setWheelScrollingEnabled(false);

        accValue.setBackground(new java.awt.Color(204, 204, 204));
        accValue.setColumns(20);
        accValue.setForeground(new java.awt.Color(0, 0, 0));
        accValue.setRows(1);
        accValue.setTabSize(1);
        accValue.setAutoscrolls(false);
        jScrollPane5.setViewportView(accValue);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 56, -1, -1));

        jScrollPane6.setAutoscrolls(true);
        jScrollPane6.setWheelScrollingEnabled(false);

        pcValue.setBackground(new java.awt.Color(204, 204, 204));
        pcValue.setColumns(20);
        pcValue.setForeground(new java.awt.Color(0, 0, 0));
        pcValue.setRows(1);
        pcValue.setTabSize(1);
        pcValue.setAutoscrolls(false);
        jScrollPane6.setViewportView(pcValue);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 90, -1, -1));

        jScrollPane7.setAutoscrolls(true);
        jScrollPane7.setWheelScrollingEnabled(false);

        spValue.setBackground(new java.awt.Color(204, 204, 204));
        spValue.setColumns(20);
        spValue.setForeground(new java.awt.Color(0, 0, 0));
        spValue.setRows(1);
        spValue.setTabSize(1);
        spValue.setAutoscrolls(false);
        jScrollPane7.setViewportView(spValue);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 124, -1, -1));

        jScrollPane8.setAutoscrolls(true);
        jScrollPane8.setWheelScrollingEnabled(false);

        mopValue.setBackground(new java.awt.Color(204, 204, 204));
        mopValue.setColumns(20);
        mopValue.setForeground(new java.awt.Color(0, 0, 0));
        mopValue.setRows(1);
        mopValue.setTabSize(1);
        mopValue.setAutoscrolls(false);
        jScrollPane8.setViewportView(mopValue);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 56, -1, -1));

        jScrollPane9.setAutoscrolls(true);
        jScrollPane9.setWheelScrollingEnabled(false);

        reValue.setBackground(new java.awt.Color(204, 204, 204));
        reValue.setColumns(20);
        reValue.setForeground(new java.awt.Color(0, 0, 0));
        reValue.setRows(1);
        reValue.setTabSize(1);
        reValue.setAutoscrolls(false);
        jScrollPane9.setViewportView(reValue);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 124, -1, -1));

        jScrollPane10.setAutoscrolls(true);
        jScrollPane10.setWheelScrollingEnabled(false);

        riValue.setBackground(new java.awt.Color(204, 204, 204));
        riValue.setColumns(20);
        riValue.setForeground(new java.awt.Color(0, 0, 0));
        riValue.setRows(1);
        riValue.setTabSize(1);
        riValue.setAutoscrolls(false);
        jScrollPane10.setViewportView(riValue);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 90, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ACC");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 62, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 96, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 130, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MOP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 62, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 96, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 130, -1, -1));

        Fundo.setBackground(new java.awt.Color(51, 51, 51));
        Fundo.setForeground(new java.awt.Color(51, 51, 51));
        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fundo1.png"))); // NOI18N
        Fundo.setText("jLabel8");
        getContentPane().add(Fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -20, 1040, 760));

        viewAjuda.setVisible(false);
        viewAjuda.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(viewAjuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 790, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clear() {
        File file = new File("./saida");
        for (File subfile : file.listFiles()) {
            subfile.delete();
        }
    }

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        MOP.setValue(0);
        runCode(false, false);
        attScreen();
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        ViewAjuda viewAjuda = new ViewAjuda();
        viewAjuda.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnDebugActionPerformed(java.awt.event.ActionEvent evt) {
        MOP.setValue(2);
        runCode(true, true);
        attScreen();
    }

    private void btnRunCicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunCicleActionPerformed
        MOP.setValue(1);
        runCode(true, false);
        attScreen();
    }//GEN-LAST:event_btnRunCicleActionPerformed
    
    private void runCode(Boolean refresh, Boolean debug) {
        Integer opd1 = null, opd2 = null;
        Assembler assembler = new Assembler();
        Instruction instruction;
        attScreen();

        String path = inCod.getText();
        File f = new File(path);
        if (inCod.getText().length() == 0) {
            IO.showError("> não há entrada de dados");
            return;
        } else if (f.exists() && !f.isDirectory()) {
            Macros.process(path);
            assembler.assemble("./saida/MASMAPRG.asm");
            //ligador
            Linker.link();
            //carregador
            Loader.load("./saida/linkedCode.hpx");
        }
        RE.setValue(Memory.memoryDataInit());
        do {
            instruction = decodeInstruction(Memory.memoryGet(PC.getValue()));

            if (PC.getValue() != null) {
                RI.setValue(Memory.memoryGet(PC.getValue()));
            }

            PC.setValue(PC.getValue() + instruction.numberOpd() + 1);

            if (Objects.equals(PC.getValue(), RE.getValue())) {
                Main.IO.write("Execução finalizada");
                break;
            }
            if (instruction instanceof STOP || PC.getValue() == null) {
                PC.setValue(null);
                break;
            }
            //imediato: é o valor que foi passado
            if (instruction.numberOpd() == 1) {
                opd1 = Memory.memoryGet(PC.getValue() - 1);
            } else if (instruction.numberOpd() == 2) {
                opd2 = Memory.memoryGet(PC.getValue() - 2);
            }
            //direto: é o valor que tá no endereço
            if (instruction.getEndType() == EndType.DIRECT) {
                if (instruction instanceof READ) {
                    opd1 = Memory.memoryGet(PC.getValue() - 1);
                } else if (instruction instanceof STORE == false) {
                    if (instruction.numberOpd() == 1) {
                        opd1 = Memory.memoryGet(opd1);
                    } else if (instruction.numberOpd() == 2) {
                        opd2 = Memory.memoryGet(opd2);
                    }
                }
            }
            //indireto: é o valor que tá no endereço apontado pelo valor passado
            if (instruction.getEndType() == EndType.INDIRECT1) {
                opd1 = Memory.memoryGet(Memory.memoryGet(opd1));
            }
            if (instruction.getEndType() == EndType.INDIRECT2) {
                opd2 = Memory.memoryGet(Memory.memoryGet(opd2));
            }
            instruction.runInstruction(outCod, opd1, opd2);
            if (refresh) {
                attScreen();
                if (debug) {
                    IO.write("> Clique para continuar");
                }
            }
        } while (Memory.memoryGet(PC.getValue()) != null && PC.getValue() < RE.getValue());
    }

    private Instruction decodeInstruction(Integer insCod) {
        Instruction instruction = null;
        Integer opcode = insCod;
        if (insCod > 16) {
            if (insCod - 32 <= 15 && insCod - 32 >= 0) {
                opcode = insCod - 32;
                insCod = 32;
            }
            if (insCod - 64 <= 15 && insCod - 64 >= 0) {
                opcode = insCod - 64;
                insCod = 64;
            }
            if (insCod - 128 <= 15 && insCod - 128 >= 0) {
                opcode = insCod - 128;
                insCod = 128;
            }
        }
        if (opcode != null) {
            switch (opcode) {
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
                    IO.showError("> opcode não reconhecido: " + opcode);
            }
            if (insCod == 32) {
                instruction.setEndType(Instruction.EndType.INDIRECT1);
            } else if (insCod == 64) {
                instruction.setEndType(Instruction.EndType.INDIRECT2);

            } else if (insCod == 128) {
                instruction.setEndType(Instruction.EndType.IMMEDIATE);
            } else {
                instruction.setEndType(Instruction.EndType.DIRECT);
            }
        }
        return instruction;
    }

    public void attScreen() {
        String bin;
        for (int i = 0; i < Memory.memorySize(); i++) {
            if (Memory.memoryGet(i) != null) {
                bin = CompleteBinary.toBin(Memory.memoryGet(i));
                tMemory.setValueAt(bin, i, 1);
            } else {
                tMemory.setValueAt(Memory.memoryGet(i), i, 1);
            }
        }
        accValue.setText(ACC.getText());
        pcValue.setText(PC.getText());
        spValue.setText(SP.getText());
        mopValue.setText(MOP.getText());
        riValue.setText(RI.getText());
        reValue.setText(RE.getText());
    }

    public void outMessage(String message) {
        outCod.setText(message);
    }

    public void setInitValues() {
        memoryInit();
        List<Integer> memory = Memory.memoryGetAll();

        DefaultTableModel table = (DefaultTableModel) tMemory.getModel();
        table.setRowCount(500);
        tMemory.setModel(table);

        for (int i = 0; i < memory.size(); i++) {
            tMemory.setValueAt(i, i, 0);
            tMemory.setValueAt(memory.get(i), i, 1);
        }

        RE.setValue(2);
        PC.setValue(2);
        SP.setValue(memory.size() - 1);
        MOP.setValue(0);
        ACC.setValue(0);
        RI.setValue(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirtualMachine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fundo;
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
    private javax.swing.JLabel viewAjuda;
    // End of variables declaration//GEN-END:variables
}
